package calculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @GetMapping("/")
    public String getPageInput(){
        return "/input";
    }

    @PostMapping("/calculator")
    public String calculator(@RequestParam String number1,
                             @RequestParam String number2,
                             @RequestParam String cal,
                             Model model){
        double num1 = Double.parseDouble(number1);
        double num2 = Double.parseDouble(number2);
        double answers = 0;
        String massage = null;
        switch (cal){
            case "Addition":
                answers = num1 + num2;
                break;
            case "Subtraction":
                answers = num1 - num2;
                break;
            case "Multiple":
                answers = num1 * num2;
                break;
            case "Division":
                if(num2 != 0){
                    answers = num1 / num2;
                }else{
                    massage = "number 2 have to different zero";
                }
                break;
        }
        model.addAttribute("number1", number1);
        model.addAttribute("number2", number2);
        model.addAttribute("answers", answers);
        model.addAttribute("massage", massage);
        return "/input";
    }

}
