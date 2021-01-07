package managing_customer.service;

import managing_customer.model.Customer;
import managing_customer.repository.CustomerRepository;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepository {
    private  static List<Customer> customerList;
    static {
        customerList = new ArrayList<>();
        customerList.add(new Customer(1, "John", "john@codegym.vn", "Hanoi"));
        customerList.add(new Customer(2, "Bill", "bill@codegym.vn", "Danang"));
        customerList.add(new Customer(3, "Alex", "alex@codegym.vn", "Saigon"));
        customerList.add(new Customer(4, "Adam", "adam@codegym.vn", "Beijin"));
        customerList.add(new Customer(5, "Sophia", "sophia@codegym.vn", "Miami"));
        customerList.add(new Customer(6, "Rose", "rose@codegym.vn", "Newyork"));
    }

    @Override
    public List<Customer> getAll() {
        return customerList;
    }

    @Override
    public Customer findById(int id) {
        Customer customer = new Customer();
        for (Customer cus : customerList) {
            if(cus.getId() == id){
                customer = cus;
                break;
            }
        }
        return customer;
    }

    @Override
    public boolean saveCustomer(Customer customer) {
        boolean status = false;
        int index = customerList.indexOf(customer);
        if(index == -1){
            customerList.add(customer);
            status = true;
        }
        return status;
    }

    @Override
    public void removeCustomer(int id) {
        customerList.remove(findById(id));
    }

    @Override
    public void updateCustomer(Customer customer) {
        Customer cus = findById(customer.getId());
        int index = customerList.indexOf(cus);
        customerList.set(index, customer);
    }

//__+__+__+__+__+__+__+__+__+__+__
//__+__+__+__+__+__+__+__+__+__+__
}
