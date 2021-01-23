package c0920g1.demo.service;

import c0920g1.demo.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BlogService {
    List<Blog> findAll();
//    Page<Blog> findAll(Pageable pageable);
    void save(Blog blog);
    void remove(Integer id);
    Blog findById(Integer id);
}
