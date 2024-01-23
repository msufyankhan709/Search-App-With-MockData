package com.demo.MyFirstSearchApp.service;

import com.demo.MyFirstSearchApp.dto.SearchRequest;
import org.springframework.stereotype.Service;

@Service
public class MockSearchService implements SearchService {

    @Override
    public void performSearch(SearchRequest request) {
        System.out.println("Performing mock search for query: " + request.getQuery());
        // Add mock search logic if needed
    }
}
