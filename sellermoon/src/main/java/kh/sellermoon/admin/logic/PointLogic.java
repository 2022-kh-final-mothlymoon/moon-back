package kh.sellermoon.admin.logic;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.sellermoon.admin.dao.FaqDao;
import kh.sellermoon.admin.dao.PointDao;

@Service
public class PointLogic {
	Logger logger = LogManager.getLogger(PointLogic.class);
	
	@Autowired
	private PointDao pointDao = null;
	
	public List<Map<String, Object>> pointList(Map<String, Object> pMap) {
		logger.info("pointList 호출 성공");
		List<Map<String, Object>> pointList = null;
		pointList = pointDao.pointList(pMap);
		return pointList;
	}

}
