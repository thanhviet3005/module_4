package c0920g1.demo.managing_customer_2.model;

import org.springframework.data.annotation.Id;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.List;

@Entity
public class Province {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Nullable
    private String name;

    @OneToMany(targetEntity = Customer.class)
    private List<Customer> customerList;

    public Province() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }
}
