package kh.sellermoon.admin.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import kh.sellermoon.admin.logic.BoardLogic;

@RestController
@RequestMapping("/admin/board/*")
public class RestBoardController {
Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired(required = false)
	private BoardLogic boardLogic = null;
	
	/*
	 * [[[[[[[[[[ 게시글 전체 조회 ]]]]]]]]]]
	 * 
	 * 조건 1. 커뮤니티 내 회원이 작성한 글의 목록을 보여준다.
	 * 조건 2. 글 번호, 제목, 작성자, 작성일, 조회수
	 */
	@GetMapping(value="/jsonBoardList", produces="application/json;charset=UTF-8")
	public String jsonBoardList(@RequestParam Map<String, Object> pMap) {
		logger.info("jsonBoardList 호출 성공 ===> " + pMap);
		List<Map<String, Object>> boardList = null;
		boardList = boardLogic.boardList(pMap);
		Gson g = new Gson();
		String gBoardList = g.toJson(boardList);
		return gBoardList;
	}
	
	/*
	 * [[[[[[[[[[ 게시글 상세 조회 ]]]]]]]]]]
	 * 
	 * 조건 1. 커뮤니티 내 회원이 작성한 글 상세 조회 (하나의 row)
	 * 조건 2. 글 번호, 제목, 작성자, 작성일, 조회수
	 * 조건 3. 게시글 전체 조회 페이지에서 제목 클릭하면 글 번호가 매핑되어 해당 글로 이동할 것
	 * 조건 4. 관리자에게서만 삭제 버튼이 보일 수 있도록..
	 */
	@RequestMapping(value="/jsonBoardDetail")
	public String jsonBoardDetail(@RequestParam Map<String, Object> pMap) {
		logger.info("jsonBoardDetail 호출 성공");
		Map<String, Object> boardDetail = null;
		boardDetail = boardLogic.boardDetail(pMap);
		Gson g = new Gson();
		String gBoardDetail = g.toJson(boardDetail);
		return gBoardDetail;
	}
}
