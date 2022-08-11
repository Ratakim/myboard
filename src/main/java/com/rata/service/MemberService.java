package com.rata.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.rata.vo.BoardVO;
import com.rata.vo.MemberVO;

public interface MemberService {

	// 회원가입
	public void join(MemberVO vo) throws Exception;

	// 로그인
	public MemberVO login(MemberVO vo) throws Exception;

	// 로그아웃
	public void signout(HttpSession session) throws Exception;
}
