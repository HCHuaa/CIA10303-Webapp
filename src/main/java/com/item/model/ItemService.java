package com.item.model;

import java.util.List;

public class ItemService {

	private ItemDAO_interface dao;

	public ItemService() {
		dao = new ItemJDBCDAO();
	}

	public ItemVO getOneItem(Integer itemId) {
		return dao.findByPrimaryKey(itemId);
	}

	public List<ItemVO> getAll() {
		return dao.getAll();
	}

	public ItemVO addItem(Integer cafeId, String name, Integer price, String content) {

		ItemVO itemVO = new ItemVO();

		itemVO.setCafeId(cafeId);
		itemVO.setName(name);
		itemVO.setPrice(price);
		itemVO.setContent(content);
		
		dao.insert(itemVO);

		return itemVO;
	}

	public ItemVO updateItem(Integer cafeId, String name, Integer price, Integer status, String content, Integer itemId) {

		ItemVO itemVO = new ItemVO();


		itemVO.setCafeId(cafeId);
		itemVO.setName(name);
		itemVO.setPrice(price);
		itemVO.setStatus(status);
		itemVO.setContent(content);
		itemVO.setItemId(itemId);

		dao.update(itemVO);

		return itemVO;
	}

	public void deleteItem(Integer itemId) {
		dao.delete(itemId);
	}

}
