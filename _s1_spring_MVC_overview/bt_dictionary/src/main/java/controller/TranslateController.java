package controller;

import model.Dictionary;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
public class TranslateController {
    @GetMapping("/")
    public String getPageTrans(){
        return "/TranslatePage";
    }

    @RequestMapping (value = "/search", method = RequestMethod.POST)
    public ModelAndView transToVN(HttpServletRequest request, HttpServletResponse response
            , ModelMap modelMap){
        String englishWord = request.getParameter("englishWord");
        String vietnamWord = null;
        Map<String, String> map = new HashMap<>();
        map.put("machine", "thiet bi co khi, cong nghe");
        map.put("house", "ngoi nha");
        map.put("building", "cong trinh");
        map.put("road", "con duong di");
        map.put("teacher", "giao vien");
        for (String word :
                map.keySet()) {
            if(word.contains(englishWord)){
                vietnamWord = map.get(word);
                englishWord = word;
                break;
            }
        }
        Dictionary dictionary = new Dictionary(englishWord, vietnamWord);
        return new ModelAndView("/ResultPage", "dictionary", dictionary );
    }

//__+__+__+__+__+__+__+__+__+__+__+__
//__+__+__+__+__+__+__+__+__+__+__+__
}
