package kh.sellermoon.member.dao;


import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.sellermoon.member.vo.MemberVO;
import kh.sellermoon.member.vo.PointVO;

@Service
public class MemberDao {
	Logger logger = LoggerFactory.getLogger(MemberDao.class);
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate = null;

	public int memberRegister(MemberVO mVO) {
		int result = 0;
		try {
			result = sqlSessionTemplate.update("memberRegister", mVO);
			logger.info("result : " + result);
		} catch (Exception e) {
			logger.info("Exception : " + e.toString());
		}
		return result;
	}

	public int registerPoint(PointVO pVO) {
		int result = 0;
		try {
			result = sqlSessionTemplate.update("registerPoint", pVO);
			logger.info("result : " + result);
		} catch (Exception e) {
			logger.info("Exception : " + e.toString());
		}
		return result;
	}

	public MemberVO memberLogin(MemberVO mVO) {
		logger.info("memberLogin 호출 성공");
		return sqlSessionTemplate.selectOne("memberLogin", mVO);
	}

	public int memberModify(MemberVO mVO) {
		int result = 0;
		try {
			result = sqlSessionTemplate.update("memberModify", mVO);
			logger.info("result : " + result);
		} catch (Exception e) {
			logger.info("Exception : " + e.toString());
		}
		return result;
	}

	public int getMNo() {
		logger.info("getMNo 호출 성공");
		int result = 0;
		try {
			result = sqlSessionTemplate.selectOne("getMNo");
			logger.info(result + "");
		} catch (Exception e) {
			logger.info("Exception : " + e.toString());
		}
		return result;
	}
	
	public int emailChk(MemberVO mVO) {
		logger.info("이메일 중복체크 호출 성공");
		int result = 0;
		try {
			result = sqlSessionTemplate.selectOne("emailChk", mVO);
			logger.info(result + "");
		} catch (Exception e) {
			logger.info("Exception : " + e.toString());
		}
		return result;
	}

	public MemberVO findEmail(MemberVO mVO) {
		logger.info("이메일 찾기 호출 성공");
		return sqlSessionTemplate.selectOne("findEmail", mVO);
	}

	public int findPassword(MemberVO mVO) {
		logger.info("비밀번호 찾기 호출 성공");
		int result = sqlSessionTemplate.selectOne("findPassword", mVO);
		return result;
	}

	public int updatePass(MemberVO mVO) {
		int result = 0;
		try {
			result = sqlSessionTemplate.update("updatePass", mVO);
			logger.info("비밀번호 수정 호출 성공");
			logger.info("result : " + result);
		} catch (Exception e) {
			logger.info("Exception : " + e.toString());
		}
		return result;
	}

}
