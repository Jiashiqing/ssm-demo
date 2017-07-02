package com.justin.ssm.mapper;

import com.justin.ssm.po.Orders;
import com.justin.ssm.po.User;

import java.util.List;


/**
 * 
 * @author Administrator
 *
 */
public interface OrdersCustomMapper {

	//查询订单关联查询用户信息 ，使用resultMap(一对一)
	public List<Orders> findOrdersUserResultMap() throws Exception;
	
	//查询订单关联查询用户信息及订单明细 ，使用resultMap（一对多）
	public List<Orders> findOrdersAndOrderdetailResultMap() throws Exception;
	
	//查询用户信息及商品信息 ，使用resultMap（多对多）
	public List<User> findUserAndItemsResultMap() throws Exception;
	
	//查询订单关联查询用户信息，用户信息是延迟加载
	public List<Orders> findOrdersUserlazyLoading() throws Exception;
}
