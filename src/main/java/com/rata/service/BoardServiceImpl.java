package com.rata.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.rata.dao.BoardDAO;
import com.rata.vo.BoardVO;


@Service
public class BoardServiceImpl implements BoardService {
   
	@Inject
	private BoardDAO dao;

	//게시물 목록
	@Override
	public List<BoardVO> list() throws Exception {
		
		return dao.list();
	}

	//게시물 작성
	@Override
	public void write(BoardVO vo) throws Exception {

        dao.write(vo);
		
	}

	//게시물 보기
	@Override
	public BoardVO view(int no) throws Exception {
		
		return dao.view(no);
	}
    
	//게시물 삭제
	@Override
	public void delete(int no) throws Exception {
		
		dao.delete(no);
		
	}

	//게시물 수정
	@Override
	public void modify(BoardVO mo) throws Exception {
		
		dao.modify(mo);
		
	}
	
	
	
	
	
}
	

