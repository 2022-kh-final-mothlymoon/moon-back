package kh.sellermoon.admin.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

/********************************************************
 * - R : 커뮤니티 전체 글 조회 / 키워드 검색 / 글 상세 조회
 * - D : 커뮤니티 게시글 및 댓글 삭제
 *******************************************************/

@Service
public class BoardDao {
	Logger logger = LoggerFactory.getLogger(BoardDao.class);

	@Autowired(required = false)
	private SqlSessionTemplate sqlSessionTemplate = null;
	
	/*
	 * [[[[[[[[[[ 게시글 전체 조회 ]]]]]]]]]]
	 * 
	 * 조건 1. 커뮤니티 내 회원이 작성한 글의 목록을 보여준다.
	 * 조건 2. 글 번호, 제목, 작성자, 작성일, 조회수
	 */
	public List<Map<String, Object>> boardList(Map<String, Object> pMap) {
		logger.info("boardList 호출 성공");
		List<Map<String, Object>> boardList = null;
		try {
			boardList = sqlSessionTemplate.selectList("boardList", pMap);
			logger.info(boardList.toString());
		} catch (DataAccessException e) {
			logger.info("Exception : " + e.toString());
		}
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
		try {
			boardDetail = sqlSessionTemplate.selectOne("boardDetail", pMap);
			System.out.println(boardDetail);
			logger.info(boardDetail.toString());
		} catch(DataAccessException e) {
			logger.info("Exception : " + e.toString());
		}
		return boardDetail;
	}

	/*
	 * [[[[[[[[[[ 게시글 상세 조회 -> 한 건 삭제하기 ]]]]]]]]]] 
	 * 
	 * 조건1. 게시글 상세 조회 페이지에서 한 건 삭제 (하나의 row)
	 */
	public int boardDelete(Map<String, Object> pMap) {
		int result = 0;
		try {
			result = sqlSessionTemplate.delete("boardDelete", pMap);
			logger.info("result : " + result);
		} catch (Exception e) {
			logger.info("Exception : " + e.toString());
		}
		return result;
	}
}
