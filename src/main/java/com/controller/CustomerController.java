package com.controller;

import com.dao.CustomerDAO;
import com.entity.Customer;
import com.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    //need to inject the customer dao
//    @Autowired
//    private CustomerDAO customerDAO;
    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public String listCustomers(Model theModel) {

        //get customers
        List<Customer> theCustomers = customerService.getCustomers();
        //add customers to model
        theModel.addAttribute("customers",theCustomers);

        return "list-customers";
    }
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        // create model attribute to bind form data
        Customer theCustomer = new Customer();

        theModel.addAttribute("customer", theCustomer);

        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {

        // save the customer using our service
        customerService.saveCustomer(theCustomer);


        return "redirect:/customer/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("customerId") int theId,
                                    Model theModel) {

        // get the customer from our service
        Customer theCustomer = customerService.getCustomer(theId);

        // set customer as a model
        theModel.addAttribute("customer", theCustomer);

        // send over to our form
        return "customer-form";
    }
    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("customerId") int theId) {

        // delete the customer from our service
        customerService.deleteCustomer(theId);

        // send over to our form
        return "redirect:/customer/list";
    }
}
