<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.item.model.*"%>
<%-- 此頁練習採用 EL 的寫法取值 --%>

<%
    ItemService itemSvc = new ItemService();
    List<ItemVO> list = itemSvc.getAll();
    pageContext.setAttribute("list",list);
%>


<html>
<head>
<title>所有商品</title>

<style>
*{
	background-color: rosybrown;
    color: cornsilk;
}
  table#table-1 {
	background-color: rosybrown;
/*     border: 2px solid black; */
    text-align: center;
  }
  table#table-1 h4 {
    color: red;
    display: block;
    margin-bottom: 1px;
  }
  h4 {
    color: blue;
    display: inline;
  }
</style>

<style>
  table {
	width: 800px;
	background-color: white;
	margin-top: 5px;
	margin-bottom: 5px;
  }
  table, th, td {
/*     border: 1px solid #CCCCFF; */
  }
  th, td {
    padding: 5px;
    text-align: center;
  }
</style>

</head>
<body bgcolor='white'>

<table id="table-1">
	<tr><td>
		 <h3>所有商品</h3>
		 <h4><a href="select_page.jsp"><img src="images/1.jpg" width="100" height="100" border="0"><br>回首頁</a></h4>
	</td></tr>
</table>

<table>
	<tr>
		<th>商品編號</th>
		<th>咖啡廳編號</th>
		<th>商品名稱</th>
		<th>單價</th>
		<th>狀態</th>
		<th>介紹</th>
		<th>星星</th>
		<th>評價數</th>
		<th>修改</th>
		<th>刪除</th>
	</tr>
	<%@ include file="page1.file" %> 
	<c:forEach var="itemVO" items="${list}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">
		
		<tr>
			<td>${itemVO.itemId}</td>
			<td>${itemVO.cafeId}</td>
			<td>${itemVO.name}</td>
			<td>${itemVO.price}</td>
			<td>${itemVO.status}</td>
			<td>${itemVO.content}</td> 
			<td>${itemVO.stars}</td>
			<td>${itemVO.comments}</td>
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/backend/item/item.do" style="margin-bottom: 0px;">
			     <input type="submit" value="修改">
			     <input type="hidden" name="itemId"  value="${itemVO.itemId}">
			     <input type="hidden" name="action"	value="getOne_For_Update"></FORM>
			</td>
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/backend/item/item.do" style="margin-bottom: 0px;">
			     <input type="submit" value="刪除">
			     <input type="hidden" name="itemId"  value="${itemVO.itemId}">
			     <input type="hidden" name="action" value="delete"></FORM>
			</td>
		</tr>
	</c:forEach>
</table>
<%@ include file="page2.file" %>

</body>
</html>