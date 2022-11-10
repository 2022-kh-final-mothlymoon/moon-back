package kh.sellermoon.admin.logic;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.sellermoon.admin.dao.AdminReportDao;


/*
	<<<관리자>>> ReportLogic
*/
@Service
public class AdminReportLogic {
	Logger logger = LoggerFactory.getLogger(AdminReportLogic.class);
	
	@Autowired(required = false)
	private AdminReportDao reportDao = null;

	// [[[[[[[[[[ 관리자 신고 내역 전체 조회 ]]]]]]]]]]
	public List<Map<String, Object>> reportList(Map<String, Object> pMap) {
		logger.info("admin : replyList 호출 성공");
		List<Map<String, Object>> reportList = null;
		reportList = reportDao.reportList(pMap);
		return reportList;
	}
	
	// [[[[[[[[[[ 관리자 신고 내역 상세 조회 ]]]]]]]]]]
	public Map<String, Object> reportDetail(Map<String, Object> pMap) {
		logger.info("admin : reportDetail 호출 성공");
		Map<String, Object> reportDetail = null;
		reportDetail = reportDao.reportDetail(pMap);
		return reportDetail;
	}
}
