package sample03;

import org.springframework.context.ApplicationContext;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpring_03 {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");	
		
		SungJukDTO sungJukDTO = (SungJukDTO)context.getBean("sungJukDTO");
		
		SungJukImpl sungJukImpl = (SungJukImpl)context.getBean("sungJukImpl");
		
		sungJukImpl.calcTot();
		sungJukImpl.calcAvg();
		sungJukImpl.display();

		sungJukImpl.modify();
		sungJukImpl.calcTot();
		sungJukImpl.calcAvg();
		sungJukImpl.display();     
	}
}
