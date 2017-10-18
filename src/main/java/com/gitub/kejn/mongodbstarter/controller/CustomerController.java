package com.gitub.kejn.mongodbstarter.controller;

import com.gitub.kejn.mongodbstarter.model.Customer;
import com.gitub.kejn.mongodbstarter.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("customer")
class CustomerController {

    private final CustomerRepository repository;

    @RequestMapping
    public List<Customer> customers() {
        return repository.findAll();
    }

    @RequestMapping(value = "/{customerId}")
    public Customer customer(@PathVariable String customerId) {
        return repository.findById(customerId);
    }

    @RequestMapping(value = "/query")
    public List<Customer> query(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName) {
        return repository.findByFirstNameOrLastName(firstName, lastName);
    }

}
