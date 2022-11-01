package kh.sellermoon.admin.dao;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.sellermoon.admin.vo.AdminVO;

@Service
public class AdminDao {
	
	Logger logger = LoggerFactory.getLogger(AdminDao.class);
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate = null;

	public AdminVO login(Map<String, Object> pMap) {
		logger.info("login 호출 성공");
		AdminVO aVO = null;
		aVO = sqlSessionTemplate.selectOne("Adminlogin", pMap);
		return aVO;
	}

}
