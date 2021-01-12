package c0920g1.demo.managing_customer_2.controller;

import c0920g1.demo.managing_customer_2.model.Province;
import c0920g1.demo.managing_customer_2.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProvinceController {
    @Autowired
    private ProvinceService provinceService;

    @GetMapping("/province")
    public ModelAndView getListProvince(){
        Iterable<Province> provincesList = provinceService.findAll();
        return new ModelAndView("/listProvince", "provincesList", provincesList);
    }

    @GetMapping("/createProvince")
    public ModelAndView getPageCreateProvince(){
        Province province = new Province();
        return new ModelAndView("/createProvince", "province", province);
    }

    @PostMapping("/create")
    public String saveNewProvince(@ModelAttribute Province province, RedirectAttributes redirectAttributes){
        provinceService.save(province);
        redirectAttributes.addFlashAttribute("massage", "Success add new province");
        return "redirect:/province";
    }





//__+__+__+__+__+__+__+__+__
//__+__+__+__+__+__+__+__+__
}
