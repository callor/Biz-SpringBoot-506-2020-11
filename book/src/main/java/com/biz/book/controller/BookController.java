package com.biz.book.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.book.domain.BookVO;
import com.biz.book.service.BookService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value="/book")
public class BookController {

    @Qualifier("bookServiceV1")
    private final BookService bookService;
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    
    @RequestMapping(value="/list",method= RequestMethod.GET)
    public String getList (@PageableDefault Pageable pageable,Model model) {

        Page<BookVO> bookList = bookService.pageSelect(pageable);
        model.addAttribute("BOOKS",bookList);
        return "book/list";
        
    }

    @RequestMapping(value="/view",method=RequestMethod.GET)
    public String view(String id,Model model) {
        BookVO bookVO = bookService.findById(Long.valueOf(id));
        model.addAttribute("BOOK",bookVO);
        return "book/view";
    }

    @RequestMapping(value="/delete/{id}")
    public String delete(@PathVariable("id")  String id) {
        bookService.delete(Long.valueOf(id));
        return "redirect:/book/list";
    }
    
    @RequestMapping(value="/insert",method=RequestMethod.GET)
    public String insert(@ModelAttribute BookVO bookVO,Model model) {
    	model.addAttribute("BOOK",bookVO);
    	return "book/input";
    }
    
    @RequestMapping(value="/insert",method=RequestMethod.POST)
    public String insert(@ModelAttribute BookVO bookVO) {
    	
    	log.debug(bookVO.toString());
    	
    	bookService.insert(bookVO);
    	return "redirect:/book/list";
    }
    
    @RequestMapping(value="/update/{id}",method=RequestMethod.GET)
    public String update(@PathVariable("id") String id, Model model) {
    	
    	BookVO bookVO = bookService.findById(Long.valueOf(id));
    	model.addAttribute("BOOK",bookVO);
    	return "book/input";
    }

    @RequestMapping(value="/update/{id}",method=RequestMethod.POST)
    public String update(@ModelAttribute BookVO bookVO,Model model) {
    	
    	bookService.update(bookVO);
    	log.debug(bookVO.toString());
    	model.addAttribute("id",bookVO.getId().toString());
    	return "redirect:/book/view?id=" + bookVO.getId() ;
  
    }
}






