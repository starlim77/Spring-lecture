package spring.conf;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import sample01.MessageBeanImpl;
import sample02.CalcAdd;
import sample02.CalcMul;
import sample05.SungJukDTO2;

@Configuration
public class SpringConfiguration {
	// applicationContext.xml을 대신해주는 자바 파일이다.
	// 빈 생성하는 자바 파일
	
	@Bean
	public MessageBeanImpl messageBeanImpl(){
		return new MessageBeanImpl("사과");
	}
	
	@Bean
	public CalcAdd calcAdd() {
		return new CalcAdd(30,50);
	}
	
	@Bean(name="calcMul")
	public CalcMul getCalcMul() {
		
		CalcMul calcmul = new CalcMul();
		calcmul.setX(30);
		calcmul.setY(50);
		
		return calcmul;
	}
	
	
}
/*
@Bean - 메소드 위에 써준다
- return되는 클래스의 빈을 생성한다
- 메소드의 이름은 반드시 id명으로 설정해야한다.
 */
