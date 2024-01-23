package com.demo.MyFirstSearchApp.service;

import com.demo.MyFirstSearchApp.entity.Product;

import java.util.List;

public interface ProductService {
    List<String> getTopTrendProducts();

    List<Product> searchProducts(String query);

    List<Product> getPreviousSearchResults(Long userId);

    void deleteSearchResults(Long userId);
}
