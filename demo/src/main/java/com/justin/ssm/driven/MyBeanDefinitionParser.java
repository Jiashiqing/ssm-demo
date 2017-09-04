/*
 * 文件名： MemcachedBeanDefinitionParser.java
 * 
 * 创建日期： 2013-5-10
 *
 * Copyright(C) 2013, by xiaozhi.
 *
 * 原始作者: <a href="mailto:3562720@qq.com">xiaozhi</a>
 *
 */
package com.justin.ssm.driven;

import com.justin.ssm.po.Student;
import org.springframework.aop.config.AopNamespaceUtils;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

/**
 * spring bean定义的解析器
 */
public class MyBeanDefinitionParser implements /*AbstractSingleBeanDefinitionParser,*/BeanDefinitionParser {

    @Override
    public BeanDefinition parse(Element element, ParserContext parserContext) {
        AopNamespaceUtils.registerAutoProxyCreatorIfNecessary(parserContext, element);

        String id = element.getAttribute("id");
        String name = element.getAttribute("name");
        String age = element.getAttribute("age");
        System.out.println("id=" + id + ",name=" + name + ",age=" + age);

        final RootBeanDefinition student = new RootBeanDefinition(Student.class);
        MutablePropertyValues propertyValues = student.getPropertyValues();
        propertyValues.addPropertyValue("id", id);
        propertyValues.addPropertyValue("name", name);
        propertyValues.addPropertyValue("age", age);

        final BeanDefinitionRegistry registry = parserContext.getRegistry();
        registry.registerBeanDefinition("student", student);

        return null;
    }


}
