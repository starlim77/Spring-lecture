package sample05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
public class SungJukInput implements SungJuk{
	
	private List<SungJukDTO2> list;
	private SungJukDTO2 sungJukDTO2;
	
	public void setList(List<SungJukDTO2> list) {
		System.out.println("list setter");
		this.list = list;
	}
	@Autowired
	public void setSungJukDTO2(SungJukDTO2 sungJukDTO2) {
		this.sungJukDTO2 = sungJukDTO2;
	}

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
