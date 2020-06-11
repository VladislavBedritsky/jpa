package org.example.controller;

import org.example.domain.Customer;
import org.example.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public String findAll(Model model) {
        model.addAttribute("customers", customerService.findAll());
        return "index";
    }

    @GetMapping("/new")
    public String getNewCustomer(Model model) {
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "new_customer";
    }

    @PostMapping("/save")
    public String saveCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.save(customer);
        return "redirect:/";
    }

}
