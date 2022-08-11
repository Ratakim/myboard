package com.rata.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rata.service.BoardService;
import com.rata.vo.BoardVO;

@Controller
@RequestMapping("/myboard")
public class BoardController {

	@Inject
	BoardService service;

	// 게시물 목록
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void list(Model model) throws Exception {

		List<BoardVO> list = service.list();

		model.addAttribute("list", list);
	}

	// 게시물 작성 get
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public void write(Model model) throws Exception {

	}

	// 게시물 작성 post
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String write(Model model, BoardVO vo, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		service.write(vo);

		return "redirect:/myboard/list";

	}

	// 게시물 보기
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public void view(int no, Model model) throws Exception {

		BoardVO view = service.view(no);

		model.addAttribute("view", view);
	}

	// 게시물 삭제
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(int no) throws Exception {

		service.delete(no);

		return "redirect:/myboard/list";
	}
	
	//게시물 수정 get
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public void modify(int no, Model model) throws Exception {
		
		BoardVO view = service.view(no);
		
		model.addAttribute("view", view);
		
	}
	
	//게시물 수정 post
		@RequestMapping(value = "/modify", method = RequestMethod.POST)
		public String modify(BoardVO mo) throws Exception {
			
			service.modify(mo);
			
			return "redirect:/myboard/view?no="+mo.getNo();
		}

}
