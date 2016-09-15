package idstay.customer;

import idstay.customer.support.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {
    private CustomerRepository customerRepository;

    public Optional<Customer> findByEmail(final String email) {
        return null;
    }

    @Autowired
    public void setCustomerRepository(final CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
}

