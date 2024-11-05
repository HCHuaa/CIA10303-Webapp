<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.item.model.*"%>
<%-- 此頁暫練習採用 Script 的寫法取值 --%>

<%
  ItemVO itemVO = (ItemVO) request.getAttribute("itemVO"); //ItemServlet.java(Concroller), 存入req的itemVO物件
%>

<html>
<head>
<title>商品資料</title>

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
	width: 600px;
	background-color: white;
	margin-top: 5px;
	margin-bottom: 5px;
  }
  table, th, td {
    border: 1px solid rosybrown;
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
		 <h3>單筆查詢</h3>
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
	</tr>
	<tr>
		<td><%=itemVO.getItemId()%></td>
		<td><%=itemVO.getCafeId()%></td>
		<td><%=itemVO.getName()%></td>
		<td><%=itemVO.getPrice()%></td>
		<td><%=itemVO.getStatus()%></td>
		<td><%=itemVO.getContent()%></td>
		<td><%=itemVO.getComments()%></td>
		<td><%=itemVO.getStars()%></td>
	</tr>
</table>

</body>
</html>