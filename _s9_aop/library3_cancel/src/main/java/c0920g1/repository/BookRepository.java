package c0920g1.repository;

import c0920g1.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
    Book findByCodeTextCodeLendReturn (String code);
}
