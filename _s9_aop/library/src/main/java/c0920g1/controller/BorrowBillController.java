package c0920g1.controller;

import c0920g1.model.BorrowBill;
import c0920g1.service.BookService;
import c0920g1.service.BorrowBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/borrow")
public class BorrowBillController {
    @Autowired
    private BookService bookService;
    @Autowired
    private BorrowBookService borrowBookService;

    @GetMapping("")
    public ModelAndView getPageListBorrowBill(){
        List<BorrowBill> borrowBillList = borrowBookService.findAll();
        ModelAndView modelAndView = new ModelAndView("/book_bill/ListBorrowBill"
                , "borrowBillList", borrowBillList);
        modelAndView.addObject("bookList", bookService.findAll());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView getPageCreateBorrowBill(){
        BorrowBill borrowBill = new BorrowBill();
        return new ModelAndView("/book_bill/CreateBill", "borrowBill", borrowBill);
    }

//____+____+____+____+____+____+____
}
