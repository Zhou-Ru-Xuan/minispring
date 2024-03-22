package ioc;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

public class BeanDefinitionAndBeanDefinitionRegistryTest {

    @Test
    public void testBeanFactory() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 构造定义Bean的信息
        BeanDefinition beanDefinition = new BeanDefinition(HelloService.class);
        // 注册Bean
        beanFactory.registerBeanDefinition("helloService", beanDefinition);
        // 获取Bean实例
        HelloService helloService = (HelloService) beanFactory.getBean("helloService");

        Assert.assertEquals("hello", helloService.sayHello());
    }
}
