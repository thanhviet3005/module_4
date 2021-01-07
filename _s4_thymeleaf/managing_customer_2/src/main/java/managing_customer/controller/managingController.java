package managing_customer.controller;

import managing_customer.model.Customer;
import managing_customer.repository.CustomerRepository;
import managing_customer.service.CustomerRepositoryImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class managingController {
    CustomerRepository customerRepository = new CustomerRepositoryImpl();

    @GetMapping("/")
    public String getPageList(Model model){
        CustomerRepository customerRepository = new CustomerRepositoryImpl();
        List<Customer> customerList = customerRepository.getAll();
        model.addAttribute("customerList", customerList);
        return "/index";
    }

    @GetMapping("/customer/{id}/delete")
    public String getPageDelete(@PathVariable int id, Model model){
        Customer customer = customerRepository.findById(id);
        model.addAttribute("customer", customer);
        return "/delete";
    }

    @GetMapping("/customer/{id}/view")
    public String getPageDetail(@PathVariable int id, Model model){
        Customer customer = customerRepository.findById(id);
        model.addAttribute("customer", customer);
        return "/detail";
    }

    @GetMapping("/customer/create")
    public String getPageCreate(Model model){
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "/create";
    }

    @PostMapping("/customer/delete")
    public String deleteCustomer(Customer customer){
        customerRepository.removeCustomer(customer.getId());
        return "redirect:/";
    }

    @PostMapping("/customer/create")
    public String saveCustomer(Customer customer){
        customerRepository.saveCustomer(customer);
        return "redirect:/";
    }

    @GetMapping("/customer/{id}/edit")
    public String getPageEdit(@PathVariable int id, Model model){
        Customer customer = customerRepository.findById(id);
        model.addAttribute("customer", customer);
        return "/edit";
    }

    @PostMapping("/customer/edit")
    public String editCustomer(Customer customer){
        customerRepository.updateCustomer(customer);
        return "redirect:/";
    }











//__+__+__+__+__+__+__+__+__+__+__
//__+__+__+__+__+__+__+__+__+__+__
}
