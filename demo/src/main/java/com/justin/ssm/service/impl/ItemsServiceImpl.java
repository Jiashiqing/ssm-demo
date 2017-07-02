package com.justin.ssm.service.impl;

import com.justin.ssm.exception.CustomException;
import com.justin.ssm.mapper.ItemsMapperCustom;
import com.justin.ssm.po.ItemsCustom;
import com.justin.ssm.po.ItemsQueryVo;
import com.justin.ssm.service.ItemsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Service("itemsService")
public class ItemsServiceImpl implements ItemsService {

	@Resource
//	@Autowired
	private ItemsMapperCustom itemsMapperCustom;
	
	@Override
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo)
			throws Exception {
		System.out.println("itemsMapperCustom="+itemsMapperCustom);
		//通过itemsMapperCustom查询数据库
		return itemsMapperCustom.findItemsList(itemsQueryVo);
	}

	@Override
	public ItemsCustom findItemsById(Integer id) throws Exception {
		ItemsCustom itemsCustom = itemsMapperCustom.findItemsById(id);
		if(itemsCustom ==null){
			throw new CustomException("修改商品信息不存在");
		}
		return itemsCustom;
	}
 
	@Override
	public void updateItems(Map<Integer,ItemsCustom> map) throws Exception {
		//添加业务校验，通常在service接口对关键参数进行校验
		//...
		Iterator<Integer> iterator = map.keySet().iterator();
		if(iterator.hasNext()){
			Integer id  = iterator.next();
			if(id!=null){
//				itemsMapperCustom.updateItems(map);
			}
		}
	}

	@Override
	public void updateItems(Integer id, ItemsCustom itemsCustom)
			throws Exception {
		if(id!=null){
				itemsCustom.setId(id);
				itemsMapperCustom.updateItems(itemsCustom);
			}
		
	}

	@Override
	public void deleteItemsById(Integer id) throws Exception {
		if(id!=null){
			itemsMapperCustom.deleteItemsById(id);;
		}
		
		
	}

}
