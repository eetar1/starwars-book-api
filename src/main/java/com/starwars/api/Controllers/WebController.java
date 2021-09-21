package com.starwars.api.Controllers;

import com.starwars.api.Repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {

    private final BookRepository bookRepository;

    @Autowired
    public WebController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping("/index")
    public String index(Model model) {
        return "index";
    }

    @RequestMapping("/old-republic")
    public String oldRepublic(Model model) {
        return "bookLists/oldRepublic";
    }
}
