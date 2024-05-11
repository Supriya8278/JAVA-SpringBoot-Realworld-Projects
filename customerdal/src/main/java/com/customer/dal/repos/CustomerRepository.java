package com.customer.dal.repos;

import org.springframework.data.repository.CrudRepository;

import com.customer.dal.entities.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
