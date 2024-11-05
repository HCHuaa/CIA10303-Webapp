<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.item.model.*"%>
<%-- 此頁暫練習採用 Script 的寫法取值 --%>

<%
  ItemVO itemVO = (ItemVO) request.getAttribute("itemVO");
%>

<html>
<head>
<title>商品資料 - listOne.jsp</title>

<style>
  table#table-1 {
	background-color: #CCCCFF;
    border: 2px solid black;
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
	width: 600px;
	background-color: white;
	margin-top: 5px;
	margin-bottom: 5px;
  }
  table, th, td {
    border: 1px solid #CCCCFF;
  }
  th, td {
    padding: 5px;
    text-align: center;
  }
</style>

</head>
<body bgcolor='white'>

<h4>此頁暫練習採用 Script 的寫法取值:</h4>
<table id="table-1">
	<tr><td>
		 <h3>商品資料 - listOne.jsp</h3>
		 <h4><a href="item_page.jsp"><img src="images/back1.gif" width="100" height="32" border="0">回首頁</a></h4>
	</td></tr>
</table>

<table>
	<tr>
		<th>ITEM編號</th>
		<th>CAFE編號</th>
		<th>名稱</th>
		<th>價格</th>
		<th>狀態</th>
		<th>介紹</th>
		<th>星星</th>
		<th>評論人數</th>
		
	</tr>
		<c:if test="${empty itemVO}">
    <tr>
        <td colspan="4">未找到商品資訊</td>
    </tr>
	<tr>
		<td><%=itemVO.getItemId()%></td>
		<td><%=itemVO.getCafeId()%></td>
		<td><%=itemVO.getName()%></td>
		<td><%=itemVO.getPrice()%></td>
		<td><%=itemVO.getStatus()%></td>
		<td><%=itemVO.getContent()%></td>
		<td><%=itemVO.getStars()%></td>
		<td><%=itemVO.getComments()%></td>
		
	</tr>

</c:if>
</table>

</body>
</html>