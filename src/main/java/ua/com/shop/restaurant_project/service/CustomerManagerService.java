package ua.com.shop.restaurant_project.service;

import org.springframework.stereotype.Service;
import ua.com.shop.restaurant_project.entity.Customer;
import ua.com.shop.restaurant_project.entity.Users;
import ua.com.shop.restaurant_project.repository.CustomerRepository;

@Service
public class CustomerManagerService {
    private final CustomerRepository customerRepository;

    public CustomerManagerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer getCustomerByUsername(Users users) {
        return customerRepository.findById(users.getId()).get();
    }

    public void saveCustomerToDB(Customer customer) {
        customerRepository.save(customer);
    }
}