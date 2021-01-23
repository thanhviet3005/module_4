package c0920g1.service;

import c0920g1.model.Blog;

import java.util.List;

public interface BlogService extends Service<Blog> {
    List<Blog> findAllByBlogTitle(String keyword);
}
