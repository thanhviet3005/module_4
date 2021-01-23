package c0920g1.controller;

import c0920g1.model.Blog;
import c0920g1.model.Category;
import c0920g1.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("")
    public ResponseEntity<List<Category>> listCategory(){
        List<Category> categoryList = categoryService.findAll();
        if(categoryList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }

    @GetMapping("/{id}/blogFollowCategory")
    public ResponseEntity<List<Blog>> listBlogFollowCategory(@PathVariable int id){
        Category category = categoryService.findById(id);
        if(category==null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            List<Blog> blogListInOneCategory = category.getBlogList();
            return new ResponseEntity<>(blogListInOneCategory, HttpStatus.OK);
        }
    }

//____+____+____+____+____+____
}
