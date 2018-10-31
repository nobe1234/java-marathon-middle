<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
<tr>
<td><h1>プロ野球<br>セントラル・リーグ一覧</h1></td>
</tr></table>
<c:forEach var="teamList" items="${teamList}">
<a href="${pageContext.request.contextPath}/baseballTeam/showTeamDetail?id=${teamList.id} " >
<c:out value="${teamList.teamName }"></c:out></a><br>
</c:forEach>
</body>
</html>