package com.item.model;

import java.sql.*;
import java.util.*;

public class ItemJDBCDAO implements ItemDAO_interface {

	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/cia103g7?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "polly0325";
	

	private static final String GET_ALL_STMT = "SELECT * FROM item order by ITEM_ID";
	private static final String GET_ONE_STMT = "SELECT * FROM item where ITEM_ID = ?";

	private static final String INSERT_STMT = "INSERT INTO item (CAFE_ID,NAME,PRICE,CONTENT) VALUES (?, ?, ?, ?)";

	private static final String UPDATE = "UPDATE item set CAFE_ID=?, NAME=?, PRICE=?, STATUS=?, CONTENT=? where ITEM_ID = ?";

	private static final String DELETE = "DELETE FROM item where ITEM_ID = ?";
	
	@Override // 單筆查詢
	public ItemVO findByPrimaryKey(Integer itemId) {
		ItemVO itemVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, itemId);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				itemVO = new ItemVO();
				itemVO.setItemId(rs.getInt("ITEM_ID"));
				itemVO.setCafeId(rs.getInt("CAFE_ID"));
				itemVO.setName(rs.getString("NAME"));
				itemVO.setPrice(rs.getInt("PRICE"));
				itemVO.setStatus(rs.getInt("STATUS"));
				itemVO.setContent(rs.getString("CONTENT"));
				itemVO.setStars(rs.getInt("STARS"));
				itemVO.setComments(rs.getInt("COMMENTS"));

			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return itemVO;
	}

	@Override
	public List<ItemVO> getAll() {
		List<ItemVO> list = new ArrayList<ItemVO>();
		ItemVO itemVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				itemVO = new ItemVO();
				itemVO.setItemId(rs.getInt("ITEM_ID"));
				itemVO.setCafeId(rs.getInt("CAFE_ID"));
				itemVO.setName(rs.getString("NAME"));
				itemVO.setPrice(rs.getInt("PRICE"));
				itemVO.setStatus(rs.getInt("STATUS"));
				itemVO.setContent(rs.getString("CONTENT"));
				itemVO.setStars(rs.getInt("STARS"));
				itemVO.setComments(rs.getInt("COMMENTS"));

				list.add(itemVO); // Store the row in the list
			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return list;
	}

	@Override
	public void insert(ItemVO itemVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			
			pstmt.setInt(1, itemVO.getCafeId());
			pstmt.setString(2, itemVO.getName());
			pstmt.setInt(3, itemVO.getPrice());
//			pstmt.setInt(4, itemVO.getStatus());
			pstmt.setString(4, itemVO.getContent());

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}

	@Override
	public void update(ItemVO itemVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);
			
			pstmt.setInt(1, itemVO.getCafeId());
			pstmt.setString(2, itemVO.getName());
			pstmt.setInt(3, itemVO.getPrice());
			pstmt.setInt(4, itemVO.getStatus());
			pstmt.setString(5, itemVO.getContent());
			pstmt.setInt(6, itemVO.getItemId());

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}

	@Override
	public void delete(Integer itemId) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, itemId);

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}

	public static void main(String[] args) {
		ItemJDBCDAO dao = new ItemJDBCDAO();

//		// 查詢
//		ItemVO itemVO1 = dao.findByPrimaryKey(1);
//		System.out.print(itemVO1.getItemId() + ",");
//		System.out.print(itemVO1.getCafeId() + ",");
//		System.out.print(itemVO1.getName() + ",");
//		System.out.print(itemVO1.getPrice() + ",");
//		System.out.print(itemVO1.getStatus() + ",");
//		System.out.print(itemVO1.getContent() + ",");
//		System.out.print(itemVO1.getStars() + ",");
//		System.out.println(itemVO1.getComments());
//
//		System.out.println("---------------------");
//
//		// 查詢
//		List<ItemVO> list = dao.getAll();
//		for (ItemVO aitem : list) {
//			System.out.print(aitem.getItemId() + ",");
//			System.out.print(aitem.getCafeId() + ",");
//			System.out.print(aitem.getName() + ",");
//			System.out.print(aitem.getPrice() + ",");
//			System.out.print(aitem.getStatus() + ",");
//			System.out.print(aitem.getContent() + ",");
//			System.out.print(aitem.getStars() + ",");
//			System.out.print(aitem.getComments());
//
//			System.out.println();
//		}
		
		// 新增
//		ItemVO itemVO2 = new ItemVO();
//		itemVO2.setCafeId(4);
//		itemVO2.setName("Mocha Latte");
//		itemVO2.setPrice(160);
//		itemVO2.setContent("抹茶拿鐵");
//		
//		dao.insert(itemVO2);

		// 修改
		ItemVO itemVO3 = new ItemVO();
		itemVO3.setItemId(1);
		itemVO3.setCafeId(3);
		itemVO3.setName("coffee");
		itemVO3.setPrice(130);
		itemVO3.setStatus(1);
		itemVO3.setContent("coffee");

		dao.update(itemVO3);

		// 刪除
//		dao.delete(10);

	}

}
