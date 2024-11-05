<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.item.model.*"%>

<% //見com.item.controller.itemServlet.java第238行存入req的itemVO物件 (此為輸入格式有錯誤時的itemVO物件)
   ItemVO itemVO = (ItemVO) request.getAttribute("itemVO");
%>

<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<title>新增商品</title>

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
	width: 450px;
	background-color: white;
	margin-top: 1px;
	margin-bottom: 1px;
  }
  table, th, td {
    border: 1px solid rosybrown;
  }
  th, td {
    padding: 1px;
  }
</style>

</head>
<body bgcolor='white'>

<table id="table-1">
	<tr><td>
		 <h3>新增商品</h3></td><td>
		 <h4><a href="select_page.jsp"><img src="images/3.jpg" width="100" height="100" border="0"><br>回首頁</a></h4>
	</td></tr>
</table>

<h3>資料新增:</h3>

<%-- 錯誤表列 --%>
<c:if test="${not empty errorMsgs}">
	<font style="color:red">請修正以下錯誤:</font>
	<ul>
		<c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>

<FORM METHOD="post" ACTION="item.do" name="form1">
<table>

	<tr>
		<td>咖啡廳編號:</td>
		<td><input type="TEXT" name="cafeId" value="<%= (itemVO==null)? "0" : itemVO.getCafeId()%>" size="45"/></td>
	</tr>	
	<tr>
		<td>商品名稱:</td>
		<td><input type="TEXT" name="name" value="<%= (itemVO==null)? "咖啡機" : itemVO.getName()%>" size="45"/></td>
	</tr>
	<tr>
		<td>單價:</td>
		<td><input type="TEXT" name="price"   value="<%= (itemVO==null)? "200" : itemVO.getPrice()%>" size="45"/></td>
	</tr>
	<tr>
		<td>介紹:</td>
		<td><input type="TEXT" name="content"   value="<%= (itemVO==null)? "coffee machine" : itemVO.getContent()%>" size="45"/></td>
	</tr>

	<jsp:useBean id="itemSvc" scope="page" class="com.item.model.ItemService" />

</table>
<br>
<input type="hidden" name="action" value="insert">
<input type="submit" value="送出新增"></FORM>

</body>
</html>