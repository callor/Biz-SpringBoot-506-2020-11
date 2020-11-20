package com.biz.book.controller;

import com.biz.book.domain.BookVO;
import com.biz.book.service.BookService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/api")
public class BookApiController {

    @Qualifier("bookServiceV1")
    private final BookService bService;

    public BookApiController(BookService bService) {
        this.bService = bService;
    }

    @RequestMapping(value="/list",method= RequestMethod.GET)
    public List<BookVO> getList() {

        List<BookVO> bookList = bService.selelecAll();
        return bookList;
    }

}
