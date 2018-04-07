package com.spring.ajax.springbootajax.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/page")
public class ControllerPage {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView getIndexPage(){
        ModelAndView view = new ModelAndView();
        view.setViewName("index");
        view.addObject("title", "Index");
        return view;
    }

    @RequestMapping(value = "/category", method = RequestMethod.GET)
    public ModelAndView getCategoryPage(){
        ModelAndView view = new ModelAndView();
        view.setViewName("category");
        view.addObject("title", "Category");
        return view;
    }
    
    @RequestMapping(value = "/book", method = RequestMethod.GET)
    public ModelAndView getBookPage() {
    	ModelAndView view = new ModelAndView();
    	view.addObject("title", "Book");
    	view.setViewName("book");
    	return view;
    }
}
