package com.rata.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rata.service.MemberService;
import com.rata.vo.MemberVO;

@Controller
@RequestMapping("/mymember")
public class MemberController {
	
	@Inject
	MemberService service;

	// 회원가입 get
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public void getJoin() throws Exception {

	}

	// 회원가입 post
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String postJoin(MemberVO vo) throws Exception {
		
		service.join(vo);
		
		return "redirect:/";

	}
	
	// 로그인
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(MemberVO vo, HttpServletRequest req, RedirectAttributes rttr) throws Exception{
		
		HttpSession session = req.getSession();
		MemberVO login = service.login(vo);
		
		System.out.println("login : " + login);
		
		if(login == null) {
			session.setAttribute("member", null);
			rttr.addFlashAttribute("msg", false);
		}else {
			session.setAttribute("member", login);
		}
		
		return "redirect:/";
		
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) throws Exception{
		
				
		service.signout(session);  // 세션 정보를 제거
		
		return "redirect:/";
	}

}
