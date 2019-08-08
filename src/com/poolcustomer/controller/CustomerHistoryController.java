package com.poolcustomer.controller;

import com.poolcustomer.entity.CustomerHistory;
import com.poolcustomer.service.CustomerHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
@RequestMapping("/poolCustomer/history")
public class CustomerHistoryController {
    @Autowired
    CustomerHistoryService customerHistoryService;

    @GetMapping("/showHistory")
    public String showHistory(Model model) {
        List<CustomerHistory> customersHistory = customerHistoryService.getCustomersHistory();
        model.addAttribute("customersHistory",customersHistory);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        model.addAttribute("dateFormat",dateFormat);
        DecimalFormat decimalFormat = new DecimalFormat("####.##");
        model.addAttribute("decimalFormat", decimalFormat);
        return "customer-history";
    }
}
