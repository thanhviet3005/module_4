package c0920g1.demo.managing_customer_2.service.impl;

import c0920g1.demo.managing_customer_2.model.Province;
import c0920g1.demo.managing_customer_2.repository.ProvinceRepository;
import c0920g1.demo.managing_customer_2.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class ProvinceServiceImpl implements ProvinceService {
    @Autowired
    private ProvinceRepository provinceRepository;

    @Override
    public Iterable<Province> findAll() {
        return provinceRepository.findAll();
    }

    @Override
    public Province findById(int id) {
        return provinceRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Province province) {
        provinceRepository.save(province);
    }

    @Override
    public void removeById(int id) {
        provinceRepository.deleteById(id);
    }

//__+__+__+__+__+__+__+__+__
}
