package c0920g1.controller;

import c0920g1.model.Customer;
import c0920g1.model.CustomerType;
import c0920g1.service.CustomerService;
import c0920g1.service.CustomerTypeService;
import c0920g1.service.impl.CustomerServiceImpl;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerTypeService customerTypeService;


    @GetMapping("")
    public ModelAndView getPageListCustomer(){
        ModelAndView modelAndView = new ModelAndView("/customer/ListCustomer"
                , "customerList", customerService.findAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView getPageCreateCustomer(){
        ModelAndView modelAndView = new ModelAndView("/customer/CreateCustomer"
                , "customer", new Customer());
        modelAndView.addObject("customerTypeList", customerTypeService.findAll());
        return modelAndView;
    }

    @PostMapping("/create")
    public String saveCustomer(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes){
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("statusmsg", "ADD new customer success");
        return "redirect:/customer";
    }

    @GetMapping("/{id}/update")
    public ModelAndView getPageUpdateCustomer(@PathVariable int id){
        Customer customer = customerService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/customer/UpdateCustomer"
                , "customer", customer);
        modelAndView.addObject("customerTypeList", customerTypeService.findAll());
        return modelAndView;
    }

    @PostMapping("/update")
    public String updateCustomer(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes){
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("statusmsg", "UPDATE customer success");
        return "redirect:/customer";
    }

    @GetMapping("/{id}/remove")
    public ModelAndView removeCustomer(@PathVariable int id){
        Customer customer = customerService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/customer/RemoveCustomer"
                , "customer", customer);
        modelAndView.addObject("customerTypeList", customerTypeService.findAll());
        return modelAndView;
    }

    @PostMapping("/remove")
    public String removeCustomer(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes){
        customerService.remove(customer.getCustomerId());
        redirectAttributes.addFlashAttribute("statusmsg", "REMOVE customer success");
        return "redirect:/customer";
    }

    @GetMapping("/search")
    public ModelAndView findCustomerByName(@RequestParam String search){
        List<Customer> customerListFind = customerService.findByName(search);
        ModelAndView modelAndView = new ModelAndView("/customer/FindCustomerByName"
                , "customerListFind", customerListFind);
        return modelAndView;
    }




//____+____+____+____+____+____+____+____
}
