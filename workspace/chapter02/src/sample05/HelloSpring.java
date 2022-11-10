package sample05;

import java.util.Scanner;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpring {
	
	private static ApplicationContext context;
	
	public void menu() {
		while(true) {
			Scanner scan = new Scanner(System.in);
			System.out.println("**************");
			System.out.println("1.입력");
			System.out.println("2.출력");
			System.out.println("3.수정");
			System.out.println("4.삭제");
			System.out.println("5.끝");
			System.out.println("**************");
			System.out.print("번호 입력 : ");
			int num = scan.nextInt();
			if(num==5) break;
			SungJuk sungJuk = null;
			if(num==1) {
				sungJuk = context.getBean("sungJukInput", SungJukInput.class);
			}
			if(num==2) {
				sungJuk = context.getBean("sungJukOutput", SungJukOutput.class);
			}
			if(num==3) {
				sungJuk = context.getBean("sungJukModify", SungJukModify.class);
			}
			if(num==4) {
				sungJuk = context.getBean("sungJukDelete", SungJukDelete.class);
			}
			sungJuk.execute();
		}//while
	};
	
	
	public static void main(String[] args) {
		
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		((HelloSpring) context.getBean("helloSpring")).menu();
		System.out.println("프로그램 종료");
		
		
	}

}
