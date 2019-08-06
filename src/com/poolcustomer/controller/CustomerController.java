package com.poolcustomer.controller;

import com.poolcustomer.entity.Customer;
import com.poolcustomer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/poolCustomer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/list")
    public String listCustomers(Model model) {
        List<Customer> customers = customerService.getCustomers();
        model.addAttribute("customers",customers);
        return "list-customers";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {
        Customer customer = new Customer();
        model.addAttribute(customer);
        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult) {
        customerService.boxIsEmpty(customer,bindingResult);

        if(bindingResult.hasErrors()){
            return "customer-form";
        } else {
            customerService.saveCustomer(customer);
            return "redirect:/poolCustomer/list";
        }
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("id") int id, Model model) {
        Customer customer = customerService.getCustomer(id);
        model.addAttribute(customer);
        return "customer-form";
    }

    @GetMapping("/deleteCustomer")
    public String deleteCustomer(@RequestParam("id") int id) {
        customerService.deleteCustomer(id);
        return "redirect:/poolCustomer/list";
    }

}
