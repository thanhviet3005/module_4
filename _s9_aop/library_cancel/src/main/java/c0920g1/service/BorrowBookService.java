package c0920g1.service;

import c0920g1.model.BorrowBill;

public interface BorrowBookService extends Service<BorrowBill> {
    BorrowBill findByBorrowCode(String code);
    void removeByBorrowBookBill(BorrowBill borrowBill);
}
