package kh.sellermoon.member.logic;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import kh.sellermoon.member.dao.MemberDao;
import kh.sellermoon.member.vo.MemberVO;
import kh.sellermoon.member.vo.PointVO;

@Service
public class MemberLogic {
	Logger logger = LoggerFactory.getLogger(MemberLogic.class);
	@Autowired
	private MemberDao memberDao = null;
	@Autowired
	private PasswordEncoder passwordEncoder;

	public int memberRegister(MemberVO mVO, PointVO pVO) {
		logger.info("memberRegister 호출 성공");
		// 비밀번호 암호화
		String encodedPassword = passwordEncoder.encode(mVO.getMember_password());
		mVO.setMember_password(encodedPassword);
		logger.info(encodedPassword);
		int result = 0;
		int member_no = 0;
		// member_no 채번해서 담기
		member_no = memberDao.getMNo();
		mVO.setMember_no(member_no);
		logger.info("member_no===> "+member_no);
		result = memberDao.memberRegister(mVO);
		// 회원가입하면 적립금 테이블에 point insert
		if (result != 0) {
			logger.info("member_no===> "+member_no);
			pVO.setMember_no(member_no);
			int result2 = memberDao.registerPoint(pVO);
			return result2;
		}
		return result;
	}

	public MemberVO memberLogin(MemberVO mVO) {
		logger.info("memberLogin 호출 성공");
		MemberVO login = memberDao.memberLogin(mVO);
		if(login!=null && passwordEncoder.matches(mVO.getMember_password(), login.getMember_password())) {
			logger.info("로그인 성공");
			return login;
		} else {
			logger.info("로그인 실패");
			return mVO;
		}
	}
	
	public MemberVO memberLogin2(MemberVO mVO) {
		logger.info("memberLogin 호출 성공");
		return memberDao.memberLogin(mVO);
	}

	public int memberModify(MemberVO mVO) {
		logger.info("memberModify 호출 성공");
		String encodedPassword = passwordEncoder.encode(mVO.getMember_password());
		mVO.setMember_password(encodedPassword);
		logger.info(encodedPassword);
		int result = 0;
		result = memberDao.memberModify(mVO);
		return result;
	}

}
