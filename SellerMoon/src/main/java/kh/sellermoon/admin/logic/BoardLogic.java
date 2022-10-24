package kh.sellermoon.admin.logic;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.sellermoon.admin.dao.BoardDao;

@Service
public class BoardLogic {
	Logger logger = LoggerFactory.getLogger(BoardLogic.class);

	@Autowired(required = false)
	private BoardDao boardDao = null;

	/*
	 * [[[[[[[[[[ 게시글 전체 조회 ]]]]]]]]]]
	 * 
	 * 조건 1. 커뮤니티 내 회원이 작성한 글의 목록을 보여준다.
	 * 조건 2. 글 번호, 제목, 작성자, 작성일, 조회수
	 */
	public List<Map<String, Object>> boardList(Map<String, Object> pMap) {
		logger.info("boardList 호출 성공");
		List<Map<String, Object>> boardList = null;
		boardList = boardDao.boardList(pMap);
		return boardList;
	}

	/*
	 * [[[[[[[[[[ 게시글 상세 조회 ]]]]]]]]]]
	 * 
	 * 조건 1. 커뮤니티 내 회원이 작성한 글 상세 조회 (하나의 row)
	 * 조건 2. 글 번호, 제목, 작성자, 작성일, 조회수
	 * 조건 3. 게시글 전체 조회 페이지에서 제목 클릭하면 글 번호가 매핑되어 해당 글로 이동할 것
	 * 조건 4. 관리자에게서만 삭제 버튼이 보일 수 있도록..
	 */
	public Map<String, Object> boardDetail(Map<String, Object> pMap) {
		logger.info("boardDetail 호출 성공");
		Map<String, Object> boardDetail = null;
		boardDetail = boardDao.boardDetail(pMap);
		return boardDetail;
	}

	/*
	 * [[[[[[[[[[ 게시글 상세 조회 -> 한 건 삭제하기 ]]]]]]]]]] 
	 * 
	 * 조건1. 게시글 상세 조회 페이지에서 한 건 삭제 (하나의 row)
	 */
	public int boardDelete(Map<String, Object> pMap) {
		int result = 0;
		result = boardDao.boardDelete(pMap);
		return result;
	}


}
