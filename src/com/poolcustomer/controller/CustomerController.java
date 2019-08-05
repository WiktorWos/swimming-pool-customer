package com.poolcustomer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/poolCustomer")
public class CustomerController {

    @GetMapping("/list")
    public String listCustomers(Model model) {
        return "list-customers";
    }
}
