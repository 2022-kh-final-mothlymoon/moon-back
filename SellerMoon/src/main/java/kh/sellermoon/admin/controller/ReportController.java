package kh.sellermoon.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/********************************************************
 * - R : 신고 내역 조회
 * - U : 신고 횟수 누적 (if 신고 누적 5회 => 게시판 차단 기능)
 *******************************************************/

@Controller
@RequestMapping("/admin/report/*")
public class ReportController {

}
