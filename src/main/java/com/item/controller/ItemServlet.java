package com.item.controller;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.item.model.*;

@WebServlet("/backend/item/item.do")
public class ItemServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		System.out.println("lllll");
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");

		if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			String str = req.getParameter("itemId");
			if (str == null || (str.trim()).length() == 0) {
				errorMsgs.add("請輸入編號");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/backend/item/select_page.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			Integer itemId = null;
			try {
				itemId = Integer.valueOf(str);
			} catch (Exception e) {
				errorMsgs.add("編號格式不正確");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/backend/item/select_page.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			/*************************** 2.開始查詢資料 *****************************************/
			ItemService itemSvc = new ItemService();
			ItemVO itemVO = itemSvc.getOneItem(itemId);
			if (itemVO == null) {
				errorMsgs.add("查無資料");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/backend/item/select_page.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			/*************************** 3.查詢完成,準備轉交(Send the Success view) *************/
			req.setAttribute("itemVO", itemVO); // 資料庫取出的itemVO物件,存入req
			String url = "/backend/item/listOneItem.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneitem.jsp
			successView.forward(req, res);
		}
		

		if ("getOne_For_Update".equals(action)) { // 來自listAllitem.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 ****************************************/
			Integer itemId = Integer.valueOf(req.getParameter("itemId"));

			/*************************** 2.開始查詢資料 ****************************************/
			ItemService itemSvc = new ItemService();
			ItemVO itemVO = itemSvc.getOneItem(itemId);

			/*************************** 3.查詢完成,準備轉交(Send the Success view) ************/
			req.setAttribute("itemVO", itemVO); // 資料庫取出的itemVO物件,存入req
			String url = "/backend/item/update_item_input.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_item_input.jsp
			successView.forward(req, res);
		}

		if ("update".equals(action)) { // 來自update_item_input.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			Integer itemId = Integer.valueOf(req.getParameter("itemId").trim());
			
			Integer cafeId = Integer.valueOf(req.getParameter("cafeId").trim());
			
			String name = req.getParameter("name");
			String nameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
			if (name == null || name.trim().length() == 0) {
				errorMsgs.add("商品名稱: 請勿空白");
			} else if (!name.trim().matches(nameReg)) { // 以下練習正則(規)表示式(regular-expression)
				errorMsgs.add("商品名稱: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
			}
			
//			Integer price = null;
//
//			try {
//			    String priceParam = req.getParameter("price");
//			    if (priceParam != null && !priceParam.trim().isEmpty()) {
//			        price = Integer.valueOf(priceParam.trim());
//			    } else {
//			        price = 0;
//			        errorMsgs.add("單價為必填項，請填寫數字.");
//			    }
//			} catch (NumberFormatException e) {
//			    price = 0;
//			    errorMsgs.add("單價請填數字.");
//			}

			Integer price = Integer.valueOf(req.getParameter("price").trim());
//			} catch (NumberFormatException e) {
//				price = 0;
//				errorMsgs.add("單價請填數字.");
//			}

			Integer status = Integer.valueOf(req.getParameter("status").trim());
//			} catch (NumberFormatException e) {
//				status = 0;
//				errorMsgs.add("狀態請填數字.");
//			}
			
//			Integer status = null;
//
//			try {
//			    String statusParam = req.getParameter("status");
//			    if (statusParam != null && !statusParam.trim().isEmpty()) {
//			        status = Integer.valueOf(statusParam.trim());
//			    } else {
//			        // 處理缺失參數的情況
//			        status = 0; // 或者其他適合的默認值
//			        errorMsgs.add("狀態為必填項，請填寫數字.");
//			    }
//			} catch (NumberFormatException e) {
//			    status = 0; // 設置默認值
//			    errorMsgs.add("狀態請填數字.");
//			}

			
			String content = req.getParameter("content").trim();
			if (content == null || content.trim().length() == 0) {
				errorMsgs.add("介紹請勿空白");
			}
			
//			String content = req.getParameter("content");
//			if (content == null || content.trim().length() == 0) {
//			    errorMsgs.add("介紹請勿空白");
//			} else {
//			    content = content.trim(); // 如果不為空，這裡可以進行修整
//			}

	

			ItemVO itemVO = new ItemVO();

			itemVO.setCafeId(cafeId);
			itemVO.setName(name);
			itemVO.setPrice(price);
			itemVO.setStatus(status);
			itemVO.setContent(content);
			itemVO.setItemId(itemId);

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("itemVO", itemVO); // 含有輸入格式錯誤的itemVO物件,也存入req
				RequestDispatcher failureView = req.getRequestDispatcher("/backend/item/update_item_input.jsp");
				failureView.forward(req, res);
				return; // 程式中斷
			}

			/*************************** 2.開始修改資料 *****************************************/
			ItemService itemSvc = new ItemService();
			itemVO = itemSvc.updateItem(cafeId, name, price, status, content, itemId);

			/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
			req.setAttribute("itemVO", itemVO); // 資料庫update成功後,正確的的itemVO物件,存入req
			String url = "/backend/item/listOneItem.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneitem.jsp
			successView.forward(req, res);
		}

		if ("insert".equals(action)) { // 來自additem.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*********************** 1.接收請求參數 - 輸入格式的錯誤處理 *************************/
			Integer cafeId = null;
			try {
				cafeId = Integer.valueOf(req.getParameter("cafeId").trim());
			} catch (NumberFormatException e) {
				cafeId = 0;
				errorMsgs.add("咖啡廳編號請填數字.");
			}
			
			String name = req.getParameter("name");
			String nameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
			if (name == null || name.trim().length() == 0) {
				errorMsgs.add("商品名稱: 請勿空白");
			} else if (!name.trim().matches(nameReg)) { // 以下練習正則(規)表示式(regular-expression)
				errorMsgs.add("商品名稱: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
			}
			
			Integer price = null;
			try {
				price = Integer.valueOf(req.getParameter("price").trim());
			} catch (NumberFormatException e) {
				price = 0;
				errorMsgs.add("單價請填數字.");
			}

			
			String content = req.getParameter("content").trim();
			if (content == null || content.trim().length() == 0) {
				errorMsgs.add("介紹請勿空白");
			}
	

			ItemVO itemVO = new ItemVO();
			itemVO.setCafeId(cafeId);
			itemVO.setName(name);
			itemVO.setPrice(price);
			itemVO.setContent(content);
			

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				req.setAttribute("itemVO", itemVO); // 含有輸入格式錯誤的itemVO物件,也存入req
				RequestDispatcher failureView = req.getRequestDispatcher("/backend/item/addItem.jsp");
				failureView.forward(req, res);
				return;
			}

			/*************************** 2.開始新增資料 ***************************************/
			ItemService itemSvc = new ItemService();
			itemVO = itemSvc.addItem(cafeId, name, price, content);

			/*************************** 3.新增完成,準備轉交(Send the Success view) ***********/
			String url = "/backend/item/listAllItem.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllitem.jsp
			successView.forward(req, res);
		}

		if ("delete".equals(action)) { // 來自listAllitem.jsp

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 ***************************************/
			Integer itemId = Integer.valueOf(req.getParameter("itemId"));

			/*************************** 2.開始刪除資料 ***************************************/
			ItemService itemSvc = new ItemService();
			itemSvc.deleteItem(itemId);

			/*************************** 3.刪除完成,準備轉交(Send the Success view) ***********/
			String url = "/backend/item/listAllItem.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
			successView.forward(req, res);
		}

	}
}
