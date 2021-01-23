package c0920g1.repository;

import c0920g1.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BlogRepository extends JpaRepository<Blog, Integer> {
    List<Blog> findAllByBlogTitleContaining(String keyword);

}
