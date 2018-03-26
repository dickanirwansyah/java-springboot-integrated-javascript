package com.spring.boot.springpostgresql.controller.page;

import com.spring.boot.springpostgresql.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControllerPage {

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/data/page/book", method = RequestMethod.GET)
    public ModelAndView getPageBook(){
        ModelAndView view = new ModelAndView();
        view.setViewName("databook");
        view.addObject("title", "Data Buku");
        view.addObject("books", bookService.listBook());
        return view;
    }

    @RequestMapping(value = "/data/page/cart", method = RequestMethod.GET)
    public ModelAndView getPageCart(){
        ModelAndView view = new ModelAndView();
        view.setViewName("datacart");
        view.addObject("title", "Order Buku");
        return view;
    }

    @RequestMapping(value = "/data/page/category", method = RequestMethod.GET)
    public ModelAndView getPageCategory(){
        ModelAndView view = new ModelAndView();
        view.setViewName("datacategory");
        view.addObject("title", "Category Book");
        return view;
    }
}
