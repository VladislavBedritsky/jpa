package org.example.controller;

import org.example.domain.Customer;
import org.example.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/edit")
    public String updateCustomer(
            Model model,
            @RequestParam Long id) {
        Customer customer = customerService.findById(id);
        model.addAttribute("customer", customer);
        return "edit_customer";
    }

    @GetMapping("/delete")
    public String deleteCustomerForm(@RequestParam Long id) {
        customerService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/search")
    public String search(
            Model model,
            @RequestParam String keyword) {
        List<Customer> customers = customerService.findCustomerByKeyword(keyword);
        model.addAttribute("customers", customers);
        return "search";
    }


}
