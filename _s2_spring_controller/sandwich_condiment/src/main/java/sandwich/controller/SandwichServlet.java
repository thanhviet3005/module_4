package sandwich.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandwichServlet {
    @GetMapping("/")
    public String getPageCondiment(){
        return "/input";
    }

@RequestMapping(value = "/sandwich", method = RequestMethod.POST)
    public String showSandwichCondiment(@RequestParam(value = "condiment") String[] condiment,
                                        Model model){
        StringBuilder stringBuilder = new StringBuilder();
        for (String str: condiment) {
            if(str!=null){
                stringBuilder.append(str+", ");
            }
        }
        String str = stringBuilder.toString();
        if(str!=null){
            model.addAttribute("str", str);
            return "/result";
        }else{
            str = "not choose condiment";
            model.addAttribute("str", str);
            return "/result";
        }
    }

}
