package kh.sellermoon.admin.dao;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class StoreDao {
	
	Logger logger = LogManager.getLogger(StoreDao.class);
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate = null;
	
	// storeList 불러오기용(다 건)
	public List<Map<String, Object>> storeList(Map<String, Object> pMap) {
		logger.info("storeList DAO 호출 성공");
		logger.info(pMap.get("STORE_NO"));
		List<Map<String, Object>> storeList = null;
		storeList = sqlSessionTemplate.selectList("storeList",pMap);
		logger.info("pMap : "+pMap);
		return storeList;
	}
	
	// store 등록용(한 건)
	public List<Map<String, Object>> storeDetail(Map<String, Object> pMap) {
		logger.info("storeDetail DAO 호출 성공");
		logger.info(pMap.get("STORE_NO"));
		List<Map<String, Object>> storeList = null;
		storeList = sqlSessionTemplate.selectList("storeDetail",pMap);
		logger.info("pMap : "+pMap);
		return storeList;
	}
	
	// store 등록용(한 건)
	public int storeInsert(Map<String, Object> pMap) {
		logger.info("storeInsert DAO 호출 성공");
		int result = 0;
		result = sqlSessionTemplate.update("storeInsert",pMap);
		logger.info("pMap : "+pMap);
		return result;
	}
	
	// 사용 안함, 필요없음, store 삭제용(한 건)
//	public int storeDelete(Map<String, Object> pMap) {
//		int result = 0;
//		try {
//			result = sqlSessionTemplate.delete("storeDelete",pMap);
//			logger.info("result : "+result);
//		} catch (Exception e) {
//			logger.info("Exception : "+e.toString());
//		return result;
//	}
	
	// store 수정용(한 건)
	public int storeUpdate(Map<String, Object> pMap) {
		logger.info("storeUpdate DAO 호출 성공");
		logger.info(pMap.get("STORE_NO"));
		logger.info(pMap.get("FIELD"));
		int result = 0;
		try {
			
			result = sqlSessionTemplate.update("storeUpdate",pMap);
			logger.info("result : "+result);
		} catch (Exception e) {
			logger.info("Exception : "+e.toString());
		} 	
		return result;
	}

}
