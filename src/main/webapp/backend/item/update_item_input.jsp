<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.item.model.*"%>

<% //見com.item.controller.itemServlet.java第163行存入req的itemVO物件 (此為從資料庫取出的itemVO, 也可以是輸入格式有錯誤時的itemVO物件)
   ItemVO itemVO = (ItemVO) request.getAttribute("itemVO");
%>

<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<title>修改商品</title>

<style>
*{
	background-color: rosybrown;
    color: cornsilk;
}
  table#table-1 {
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
  table#table-2 {
	width: 450px;
	background-color: white;
	margin-top: 1px;
	margin-bottom: 1px;
  }
  table, th, td {
    border: 0px solid rosybrown;
  }
  th, td {
    padding: 1px;
  }
</style>

</head>
<body bgcolor='white'>

<table id="table-1">
	<tr><td>
		 <h3>修改商品</h3>
		 <h4><a href="select_page.jsp"><img src="images/2.jpg" width="350" height="200" border="0"><br>回首頁</a></h4>
	</td></tr>
</table>

<h3>資料修改:</h3>

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
<table id="table-2">
	<tr>
		<td>商品編號:<font color=red><b>*</b></font></td>
		<td><%=itemVO.getItemId()%></td>
	</tr>
	<tr>
		<td>咖啡廳編號:<font color=red><b>*</b></font></td>
		<td><%=itemVO.getCafeId()%></td>
	</tr>
	<tr>
		<td>商品名稱:</td>
		<td><input type="TEXT" name="name" value="<%=itemVO.getName()%>" size="45"/></td>
	</tr>
	<tr>
		<td>單價:</td>
		<td><input type="TEXT" name="price"  value="<%=itemVO.getPrice()%>" size="45"/></td>
	</tr>
	<tr>
		<td>狀態:</td>
		<td><input type="TEXT" name="status"  value="<%=itemVO.getStatus()%>" size="45"/></td>
	</tr>
	<tr>
		<td>介紹:</td>
		<td><input type="TEXT" name="content" value="<%=itemVO.getContent()%>" size="45"/></td>
	</tr>

</table>
<br>
<input type="hidden" name="action" value="update">
<input type="hidden" name="itemId" value="<%=itemVO.getItemId()%>">
<input type="hidden" name="cafeId" value="<%=itemVO.getCafeId()%>">
<input type="submit" value="送出修改"></FORM>
</body>
</html>