package org.springframework.test.ioc;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.test.ioc.bean.Car;
import org.springframework.test.ioc.bean.Person;


public class XmlFileDefineBeanTest {

    @Test
    public void testXmlFile() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        beanDefinitionReader.loadBeanDefinitions("classpath:spring.xml");

        Person person = (Person) beanFactory.getBean("person");
        Assert.assertEquals("derek", person.getName());
        Assert.assertEquals("porsche", person.getCar().getBrand());

        Car car = (Car) beanFactory.getBean("car");
        Assert.assertEquals("porsche", car.getBrand());

    }
}
