package c0920g1.controller;

import c0920g1.model.CustomerType;
import c0920g1.service.CustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/customerType")
public class CustomerTypeController {
    @Autowired
    private CustomerTypeService customerTypeService;

    @GetMapping("")
    public ModelAndView getPageListCustomerType(){
        ModelAndView modelAndView = new ModelAndView("/customer_type/ListCustomerType"
                , "customerTypeList", customerTypeService.findAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView getPageCreateCustomerType(){
        CustomerType customerType = new CustomerType();
        ModelAndView modelAndView = new ModelAndView("/customer_type/CreateCustomerType"
                , "customerType", customerType);
        return modelAndView;
    }

    @GetMapping("/{id}/remove")
    public String removeCustomerType(@PathVariable int id){
        customerTypeService.remove(id);
        return "redirect:/customerType";
    }

    @PostMapping("/create")
    public String saveCustomerType(@ModelAttribute CustomerType customerType, RedirectAttributes redirectAttributes){
        customerTypeService.save(customerType);
        redirectAttributes.addFlashAttribute("statusmsg", "Create customer type success");
        return "redirect:/customerType";
    }











//__+__+__+__+__+__+__+__+__+__+__
}
