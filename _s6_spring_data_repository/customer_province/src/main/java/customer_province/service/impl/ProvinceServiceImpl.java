package customer_province.service.impl;

import customer_province.model.Province;
import customer_province.repository.ProvinceRepository;
import customer_province.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Primary
public class ProvinceServiceImpl implements ProvinceService {
    @Autowired
    private ProvinceRepository provinceRepository;


    @Override
    public List<Province> findAll() {
        return provinceRepository.findAll();
    }

    @Override
    public Page<Province> findAll(Pageable pageable) {
        return provinceRepository.findAll(pageable);
    }

    @Override
    public Province findById(Integer id) {
        return null;
    }

    @Override
    public void save(Province province) {
        provinceRepository.save(province);
    }

    @Override
    public void update(Province province) {

    }

    @Override
    public void removeById(Integer id) {

    }

    @Override
    public Page<Province> findByInputText(String name, Pageable pageable) {
        return provinceRepository.findAllByProvinceName(name, pageable);
    }
}
