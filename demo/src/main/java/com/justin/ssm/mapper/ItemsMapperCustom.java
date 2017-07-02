package com.justin.ssm.mapper;

import com.justin.ssm.po.ItemsCustom;
import com.justin.ssm.po.ItemsQueryVo;

import java.util.List;

/**
 * 
 * @author Administrator
 * 
 */
public interface ItemsMapperCustom {

	// 商品查询列表
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo)throws Exception;

	// 根据商品id查询列表
	public ItemsCustom findItemsById(Integer id) throws Exception;
	
	// 根据商品id删除商品
	public void deleteItemsById(Integer id) throws Exception;

	// 修改商品的信息
	public void updateItems(ItemsCustom itemsCustom) throws Exception;
	//public void updateItems(Map<Integer,ItemsCustom> map) throws Exception;

}
