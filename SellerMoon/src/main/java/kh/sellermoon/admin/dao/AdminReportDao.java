package kh.sellermoon.admin.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

/*
	<<<관리자>>> ReportDao
*/
@Service
public class AdminReportDao {
	Logger logger = LoggerFactory.getLogger(AdminReportDao.class);

	@Autowired(required = false)
	private SqlSessionTemplate sqlSessionTemplate = null;
	
	// [[[[[[[[[[ 관리자 신고 내역 전체 조회 ]]]]]]]]]]
	public List<Map<String, Object>> reportList(Map<String, Object> pMap) {
		logger.info("admin reportList : pMap => " + pMap);
		List<Map<String, Object>> reportList = null;
		try {
			reportList = sqlSessionTemplate.selectList("reportList", pMap);
		} catch (DataAccessException e) {
			logger.info("Exception : " + e.toString());
		}
		return reportList;
	}

	// [[[[[[[[[[ 관리자 신고 내역 상세 조회 ]]]]]]]]]]
	public Map<String, Object> reportDetail(Map<String, Object> pMap) {
		logger.info("admin reportDetail : pMap => " + pMap);
		Map<String, Object> reportDetail = null;
		try {
			reportDetail = sqlSessionTemplate.selectOne("boardList", pMap);
		} catch(DataAccessException e) {
			logger.info("Exception : " + e.toString());
		}
		return reportDetail;
	}

}
