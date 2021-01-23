package c0920g1.demo.repository;

import c0920g1.demo.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog, Integer> {
//    Page<Blog> findByContentContaining(String content, Pageable pageable);
}
