package com.starwars.api.Controllers;

import com.starwars.api.Models.Book;
import com.starwars.api.Repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
        model.addAttribute(
                "bookList", bookRepository.findByEraAndTypeOrderById("Old Republic era", "ON"));
        model.addAttribute("title", "The Old Republic Era");
        return "bookLists/bookList";
    }

    @RequestMapping("/rise-empire")
    public String riseOfTheEmpire(Model model) {
        model.addAttribute(
                "bookList",
                bookRepository.findByEraAndTypeOrderById("Rise of the Empire era", "ON"));
        model.addAttribute("title", "Rise of the Empire era");
        return "bookLists/bookList";
    }

    @RequestMapping("/new-republic")
    public String newRepublic(Model model) {
        model.addAttribute(
                "bookList", bookRepository.findByEraAndTypeOrderById("New Republic era", "ON"));
        model.addAttribute("title", "New Republic era");
        return "bookLists/bookList";
    }

    @RequestMapping("/new-jedi-order")
    public String newJediOrder(Model model) {
        model.addAttribute(
                "bookList", bookRepository.findByEraAndTypeOrderById("New Jedi Order era", "ON"));
        model.addAttribute("title", "New Jedi Order era");
        return "bookLists/bookList";
    }

    @RequestMapping("/legacy")
    public String legacyEra(Model model) {
        model.addAttribute(
                "bookList", bookRepository.findByEraAndTypeOrderById("Legacy era", "ON"));
        model.addAttribute("title", "Legacy era");
        return "bookLists/bookList";
    }

    @RequestMapping("/on-list")
    public String originalNovelList(Model model) {
        model.addAttribute("bookList", bookRepository.findByTypeOrderById("ON"));
        model.addAttribute("title", "Original Novels");
        return "bookLists/bookList";
    }

    @RequestMapping("/search/{query}")
    public String searchByTitle(Model model, @PathVariable(name = "query") String query) {
        model.addAttribute("bookList", bookRepository.findByTitleContainingIgnoreCase(query));
        model.addAttribute("title", "Search Results");
        return "bookLists/bookList";
    }

    @RequestMapping("/full-list")
    public String fullList(Model model) {
        model.addAttribute("bookList", bookRepository.findAllByOrderById());
        model.addAttribute("title", "Full Star Wars Legends Timeline");
        return "bookLists/bookList";
    }

    @GetMapping("modals/buyModal")
    public String modal1(
            @RequestParam("title") String title,
            @RequestParam("id") String id,
            @RequestParam("owned") boolean owned,
            Model model) {
        Book book = new Book(id, title, owned);
        model.addAttribute("book", book);
        return "modals/buyModal";
    }
}
