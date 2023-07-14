package com.qorlwn.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {

	@Autowired
	private BoardService service;

	// 1. boardList 보는 화면 = board.jsp
	@GetMapping("/board")
	public String board(Model model) {
		// 데이터 붙이기
		model.addAttribute("name", "1234");// key value

		// service에서 메소드 불러오기
		List<BoardDTO> list = service.boardList();
		if (list.size() > 0) {
			model.addAttribute("list", list);
			return "board";
		} else {
			return "redirect:/";// 다시 컨트롤러 지나가게 한다
		}
	}
	// 2. detail 상세보기 화면 = detail.jsp
	@GetMapping("/detail")
	public String detail(HttpServletRequest request) {
		String bno = request.getParameter("bno");
		
//		for (int i = 0; i < bno.length(); i++) {
//			System.out.println(Character.isDigit(bno.charAt(i)));
//		}
		
//		if () {
//			int no = Integer.parseInt(bno);
//		} else {
//			
//		}
		try {
			int no = Integer.parseInt(bno);
			System.out.println("숫자");
		} catch (Exception e) {
			System.out.println("숫자 아님");
		}
		
		return "detail";
	}
}
