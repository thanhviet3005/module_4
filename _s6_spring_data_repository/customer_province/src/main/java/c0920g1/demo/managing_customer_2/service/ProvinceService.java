package c0920g1.demo.managing_customer_2.service;

import c0920g1.demo.managing_customer_2.model.Customer;
import c0920g1.demo.managing_customer_2.model.Province;

public interface ProvinceService {
    Iterable<Province> findAll();
    Province findById(int id);
    void save(Province province);
    void removeById(int id);
}
