package org.homework.jdbc.service;

import org.homework.jdbc.service.interfaces.CustomerService;
import org.homework.jdbc.model.Customer;
import org.homework.jdbc.repository.CustomerRepositoryImpl;
import org.homework.jdbc.repository.interfaces.CrudRepository;

import java.util.List;
import java.util.Optional;

public class CustomerServiceImpl implements CustomerService {

    private final CrudRepository<Customer, Long> CRUD_REPOSITORY = new CustomerRepositoryImpl();

    @Override
    public Optional<Customer> getById(Long id) {
        return CRUD_REPOSITORY.findById(id);
    }

    @Override
    public List<Customer> getAll() {
        return CRUD_REPOSITORY.findAll();
    }

    @Override
    public void update(Long id, String name, Long budget, Long companyId) {
        Customer customer = new Customer();
        customer.setName(name);
        customer.setBudget(budget);
        customer.setCompanyId(companyId);
        CRUD_REPOSITORY.update(id, customer);
    }

    @Override
    public void delete(Long id) {
        CRUD_REPOSITORY.delete(id);
    }

    @Override
    public Customer createNewCustomer(String name, Long budget, Long companyId) {
        Customer customer = new Customer();
        customer.setName(name);
        customer.setBudget(budget);
        customer.setCompanyId(companyId);
        return CRUD_REPOSITORY.create(customer);
    }
}