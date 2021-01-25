package c0920g1.controller;

import c0920g1.model.Blog;
import c0920g1.service.BlogService;
import c0920g1.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/blog/api")
public class BlogController {
    @Autowired
    private BlogService blogService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping("")
    public ResponseEntity<List<Blog>> listBlog(){
        List<Blog> blogList = blogService.findAll();
        if(blogList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

    @GetMapping("/{idBlog}/detailBlog")
    public ResponseEntity<Blog> getPageDetailBlog(@PathVariable(value = "idBlog") int idBlog){
        Blog blog = blogService.findById(idBlog);
        if(blog==null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

    @PostMapping("/create")     // bi loi, khong tao moi duoc
    public ResponseEntity<Void> addBlog(@RequestBody Blog blog, UriComponentsBuilder uriComponentsBuilder){
        blogService.save(blog);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uriComponentsBuilder.path("/blog/api/{idBlog}/detailBlog").buildAndExpand(blog.getBlogId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping("/{idBlog}/update")
    public ResponseEntity<Blog> updateBlog(@PathVariable(value = "idBlog") int id, @RequestBody Blog blog){
        Blog blogToUpdate = blogService.findById(id);
        if(blogToUpdate==null){
            System.out.println("Blog "+id+" not found");
            return new ResponseEntity<Blog>(HttpStatus.NO_CONTENT);
        }else{
            blogToUpdate.setBlogTitle(blog.getBlogTitle());
            blogToUpdate.setBlogContent(blog.getBlogContent());
            blogToUpdate.setBlogDateCreate(blog.getBlogDateCreate());
            blogToUpdate.setCategory(blog.getCategory());
            blogService.save(blogToUpdate);
            return new ResponseEntity<>(blogToUpdate, HttpStatus.OK);
        }
    }

    // xoa duoc, nhung phai trong @OneToMany va @ManyToOne phai cung de la fetch = FetchType.EAGER
    @DeleteMapping("/{idBlog}/delete")
    public ResponseEntity<Blog> deleteBlog(@PathVariable(value = "idBlog") int idBlog){
        Blog blogToDelete = blogService.findById(idBlog);
        if(blogToDelete==null){
            System.out.println("Blog "+idBlog+" not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            blogService.remove(idBlog);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

//____+____+____+____+____+____
}

