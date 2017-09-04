/*
 * 文件名： MemcachedNamespaceHandler.java
 * 
 * 创建日期： 2013-5-10
 *
 * Copyright(C) 2013, by xiaozhi.
 *
 * 原始作者: <a href="mailto:3562720@qq.com">xiaozhi</a>
 *
 */
package com.justin.ssm.driven;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * 这个是自定义spring的xml元素类 <br>
 */
public class MyNamespaceHandler extends NamespaceHandlerSupport {

    @Override
    public void init() {
        // 初始化解析器
//        this.registerBeanDefinitionParser("annotation-driven", new MyBeanDefinitionParser());
        this.registerBeanDefinitionParser("student", new MyBeanDefinitionParser());
    }

}
