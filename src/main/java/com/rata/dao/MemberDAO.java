package com.rata.dao;

import com.rata.vo.MemberVO;

public interface MemberDAO {

	//회원가입
	public void join(MemberVO vo) throws Exception;
	
	//로그인
	public MemberVO login(MemberVO vo) throws Exception;

}