/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.saleapp;

import com.mycompany.pojo.Category;
import com.mycompany.pojo.OrderDetail;
import com.mycompany.pojo.Product;
import com.mycompany.pojo.SaleOrder;
import com.mycompany.pojo.Tag;
import com.mycompany.pojo.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author admin
 */
public class HibernateUtil {

    private static SessionFactory factory;

    static {
        Configuration conf = new Configuration();
        conf.configure("hibernate.cfg.xml");
        conf.addAnnotatedClass(Category.class);
        conf.addAnnotatedClass(Product.class);
        conf.addAnnotatedClass(Tag.class);
        conf.addAnnotatedClass(User.class);
        conf.addAnnotatedClass(SaleOrder.class);
        conf.addAnnotatedClass(OrderDetail.class);
        
        ServiceRegistry service = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();

        factory = conf.buildSessionFactory(service);
    }

    /**
     * @return the factory
     */
    public static SessionFactory getFactory() {
        return factory;
    }

    /**
     * @param aFactory the factory to set
     */
}
