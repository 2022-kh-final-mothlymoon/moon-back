<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.Map" %>

<%
	Map<String, Object> boardDetail = (Map)request.getAttribute("boardDetail");
%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.6.1.slim.min.js" integrity="sha256-w8CvhFs7iHNVUtnSP0YKEg00p9Ih13rlL9zGqvLdePA=" crossorigin="anonymous"></script>
<meta charset="UTF-8">
<title>admin.boardDetail</title>
<script>
	$(function() {
		$("#delBtn").click(function() {
			 let board_no = $("#boardNo").val();
			 if (confirm("정말 삭제하시겠습니까?") == true) {
				 location.href="/admin/board/boardDelete?board_no=" + board_no;
			 } else {
			     return false;
			 }
		})
	})
</script>
</head>
<body>
관리자 커뮤니티 게시글 상세조회 페이지
	<table>
		<thead>
			<tr>
				<th>번호</th>
				<th>카테고리</th>
				<th>제목</th>
				<th>내용</th>
				<th>작성자</th>
				<th>날짜</th>  
				<th>조회수</th>
				<th>삭제</th>
			</tr>
		</thead>	
		<tbody>
			<tr>
				<td><input type="hidden" id="boardNo" value="${boardDetail.BOARD_NO}" />${boardDetail.BOARD_NO}</td>
				<td><%= boardDetail.get("BOARD_CATEGORY") %></td>
				<td><%= boardDetail.get("BOARD_TITLE") %><td>
				<td><%= boardDetail.get("BOARD_CONTENT") %></td>
				<td><%= boardDetail.get("MEMBER_NAME") %></td>
				<td><%= boardDetail.get("BOARD_WRITTEN_DATE") %></td>
				<td><%= boardDetail.get("BOARD_HIT") %></td>
				<td><input type="button" id="delBtn" value="Delete"></td>
			</tr>
		</tbody>	
	</table>
</body>
</html>