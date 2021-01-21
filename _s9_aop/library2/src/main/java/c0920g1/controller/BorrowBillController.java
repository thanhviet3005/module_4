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
@RequestMapping("/bill")
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

    @PostMapping("/borrow")
    public String saveBookAndBorrowCodeBill(@ModelAttribute Book book, RedirectAttributes redirectAttributes){
        if(book.getQuantity()<=0){
            redirectAttributes.addFlashAttribute("statusmsg", "Borrow fail, not enough book");
            return "redirect:/book";
        }else {
            BorrowBill borrowBill = new BorrowBill();
            borrowBill.setBorrowCode(Math.round(Math.random() * 10000) + "");
            borrowBill.setTitleBook(book.getTitle());
            borrowBookService.save(borrowBill);
            book.setQuantity(book.getQuantity() - 1);
            bookService.save(book);
            redirectAttributes.addFlashAttribute("statusmsg"
                    , "Borrow success, code lend = " + borrowBill.getBorrowCode());
            return "redirect:/book";
        }
    }

    @PostMapping("/return")
    public String returnBookAndDeleteBorrowCode(@RequestParam(name = "borrowCode") String borrowCode
            , RedirectAttributes redirectAttributes){
        List<Book> bookList = bookService.findAll();
        BorrowBill borrowBill = borrowBookService.findByBorrowCode(borrowCode);
        if(borrowBill==null){
            redirectAttributes.addFlashAttribute("statusmsg", "Wrong borrow code ");
            return "redirect:/book";
        }else {
            for (Book book : bookList) {
                if (book.getTitle().equals(borrowBill.getTitleBook())) {
                    book.setQuantity(book.getQuantity() + 1);
                    bookService.save(book);
                    break;
                }
            }
            borrowBookService.removeByBorrowBookBill(borrowBill);
            redirectAttributes.addFlashAttribute("statusmsg", "Return success ");
            return "redirect:/book";
        }
    }



//____+____+____+____+____+____+____
}
