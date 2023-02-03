package com.workshop.day21.repo;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import com.workshop.day21.model.Customer;

import static com.workshop.day21.query.Query.*;

@Repository
public class NorthRepo {
    
    @Autowired
    JdbcTemplate jdbcTemplate;

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

    public List<Customer> getCustomers(Integer offset, Integer limit) {
        final List<Customer> customerList = new LinkedList<>();

        // SELECT * FROM customers LIMIT <offset>, <limit>;
        final SqlRowSet rs = jdbcTemplate.queryForRowSet(LIMIT_SQL, offset, limit);

        // while rs has next line, extract info from columns, to create object
        while (rs.next()) {
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

    
}
