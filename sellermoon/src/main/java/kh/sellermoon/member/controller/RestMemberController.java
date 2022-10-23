package kh.sellermoon.member.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import kh.sellermoon.member.logic.MemberLogic;
import kh.sellermoon.member.vo.MemberVO;

@RestController
@RequestMapping("/monthlymoon")
public class RestMemberController {
	Logger logger = LoggerFactory.getLogger(RestMemberController.class);
	@Autowired
	private MemberLogic memberLogic = null;
	
	@PostMapping("login")
	public String memberLogin(HttpServletRequest req, MemberVO mVO) {

		logger.info("memberLogin 호출 성공");
		HttpSession session = req.getSession();
		String temp = null;
		MemberVO login = memberLogic.memberLogin(mVO);
		session.setAttribute("member", login);
		Gson g = new Gson();
		temp = g.toJson(login);
		return temp;
	
	}

}
