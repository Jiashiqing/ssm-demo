package com.justin.ssm.service;

import com.justin.ssm.po.ItemsCustom;
import com.justin.ssm.po.ItemsQueryVo;

import java.util.List;
import java.util.Map;

/**
 * 商品管理的service
 * 
 * @author Administrator
 * 
 */

public interface ItemsService {

	// 商品的查询列表
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo)
			throws Exception;

	// 根据商品id查询列表
	public ItemsCustom findItemsById(Integer id) throws Exception;

	// 根据商品id删除商品
	public void deleteItemsById(Integer id) throws Exception;

	// 修改商品的信息
	public void updateItems(Integer id, ItemsCustom itemsCustom)
			throws Exception;

	public void updateItems(Map<Integer, ItemsCustom> map) throws Exception;
}
