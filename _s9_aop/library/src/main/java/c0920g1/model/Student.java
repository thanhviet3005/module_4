package c0920g1.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty
    private String name;

    @OneToMany(mappedBy = "student")
    private Set<BillLend> billLend;

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<BillLend> getBillLend() {
        return billLend;
    }

    public void setBillLend(Set<BillLend> billLend) {
        this.billLend = billLend;
    }
}
