package customer_province.service;

import customer_province.model.Customer;
import customer_province.model.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProvinceService {
    List<Province> findAll();
    Page<Province> findAll(Pageable pageable);
    Province findById(Integer id);
    void save(Province province);
    void update(Province province);
    void removeById(Integer id);
    Page<Province> findByInputText(String name, Pageable pageable);
}
