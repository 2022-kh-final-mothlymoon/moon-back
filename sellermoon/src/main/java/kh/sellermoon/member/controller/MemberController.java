package kh.sellermoon.member.controller;


import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kh.sellermoon.admin.controller.AdminController;
import kh.sellermoon.member.logic.MemberLogic;
import kh.sellermoon.member.vo.MemberVO;
import kh.sellermoon.member.vo.PointVO;

@Controller
@RequestMapping("/monthlymoon")
public class MemberController {
	Logger logger = LoggerFactory.getLogger(AdminController.class);
	@Autowired
	private MemberLogic memberLogic = null;

	// 회원가입
	@PostMapping("register")
	public String memberRegister(MemberVO mVO, PointVO pVO) {
		logger.info("memberRegister 호출 성공");
		int result = 0;
		result = memberLogic.memberRegister(mVO, pVO);
		return "redirect:/login";
	}


	// 로그아웃
	@GetMapping("logout")
	public String memberLogout(HttpSession session) {
		session.invalidate();
		logger.info("로그아웃 성공");
		return "redirect:/monthlymoon/main";
	}

	// 회원 정보 수정
	@PostMapping("membermodify")
	public String memberModify(HttpSession session, MemberVO mVO) {
		logger.info("회원정보 수정 호출");
		int result = 0;
		result = memberLogic.memberModify(mVO);
		session.invalidate();
		return "redirect:/monthlymoon/login";
	}

}