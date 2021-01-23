package c0920g1.controller;

import c0920g1.model.Category;
import c0920g1.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("")
    public ModelAndView getPageListCategory(){
        List<Category> categoryList = categoryService.findAll();
        return new ModelAndView("/category/ListCategory", "categoryList", categoryList);
    }

    @GetMapping("/create")
    public ModelAndView getPageCreateCategory(){
        Category category = new Category();
        return new ModelAndView("/category/CreateCategory", "category", category);
    }

    @PostMapping("/create")
    public String saveCategory(@ModelAttribute Category category, RedirectAttributes redirectAttributes){
        categoryService.save(category);
        redirectAttributes.addFlashAttribute("statusmsg", "Create category success");
        return "redirect:";
    }

    @GetMapping("/{id}/update")
    public ModelAndView getPageCreateCategory(@PathVariable int id){
        Category category = categoryService.findById(id);
        return new ModelAndView("/category/CreateCategory", "category", category);
    }

    @PostMapping("/update")
    public String updateCategory(@ModelAttribute Category category, RedirectAttributes redirectAttributes){
        categoryService.save(category);
        redirectAttributes.addFlashAttribute("statusmsg", "Update category success");
        return "redirect:/category";
    }

    @GetMapping("/{id}/detail")
    public ModelAndView getPageDetail(@PathVariable int id){
        Category category = categoryService.findById(id);
        return new ModelAndView("/category/DetailCategory", "category", category);
    }

    @GetMapping("/{id}/remove")
    public ModelAndView getPageRemoveCategory(@PathVariable int id){
        Category category = categoryService.findById(id);
        return new ModelAndView("/category/DetailCategory", "category", category);
    }

    @PostMapping("/remove")
    public String removeCategory(@ModelAttribute Category category, RedirectAttributes redirectAttributes){
        categoryService.remove(category.getCategoryId());
        redirectAttributes.addFlashAttribute("statusmsg", "Remove category success");
        return "redirect:/category";
    }

    @GetMapping("/{id}/blogFollowCategory")
    public ModelAndView getPageBlogFollowCategory(@PathVariable int id){
        Category category = categoryService.findById(id);
        return new ModelAndView("/blog/BlogFollowCategory", "category", category);
    }







//____+____+____+____+____+____
}
