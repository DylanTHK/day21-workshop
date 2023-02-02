package com.workshop.day21.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.workshop.day21.model.Customer;

@RestController
@RequestMapping("/api")
public class NorthController {
    
    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        
        return null;
    }
}
