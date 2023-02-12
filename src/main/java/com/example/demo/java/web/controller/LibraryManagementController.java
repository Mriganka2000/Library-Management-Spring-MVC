package com.example.demo.java.web.controller;

import com.example.demo.java.business.bean.BookBean;
import com.example.demo.java.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class LibraryManagementController {

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String viewHomePage(Model model) {
        List<BookBean> bookBeans = bookService.findAllBooks();
        model.addAttribute("books", bookBeans);

        return "index";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public ModelAndView showAddNewBookPage() {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("add_new");
        modelAndView.addObject("bookBean", new BookBean());

        return modelAndView;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("book") BookBean bookBean) {
        bookService.saveNewBook(bookBean);

        return "redirect:/";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView showEditBookPage(@PathVariable(name = "id") Long id) {
        ModelAndView modelAndView = new ModelAndView();
        BookBean bookBean = bookService.findByBookId(id);
        System.out.println(bookBean);

        modelAndView.setViewName("edit_book");
        modelAndView.addObject("bookBean", bookBean);

        return modelAndView;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable(name = "id") Long id) {
        bookService.deleteBook(id);

        return "redirect:/";
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ModelAndView searchResult(@RequestParam String keyword) {
        List<BookBean> bookBeans = bookService.searchByKeyword(keyword);
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("search_result");
        modelAndView.addObject("bookBeans", bookBeans);

        return modelAndView;
    }

}
