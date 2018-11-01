<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    <%@ page import="java.util.Calendar" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- 検索項目部分 -->
<table border="1">
<tr align="center">
<td align="center"><h2><strong>洋服</strong>shop</h2></td>
</tr>
</table>
<form action="${pageContext.request.contextPath }/shop/searchClothes" method="post">

<input type="radio" name="gender" value="0">Man<br>
<input type="radio" name="gender" value="1">Woman

<select name="color">
<option value="赤">赤</option>
<option value="青">青</option>
<option value="黄">黄</option>
<option value="白">白</option>
</select>

<input type="submit" value="検索">

</form>

<!-- 結果表示部分 -->
<c:forEach var="shopList" items="${shopList}">
<table border="1">
<tr>
<td>ジャンル</td>
<td><c:out value="${shopList.genre}"></c:out></td>
</tr>

<tr>
<td>サイズ</td>
<td><c:out value="${shopList.size}"></c:out></td>
</tr>

<tr>
<td>価格</td>
<td><fmt:formatNumber value="${shopList.price}" pattern="###,###"/></td>
</tr>
</table>
</c:forEach>


</body>
</html>