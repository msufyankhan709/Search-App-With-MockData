package com.demo.MyFirstSearchApp.controller;

import com.demo.MyFirstSearchApp.dto.SearchRequest;
import com.demo.MyFirstSearchApp.dto.UserDataRequest;
import com.demo.MyFirstSearchApp.entity.Product;
import com.demo.MyFirstSearchApp.service.ProductService;
import com.demo.MyFirstSearchApp.service.SearchService;
import com.demo.MyFirstSearchApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SearchController {

    @Autowired
    private ProductService productService;

    @Autowired
    private SearchService searchService;

    @Autowired
    private UserService userService;

    @GetMapping("/search/top")
    public List<String> getTopTrendSearch() {
        return productService.getTopTrendProducts();
    }

    @PostMapping("/search")
    public ResponseEntity<String> performSearch(@RequestBody SearchRequest request) {
        try {
            searchService.performSearch(request);
            return ResponseEntity.ok("Search performed successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error performing search");
        }
    }

    @GetMapping("/search/{userId}")
    public ResponseEntity<List<Product>> getPreviousSearches(@PathVariable Long userId) {
        try {
            List<Product> previousSearchResults = productService.getPreviousSearchResults(userId);
            return ResponseEntity.ok(previousSearchResults);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("/search/{userId}")
    public ResponseEntity<String> deleteSearchData(@PathVariable Long userId) {
        try {
            productService.deleteSearchResults(userId);
            return ResponseEntity.ok("Search data deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting search data");
        }
    }

    @PostMapping("/user/add")
    public ResponseEntity<String> addUserData(@RequestBody UserDataRequest userDataRequest) {
        try {
            userService.addUserData(userDataRequest);
            return ResponseEntity.ok("User data added successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error adding user data");
        }
    }
}
