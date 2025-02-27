<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>Item</title>

<style>
*{
	background-color: rosybrown;
    color: cornsilk;
}
  
  h1 {
  	display: flex;
    align-items: center;
    padding: 20px; 
    color: cornsilk;
    margin-bottom: 1px;
	font-size: 2.5rem;
    text-shadow: 3px 3px 5px lightpink;
  }
  h3{
  	padding: 20px; 
  }

</style>

</head>
<body bgcolor='white'>

<h1>CAFE Item</h1>

<!-- <p>This is the Home page for Item</p> -->

<h3>商品查詢</h3>
	
<%-- 錯誤表列 --%>
<c:if test="${not empty errorMsgs}">
	<font style="color:red">請修正以下錯誤:</font>
	<ul>
	    <c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>

<ul>
  <li><a href='listAllItem.jsp'>List</a> all Items.  <br><br></li>
  
  
  <li>
    <FORM METHOD="post" ACTION="item.do" >
        <b>輸入商品編號 (Ex.1):</b>
        <input type="text" name="itemId">
        <input type="hidden" name="action" value="getOne_For_Display">
        <input type="submit" value="送出">
    </FORM>
  </li>

  <jsp:useBean id="ItemSvc" scope="page" class="com.item.model.ItemService" />
   
  <li>
     <FORM METHOD="post" ACTION="item.do" >
       <b>選擇商品編號:</b>
       <select size="1" name="itemId">
         <c:forEach var="itemVO" items="${ItemSvc.all}" > 
          <option value="${itemVO.itemId}">${itemVO.itemId}
         </c:forEach>   
       </select>
       <input type="hidden" name="action" value="getOne_For_Display">
       <input type="submit" value="送出">
    </FORM>
  </li>
  
  <li>
     <FORM METHOD="post" ACTION="item.do" >
       <b>選擇商品名稱:</b>
       <select size="1" name="itemId">
         <c:forEach var="itemVO" items="${ItemSvc.all}" > 
          <option value="${itemVO.itemId}">${itemVO.name}
         </c:forEach>   
       </select>
       <input type="hidden" name="action" value="getOne_For_Display">
       <input type="submit" value="送出">
     </FORM>
  </li>
</ul>


<h3>商品管理</h3>

<ul>
  <li><a href='addItem.jsp'>Add</a> a new Item.</li>
</ul>

</body>
</html>