/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.saleapp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mycompany.pojo.Category;
import com.mycompany.pojo.Product;
import com.mycompany.respository.CategoryRepository;
import com.mycompany.respository.ProductRepository;
import com.mycompany.respository.StatsRepository;
import com.mycompany.respository.impl.CategoryRepositoryImpl;
import com.mycompany.respository.impl.ProductRepositoryImpl;
import com.mycompany.respository.impl.StatsRepositoryImpl;

/**
 *
 * @author admin
 */
public class SaleApp {

    public static void main(String[] args) {
        ProductRepository p = new ProductRepositoryImpl();
        
        Map<String, String> params = new HashMap<>();
        params.put("kw", "iPad");
        params.put("fromPrice", "10000000");
        params.put("toPrice", "13000000");
        params.put("category", "Máy tính bảng");
        params.put("order", "name");
        
        List<Product> products = p.getProducts(params);
        products.forEach(x -> System.out.printf("%s - %.1f - %s\n", x.getName(), x.getPrice(), x.getCategory().getName()));
        
        System.out.println("-----------------------------------------------------------------------------");
        
        StatsRepository s = new StatsRepositoryImpl();
        List<Object[]> statsList = s.statsByCategory();
        List<Object[]> statsTopSell = s.statsByTopSell();
        List<Object[]> statsRevenue = s.statsRevenue(null, null);
        
        statsList.forEach(o -> System.out.printf("%s - %d\n", o[0], o[1]));
        
        System.out.println("-----------------------------------------------------------------------------");
        statsTopSell.forEach(o -> System.out.printf("%s - %s\n", o[0], o[1]));
        
        System.out.println("-----------------------------------------------------------------------------");
        statsRevenue.forEach(o -> System.out.printf("%s - %s - %,.1f\n", o[0], o[1], o[2]));
        

//        p.addProduct("SamSung Galaxy", "", 10000000.0, "SanSung", "", true);
        
    }
}
