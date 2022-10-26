
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*, kh.sellermoon.admin.vo.StoreVO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
int STORE_NO = 0;
int MD_NO = 0;
String STORE_CONTACT = "";
String STORE_MANAGER = "";
String STORE_MEMO = "";
String STORE_YN = "";
String FIELD = "";
List<Map<String, Object>> storeList = (List<Map<String, Object>>) request.getAttribute("storeList");
if (storeList != null && storeList.size() > 0) {
	/* STORE_NO = storeList.get(0).get("STORE_NO").toString();
	MD_NO = storeList.get(0).get("MD_NO").toString(); */
	STORE_CONTACT = storeList.get(0).get("STORE_CONTACT").toString();
	STORE_MANAGER = storeList.get(0).get("STORE_MANAGER").toString();
	STORE_MEMO = storeList.get(0).get("STORE_MEMO").toString();
	STORE_YN = storeList.get(0).get("STORE_YN").toString();
	FIELD = storeList.get(0).get("FIELD").toString();
}
%>
<script type="text/javascript">
	console.log('f_boardUpd호출 성공');
	console.log('${STORE_NO}');

	function dlgUpd_save() {
		$("#f_boardUpd").submit();
	}
	function dlgUpd_close() {
		location.href = "./storeList";
	}
</script>
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.w3.org/1999/xhtml">
<head>
<meta charset="UTF-8">
<title>거래처목록 view</title>
</head>

<body>
	<h2>거래처목록</h2>
	<c:forEach var="storeList" items="${storeList}">
	     <form id="frm" name="frm" action=./storeUpdate?STORE_NO=${storeList.STORE_NO}'/>
	<label>FIELD</label>
	<input id="FIELD" name="FIELD" value="${storeList.FIELD}"><br/>
	<label>STORE_YN</label>
	<input id="STORE_YN" name="STORE_YN"  value="${storeList.STORE_YN}"><br/>
	<label>STORE_CONTACT</label>
	<input id="STORE_CONTACT" name="STORE_CONTACT"  value="${storeList.STORE_CONTACT}"><br/>
	<label>STORE_MANAGER</label>
	<input id="STORE_MANAGER" name="STORE_MANAGER" value="${storeList.STORE_MANAGER}"><br/>
	<label>STORE_MEMO</label>
	<input id="STORE_MEMO" name="STORE_MEMO" value="${storeList.STORE_MEMO}">
<input type="hidden" name="STORE_NO" value="${storeList.STORE_NO}">


       	</c:forEach>
       	<a href="#" onclick="document.getElementById('frm').submit();">
			전송 </a>
        </form>
       <!--  <input type="button" id="delete" value="삭제하기"> -->
</body>

</html>



