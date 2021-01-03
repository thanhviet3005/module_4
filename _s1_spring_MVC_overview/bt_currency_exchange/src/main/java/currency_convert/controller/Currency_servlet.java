package currency_convert.controller;

import currency_convert.model.CurrencyRate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
public class Currency_servlet {

    @GetMapping("/")
    public String exchangeCurrency(){
        return "/input";
    }

    @RequestMapping(value ="/exchange", method = RequestMethod.POST)
    public String exchangeComplete(HttpServletRequest request, Model model){
        int amount = Integer.parseInt(request.getParameter("amount"));
        int rate =  Integer.parseInt(request.getParameter("rate"));
        int ans = amount * rate;
        model.addAttribute("amount", amount);
        model.addAttribute("rate",rate);
        model.addAttribute("ans", ans);

        return "/result";
    }


//__+__+__+__+__+__+__+__+__+__+__+__
//__+__+__+__+__+__+__+__+__+__+__+__
}
