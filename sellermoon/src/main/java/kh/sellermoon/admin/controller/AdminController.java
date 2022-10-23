package kh.sellermoon.admin.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import kh.sellermoon.admin.logic.AdminLogic;
import kh.sellermoon.admin.vo.AdminVO;


@Controller
@RequestMapping("/admin/*")
@SessionAttributes({"admin_id","admin_name", "admin_pw"})
public class AdminController {
	Logger logger = LoggerFactory.getLogger(AdminController.class);
	@Autowired
	private AdminLogic adminLogic = null;
	
	@GetMapping("login")
	public String login(HttpSession session, @RequestParam Map<String,Object> pMap) {
		logger.info("login 호출 성공 : "+pMap);
		AdminVO aVO = null;
		aVO = adminLogic.login(pMap);
		if(aVO != null) {
			session.setAttribute("admin_id", aVO.getAdmin_id());
			session.setAttribute("admin_name", aVO.getAdmin_name());
			session.setAttribute("admin_pw", aVO.getAdmin_pw());
		}
		return "/admin/main";
	}

}
