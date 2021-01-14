package customer_province.service.impl;

import customer_province.model.Customer;
import customer_province.repository.CustomerRepository;
import customer_province.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public Customer findById(Integer id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void update(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void removeById(Integer id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Page<Customer> findByInputText(String name, Pageable pageable) {
        return customerRepository.findCustomerByFirstNameContaining(name, pageable);
    }




//__+__+__+__+__+__+__+__+__+__+__+
//__+__+__+__+__+__+__+__+__+__+__+
}
