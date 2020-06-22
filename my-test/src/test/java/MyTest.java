import com.myspring.demo.AopTestBean;
import com.myspring.demo.MyBean;
import com.myspring.demo.MyBeanLoop1;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {

	@Test
	public void	MySpringTest(){
		/*
		ApplicationContext 是IOC容器的高级接口，BeanFactory（顶级容器/根容器，规范了容器的基础行为）
		Spring应用上下文，官方称之为IOC容器 （错误的认识：容器就是map而已；准确来说，map是ioc容器的一个成员，叫做单例池（singletonObjects），
		IOC容器是一组组件和过程的集合，包括BeanFactory、单例池、BeanPostProcessor等以及之间的协作流程 ）

		SpringBean生命周期的特殊的时机点:

		SpringBean的构造器、afterPropertiesSet初始化方法是哪个方法调用的？
		AbstractApplicationContext#refresh()#finishBeanFactoryInitialization

		SpringBean工厂的后置处理器的BeanFactoryPostProcessor的构造器、postProcessBeanFactory方法是哪个方法调用的？
		AbstractApplicationContext#refresh()#invokeBeanFactoryPostProcessors

		SpringBean的后置处理器BeanPostProcessor的构造方法是哪个方法调用的？
		AbstractApplicationContext#refresh()#registerBeanPostProcessors

		SpringBean的后置处理器BeanPostProcessor的Before和after方法是哪个方法调用的？
		AbstractApplicationContext#refresh()#finishBeanFactoryInitialization

		 */
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		MyBean myBean = (MyBean) applicationContext.getBean("myBean");
		System.out.println(myBean);
	}


	/**
	 * 测试循环依赖
	 */
	@Test
	public void testLoop(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		MyBeanLoop1 myBeanLoop1 = (MyBeanLoop1) applicationContext.getBean("myBeanLoop1");
		System.out.println(myBeanLoop1);
	}

	@Test
	public void testAopProxyBuild() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		AopTestBean aopTestBean = applicationContext.getBean(AopTestBean.class);
		aopTestBean.test();
	}




}
