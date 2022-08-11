package com.rata.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.rata.vo.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	
	@Inject
	private SqlSession sql;

	String namespace = "com.rata.mappers.member";

	@Override
	public void join(MemberVO vo) throws Exception {
		
		sql.insert(namespace + ".join", vo);

	}

	@Override
	public MemberVO login(MemberVO vo) throws Exception {
		
		return sql.selectOne(namespace + ".login",vo);
	}

}
