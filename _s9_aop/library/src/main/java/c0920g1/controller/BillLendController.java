package c0920g1.controller;

import c0920g1.model.BillLend;
import c0920g1.model.Book;
import c0920g1.model.Student;
import c0920g1.service.BillLendService;
import c0920g1.service.BookService;
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
@RequestMapping("/bill")
public class BillLendController {
    @Autowired
    private BillLendService billLendService;
    @Autowired
    private BookService bookService;
    @Autowired
    private StudentService studentService;

//    @ModelAttribute ("bookList")
//    public Iterable<Book> bookIterable(){
//        return bookService.findAll();
//    }
//
//    @ModelAttribute ("studentList")
//    public Iterable<Student> studentIterable(){
//        return studentService.findAll();
//    }

    @GetMapping("")
    public ModelAndView getPageListBillLend(){
        List<BillLend> billLendList = billLendService.findAll();
        ModelAndView modelAndView = new ModelAndView("/bill_lend/ListBill"
                , "billLendList", billLendList);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView getPageCreateBillLend(){
        BillLend billLend = new BillLend();
        List<Book> bookList = bookService.findAll();
        List<Student> studentList = studentService.findAll();
        ModelAndView modelAndView = new ModelAndView("/bill_lend/CreateBill");
        modelAndView.addObject("bookList", bookList);
        modelAndView.addObject("studentList", studentList);
        modelAndView.addObject("billLend", billLend);
        return modelAndView;
    }

    @PostMapping("/create")
    public String saveBillLend(@ModelAttribute BillLend billLend){
        int numberLend = billLend.getNumberLent();
        int numberReturn = billLend.getNumberReturn();
        int numberInStore = billLend.getBook().getNumber();
        Book book = bookService.findById(billLend.getBook().getId());
        if(0 <= numberLend && numberLend <= numberInStore || numberReturn > 0 ){
            book.setNumber(numberInStore - numberLend + numberReturn);
            bookService.save(book);
        }
        return "redirect:";
    }






//__+__+__+__+__+__+__+__+__+__
}
