import org.junit.Assert;
import org.junit.Test;


public class SimpleBeanContainerTest {

    @Test
    public void testGetBean() {
        // 创建容器
        BeanFactory beanFactory = new BeanFactory();
        // 注册bean
        beanFactory.registerBean("helloService", new HelloService());
        // 获取bean
        HelloService helloService = (HelloService) beanFactory.getBean("helloService");
        
        Assert.assertNotNull(helloService);
        Assert.assertEquals("hello", helloService.sayHello());
    }

    class HelloService {
        public String sayHello() {
            System.out.println("hello");
            return "hello";
        }
    }
}