<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.Map" %>

<%
	List<Map<String, Object>> boardList = (List<Map<String, Object>>)request.getAttribute("boardList");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>admin/boardList</title>
<script type="text/javascript">
	function detailBtn() {
		alert("detailBtn 호출 성공");
	}
</script>
</head>
<body>
	<!-- 게시글 전체 조회 (글번호, 카테고리, 제목, 작성자, 날짜, 조회수) -->
		<table>
			<thead>
				<tr>
					<th>번호</th>
					<th>카테고리</th>
					<th>제목</th>
					<th>작성자</th>
					<th>날짜</th>  
					<th>조회수</th>
				</tr>
			</thead>
<%
	if(boardList != null || boardList.size() != 0) {
		for(int i=0; i<boardList.size(); i++) {
			Map<String, Object> bMap = boardList.get(i);
			System.out.println(bMap);
%>
			<tbody>
				<tr>
					<td><%= bMap.get("BOARD_NO") %></td>
					<td><%= bMap.get("BOARD_CATEGORY") %></td>
					<td id="board_title" onClick="detailBtn()"><%= bMap.get("BOARD_TITLE") %><td>
					<td><%= bMap.get("MEMBER_NAME") %></td>
					<td><%= bMap.get("BOARD_WRITTEN_DATE") %></td>
					<td><%= bMap.get("BOARD_HIT") %></td>
				</tr>
			</tbody>
<%
		}
	}
%>
		</table>
</body>
</html>