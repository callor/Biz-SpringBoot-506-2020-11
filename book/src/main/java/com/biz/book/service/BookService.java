package com.biz.book.service;

import com.biz.book.domain.BookVO;

import java.util.List;

public interface BookService {

    public List<BookVO> selelecAll();
    public BookVO findById(Long id);

    public int insert(BookVO bookVO);
    public int update(BookVO bookVO);
    public int delete(Long id);

}
