package com.rata.dao;

import java.util.List;

import com.rata.vo.BoardVO;

public interface BoardDAO {

	// 게시물 목록
	public List<BoardVO> list() throws Exception;

	// 게시물 작성
	public void write(BoardVO vo) throws Exception;

	// 게시물 보기
	public BoardVO view(int no) throws Exception;

	// 게시물 삭제
	public void delete(int no) throws Exception;

	// 게시물 수정
	public void modify(BoardVO mo) throws Exception;

}