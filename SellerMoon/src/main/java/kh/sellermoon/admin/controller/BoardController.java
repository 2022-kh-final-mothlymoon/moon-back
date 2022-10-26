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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kh.sellermoon.admin.logic.BoardLogic;

/********************************************************
 * - R : 커뮤니티 전체 글 조회 / 키워드 검색 / 글 상세 조회
 * - D : 커뮤니티 게시글 및 댓글 삭제
 *******************************************************/

@Controller
@RequestMapping("/admin/board/*")
public class BoardController {
	Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired(required = false)
	private BoardLogic boardLogic = null;
	
	/*
	 * [[[[[[[[[[ 게시글 전체 조회 ]]]]]]]]]]
	 * 
	 * 조건 1. 커뮤니티 내 회원이 작성한 글의 목록을 보여준다.
	 * 조건 2. 글 번호, 제목, 작성자, 작성일, 조회수
	 */
	@GetMapping(value="/boardList")
	public String boardList(Model model, @RequestParam Map<String, Object> pMap) {
		logger.info("boardList 호출 성공");
		List<Map<String, Object>> boardList = null;
		boardList = boardLogic.boardList(pMap);
		// 파라미터에 Model 객체 사용 : 백에서 프론트로 데이터를 옮기고 싶을 때 => model.addAttribute
		model.addAttribute("boardList", boardList);
		return "board/boardList"; // WEB-INF/views/board
	}
	
	/*
	 * [[[[[[[[[[ 게시글 상세 조회 ]]]]]]]]]]
	 * 
	 * 조건 1. 커뮤니티 내 회원이 작성한 글 상세 조회 (하나의 row)
	 * 조건 2. 글 번호, 제목, 작성자, 작성일, 조회수
	 * 조건 3. 게시글 전체 조회 페이지에서 제목 클릭하면 글 번호가 매핑되어 해당 글로 이동할 것
	 * 조건 4. 관리자에게서만 삭제 버튼이 보일 수 있도록..
	 */
	@RequestMapping(value="/boardDetail")
	public String boardDetail(@RequestParam Map<String, Object> pMap, Model model) {
		logger.info("boardDetail 호출 성공");
		Map<String, Object> boardDetail = null;
		boardDetail = boardLogic.boardDetail(pMap);
		model.addAttribute("boardDetail", boardDetail);
		return "board/boardDetail";
	}
	
	/*
	 * [[[[[[[[[[ 게시글 상세 조회 -> 한 건 삭제하기 ]]]]]]]]]] 
	 * 
	 * 조건1. 게시글 상세 조회 페이지에서 한 건 삭제 (하나의 row)
	 */
	@RequestMapping(value="/boardDelete")
	public Object boardDelete(@RequestParam Map<String, Object> pMap) {
		logger.info("boardDelete 호출 성공");
		// 이거 왜 쓰는거지..?
		int result = 0;
		result = boardLogic.boardDelete(pMap);
		return "redirect:boardList";
	}
	
	@RequestMapping(value="/boardUpdate")
	public Object boardUpdate(@RequestParam Map<String, Object> pMap) {
		logger.info("boardUpdate 호출 성공");
		int result = 0;
		result = boardLogic.boardBlind(pMap);
		return "redirect:boardDetail";
	}
	
}