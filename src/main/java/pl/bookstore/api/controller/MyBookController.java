package pl.bookstore.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.bookstore.business.MyBooksService;

@Controller
public class MyBookController {
    @Autowired
    private MyBooksService myBooksService;

    @RequestMapping("/deleteMyBook/{id}")
    public String deleteMyBook(@PathVariable("id") int id){
        myBooksService.deleteById(id);
        return "redirect:/my_books";
    }
}
