package org.springframework.test.ioc;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.ioc.bean.Car;
import org.springframework.test.ioc.bean.Person;


public class ApplicationContextTest {

    @Test
    public void testApplicationContext() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");

        Person person = applicationContext.getBean("person", Person.class);
        //name属性在CustomBeanFactoryPostProcessor中被修改为ivy
        Assert.assertEquals("ivy", person.getName());

        Car car = applicationContext.getBean("car", Car.class);
        //brand属性在CustomerBeanPostProcessor中被修改为lamborghini
        Assert.assertEquals("lamborghini", car.getBrand());
    }
}
