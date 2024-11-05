package com.item.model;

import java.util.*;

public interface ItemDAO_interface {
	public void insert(ItemVO itemVO);

	public void update(ItemVO itemVO);

	public void delete(Integer itemId);

	public ItemVO findByPrimaryKey(Integer itemId);

	public List<ItemVO> getAll();
	// 萬用複合查詢(傳入參數型態Map)(回傳 List)
	//  public List<EmpVO> getAll(Map<String, String[]> map); 
}
