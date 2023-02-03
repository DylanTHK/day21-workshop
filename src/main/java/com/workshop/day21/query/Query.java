package com.workshop.day21.query;

public class Query {

    // list out all string queries here
    // Task 3 Query #1
    public static final String GET_ALL_SQL = "SELECT * FROM customers";

    // SELECT * FROM customers LIMIT <offset>, <limit>
    public static final String LIMIT_SQL = """
                SELECT * 
                FROM customers
                LIMIT ?, ?;""";

}
