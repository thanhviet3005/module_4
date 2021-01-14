package c0920g1.demo.controller;

import c0920g1.demo.model.Blog;
import c0920g1.demo.repository.BlogRepository;
import c0920g1.demo.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Controller
public class BlogController {
    @Autowired
    private BlogService blogService;

    @GetMapping("/")
    public ModelAndView getPageListBlog(){
        List<Blog> blogList = blogService.findAll();
        return new ModelAndView("/blog/list", "blogList", blogList);
    }

    @GetMapping("/blog/createNew")
    public ModelAndView getPageCreateBlog(){
        Blog blog = new Blog();
        ModelAndView modelAndView = new ModelAndView("/blog/createBlog");
        modelAndView.addObject("blog", blog);
        return modelAndView;
    }

    @GetMapping("/blog/{id}/update")
    public ModelAndView getPageUpdateBlog(@PathVariable Integer id){
        Blog blog = blogService.findById(id);
        return new ModelAndView("/blog/updateBlog", "blog", blog);
    }

    @GetMapping("/blog/{id}/remove")
    public ModelAndView getPageRemoveBlog(@PathVariable Integer id){
        Blog blog = blogService.findById(id);
        return new ModelAndView("/blog/removeBlog", "blog", blog);
    }

    @PostMapping("/blog/create")
    public String saveBlog(@ModelAttribute Blog blog){
        blogService.save(blog);
        return "redirect:/";
    }

    @PostMapping("/blog/update")
    public String updateBlog(@ModelAttribute Blog blog){
        blogService.save(blog);
        return "redirect:/";
    }

    @PostMapping("/blog/remove")
    public String removeBlog(@ModelAttribute Blog blog){
        blogService.remove(blog.getId());
        return "redirect:/";
    }










//__+__+__+__+__+__+__+__+__+__+__+__
}



//    public ModelAndView getPageListBlog(@PageableDefault(size = 4)Pageable pageable){
//        return new ModelAndView("/blog/list"
//                , "blogList", blogRepository.findAll(pageable));
//    }