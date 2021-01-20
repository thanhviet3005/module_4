package c0920g1.model;

import javax.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private int quantity;

    public Book() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


}

//    @ManyToOne(cascade =  CascadeType.ALL)
//    @JoinColumn(name = "borrow_id", referencedColumnName = "borrowId")
//    private BorrowBill borrowBookCode;

//    public BorrowBill getBorrowBookCode() {
//        return borrowBookCode;
//    }
//
//    public void setBorrowBookCode(BorrowBill borrowBookCode) {
//        this.borrowBookCode = borrowBookCode;
//    }
