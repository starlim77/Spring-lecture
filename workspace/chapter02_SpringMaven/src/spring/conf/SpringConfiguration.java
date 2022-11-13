package spring.conf;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import sample01.MessageBeanImpl;
import sample02.CalcAdd;
import sample02.CalcMul;
import sample05.SungJukDTO2;
import sample05.SungJukDelete;
import sample05.SungJukInput;
import sample05.SungJukModify;
import sample05.SungJukOutput;

@Configuration
public class SpringConfiguration {
	// applicationContext.xml을 대신해주는 자바 파일이다.
	// 빈 생성하는 자바 파일
		
	//sample01
	@Bean
	public MessageBeanImpl messageBeanImpl(){
		return new MessageBeanImpl("사과");
	}
	
	//sample02
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
	
//	sample05
	@Bean(name="list")
	//public ArrayList<SungJukDTO2> list(){
	public List<SungJukDTO2> list(){
		return new ArrayList<SungJukDTO2>();
	}
//	@Bean
//	@Scope("prototype")
//	public SungJukInput sungJukInput() {
//		SungJukInput sungJukInput = new SungJukInput();
//		sungJukInput.setList(list);
//		return sungJukInput;
//	}
//	@Bean
//	public SungJukOutput sungJukOutput() {
//		SungJukOutput sungJukOutput = new SungJukOutput();
//		sungJukOutput.setList(list);
//		return sungJukOutput;
//	}
//	@Bean
//	public SungJukDelete sungJukDelete() {
//		SungJukDelete sungJukDelete = new SungJukDelete();
//		sungJukDelete.setList(list);
//		return sungJukDelete;
//	}
//	@Bean
//	public SungJukModify sungJukModify() {
//		SungJukModify sungJukModify = new SungJukModify();
//		sungJukModify.setList(list);
//		return sungJukModify;
//	}
}
/*
@Bean - 메소드 위에 써준다
- return되는 클래스의 빈을 생성한다
- 메소드의 이름은 반드시 id명으로 설정해야한다.
 */
