/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.respository.impl;

import com.mycompany.pojo.Category;
import com.mycompany.pojo.Product;
import com.mycompany.respository.ProductRepository;
import com.mycompany.saleapp.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;

/**
 *
 * @author AnChuPC
 */
public class ProductRepositoryImpl implements ProductRepository {

    @Override
    public List<Product> getProducts(Map<String, String> params) {
        try ( Session s = HibernateUtil.getFactory().openSession()) {
            CriteriaBuilder b = s.getCriteriaBuilder();
            CriteriaQuery<Product> q = b.createQuery(Product.class);
            Root<Product> root = q.from(Product.class);
            q.select(root);

            List<Predicate> predicates = new ArrayList<>();
            // Filter by key word
            String kw = params.get("kw");
            if (kw != null && !kw.isEmpty()) {
                Predicate p = b.like(root.get("name").as(String.class),
                        String.format("%%%s%%", kw));
                predicates.add(p);
            }

            // Filter by price
            String fromPrice = params.get("fromPrice");
            String toPrice = params.get("toPrice");

            if (fromPrice != null && !fromPrice.isEmpty()) {
                Predicate p = b.greaterThanOrEqualTo(root.get("price").as(Double.class),
                        Double.parseDouble(fromPrice));
                predicates.add(p);
            }

            if (toPrice != null && !toPrice.isEmpty()) {
                Predicate p = b.lessThanOrEqualTo(root.get("price").as(Double.class), Double.parseDouble(toPrice));
                predicates.add(p);
            }

            // Filter by category name
            String categoryName = params.get("category");
            if (categoryName != null && !categoryName.isEmpty()) {
                Predicate p = b.equal(root.get("category").get("name").as(String.class), categoryName);
                predicates.add(p);
            }

            // Order by id, name, price
            String order = params.get("order");
            if (order != null && !order.isEmpty()) {
                q.orderBy(b.asc(root.get(order)));
            }

            q.where(predicates.toArray(new Predicate[] {}));
            Query query = s.createQuery(q);
            return query.getResultList();
        }
    }

    @Override
    public Boolean addProduct(String name, String descreption, Double price, String manufacturer, String image, Boolean active) {
        try(Session session = HibernateUtil.getFactory().openSession()) {
            Product p = new Product();
            p.setName(name);
            p.setDescription(descreption);
            p.setPrice(price);
            p.setManufacturer(manufacturer);
            p.setImage(image);
            p.setActive(active);
            
            System.out.println(p);
        }
        return false;
    }
};
