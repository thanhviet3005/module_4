package c0920g1.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class BillLend {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

//    @OneToMany(mappedBy = "billLend")

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student student;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book book;

    private int numberLent;
    private String codeLent;
    private int numberReturn;

    public BillLend() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getNumberLent() {
        return numberLent;
    }

    public void setNumberLent(int numberLent) {
        this.numberLent = numberLent;
    }

    public String getCodeLent() {
        return codeLent;
    }

    public void setCodeLent(String codeLent) {
        this.codeLent = codeLent;
    }

    public int getNumberReturn() {
        return numberReturn;
    }

    public void setNumberReturn(int numberReturn) {
        this.numberReturn = numberReturn;
    }
}
