package c0920g1.repository;

import c0920g1.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlogRepository extends JpaRepository<Blog, Integer> {
    List<Blog> findAllByBlogTitleContaining(String keyword);

}
