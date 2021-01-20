package c0920g1.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class CodeText {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codeText_id;
    private String codeLendReturn;

    @OneToMany(mappedBy = "codeText")
    private Set<Book> bookSet;

    public CodeText() {
    }

    public int getCodeText_id() {
        return codeText_id;
    }

    public void setCodeText_id(int id) {
        this.codeText_id = id;
    }

    public String getCodeLendReturn() {
        return codeLendReturn;
    }

    public void setCodeLendReturn(String codeLendReturn) {
        this.codeLendReturn = codeLendReturn;
    }

    public Set<Book> getBookSet() {
        return bookSet;
    }

    public void setBookSet(Set<Book> bookSet) {
        this.bookSet = bookSet;
    }
}
