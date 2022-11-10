package sample05;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
public class SungJukModify implements SungJuk{
	
	private List<SungJukDTO2> list;
	
	@Autowired
	public void setList(List<SungJukDTO2> list) {
		this.list = list;
	}
	
	@Override
	public void execute() {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("수정할 이름 입력 : ");
		String name = scan.next();
		
		for(SungJukDTO2 sungJukDTO2 : list) {
			if(sungJukDTO2.getName().equals(name)) {
				
				System.out.println(sungJukDTO2.getName()+"\t"
						          +sungJukDTO2.getKor()+"\t"
						          +sungJukDTO2.getEng()+"\t"
						          +sungJukDTO2.getMath()+"\t"
						          +sungJukDTO2.getTot()+"\t"
						          +sungJukDTO2.getAvg()+"\t");
				
				
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
				
				System.out.println(name+"님의 데이터를 수정하였습니다");
				return;
			}//if
		}//for
		System.out.println("찾고자 하는 이름이 없습니다");
	}
	
	
}
