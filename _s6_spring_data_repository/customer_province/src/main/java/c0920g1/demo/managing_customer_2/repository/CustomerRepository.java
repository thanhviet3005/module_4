package c0920g1.demo.managing_customer_2.repository;

import c0920g1.demo.managing_customer_2.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
