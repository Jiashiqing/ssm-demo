package com.justin.ssm.controller;

import com.justin.ssm.exception.CustomException;
import com.justin.ssm.po.ItemsCustom;
import com.justin.ssm.po.ItemsQueryVo;
import com.justin.ssm.service.ItemsService;
import com.justin.ssm.utils.MD5Util;
import com.justin.ssm.validation.validGroup1;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
//为了对url进行分类管理，可以定义根路径
@RequestMapping("/items")
public class ItemsController {
	private static Logger logger = Logger.getLogger(ItemsController.class);
	// 注入
	//@Resource 
	@Autowired
	private ItemsService itemsService;
	
	//商品分类
	//itemTypes表示最终将方法返回值放到Request中的key
	@ModelAttribute("itemtypes")
	public Map<String, String> getItemType(){
		Map<String, String> itemTypes = new HashMap<String,String>();
		itemTypes.put("101", "手机");
		itemTypes.put("102", "电脑");
		
		return itemTypes;
	}
	
/***********************查询商品*****************************/		
	// 查询商品列表
	// @RequestMapping实现对queryItems方法和url进行映射，一个方法对应一个url
	// 一般建议将url和方法名一致，方便维护
	@RequestMapping("/queryItems")
	public ModelAndView queryItems(HttpServletRequest request, ItemsQueryVo itemsQueryVo) throws Exception {
		System.out.println("itemsService=" + itemsService +",id=="+ request.getParameter("id"));
		
		logger.debug("This is debug message.");
		
		
//		ItemsQueryVo itemsQueryVo = new ItemsQueryVo();
		// 调用service查找数据库，查询商品列表
		List<ItemsCustom> itemsList = itemsService.findItemsList(itemsQueryVo);

		// 返回ModelAndView
		ModelAndView modelAndView = new ModelAndView();
		// 相当于request的setAttribute,在jsp页面通过itemsList获取数据
		modelAndView.addObject("itemsList", itemsList);
		// 指定视图
		// modelAndView.setViewName("/WEB-INF/jsp/items/itemsList.jsp");
		// 下边的路径，如果在视图解析器中配置jsp路径的前缀和后缀，就可以修改
		modelAndView.setViewName("items/itemsList");
		return modelAndView;
	}
	
	//查询商品信息,输出json
	///itemsView/{id}里边的{id}表示将这个位置参数传到@PathVariable指定的名称中。
	@RequestMapping("/itemsView/{id}")
	public @ResponseBody
    ItemsCustom itemsView(@PathVariable("id") Integer id) throws Exception{
		//调用service查询商品信息
		ItemsCustom itemsCustom = itemsService.findItemsById(id);
		return itemsCustom;
	}

/***********************修改商品信息*****************************/	
	//修改商品信息
	@RequestMapping(value="/editItems",method={RequestMethod.POST, RequestMethod.GET})
	//@RequestParam里面指定Request传入参数名称和形参进行绑定
	//required=true指定参数必须要传入
	public String editItems(
			Model model,
			@RequestParam(value = "id", required = true/* ,defaultValue="1" */) Integer item_id)
			throws Exception {
		ItemsCustom itemsCustom = itemsService.findItemsById(item_id);
		// 判断商品是否为空
		if (itemsCustom == null) {
			throw new CustomException("修改商品信息不存在");
		}
		// 相当于modelAndView.addObject方法
		model.addAttribute("itemsCustom", itemsCustom);
		return "items/editItems";
	}
	
	//修改商品信息页面
//	@RequestMapping("/editItems")
	//限制http请求方法，可以post和get
	//@RequestMapping(value="/editItems",method={RequestMethod.POST,RequestMethod.GET})
	/*public ModelAndView editItems() throws Exception {
		System.out.println("itemsService=" + itemsService);
		
		// 调用service查找数据库，查询商品列表
		ItemsCustom itemsCustom = itemsService.findItemsById(1);
		
		// 返回ModelAndView
		ModelAndView modelAndView = new ModelAndView();
		// 相当于request的setAttribute,在jsp页面通过itemsList获取数据
		modelAndView.addObject("itemsCustom", itemsCustom);
		// 指定视图
		// 下边的路径，如果在视图解析器中配置jsp路径的前缀和后缀，就可以修改
		modelAndView.setViewName("items/editItems");
		return modelAndView;
	}*/

/***********************修改商品信息提交*****************************/		
	//商品信息修改提交
	/*	
	 	在需要校验的pojo前边添加@Validated，在需要校验的pojo后边添加BindingResult bindingResult接收校验出错信息
		注意：@Validated和BindingResult bindingResult是配对出现的，并且顺序是固定的
	*/
	//value={validGroup1.class}指定使用validGroup1分组的校验
	//@ModelAttribute("items")指定pojo回显到页面在Request中的key
	@RequestMapping("/editItemsSubmit")
	public String editItemsSubmit(
//            Model model,
			RedirectAttributes model, // 用于重定向时保存数据
            HttpServletRequest request,
            Integer id,
			/*@ModelAttribute("items")*/ @Validated(value={validGroup1.class}) ItemsCustom itemsCustom, BindingResult bindingResult,
            MultipartFile items_pic //接收商品的图片
			) throws Exception {
		//调用service更新商品信息，页面需要将商品信息传到此方法
		
		//获取校验错误信息
		if(bindingResult.hasErrors()){
			//输出错误信息
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			for (ObjectError objectError : allErrors) {
				//打印错误信息
				System.out.println(objectError.getDefaultMessage());
			}
			//将错误信息传到页面
			model.addAttribute("allErrors",allErrors);
			//可以直接使用model将提交pojo回显到页面
			model.addAttribute("itemsCustom",itemsCustom);
			return "items/editItems";
		}
		//图片的原始名称
		String originalFilename = items_pic.getOriginalFilename();
		//上传图片
		if(items_pic!=null && originalFilename!=null && originalFilename.length()>0){
			//存储图片的物理路径
			String pic_path ="D:\\Java\\upload\\";
			//生成新的图片名称
			String newFilename = MD5Util.MD5(originalFilename)
					+ originalFilename.substring(originalFilename.lastIndexOf("."));
			//新图片
			File newFile = new File(pic_path+newFilename);
			System.out.println("newFile="+newFile);
			//将内存中的数据写入磁盘
			items_pic.transferTo(newFile);
			//将新图片名称写到itemsCustom中
			itemsCustom.setPic(newFilename);
		}
		
		itemsService.updateItems(id, itemsCustom);
		//重定向到商品查询列表
		//return "redirect:queryItems";
		
		//页面转发
		return "forward:queryItems";
		//跳转到success.jsp页面
//		return "success";
	}

	
	
/***********************批量删除商品*****************************/	
	//批量删除商品
	@RequestMapping("/deleteItems")
	public String deleteItems(Integer[] items_id) throws Exception {
		//调用service更新商品信息，页面需要将商品信息传到此方法
		for (Integer id : items_id) {
			itemsService.deleteItemsById(id);
		}
		//页面转发
		return "forward:queryItems";
	}

	
/***********************批量修改商品*****************************/
	//批量修改商品页面，将商品信息查询出来，在页面中可以编辑商品信息
	@RequestMapping("/editItemsQuery")
	public ModelAndView editItemsQuery(HttpServletRequest request, ItemsQueryVo itemsQueryVo) throws Exception {
		System.out.println("itemsService=" + itemsService +",id=="+ request.getParameter("id"));
		
		// 调用service查找数据库，查询商品列表
		List<ItemsCustom> itemsList = itemsService.findItemsList(itemsQueryVo);

		// 返回ModelAndView
		ModelAndView modelAndView = new ModelAndView();
		// 相当于request的setAttribute,在jsp页面通过itemsList获取数据
		modelAndView.addObject("itemsList", itemsList);
		// 指定视图
		// 下边的路径，如果在视图解析器中配置jsp路径的前缀和后缀，就可以修改
		modelAndView.setViewName("items/editItemsQuery");
		return modelAndView;
	}
	
	//批量修改商品提交
	@RequestMapping("/editItemsAllSubmit")
	public String editItemsAllSubmit(ItemsQueryVo itemsQueryVo) throws Exception {
		//调用service更新商品信息，页面需要将商品信息传到此方法
		
//		itemsService.updateItems(id, itemsCustom);
		
		return "success";
	}
	
}
