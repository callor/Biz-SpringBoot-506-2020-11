package com.biz.book.pesistence;


import com.biz.book.domain.BookVO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRespository extends JpaRepository<BookVO,Long> {



}
