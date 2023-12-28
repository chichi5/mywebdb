package com.chi.mywebdb.controller;



import com.chi.mywebdb.model.Customer;
import com.chi.mywebdb.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    CustomerService customerService;
    @GetMapping("/customers")
    public String showCustomers(Model model){
        // CustomersService 要資料
        List<Customer> custs = customerService.getCustomerAll();
        // 放入 model
        model.addAttribute("custs",custs);
        return "customer_list";

    }
}
