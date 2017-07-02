package com.justin.ssm.controller;

import com.justin.ssm.po.ItemsCustom;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Json交互测试
 * @author Justin
 *
 */
@Controller
public class JsonTest {

	//请求json（商品信息），输出json
	//@RequestBody将请求的商品信息的json串转成itemsCustom对象
	//@ResponseBody将itemsCustom对象转成json输出
	@RequestMapping("requestJson")
	public @ResponseBody
    ItemsCustom requestJson(@RequestBody ItemsCustom itemsCustom){
		
		//@ResponseBody将itemsCustom对象转成json输出
		return itemsCustom;
	}
	
	//请求key/value（商品信息），输出json
	//@ResponseBody将itemsCustom对象转成json输出
	@RequestMapping("responseJson")
	public @ResponseBody
    ItemsCustom responseJson(ItemsCustom itemsCustom){
		
		//@ResponseBody将itemsCustom对象转成json输出
		return itemsCustom;
	}
	
}
