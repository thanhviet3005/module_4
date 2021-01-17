package c0920g1.model;

import javax.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String bookName;
    private int quantity;

    @ManyToOne(cascade =  CascadeType.ALL)
    @JoinColumn(name = "codeText_id", referencedColumnName = "codeText_id")
    private CodeText codeText;

    public Book() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public CodeText getCodeText() {
        return codeText;
    }

    public void setCodeText(CodeText codeText) {
        this.codeText = codeText;
    }
}
