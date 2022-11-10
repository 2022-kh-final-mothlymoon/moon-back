package kh.sellermoon.member.dao;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentDao {
	Logger logger = LogManager.getLogger(PaymentDao.class);

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate = null;

	// 개별 결제정보 등록
	public int paymentInsert(Map<String, Object> pMap) {
		logger.info("paymentInsert DAO 호출 성공");
		int result = 0;
		result = sqlSessionTemplate.update("paymentInsert", pMap);
		logger.info("pMap : " + pMap);
		return result;
	}

	// 개별구매 List
	public List<Map<String, Object>> paymentList(Map<String, Object> pMap) {
		logger.info(pMap.get("member_no"));
		List<Map<String, Object>> paymentList = null;
		paymentList = sqlSessionTemplate.selectList("paymentList", pMap);
		logger.info("pMap : " + pMap);
		return paymentList;
	}

	// 정기구독 List
	public List<Map<String, Object>> spaymentList(Map<String, Object> pMap) {
		logger.info(pMap.get("member_no"));
		List<Map<String, Object>> spaymentList = null;
		spaymentList = sqlSessionTemplate.selectList("spaymentList", pMap);
		logger.info("pMap : " + pMap);
		return spaymentList;
	}

	// 개별구매 총금액
	public Map<String, Object> payTotal(Map<String, Object> pMap) {
		logger.info(pMap.get("member_no"));
		Map<String, Object> payTotal = null;
		payTotal = sqlSessionTemplate.selectOne("payTotal", pMap);
		logger.info("pMap : " + pMap);
		return payTotal;
	}

	// 정기구독 총금액
	public Map<String, Object> spayTotal(Map<String, Object> pMap) {
		logger.info(pMap.get("member_no"));
		Map<String, Object> spayTotal = null;
		spayTotal = sqlSessionTemplate.selectOne("spayTotal", pMap);
		logger.info("pMap : " + pMap);
		return spayTotal;
	}

	// 결제 후 포인트 업데이트
	public int payPointUpdate(Map<String, Object> pMap) {
		logger.info("payPointUpdate 호출 성공");
		int result = 0;
		try {
			result = sqlSessionTemplate.update("payPointUpdate", pMap);
			logger.info("result : " + result);
		} catch (Exception e) {
			logger.info("Exception : " + e.toString());
		}
		return result;
	}

	// 정기 결제정보 등록
	public int spaymentInsert(Map<String, Object> pMap) {
		logger.info("spaymentInsert DAO 호출 성공");
		int result = 0;
		result = sqlSessionTemplate.update("spaymentInsert", pMap);
		logger.info("pMap : " + pMap);
		return result;
	}
}
