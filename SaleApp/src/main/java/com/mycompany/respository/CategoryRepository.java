package com.mycompany.respository;

import java.util.List;
import java.util.Map;

import com.mycompany.pojo.Category;


public interface CategoryRepository {
    public List<Category> getCategories(Map<String, String> params);
}
