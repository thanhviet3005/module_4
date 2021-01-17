package c0920g1.controller;

import c0920g1.model.Book;
import c0920g1.service.BookService;
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
    private BookService bookService;

    @GetMapping("")
    public ModelAndView getPageListBook(){
        List<Book> bookList = bookService.findAll();
        ModelAndView modelAndView = new ModelAndView("/book/ListBook", "bookList", bookList);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView getPageCreateBook(){
        Book book = new Book();
        ModelAndView modelAndView = new ModelAndView("/book/CreateBook", "book", book);
        return modelAndView;
    }

    @GetMapping("/{id}/borrow")
    public ModelAndView getPageBorrowBook(@PathVariable int id){
        Book book = bookService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/book/BorrowBook", "book", book);
        return modelAndView;
    }

    @PostMapping(value = "/borrow")
    public String borrowBook(@ModelAttribute Book book){


    }

    @PostMapping(value = "/create")
    public String saveBook(@ModelAttribute Book book, RedirectAttributes redirectAttributes){
        bookService.save(book);
        redirectAttributes.addFlashAttribute("statusMsg", "Add book success");
        return "redirect:";
    }











//__+__+__+__+__+__+__+__+__+__
//__+__+__+__+__+__+__+__+__+__
}
