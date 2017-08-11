package com.justin.ssm.po;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Created by jiashiqing on 17/6/3.
 */

@Component
public class Person implements
        BeanNameAware,              //获得Bean名，也就是<Bean>标签的id属性值。
        BeanClassLoaderAware,       //获得装载过程中的ClassLoader对象。
        BeanFactoryAware,           //获得BeanFactory对象
        ApplicationContextAware,    //获得ApplicationContext对象
        InitializingBean,           //在Bean的所有属性设置完后，并且在调用完上面接口的方法后，调用此接口的afterPropertiesSet方法
        BeanPostProcessor,          //如果我们需要在Spring容器完成Bean的实例化、配置和其他的初始化前后添加一些自己的逻辑处理，我们就可以定义一个或者多个BeanPostProcessor接口的实现，然后注册到容器中。
        DisposableBean              //当销毁Bean时，调用此接口的destroy方法
{
    private String name;

    // 1
    public Person() {
        System.out.println("Person() execute...");
    }

    public Person(String name) {
        this.name = name;
        System.out.println("Person(String name) execute...");
    }


    // 2
    public void setName(String name) {
        this.name = name;
        System.out.println("name=" + name);
    }

    // 3
    @Override
    public void setBeanName(String s) {
        System.out.println("setBeanName=" + s);
    }

    //4
    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("setBeanClassLoader="+classLoader.getClass());
    }

    // 5
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("setBeanFactory=" + beanFactory);
        System.out.println("setBeanFactory=" + beanFactory.getBean("person",Person.class));
    }

    // 6
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("setApplicationContext=" + applicationContext);
        System.out.println("setApplicationContext=" + applicationContext.getBean("person",Person.class));
    }

    // 7
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet...");
    }

    // 8
    public void myinit() {
        System.out.println("myinit...");
    }


    // 9
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessBeforeInitialization...,bean=" + bean + ",beanName=" + beanName);

        return bean;
    }

    // 9
    public String getName() {
        return name;
    }


    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessAfterInitialization...,bean=" + bean + ",beanName=" + beanName);

        if ((bean instanceof Animal)) {
            Animal animal = (Animal) bean;
            animal.setAge(50);
            animal.setName("猴子");
            return bean;
        }
        return bean;

    }

    // 10
    @Override
    public void destroy() throws Exception {
        System.out.println("destroy...");
    }

    // 11
    public void mydestory() {
        System.out.println("mydestory...");
    }



}
