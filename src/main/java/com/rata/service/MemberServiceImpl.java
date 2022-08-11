package com.rata.service;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.rata.dao.MemberDAO;
import com.rata.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {

	@Inject
	private MemberDAO dao;
	
	@Override
	public void join(MemberVO vo) throws Exception {
		
		dao.join(vo);

	}

	@Override
	public MemberVO login(MemberVO vo) throws Exception {
		
		return dao.login(vo);
	}

	@Override
	public void signout(HttpSession session) throws Exception {
		
		session.invalidate(); // 세션 정보를 제거
	}

}
