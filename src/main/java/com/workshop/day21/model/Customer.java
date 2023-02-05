package com.workshop.day21.model;

import org.springframework.jdbc.support.rowset.SqlRowSet;


public class Customer {
    private Integer id;
    private String company;
    private String firstName;
    private String lastName;
    private String jobTitle;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getCompany() {
        return company;
    }
    public void setCompany(String company) {
        this.company = company;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getJobTitle() {
        return jobTitle;
    }
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
        

    @Override
    public String toString() {
        return "Customer [id=" + id + ", company=" + company + ", firstName=" + firstName + ", lastName=" + lastName
                + ", jobTitle=" + jobTitle + "]";
    }

    // method to generate customer from rowset
    public Customer create(SqlRowSet rs) {
        Customer c = new Customer();
        c.setId(rs.getInt("id"));
        c.setCompany(rs.getString("company"));
        c.setFirstName(rs.getString("first_name"));
        c.setLastName(rs.getString("last_name"));
        c.setJobTitle(rs.getString("job_title"));

        return c;
    }

}
