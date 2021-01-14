package customer_province.service;

import customer_province.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    List<Customer> findAll();
    Page<Customer> findAll(Pageable pageable);
    Customer findById(Integer id);
    void save(Customer customer);
    void update(Customer customer);
    void removeById(Integer id);
    Page<Customer> findByInputText(String name, Pageable pageable);

}
