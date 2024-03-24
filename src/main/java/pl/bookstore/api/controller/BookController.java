package pl.bookstore.api.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.bookstore.business.BookService;
import pl.bookstore.business.MyBooksService;
import pl.bookstore.business.dto.BookDTO;
import pl.bookstore.business.dto.MyBookDTO;
import pl.bookstore.entity.mapper.BookEntityMapper;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;
    @Autowired
    private MyBooksService myBooksService;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/book_register")
    public String bookRegister() {
        return "bookRegister";
    }

    @GetMapping("/available_books")
    public String getAvailableBooks(Model model) {
        List<BookDTO> bookList = bookService.showAllBooks();
        model.addAttribute("bookList", bookList);
        return "bookList";
    }

    @PostMapping("/save")
    public String addBook(@ModelAttribute BookDTO bookDTO) {
        bookService.createNewBook(bookDTO);
        return "redirect:/available_books";
    }

    @GetMapping("/my_books")
    public String getMyBooks(Model model){
        List<MyBookDTO> allMyBooks = myBooksService.getAllMyBooks();
        model.addAttribute("book", allMyBooks);
        return "myBooks";
    }

    @RequestMapping("/mylist/{id}")
    public String getMyList(@PathVariable("id") int id){
        BookDTO bookDTO = bookService.getBookById(id);
        myBooksService.saveMyBooks(bookDTO);
        return "redirect:/my_books";
    }
    @RequestMapping("/editBook/{id}")
    public String editBook(@PathVariable("id") int id, Model model){
        BookDTO bookDTO = bookService.getBookById(id);
        model.addAttribute("bookDTO", bookDTO);
        return "bookEdit";
    }

    @RequestMapping("/deleteBook/{id}")
    public String delete(@PathVariable("id") int id){
        bookService.deleteById(id);
        return "redirect:/available_books";
    }
}
