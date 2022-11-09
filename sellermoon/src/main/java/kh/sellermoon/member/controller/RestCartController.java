package kh.sellermoon.member.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kh.sellermoon.member.logic.CartLogic;
import kh.sellermoon.member.logic.MemberLogic;
import kh.sellermoon.member.logic.PCartLogic;
import kh.sellermoon.member.vo.CartVO;
import kh.sellermoon.member.vo.MemberVO;

import com.google.gson.Gson;

@RestController
@RequestMapping("/cart")
public class RestCartController {
	Logger logger = LogManager.getLogger(RestCartController.class);

	@Autowired
	private PCartLogic pCartLogic;

	// 로그인한 유저의 모든 장바구니 목록 조회
	@GetMapping({ "/", "" })
	public String getAllCartList(HttpServletRequest req, 
			@RequestParam(required = false, defaultValue="O") String type) {
		
		String result = "";
		try {
			HttpSession session = req.getSession();
			// 리액트 로그인 오류 해결 이후 해당 구문 주석 해제
			// MemberVO member = (MemberVO)session.getAttribute("member");
			// logger.info("member: " + member);
			//int memberNo = member.getMember_no();
			int memberNo = 1;
			
			Map<String, Object> map = new HashMap<>();
			map.put("orderType", type);
			map.put("no", memberNo);
			logger.info("map > "+ map);
			List<CartVO> cartList = pCartLogic.getAllCartsVO(map);
			Gson g = new Gson();
			result = g.toJson(cartList);

		} catch (Exception e) {
			logger.error("error : " + e.getStackTrace());
			logger.error("error msg : " + e.getMessage());
		}

		return result;
	}

	@PostMapping({ "/", "" })
	public String CartList(@RequestBody Map<String, Object> pMap) {
		String result = "false";
		try {
			// 리액트 로그인 오류 해결 이후 해당 구문 주석 해제
			// MemberVO member = (MemberVO)session.getAttribute("member");
			// logger.info("member: " + member);
			// int memberNo = member.getMember_no();
			int memberNo = 1;

			pMap.put("memberNo", memberNo);
			logger.info("jsonCartList 호출 성공" + pMap);
			pCartLogic.insertCart(pMap);
			result = "true";

		} catch (Exception e) {
			logger.error("error : " + e.getStackTrace());
			logger.error("error msg : " + e.getMessage());
		}

		return result;
	}
	
	// parameter cartNo, quantity
	@PutMapping({ "/", "" })
	public String updateCart(@RequestBody Map<String, Object> cartMap) {
		String result = "false";
		try {
			// 리액트 로그인 오류 해결 이후 해당 구문 주석 해제
			// MemberVO member = (MemberVO)session.getAttribute("member");
			// logger.info("member: " + member);
			// int memberNo = member.getMember_no();
			int memberNo = 1;

			cartMap.put("memberNo", memberNo);
			pCartLogic.updateCart(cartMap);
			result = "true";

		} catch (Exception e) {
			logger.error("error : " + e.getStackTrace());
			logger.error("error msg : " + e.getMessage());
		}

		return result;
	}
	
	// parameter cartNo
	@DeleteMapping({ "/", "" })
	public String deleteCart(@RequestBody Map<String, Object> cartMap) {
		String result = "false";
		try {
			// 리액트 로그인 오류 해결 이후 해당 구문 주석 해제
			// MemberVO member = (MemberVO)session.getAttribute("member");
			// logger.info("member: " + member);
			// int memberNo = member.getMember_no();
			int memberNo = 1;

			cartMap.put("memberNo", memberNo);
			pCartLogic.deleteCart(cartMap);
			result = "true";

		} catch (Exception e) {
			logger.error("error : " + e.getStackTrace());
			logger.error("error msg : " + e.getMessage());
		}

		return result;
	}

}
