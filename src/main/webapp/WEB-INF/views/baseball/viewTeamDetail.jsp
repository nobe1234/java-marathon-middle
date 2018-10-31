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

<strong>球団名</strong>
<c:out value="${form.teamName}"></c:out><br><br>
<strong>本拠地</strong>
<c:out value="${form.headquarters}"></c:out><br><br>
<strong>発足</strong>
<c:out value="${form.inauguration}"></c:out><br><br>
<strong>歴史</strong>
　<pre><c:out value="${form.history}"></c:out></pre><br><br>

<form action="${pageContext.request.contextPath}/baseballTeam/index " method="post">
<input type="submit" value="戻る">
</form>

</body>
</html>