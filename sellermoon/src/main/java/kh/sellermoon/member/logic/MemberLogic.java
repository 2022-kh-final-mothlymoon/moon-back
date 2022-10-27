package kh.sellermoon.member.logic;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import kh.sellermoon.member.dao.MemberDao;
import kh.sellermoon.member.vo.MailVO;
import kh.sellermoon.member.vo.MemberVO;
import kh.sellermoon.member.vo.PointVO;

@Service
public class MemberLogic {
	Logger logger = LoggerFactory.getLogger(MemberLogic.class);
	@Autowired
	private MemberDao memberDao = null;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private MailSender mailsend;

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
		logger.info("member_no===> " + member_no);
		result = memberDao.memberRegister(mVO);
		// 회원가입하면 적립금 테이블에 point insert
		if (result == 1) {
			logger.info("member_no===> " + member_no);
			pVO.setMember_no(member_no);
			int result2 = memberDao.registerPoint(pVO);
			return result2;
		}
		return result;
	}

	public MemberVO memberLogin(MemberVO mVO) {
		logger.info("memberLogin 호출 성공");
		MemberVO login = memberDao.memberLogin(mVO);
		if (login != null && passwordEncoder.matches(mVO.getMember_password(), login.getMember_password())) {
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

	public int emailChk(MemberVO mVO) {
		logger.info("이메일 중복체크 호출 성공");
		int result = 0;
		result = memberDao.emailChk(mVO);
		return result;
	}

	public MemberVO findEmail(MemberVO mVO) {
		logger.info("이메일 찾기 호출 성공");
		return memberDao.findEmail(mVO);
	}

	// 랜덤 비밀번호 생성
	public String getTempPassword() {
		char[] charSet = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F',
				'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

		String str = "";

		int idx = 0;
		for (int i = 0; i < 10; i++) {
			idx = (int) (charSet.length * Math.random());
			str += charSet[idx];
		}
		return str;
	}
	
	// 비밀번호 랜덤 숫자+문자로 업데이트해서 메일 발송
	public int updatePass(MemberVO mVO, MailVO mailVO) {
		if(memberDao.findPassword(mVO) == 0) { // 해당하는 email이 없으면 0을 return
			logger.info("존재하지 않는 회원");
			return 0;
		} else {
			logger.info("비밀번호 수정 호출 성공");
			memberDao.findPassword(mVO);
			String tempPass = getTempPassword();
			mVO.setMember_email(mVO.getMember_email());
			mVO.setMember_password(tempPass);
			logger.info(tempPass);
			// 비밀번호 변경
			int result = memberDao.updatePass(mVO);
			// 변경 후 메일 발송
			sendEmail(mVO, mailVO);
			// 랜덤 비밀번호 암호화해서 DB저장
			if(result == 1) {
				String encodedPassword = passwordEncoder.encode(mVO.getMember_password());
				mVO.setMember_password(encodedPassword);
				logger.info(encodedPassword);
				int result2 = memberDao.updatePass(mVO);
			}
			return result;			
		}
	}
	// 임시 비밀번호 발급 메일 보내기
	public void sendEmail(MemberVO mVO, MailVO mailVO) {
			logger.info("메일 작성 호출 성공");
			logger.info(mVO.getMember_email());
			logger.info(mVO.getMember_name());
			// 메일 작성하기
			mailVO.setAddress(mVO.getMember_email());
			logger.info(mailVO.getAddress());
			mailVO.setTitle("Sellermoon 임시 비밀번호 안내 메일입니다.");
			mailVO.setMessage("안녕하세요. Sellermoon 임시 비밀번호 관련 안내 메일입니다. "
					+ mVO.getMember_name() + " 님의 임시비밀번호는 "
					+ mVO.getMember_password() + " 입니다. " + "로그인 후 비밀번호를 변경해주세요.");
			
			// 메일 보내기
			logger.info("메일 보내기 호출 성공");
			SimpleMailMessage message = new SimpleMailMessage();
			message.setTo(mailVO.getAddress());
			message.setSubject(mailVO.getTitle());
			message.setText(mailVO.getMessage());
			message.setFrom("kh.sellermoon@gmail.com");
			message.setReplyTo("kh.sellermoon@gmail.com");
			logger.info(message.toString());
			mailsend.send(message);
		}
	}
	
