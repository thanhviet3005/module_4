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
    public String showSandwichCondiment(@RequestParam(value = "condiment", required = false) String[] condiment,
                                        Model model){
    StringBuffer stringBuffer = new StringBuffer();
    if(condiment!=null){
        for (String str: condiment) {
            stringBuffer.append(str+", ");
        }
        String str = stringBuffer.toString();
        model.addAttribute("str", str);
        return "/result";
    }else{
        return "/input";
    }

    }

}
