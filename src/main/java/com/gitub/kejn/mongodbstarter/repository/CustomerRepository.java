package com.gitub.kejn.mongodbstarter.repository;

import com.gitub.kejn.mongodbstarter.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface CustomerRepository extends MongoRepository<Customer, String> {
    Customer findByFirstName(String firstName);
    List<Customer> findByLastName(String lastName);
    List<Customer> findByFirstNameOrLastName(String firstName, String lastName);
    Customer findById(String customerId);

}
