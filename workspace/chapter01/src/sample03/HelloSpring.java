package sample03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class HelloSpring {
		
	public static void main(String[] args) {
		
		//ApplicationContext context = new FileSystemXmlApplicationContext("src/applicationContext.xml");
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		MessageBean messageBean = (MessageBean)context.getBean("messageBean"); //자식 = 부모
		messageBean.sayHello("Spring");
		
		((MessageBean)context.getBean("messageBean")).sayHello("Spring"); //자식 = 부모
//		messageBean2.sayHello("Spring");
		
	}
}


