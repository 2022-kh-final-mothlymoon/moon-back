package kh.sellermoon.admin.logic;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.sellermoon.admin.dao.AmdDao;
import kh.sellermoon.admin.dao.StoreDao;

@Service
public class AmdLogic {
	Logger logger = LogManager.getLogger(AmdLogic.class);

	@Autowired
	private AmdDao amdDao = null;

	// amdList 불러오기용(다 건)
	public List<Map<String, Object>> amdList(Map<String, Object> pMap) {
		logger.info("storeList Logic 호출 성공");
		List<Map<String, Object>> amdList = null;
		amdList = amdDao.amdList(pMap);
		return amdList;
	}

	// amd 등록용(한 건)
	public int amdInsert(Map<String, Object> pMap) {
		logger.info("amdInsert Logic 호출 성공");
		int result = 0;
		result = amdDao.amdInsert(pMap);
		return result;
	}

	// amd 삭제용(한 건)
	public int amdDelete(Map<String, Object> pMap) {
		int result = 0;
		result = amdDao.amdDelete(pMap);
		return result;
	}

	// amd 불러오기용(한 건)
	public List<Map<String, Object>> amdDetail(Map<String, Object> pMap) {
		logger.info("amdDetail Logic 호출 성공");
		List<Map<String, Object>> amdList = null;
		amdList = amdDao.amdDetail(pMap);
		return amdList;
	}

	// amd 수정용(한 건)
	public int amdUpdate(Map<String, Object> pMap) {
		logger.info("amdUpdate Logic 호출 성공");
		int result = 0;
		result = amdDao.amdUpdate(pMap);
		return result;
	}

}
