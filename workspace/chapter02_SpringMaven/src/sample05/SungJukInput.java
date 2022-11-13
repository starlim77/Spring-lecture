package sample05;

import java.util.List;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class SungJukInput implements SungJuk{
	@Autowired
	@Qualifier("list")
	//private ArrayList<SungJukDTO2> list;
	private List<SungJukDTO2> list;
	@Autowired
	//스프링 컨테이너가 빈(@Component, @Bean)으로 생성된 것들 중에서 SungJukDTO2 타입을 찾아서 자동으로 주입
	private SungJukDTO2 sungJukDTO2;
	
	@Override
	public void execute() {
		
		Scanner scan = new Scanner(System.in);
				
		System.out.print("이름 입력 : ");
		String name = scan.next();
		
		System.out.println(list);
		System.out.println(list.size());
		
		for(SungJukDTO2 sungJukDTO : list) {
			if(sungJukDTO.getName().equals(name)) {
				System.out.println("이미 있는 이름입니다. 다른 이름을 입력하세요");
				return;
			}
		}
		
		System.out.print("국어 입력 : ");
		int kor = scan.nextInt();
		System.out.print("영어 입력 : ");
		int eng = scan.nextInt();
		System.out.print("수학 입력 : ");
		int math = scan.nextInt();
		
		sungJukDTO2.setName(name);
		sungJukDTO2.setKor(kor);
		sungJukDTO2.setEng(eng);
		sungJukDTO2.setMath(math);
		sungJukDTO2.setTot(kor+eng+math);
		sungJukDTO2.setAvg(String.format("%.2f", (kor+eng+math)/3.));
		
		list.add(sungJukDTO2);
		
		System.out.println(name + "님의 데이터를 입력하였습니다");
		
	}


	
}
