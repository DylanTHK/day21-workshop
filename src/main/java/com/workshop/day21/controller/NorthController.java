package com.workshop.day21.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.workshop.day21.model.Customer;
import com.workshop.day21.repo.NorthRepo;


@RestController
@RequestMapping("/api")
public class NorthController {
    
    @Autowired
    NorthRepo northRepo;

    // handler method for retrieving ALL customers
    @GetMapping("/allcustomers")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        
        List<Customer> queryResult = northRepo.getAllCustomers();

        // check if list is empty, generate response entity with body and Httpstatus
        if (queryResult.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(queryResult, HttpStatus.OK);
        }
    }

    // method to get subset of customers
    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getCustomers(@RequestParam("offset") Integer offset, 
    @RequestParam("limit") Integer limit) {
        List<Customer> queryResult = northRepo.getCustomers(offset, limit);

        if (queryResult.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<List<Customer>>(queryResult, HttpStatus.OK);
        }

    }


// FOR TESTING PURPOSEShandler method to retrieve SUBSET of customers
    // http://localhost:8080/api/hello/world (PathVariable is DIRECTLY in url)
    @GetMapping("/{value1}/{value2}")
    public ResponseEntity<List<Customer>> testPathVariable(@PathVariable("value1") String textA, 
        @PathVariable("value2") String textB) {
        // test request param
        System.out.println("Printing text: %s and %s".formatted(textA, textB)); 
        // test pathvariable
        return null;
    }
    // http://localhost:8080/api?param1=value1&param2=value2 (Request Params are extracted from url)
    @GetMapping(path="/request", params={"param1", "param2"})
    public ResponseEntity<List<Customer>> testReqParam(@RequestParam("param1") String paramA,
    @RequestParam("param2") String paramB) {
        // test request param
        System.out.println("Printing text: %s and %s".formatted(paramA, paramB)); 
        // test pathvariable
        return null;
    }
    // http://localhost:8080/api?param1=value1
    @GetMapping(path="/request", params="param1")
    public ResponseEntity<List<Customer>> testReqParam(@RequestParam("param1") String paramA) {
        // test request param
        System.out.println("Printing text: %s".formatted(paramA)); 
        // test pathvariable
        return null;
    }
}
