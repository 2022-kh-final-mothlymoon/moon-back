package kh.sellermoon.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/********************************************************
 * - R : 전체 리뷰 조회
 * - U : 베스트 리뷰 선정
 * - D : 부적절한 리뷰 삭제
 * 
 * [구조]
 * 관리자 페이지 내, navbar - 리뷰 관리
 * => 전체 ReviewList, 상품별 ReviewList, 리뷰 선택 시 상세 리뷰
 * => 
 * 
 *******************************************************/

@Controller
@RequestMapping("/admin/review/*")
public class ReviewController {

}
