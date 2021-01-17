package c0920g1.controller;

import c0920g1.model.Book;
import c0920g1.model.CodeText;
import c0920g1.service.BookService;
import c0920g1.service.CodeTextService;
import org.aspectj.apache.bcel.classfile.Code;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    @Autowired
    private CodeTextService codeTextService;

    @GetMapping("/")
    public ModelAndView getPageListBook(){
        List<Book> bookList = bookService.findAll();
        ModelAndView modelAndView = new ModelAndView("/book/ListBook", "bookList", bookList);
        return modelAndView;
    }

    @GetMapping("/book/create")
    public ModelAndView getPageCreateBook(){
        Book book = new Book();
        ModelAndView modelAndView = new ModelAndView("/book/CreateBook", "book", book);
        return modelAndView;
    }

    @GetMapping("/book/{id}/borrow")
    public ModelAndView getPageBorrowBook(@PathVariable int id){
        Book book = bookService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/book/BorrowBook");
        modelAndView.addObject("book", book);
        return modelAndView;
    }

    @PostMapping("/book/create")
    public String saveBook(@ModelAttribute Book book){
        bookService.save(book);
        return "redirect:/";
    }

    @GetMapping("/book/{id}/return")
    public ModelAndView getPageReturnBook(@PathVariable int id){
        Book book = bookService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/book/ReturnBook");
        modelAndView.addObject("book", book);
        return modelAndView;
    }

    @PostMapping("/book/borrow")
    public ModelAndView borrowBook(@ModelAttribute Book book, RedirectAttributes redirectAttributes){
        book.getCodeText().setCodeLendReturn(Math.random()*1000 +"");
        book.setQuantity(book.getQuantity()-1);
        bookService.save(book);
        redirectAttributes.addFlashAttribute("statusMsg", "Borrowing book success");
        ModelAndView modelAndView = new ModelAndView("/book/BorrowBook", "book", book);
        return modelAndView;
    }

    @PostMapping("/book/return")
    public String returnBook(@ModelAttribute Book book, RedirectAttributes redirectAttributes, Model model){
        int quantity = book.getQuantity();
        String codeReturn = book.getCodeText().getCodeLendReturn();
        Book bookUpdate = bookService.findByCodeLendReturn(codeReturn);
        if(bookUpdate!=null){
            bookUpdate.setQuantity(quantity+1);
            bookUpdate.getCodeText().setCodeLendReturn("");
            bookService.save(bookUpdate);
        }
        model.addAttribute("book", bookUpdate);
        redirectAttributes.addFlashAttribute("statusMsg", "Returning success");
        return "redirect:/";
    }



//__+__+__+__+__+__+__+__+__
}
