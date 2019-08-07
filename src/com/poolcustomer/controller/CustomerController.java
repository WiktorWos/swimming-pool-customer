package com.poolcustomer.controller;

import com.poolcustomer.entity.Customer;
import com.poolcustomer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        model.addAttribute("dateFormat",dateFormat);
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
        if(!customerService.boxIsEmpty(customer,bindingResult)){
            bindingResult.addError(new ObjectError("boxNotEmpty","Box is already used"));
        }

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

    @GetMapping("/showCheckout")
    public String showCheckout(Model model) {
        Customer customer = new Customer();
        model.addAttribute("customer",customer);
        return "customer-checkout";
    }

    @GetMapping("/showCheckoutFromId")
    public String showCheckoutFromId(@RequestParam("id") int id, Model model) {
        Customer customer = customerService.getCustomer(id);
        model.addAttribute("customer",customer);
        return "customer-checkout";
    }

    @GetMapping("/checkout")
    public String checkout(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult,
                           Model model) {

        if(customerService.boxIsEmpty(customer,bindingResult)){
            if(customer.getBoxNumber()>0 && customer.getBoxNumber()<201){
                bindingResult.addError(new ObjectError("boxIsEmpty","Box was not used"));
            }
        }

        if(bindingResult.hasErrors()){
            return "customer-checkout";
        } else {
            customer = customerService.getCustomerForCheckout(customer.getBoxNumber());
            model.addAttribute("customer",customer);

            Date currentDate = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            model.addAttribute("dateFormat",dateFormat);
            model.addAttribute("currentDate", dateFormat.format(currentDate));

            long diff = (currentDate.getTime() - customer.getStart().getTime())/1000;

            double charge;
            if(customer.getTicket().equals("Normal")) {
                charge = diff * 0.002;
            } else {
                charge = diff * 0.003;
            }

            DecimalFormat decimalFormat = new DecimalFormat("####.##");
            model.addAttribute("charge", decimalFormat.format(charge));

            customerService.deleteCustomer(customer.getId());

            return "customer-checkout-result";
        }
    }

}
