package com.rata.dao;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.rata.vo.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Inject
	private SqlSession sql;

	String namespace = "com.rata.mappers.board";

	// 게시물 목록
	@Override
	public List<BoardVO> list() throws Exception {

		return sql.selectList(namespace + ".list");
	}

	// 게시물 작성
	@Override
	public void write(BoardVO vo) throws Exception {

		sql.insert(namespace + ".write", vo);

	}

	// 게시물 보기
	@Override
	public BoardVO view(int no) throws Exception {

		return sql.selectOne(namespace + ".view", no);
	}

	// 게시물 삭제
	@Override
	public void delete(int no) throws Exception {
		
		sql.delete(namespace + ".delete", no);

	}

	//게시물 수정
	@Override
	public void modify(BoardVO mo) throws Exception {
		
		sql.update(namespace + ".modify", mo);
		
	}

}
