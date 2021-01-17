package c0920g1.repository;

import c0920g1.model.CodeText;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CodeTextRepository extends JpaRepository<CodeText, Integer> {
    CodeText findByCodeLendReturn(String codeText);
}
