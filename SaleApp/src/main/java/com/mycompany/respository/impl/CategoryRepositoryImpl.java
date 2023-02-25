package com.mycompany.respository.impl;

import java.util.List;
import java.util.Map;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import com.mycompany.pojo.Category;
import com.mycompany.respository.CategoryRepository;
import com.mycompany.saleapp.HibernateUtil;

public class CategoryRepositoryImpl implements CategoryRepository {

    @Override
    public List<Category> getCategories(Map<String, String> params) {
        // TODO Auto-generated method stub
        try (Session session = HibernateUtil.getFactory().openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery query = builder.createQuery();
            Root<Category> root = query.from(Category.class);
            query.select(root);

            Query q = session.createQuery(query);

            
            return q.getResultList();

        }
    }

}
