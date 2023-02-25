/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.respository;

import com.mycompany.pojo.Product;
import java.util.List;
import java.util.Map;

/**
 *
 * @author AnChuPC
 */
public interface ProductRepository {
    List<Product> getProducts(Map<String, String> params); 
}
