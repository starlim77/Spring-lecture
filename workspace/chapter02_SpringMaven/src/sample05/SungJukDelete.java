package sample05;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
public class SungJukDelete implements SungJuk{
	
	private List<SungJukDTO2> list;
	
	@Autowired
	public void setList(List<SungJukDTO2> list) {
		this.list = list;
	}

	@Override
	public void execute() {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("삭제할 이름 입력 : ");
		String name = scan.next();
		
		for(SungJukDTO2 sungJukDTO2 : list) {
			if(sungJukDTO2.getName().equals(name)) {
				list.remove(sungJukDTO2);
				
				System.out.println(sungJukDTO2.getName()+"님의 데이터를 삭제 하였습니다");
				return;
			}//if
		}//for
		System.out.println("찾고자 하는 삭제할 이름이 없습니다 ");
	}
	
	
	
}
