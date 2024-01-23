package com.demo.MyFirstSearchApp.service;

import com.demo.MyFirstSearchApp.entity.Product;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class MockProductService implements ProductService {

    private static final List<String> topTrendProducts = Arrays.asList("MockProduct1", "MockProduct2", "MockProduct3");

    private static final List<Product> searchResults = Arrays.asList(
            new Product("MockProductA", "DescriptionA"),
            new Product("MockProductB", "DescriptionB"),
            new Product("MockProductC", "DescriptionC")
    );

    private static final List<Product> previousSearchResults = Arrays.asList(
            new Product("PreviousSearchProduct1", "Description1"),
            new Product("PreviousSearchProduct2", "Description2")
    );

    @Override
    public List<String> getTopTrendProducts() {
        return topTrendProducts;
    }

    @Override
    public List<Product> searchProducts(String query) {
        return searchResults;
    }

    @Override
    public List<Product> getPreviousSearchResults(Long userId) {
        return previousSearchResults;
    }

    @Override
    public void deleteSearchResults(Long userId) {
        System.out.println("Deleting search results for user with ID: " + userId);
    }
}
