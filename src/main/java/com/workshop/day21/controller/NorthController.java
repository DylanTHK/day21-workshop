package com.workshop.day21.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.workshop.day21.model.Customer;
import com.workshop.day21.repo.NorthRepo;

import static com.workshop.day21.query.Query.*;


@RestController
@RequestMapping("/api")
public class NorthController {
    
    @Autowired
    NorthRepo northRepo;

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        
        List<Customer> queryResult = northRepo.getAllCustomers();

        if (queryResult.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(queryResult, HttpStatus.OK);
        }
        
        return null;
    }
}
