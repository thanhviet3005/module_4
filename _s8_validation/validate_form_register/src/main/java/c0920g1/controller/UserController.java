package c0920g1.controller;

import c0920g1.model.User;
import c0920g1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public ModelAndView getPageList(){
        ModelAndView modelAndView = new ModelAndView("/listUser");
        List<User> userList = userService.findAll();
        modelAndView.addObject("userList", userList);
        return modelAndView;
    }

    @GetMapping("/user/create")
    public ModelAndView getPageCreateUser(){
        User user = new User();
        ModelAndView modelAndView = new ModelAndView("/createUser", "user", user);
        return modelAndView;
    }

    @PostMapping("/user/create")
    public String saveUser(@Validated @ModelAttribute User user
            , BindingResult bindingResult, RedirectAttributes redirectAttributes){
        new User().validate(user, bindingResult);
        if(bindingResult.hasErrors()){
            return "/createUser";
        } else{
            userService.save(user);
            redirectAttributes.addFlashAttribute("statusMsg", "Add new user success");
            return "redirect:/";
        }
    }




}
