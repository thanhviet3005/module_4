package c0920g1.repository;

import c0920g1.model.BorrowBill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowBookRepository extends JpaRepository<BorrowBill, Integer> {
    BorrowBill findByBorrowCode(String code);
}
