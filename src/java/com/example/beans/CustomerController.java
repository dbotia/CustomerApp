/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.beans;

import com.example.interceptors.Logged;
import java.io.Serializable;
import javax.faces.bean.RequestScoped;

import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author admin
 */
@Named(value = "customerController")
@RequestScoped
@Logged
public class CustomerController implements Serializable{

    /**
     * Creates a new instance of CustomerController
     */
    public CustomerController() {
    }
    @Inject
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String saveCustomer() {
//write code to save customer information in database
        return "saved";
    }
}
