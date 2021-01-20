package c0920g1.controller;

import c0920g1.model.Book;
import c0920g1.model.BorrowBill;
import c0920g1.service.BookService;
import c0920g1.service.BorrowBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BorrowBookService borrowBookService;
    @Autowired
    private BookService bookService;

    @GetMapping("")
    public ModelAndView getPageListBook(){
        List<Book> bookList = bookService.findAll();
        List<BorrowBill> borrowBillList = borrowBookService.findAll();
        ModelAndView modelAndView = new ModelAndView("/book_bill/ListBook");
        modelAndView.addObject("bookList", bookList);
        modelAndView.addObject("borrowBillList", borrowBillList);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView getPageCreateBook(){
        return new ModelAndView("/book_bill/CreateBook", "book", new Book());
    }

    @PostMapping("/create")
    public String saveBook(@ModelAttribute Book book, RedirectAttributes redirectAttributes){
        bookService.save(book);
        redirectAttributes.addFlashAttribute("statusmsg", "Create book success");
        return "redirect:/book";
    }

    @GetMapping("/{id}/borrow")
    public ModelAndView getPageCreateBorrowBill(@PathVariable int id){
        Book book = bookService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/book_bill/CreateBill", "book", book);
        return modelAndView;
    }











//____+____+____+____+____+____+____
}
