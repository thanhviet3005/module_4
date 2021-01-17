package c0920g1.service.Impl;

import c0920g1.model.BillLend;
import c0920g1.repository.BillLendRepository;
import c0920g1.service.BillLendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Primary
public class BillLendServiceImpl implements BillLendService {
    @Autowired
    private BillLendRepository billLendRepository;

    @Override
    public List<BillLend> findAll() {
        return billLendRepository.findAll();
    }

    @Override
    public BillLend findById(int id) {
        return billLendRepository.findById(id).orElse(null);
    }

    @Override
    public void save(BillLend billLend) {
        billLendRepository.save(billLend);

    }

    @Override
    public void update(BillLend billLend) {
        billLendRepository.save(billLend);
    }

    @Override
    public void remove(int id) {
    }
//__+__+__+__+__+__+__+__+
}
