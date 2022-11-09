package sample03;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


public class MessageBeanEn implements MessageBean {
	
	public MessageBeanEn() {
		System.out.println("MessageBeanEn 기본 생성자");
	}

	@Override
	public void sayHello(String name) {
		System.out.println("Hello "+name);
	}

}
