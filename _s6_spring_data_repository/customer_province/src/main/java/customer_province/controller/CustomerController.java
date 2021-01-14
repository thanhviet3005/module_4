package customer_province.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import customer_province.model.Customer;
import customer_province.model.Province;
import customer_province.service.CustomerService;
import customer_province.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private ProvinceService provinceService;

    @ModelAttribute("provinceList")
    public Iterable<Province> provinceIterable(){
        return provinceService.findAll();
    }

    @GetMapping("/")
    public ModelAndView getPageListCustomer(@PageableDefault(size = 2) Pageable pageable){
        return new ModelAndView("/customer/ListCustomer"
                , "customerList", customerService.findAll(pageable));
    }

    @GetMapping("/customer/create")
    public ModelAndView getPageCreateCustomer(){
        Customer customer = new Customer();
        ModelAndView modelAndView = new ModelAndView("/customer/CreateCustomer");
        modelAndView.addObject("customer", customer);
        return modelAndView;
    }

    @GetMapping("/customer/{id}/update")
    public ModelAndView getPageUpdateCustomer(@PathVariable Integer id){
        Customer customer = customerService.findById(id);
        return new ModelAndView("/customer/UpdateCustomer", "customer", customer);
    }

    @GetMapping("/customer/{id}/remove")
    public ModelAndView getPageRemoveCustomer(@PathVariable int id){
        Customer customer = customerService.findById(id);
        return new ModelAndView("/customer/RemoveCustomer", "customer", customer);
    }

    @PostMapping("/customer/search")
    public ModelAndView getListSearchName(@RequestParam String searchName, @PageableDefault(value = 2)Pageable pageable){
        return new ModelAndView("/customer/ListCustomer"
                , "customerList", customerService.findByInputText(searchName, pageable));
    }

    @PostMapping("/customer/create")
    public String saveCustomer(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes){
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("success", "Add new customer success");
        return "redirect:/";
    }

    @PostMapping("/customer/update")
    public String updateCustomer(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes){
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("success", "Update customer success");
        return "redirect:/";
    }

    @PostMapping("/customer/remove")
    public String removeCustomer(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes){
        customerService.removeById(customer.getId());
        redirectAttributes.addFlashAttribute("success", "Remove customer success");
        return "redirect:/";
    }


//__+__+__+__+__+__+__+__+__+__+
//__+__+__+__+__+__+__+__+__+__+
}
