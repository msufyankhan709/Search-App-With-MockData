package com.demo.MyFirstSearchApp.service;

import com.demo.MyFirstSearchApp.dto.UserDataRequest;
import org.springframework.stereotype.Service;

@Service
public class MockUserService implements UserService {

    @Override
    public void addUserData(UserDataRequest request) {
        System.out.println("Adding mock user data: " + request.getUsername());
        // Add mock user data logic if needed
    }
}
