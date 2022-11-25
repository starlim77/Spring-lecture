package sample01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//Target
public class MessageBeanImpl implements MessageBean {
	
	private String str;
	
	public void setStr(@Value("Have a nicd day!!") String str) {
		this.str = str;
	}

	@Override
	public void showPrintBefore() {
			System.out.println("showPrintBefore 메세지 = " + str);//핵심 코드
	}

	@Override
	public void viewPrintBefore() {
		try {
			Thread.sleep(1000);//1초 delay - 기본단위 1/1000 초
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("viewPrintBefore 메세지 = " + str);//핵심 코드
	}

	@Override
	public void display() {
		System.out.println("displayPrintBefore 메세지 = " + str);//핵심 코드
	}

	@Override
	public void showPrintAfter() {
		System.out.println("showPrintAfter 메세지 = " + str);//핵심 코드
	}

	@Override
	public void viewPrintAfter() {
		System.out.println("viewPrintAfter 메세지 = " + str);//핵심 코드
	}

	@Override
	public String showPrint() {
		System.out.println("viewPrint 메세지 = " + str);
		return "hello Spring";
	}

	@Override
	public void viewPrint() {
		System.out.println("viewPrint 메세지 = " + str);
	}

}
