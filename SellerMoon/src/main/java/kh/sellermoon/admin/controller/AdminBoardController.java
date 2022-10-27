package kh.sellermoon.admin.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import kh.sellermoon.admin.logic.AdminBoardLogic;

/*
	<<<관리자>>> BoardController
*/
@Controller
@RestController
@RequestMapping("/admin/board/*")
public class AdminBoardController {
	Logger logger = LoggerFactory.getLogger(AdminBoardController.class);
	
	@Autowired(required = false)
	private AdminBoardLogic boardLogic = null;
	
	// [[[[[[[[[[ 관리자 게시글 전체조회 / 상세조회 / 조건검색 ]]]]]]]]]]
	@GetMapping(value="jsonBoardList")
	public String jsonBoardList(@RequestParam Map<String, Object> pMap) {
		logger.info("admin : jsonBoardList 호출 성공");
		List<Map<String, Object>> boardList = null;
		boardList = boardLogic.boardList(pMap);
		String gBoardList = null;
		Gson g = new Gson();
		gBoardList = g.toJson(boardList);
		return gBoardList;
	}
	
	// [[[[[[[[[[ 관리자 게시글 수정 (블라인드 처리) ]]]]]]]]]]
	@RequestMapping(value="boardUpdate")
	public Object boardUpdate(@RequestParam Map<String, Object> pMap) {
		logger.info("boardUpdate 호출 성공");
		int result = 0;
		result = boardLogic.boardUpdate(pMap);
		return "redirect:boardList";
	}
		
	// [[[[[[[[[[ 관리자 게시글 삭제 ]]]]]]]]]]
	@RequestMapping(value="boardDelete")
	public Object boardDelete(@RequestParam Map<String, Object> pMap) {
		logger.info("boardDelete 호출 성공");
		int result = 0;
		result = boardLogic.boardDelete(pMap);
		return "redirect:boardList";
	}
}
