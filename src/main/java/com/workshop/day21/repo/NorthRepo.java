package com.workshop.day21.repo;

import org.springframework.stereotype.Repository;

@Repository
public class NorthRepo {
    private String limitSQL = """
                SELECT * 
                FROM customers
                LIMIT 10, 5;""";

    
}
