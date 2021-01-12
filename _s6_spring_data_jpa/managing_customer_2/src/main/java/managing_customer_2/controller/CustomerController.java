package managing_customer_2.controller;

import managing_customer_2.model.Customer;
import managing_customer_2.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping("/")
    public ModelAndView getPageList(){
        ModelAndView modelAndView = new ModelAndView("/list", "customerList", customerService.findAll());
        return modelAndView;
    }

    @GetMapping("/customer/create")
    public ModelAndView getPageCreate(){
        Customer customer = new Customer();
        ModelAndView modelAndView = new ModelAndView("/create", "customer", customer);
        return modelAndView;
    }

    @GetMapping("/customer/{id}/edit")
    public ModelAndView getPageUpdate(@PathVariable int id){
        Customer customer = customerService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/update", "customer", customer);
        return  modelAndView;
    }

    @PostMapping("/update")
    public String updateCustomer(Customer customer){
        customerService.update(customer);
        return "redirect:/";
    }

    @PostMapping("/create")
    public String saveCustomer(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes){
        customerService.save(customer);
//        redirectAttributes.addFlashAttribute("successAdd", "Create customer success");
        return "redirect:/";
    }





}
