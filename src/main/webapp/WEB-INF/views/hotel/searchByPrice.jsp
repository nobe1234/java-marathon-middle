<%@page import="org.apache.jasper.tagplugins.jstl.core.Import"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib  uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
    <%@ page import="java.util.Calendar" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ホテル検索</title>
</head>
<!-- 検索エリア -->
<body>
<table border="1">
<tr>
<td align="center"><h2>ホテル検索</h2></td>
</tr></table>

<form action="${pageContext.request.contextPath}/hotel/searchHotel">
一泊料金<input type="text" name="price">円以下
<br>
<input type="submit" value="検索">
</form>

<!-- 表示エリア -->
<c:forEach var="hotel" items="${hotelList}">
<table border="1">
<tr>
<td>ホテル名</td>
<td><c:out value="${hotel.hotelName }"></c:out></td>
</tr>
<tr>
<td>最寄り駅</td>
<td><c:out value="${hotel.nearestStation }"></c:out></td>
</tr>
<tr>
<td>価格</td>
<!-- 価格 -->
<td><fmt:formatNumber value="${hotel.price }" pattern="###,###" /></td>
</tr>
</table>
</c:forEach>

</body>
</html>