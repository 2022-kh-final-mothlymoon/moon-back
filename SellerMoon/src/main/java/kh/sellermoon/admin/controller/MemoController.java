package kh.sellermoon.admin.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kh.sellermoon.admin.logic.MemoLogic;

/********************************************************
 * - C : 회원에게 전체 쪽지 발송
 * - R : 발송 내역 확인
 * 
 * [구조]
 * 관리자 페이지 내에서 전체 쪽지 보내기 카테고리 선택 하면 쪽지 전송 페이지
 * -> 쪽지 전송 페이지 (회원 선택 가능한 창)
 * -> 쪽지 전송 내역 페이지 (쪽지 전송 내역 리스트, 보낸 쪽지 상세조회)
 * 
 * 1. 관리자는 회원을 다중 선택하여 광고성 쪽지 발송 가능
 * 2. 한 페이지 내에서 회원 선택, 쪽지 입력 및 전송 가능
 * 3. 보낸 메세지 내역은 하위 카테고리 선택 / 보낸 메세지 상세 조회 까지
 *******************************************************/

@Controller
@RequestMapping("/admin/memo/*")
public class MemoController {
	Logger logger = LoggerFactory.getLogger(MemoController.class);

	@Autowired(required=false)
	private MemoLogic memoLogic = null;
}
