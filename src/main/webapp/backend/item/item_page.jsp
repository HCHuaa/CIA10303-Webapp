<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>CAFE Shop :)</title>
    <link rel="stylesheet" href="./Item.css">
    <style>
	    * {
		    box-sizing: border-box;
		    margin: 0;
		    padding: 0;
		    background-color: rosybrown;
		    font-weight: 500;
		}
		h1{
		    font-size: 3.5rem;
		    text-shadow: 3px 3px 5px lightpink;
		}
		header {
		    color: cornsilk;
		    display: flex;
		    align-items: center;
		    padding: 20px; 
		    justify-content: space-between;
		}
		button {
		    color: cornsilk;
		    background-color: rosybrown;
		    padding: 10px 15px;
		    margin: 5px; 
		    border: 1px solid lightgray;
		    border-radius: 3px;
		    height: 40px;
		    font-size: 16px;
		    cursor: pointer;
		    transition: background-color 0.3s;
		    box-shadow: 1px 1px 3px lightpink;
		}
		button:hover {
		    background-color: lightcoral;
		}
		
		div.search input.search_item{
		    width: 15%;
		    height: 40px;
		    border-radius: 3px;
		    border: 1px solid lightgray;
		    background-color:#ddd;
		    opacity: 40%;
		    font-size: 16px;
		    padding: 5px 10px;
		    outline: none;
		    display: inline-block;
		    margin-left: 76%;
		}
		input.search_item::placeholder{
		    color: rgb(61, 60, 60);
		}
		
		
		.form_controls {
		    display: flex; 
		    align-items: center; 
		    gap: 10px; 
		    margin: 20px;
		}
		.form_select {
		    color:cornsilk ;
		    width: 200px;
		    border: 1px solid lightgray;
		    border-radius: 3px;
		    height: 40px;
		    font-size: 16px;
		    padding: 5px 10px;
		    outline: none;
		}
		
		table {
		    color: cornsilk;
		    width: 95%;
		    margin: 20px;;
		    border-collapse: collapse;
		}
		
		
		th, td {
		    border: 1.5px solid #ddd;
		    padding: 8px;
		    text-align: center;
		}
		
		th {
		    background-color: rgb(93, 123, 148);
		    color: white; 
		}
		
		td img {
		    width: 100px;
		    height: auto;
		}
    </style>
    
</head>
<body>
    <header>
        <h1>CAFE</h1>
        <form action="">
        <div>
            <button type="button" class="my_cafe">我的CAFE</button>
            <button type="button" class="item_manage">商品管理</button>
            <button type="button" class="order_manage">訂單管理</button>
            <button type="button" class="money_manage">查看款項</button>
            <button type="button" class="log_out">登出</button>
        </div>
        </form>
    </header>

	<form action="" METHOD="post" ACTION="item.do">
    <div class="search">
        <input class="search_item" placeholder="請輸入商品名稱..." type="text" name="name">
        <input type="hidden" name="action" value="getOne_For_Display">
        <button type="submit" class="search_item" value="送出">Search</button>
    </div>
    <jsp:useBean id="itemSvc" scope="page" class="com.item.model.ItemService" />
	</form>


    <div class="form_controls">
        <div class="Item_controls">
            <button type="button" class="add_item">新增商品</button>
            <button type="button" class="delete_item">刪除商品</button>
        </div>
        <div class="select">
            <select class="form_select">
                <option value="0">全部商品</option>
                <option value="1">上架中</option>
                <option value="2">已下架</option>
                <option value="3">平台強制下架</option>
            </select>
        </div>
    </div>

    <div class="table_container">
        <table id="ItemList">
            <thead>
                <tr>
                    <th><input type="checkbox" id="select_all"></th>
                    <th>ID</th>
                    <th>名稱</th>
                    <th>圖片</th>
                    <th>狀態</th>
                    <th>介紹</th>
                    <th>單價</th>
                    <th>編輯</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td><input type="checkbox" class="item_select"></td>
                    <td>1</td>
                    <td>Coffee</td>
                    <td><img src="images/7.jpg" alt="EX1"></td>
                    <td>下架</td>
                    <td>咖啡</td>
                    <td>$150</td>
                    <td><button>修改</button></td>
                </tr>
                <tr>
                    <td><input type="checkbox" class="item_select"></td>
                    <td>2</td>
                    <td>Latte</td>
                    <td><img src="images/4.jpg" alt="EX2"></td>
                    <td>下架</td>
                    <td>那堤</td>
                    <td>$170</td>
                    <td><button>修改</button></td>
                </tr>
            </tbody>
        </table>
    </div>
</body>
</html>
