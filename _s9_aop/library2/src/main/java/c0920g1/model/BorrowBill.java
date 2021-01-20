package c0920g1.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class BorrowBill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int borrowId;
    private String titleBook;
    private String borrowCode;


    public BorrowBill() {
    }

    public int getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(int borrowId) {
        this.borrowId = borrowId;
    }

    public String getBorrowCode() {
        return borrowCode;
    }

    public void setBorrowCode(String borrowCode) {
        this.borrowCode = borrowCode;
    }

    public String getTitleBook() {
        return titleBook;
    }

    public void setTitleBook(String titleBook) {
        this.titleBook = titleBook;
    }
}



//    @OneToMany(mappedBy = "borrowBookCode")
//    private Set<Book> bookSet;

//    public Set<Book> getBookSet() {
//        return bookSet;
//    }
//
//    public void setBookSet(Set<Book> bookSet) {
//        this.bookSet = bookSet;
//    }