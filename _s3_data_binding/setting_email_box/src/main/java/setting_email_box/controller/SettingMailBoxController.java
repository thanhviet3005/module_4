package setting_email_box.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import setting_email_box.model.MailBox;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SettingMailBoxController {

    @GetMapping("/")
    public String getSettingPage(Model model){
        MailBox mailBox = new MailBox();
        List<String> languageList = new ArrayList<>();
        List<Integer> pageSizeList = new ArrayList<>();
        languageList.add("English");
        languageList.add("Vietnamese");
        languageList.add("Thailand");
        languageList.add("Laos");

        pageSizeList.add(5);
        pageSizeList.add(10);
        pageSizeList.add(15);
        pageSizeList.add(25);
        pageSizeList.add(50);
        pageSizeList.add(100);

        model.addAttribute("pageSizeList", pageSizeList);
        model.addAttribute("languageList",languageList);
        model.addAttribute("mailBox", mailBox);

        return "/setting";
    }

    //__+__+__+__+__+__+__+__+__+__+__
    @PostMapping("/create")
    public String settingMailBox(@ModelAttribute MailBox mailBox, Model model){
        model.addAttribute("mailBox", mailBox);
        model.addAttribute("msSucess", "setting "+ mailBox.getLanguage()+" is ok");
        return "/info";
    }





//__+__+__+__+__+__+__+__+__+__+__
//__+__+__+__+__+__+__+__+__+__+__
}
