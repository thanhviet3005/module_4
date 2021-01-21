package c0920g1.service.impl;

import c0920g1.model.BorrowBill;
import c0920g1.repository.BorrowBookRepository;
import c0920g1.service.BorrowBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Primary
public class BorrowBookServiceImpl implements BorrowBookService {
    @Autowired
    private BorrowBookRepository borrowBookRepository;

    @Override
    public BorrowBill findByBorrowCode(String code) {
        return borrowBookRepository.findByBorrowCode(code);
    }

    @Override
    public void removeByBorrowBookBill(BorrowBill borrowBill) {
        borrowBookRepository.delete(borrowBill);
    }

    @Override
    public List<BorrowBill> findAll() {
        return borrowBookRepository.findAll();
    }

    @Override
    public BorrowBill findById(int id) {
        return borrowBookRepository.findById(id).orElse(null);
    }

    @Override
    public void save(BorrowBill borrowBook) {
        borrowBookRepository.save(borrowBook);
    }

    @Override
    public void update(BorrowBill borrowBook) {

    }

    @Override
    public void remove(int id) {

    }
}
