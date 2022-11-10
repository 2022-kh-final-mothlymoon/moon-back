package kh.sellermoon.member.logic;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.sellermoon.admin.dao.AmdDao;
import kh.sellermoon.admin.logic.AmdLogic;
import kh.sellermoon.member.dao.PaymentDao;

@Service
public class PaymentLogic {
	Logger logger = LogManager.getLogger(PaymentLogic.class);

	@Autowired
	private PaymentDao paymentDao = null;

	//개별 결제정보 등록
	public int paymentInsert(Map<String, Object> pMap) {
		logger.info("paymentInsert Logic 호출 성공");
		int result = 0;
		result = paymentDao.paymentInsert(pMap);
		return result;
	}

	// 개별구매 List
	public List<Map<String, Object>> paymentList(Map<String, Object> pMap) {
		logger.info("paymentList 호출 성공");
		List<Map<String, Object>> paymentList = null;
		paymentList = paymentDao.paymentList(pMap);
		return paymentList;
	}

	// 정기구독 List
	public List<Map<String, Object>> spaymentList(Map<String, Object> pMap) {
		logger.info("spaymentList 호출 성공");
		List<Map<String, Object>> spaymentList = null;
		spaymentList = paymentDao.spaymentList(pMap);
		return spaymentList;
	}

	// 개별구매 총금액
	public Map<String, Object> payTotal(Map<String, Object> pMap) {
		logger.info("payTotal 호출 성공");
		Map<String, Object> payTotal = null;
		payTotal = paymentDao.payTotal(pMap);
		return payTotal;
	}

	// 정기구독 총금액
	public Map<String, Object> spayTotal(Map<String, Object> pMap) {
		logger.info("spayTotal 호출 성공");
		Map<String, Object> spayTotal = null;
		spayTotal = paymentDao.spayTotal(pMap);
		return spayTotal;
	}

	// 결제 후 포인트 업데이트
	public int payPointUpdate(Map<String, Object> pMap) {
		logger.info("payPointUpdate 호출 성공");
		int result = 0;
		result = paymentDao.payPointUpdate(pMap);
		return result;
	}

	//정기 결제정보 등록
	public int spaymentInsert(Map<String, Object> pMap) {
		logger.info("spaymentInsert Logic 호출 성공");
		int result = 0;
		result = paymentDao.spaymentInsert(pMap);
		return result;
	}
}
