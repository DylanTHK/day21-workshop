package com.workshop.day21.repo;

import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import com.workshop.day21.model.Customer;
import com.workshop.day21.model.Order;

import static com.workshop.day21.query.Query.*;

@Repository
public class NorthRepo {
    
    @Autowired
    JdbcTemplate jdbcTemplate;

    // method to retrieve customer information from sql table to java list
    public List<Customer> getAllCustomers() {
        final List<Customer> customerList = new LinkedList<>();
        // call information from the database
        // queryString: "SELECT * FROM customers"
        SqlRowSet rs = jdbcTemplate.queryForRowSet(GET_ALL_SQL);

        while(rs.next()) {
            Customer c = new Customer();
            c.setId(rs.getInt("id"));
            c.setCompany(rs.getString("company"));
            c.setFirstName(rs.getString("first_name"));
            c.setLastName(rs.getString("last_name"));
            c.setJobTitle(rs.getString("job_title"));
            customerList.add(c);
        }

        return customerList;
    }

    // method to retrieve subset of rows from table to java list
    public List<Customer> getCustomers(Integer offset, Integer limit) {
        final List<Customer> customerList = new LinkedList<>();

        // SELECT * FROM customers LIMIT <offset>, <limit>;
        final SqlRowSet rs = jdbcTemplate.queryForRowSet(LIMIT_SQL, offset, limit);

        // while rs has next line, extract info from columns, to create object
        while (rs.next()) {
            System.out.println("Rowset: " + rs);
            Customer c = new Customer();
            c = c.create(rs);

            System.out.println("Customer created: " + c);
            customerList.add(c);
        }

        return customerList;
    }

    // method to retrive a single row of data to java object
    public Customer getCustomer(Integer id) {
        // method to query
        SqlRowSet rs = jdbcTemplate.queryForRowSet(GET_BY_ID_SQL, id);

        Boolean haveCustomer = rs.next(); // returns boolean
        System.out.println("Customer found in rs: " + haveCustomer);

        Customer c = new Customer();
        if (haveCustomer) {
            c = c.create(rs);
            System.out.println("Customer Created: " + c);
        } else {
            System.out.println("Customer Created: " + c);
            return null;
        }

        return c;
    }

    public List<Order> getCustomerOrders(Integer id) throws ParseException {
        
        List<Order> customerOrders = new LinkedList<>();

        SqlRowSet rs = jdbcTemplate.queryForRowSet(GET_ORDERS_BY_ID_SQL, id);

        while (rs.next()) {
            Order o = Order.create(rs);
            customerOrders.add(o);
        }

        return customerOrders;
    }
    
}
