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
	Logger logger = LoggerFactory.getLogger(RestBoardController.class);
	
	@Autowired(required = false)
	private BoardLogic boardLogic = null;
	
	// [[[[[[[[[[ json 게시글 전체 조회 ]]]]]]]]]]
	@GetMapping(value="jsonBoardList")
	public String jsonBoardList(@RequestParam Map<String, Object> pMap) {
		logger.info("jsonBoardList 호출 성공");
		List<Map<String, Object>> boardList = null;
		boardList = boardLogic.boardList(pMap);
//		logger.info(boardList);
		String gBoardList = null;
		Gson g = new Gson();
		gBoardList = g.toJson(boardList);
		return gBoardList;
	}
	
	// [[[[[[[[[[ json 게시글 상세 조회 ]]]]]]]]]]
//	@GetMapping(value="jsonBoardDetail")
//	public String jsonBoardDetail(@RequestParam Map<String, Object> pMap) {
//		logger.info("jsonBoardDetail 호출 성공");
//		Map<String, Object> boardDetail = null;
//		boardDetail = boardLogic.boardDetail(pMap);
//		String gBoardDetail = null;
//		Gson g = new Gson();
//		gBoardDetail = g.toJson(boardDetail);
//		return gBoardDetail;
//	}
}
