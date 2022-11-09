package sample02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class HelloSpring_02 {
	
	
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");	
		
		Calc calc = (Calc)context.getBean("add");
		calc = (Calc)context.getBean("mul");
		
		calc.calculate();
		
	}
	
	
}
