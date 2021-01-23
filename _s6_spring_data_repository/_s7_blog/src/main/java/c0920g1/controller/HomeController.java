package c0920g1.controller;

import c0920g1.model.Category;
import c0920g1.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/")
    public ModelAndView getPageHome(){
        List<Category> categoryList = categoryService.findAll();
        return new ModelAndView("/index", "categoryList", categoryList);
    }

}
