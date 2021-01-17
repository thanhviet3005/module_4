package c0920g1.controller;

import c0920g1.model.Student;
import c0920g1.repository.StudentRepository;
import c0920g1.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("")
    public ModelAndView getPageListStudent(){
        List<Student> studentList = studentService.findAll();
        ModelAndView modelAndView = new ModelAndView("/student/ListStudent"
                , "studentList", studentList);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView getPageCreateStudent(){
        Student student = new Student();
        ModelAndView modelAndView = new ModelAndView("/student/CreateStudent", "student", student);
        return modelAndView;
    }

    @PostMapping("/create")
    public String saveStudent(@ModelAttribute Student student, RedirectAttributes redirectAttributes){
        studentService.save(student);
        redirectAttributes.addFlashAttribute("statusMsg", "Add student success");
        return "redirect:";

    }




}
