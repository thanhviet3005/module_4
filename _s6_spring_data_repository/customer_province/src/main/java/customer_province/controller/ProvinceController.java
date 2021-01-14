package customer_province.controller;

import customer_province.model.Customer;
import customer_province.model.Province;
import customer_province.service.CustomerService;
import customer_province.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProvinceController {
    @Autowired
    private ProvinceService provinceService;

//    @GetMapping("/province")
//    public ModelAndView getPageListProvince(@PageableDefault(size = 4) Pageable pageable){
//        return new ModelAndView("/province/ListProvince"
//                , "provinceList", provinceService.findAll(pageable));
//    }

    @GetMapping("/province")
    public ModelAndView getPageListProvince(){
        return new ModelAndView("/province/ListProvince"
                , "provinceList", provinceService.findAll());
    }

    @GetMapping("/province/create")
    public ModelAndView getPageCreateProvince(){
        Province province = new Province();
        return new ModelAndView("/province/CreateProvince", "province", province);
    }

    @PostMapping("/province/create")
    public String saveProvince(@ModelAttribute Province province){
        provinceService.save(province);
        return "redirect:/province";
    }

//__+__+__+__+__+__+__+__+__+__+__+__
}
