package c0920g1.controller;

import c0920g1.service.BlogService;
import c0920g1.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private BlogService blogService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping("")
    public ModelAndView getPageListBlog(){
        List<Blog> blogList = blogService.findAll();
        return new ModelAndView("/blog/ListBlog", "blogList", blogList);
    }

    @GetMapping("/create")
    public ModelAndView getPageCreateBlog(){
        Blog blog = new Blog();
        List<Category> categoryList = categoryService.findAll();
        ModelAndView modelAndView = new ModelAndView("/blog/CreateBlog", "blog", blog);
        modelAndView.addObject("categoryList", categoryList);
        return modelAndView;
    }

    @PostMapping("/create")
    public String saveBlog(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes){
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("statusmsg", "Create new blog success");
        return "redirect:/blog";
    }

    @GetMapping("/{id}/update")
    public ModelAndView getPageUpdateBlog(@PathVariable int id){
        Blog blog = blogService.findById(id);
        List<Category> categoryList = categoryService.findAll();
        ModelAndView modelAndView = new ModelAndView("/blog/UpdateBlog", "blog", blog);
        modelAndView.addObject("categoryList", categoryList);
        return modelAndView;
    }

    @PostMapping("/update")
    public String updateBlog(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes){
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("statusmsg", "Update new blog success");
        return "redirect:/blog";
    }

    @GetMapping("/title/search")
    public ModelAndView getPageSearchTitleBlog(@RequestParam(value = "search") String search){
        List<Blog> blogList = blogService.findAllByBlogTitle(search);
        return new ModelAndView("/blog/ListBySearch", "blogList", blogList);
    }

    @GetMapping("/{idCategory}/{idBlog}/detailBlog")
    public ModelAndView getPageDetailBlog(@PathVariable(value = "idCategory") int idCategory
            , @PathVariable(value = "idBlog") int idBlog){
        Blog blog = blogService.findById(idBlog);
        Category category = categoryService.findById(idCategory);
        String categoryName = category.getCategoryName();
        ModelAndView modelAndView = new ModelAndView("/blog/DetailBlog", "blog", blog);
        modelAndView.addObject("categoryList", categoryService.findAll());
        modelAndView.addObject("categoryName", categoryName);
        categoryName = null;
        return modelAndView;
    }










//____+____+____+____+____+____
}
