package cg.wbd.grandemonstration.model;

import javax.persistence.*;

@Entity
@Table
public class Customer implements Cloneable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String address;

    public Customer() {
    }

    public Customer(String name, String email, String address) {
        this.name = name;
        this.email = email;
        this.address = address;
    }

    public Customer(Long id, String name, String email, String address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public Customer clone() {
        Customer customer = new Customer();
        customer.setId(id);
        customer.setName(name);
        customer.setEmail(email);
        customer.setAddress(address);
        return customer;
    }

    //__+__+__+__+__+__+__+__+
    //    Ví dụ về phương thức clone lại đối tượng để tạo ra, tiết kiệm bộ nhớ thay vì tạo ra một
    // đối tượng mới hoàn toàn như ở ví dụ dưới
    //    public Object clone() throws CloneNotSupportedException {
    //        return super.clone();
    //    }
    //
    //    public static void main(String args[]) {
    //        try {
    //            Student s1 = new Student(101, "An");
    //            Student s2 = (Student) s1.clone();
    //            System.out.println(s1.rollno + " " + s1.name);
    //            System.out.println(s2.rollno + " " + s2.name);
    //        } catch (CloneNotSupportedException c) {
    //        }

    //__+__+__+__+__+__+__+__+
    //__+__+__+__+__+__+__+__+


    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
