package com.biz.bbs.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.biz.bbs.domain.BBsVO;
import com.biz.bbs.domain.persistence.BBsDao;

@CrossOrigin({"http://localhost:3000", "*"})
@RestController
@RequestMapping(value = "/api")
public class BBsApiController {

	@Autowired
	private BBsDao bbsDao;

	@RequestMapping(value = "/bbsList", method = RequestMethod.GET)
	public List<BBsVO> list() {
		List<BBsVO> bbsList = bbsDao.findAll();
		return bbsList;
	}

	@RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
	public BBsVO findBy(@PathVariable("id") String id) {
		Optional<BBsVO> optionVO = bbsDao.findById(Long.valueOf(id));
		BBsVO bbsVO = optionVO.get();
		return bbsVO;
	}

	
	/*
	 * Jquery Ajax 통해서 JSON데이터를 보낼때는 Spring Controller의 method에서
	 * VO에 데이터를 받을수 있도록 잘 요리해서 보내준다.
	 * 
	 * axios, fetch를 사용할때는 spring framework와의 관계에서 매끄럽지 못하게
	 * 데이터가 변환되는 현상이 있다
	 * 
	 * 이때는 VO클래스 앞에 @RequestBody를 붙여준다
	 */
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insert(@RequestBody BBsVO bbsVO) {
		System.out.println(bbsVO.toString());
		BBsVO bVO = bbsDao.save(bbsVO);
		return "OK";
	}
	
}





