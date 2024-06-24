package vn.codegym.service;

import vn.codegym.model.Customer;

import java.util.List;

public interface ICustomerService {

    List<Customer> findAll() throws Exception;

    Customer findOne(Long id) throws Exception;
}
