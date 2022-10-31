package kh.sellermoon.admin.dao;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.mybatis.spring.SqlSessionTemplate;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PointDao {
	Logger logger = LogManager.getLogger(FaqDao.class);
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate = null;
	
	public List<Map<String, Object>> pointList(Map<String, Object> pMap) {
		logger.info(pMap.get("point_no"));
		List<Map<String, Object>> pointList = null;
		pointList = sqlSessionTemplate.selectList("pointList",pMap);
	      logger.info("pMap : "+pMap);
	      return pointList;
	}

}
