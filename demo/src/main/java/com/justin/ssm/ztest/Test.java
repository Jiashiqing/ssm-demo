package com.justin.ssm.ztest;

import com.justin.ssm.mapper.ItemsMapperCustom;
import com.justin.ssm.po.ItemsCustom;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	private static ApplicationContext applicationContext;


	public static void testFindUserById() throws Exception {
		
		applicationContext = new ClassPathXmlApplicationContext(
				"classpath:spring/applicationContext-dao.xml");
		
		ItemsMapperCustom itemsMapperCustom =  (ItemsMapperCustom) applicationContext.getBean("itemsMapperCustom");
//		ItemsService itemsService =  (ItemsService) applicationContext.getBean("itemsService");
//		ItemsController itemsController =  (ItemsController) applicationContext.getBean("itemsController");
		
		System.out.println("itemsMapperCustom="+itemsMapperCustom);
//		System.out.println("itemsService="+itemsService);
//		System.out.println("itemsController="+itemsController);

		ItemsCustom i =  itemsMapperCustom.findItemsById(1);
			System.out.println(i);

	}
	
	public static void main(String[] args) throws Exception {
		testFindUserById();
	}
	

}
