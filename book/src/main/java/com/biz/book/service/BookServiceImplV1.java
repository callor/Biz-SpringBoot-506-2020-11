package com.biz.book.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.biz.book.domain.BookVO;
import com.biz.book.pesistence.BookRespository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("bookServiceV1")
public class BookServiceImplV1 implements BookService {

    private final BookRespository bookDao;
    public BookServiceImplV1(BookRespository bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public List<BookVO> selelecAll() {
        List<BookVO> bookList = bookDao.findAll();
        return bookList;
    }

    /**
     * Optional
     *  데이터가 없음을 null 이아닌 어떤 명화한 근거를 바탕으로
     *  알고 싶다 라는 취지에서 새로 생성한 wrapper 클래스
     *  VO클래스를 감싸는 wrapper 클래스
     *
     *  일반적으로 DB핸들링에서 findById(Long id)를 수행한 후
     *  id에 해당하는 데이터가 없을경우 return 값이 null이엇다
     *  if(vo == null) {
     *      log.debug("데이터가 없음")
     *  }
     *
     *  Optional 은 어떤 객체의 저장된 값이 null인가를 비교하는 것을
     *  사용하지 않기 위해서 새롭게 등장한 class 이다.
     *
     *  null값을 비교하는 것 보다 연산 비용이 많이 든다
     *  아직은 논란의 여지가 많다.
     *
     */
    @Override
    public BookVO findById(Long id) {
        Optional<BookVO> bookVO = bookDao.findById(id);

        // 만약 findById() 수행하여 데이터가 없으면
        // 새로운 VO를 만들고 id값을 -1로 세팅하여 리턴하라
        // return bookVO.orElse(BookVO.builder().id(-1L).build());
        return bookVO.get();
    }

    @Override
    public int insert(BookVO bookVO) {
        bookDao.save(bookVO);
        return 0;
    }

    @Override
    public int update(BookVO bookVO) {
        bookDao.save(bookVO);
        return 0;
    }

    @Override
    public int delete(Long id) {
        bookDao.deleteById(id);
        return 0;
    }

	@Override
	public Page<BookVO> pageSelect(Pageable pageable) {

		// pagination의 페이지번호를 클릭했을때 데이터를 가져오기 쉽도록 index값을 변화
		// getPageNumber값을 0부터 시작하도록
		int page = pageable.getPageNumber() == 0 ? 0 : pageable.getPageNumber() - 1;
		// 몇페이지의 데이터를 몇개 가져올거냐
		pageable = PageRequest.of(page, 5);
		
		log.debug(pageable.toString());
		
		return bookDao.findAll(pageable);
	}
}
