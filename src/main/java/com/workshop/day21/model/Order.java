package com.workshop.day21.model;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.jdbc.support.rowset.SqlRowSet;

public class Order {
    private Integer customerId;
    private Integer orderId;
    private Date orderDate; // check java.sql.Date vs java.util.Date
    private String zipCode;
    private String country;

    public Integer getCustomerId() {
        return customerId;
    }
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
    public Integer getOrderId() {
        return orderId;
    }
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
    public Date getOrderDate() {
        return orderDate;
    }
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
    public String getZipCode() {
        return zipCode;
    }
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    @Override
    public String toString() {
        return "Order [customerId=" + customerId + ", orderId=" + orderId + ", orderDate=" + orderDate + ", zipCode="
                + zipCode + ", country=" + country + "]";
    }

    public static Order create(SqlRowSet rs) throws ParseException {
        Order o = new Order();
        o.setCustomerId(rs.getInt("customer_id"));
        o.setOrderId(rs.getInt("id"));
        o.setZipCode(rs.getString("ship_zip_postal_code"));
        o.setCountry(rs.getString("ship_country_region"));

        // extracting date
        String dateString = rs.getString("order_date").split("T")[0];
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
        System.out.println("Date 1 (Date format): " + date);
        o.setOrderDate(date);

        return o;
    }
    
}
