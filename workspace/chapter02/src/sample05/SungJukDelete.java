package sample05;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import lombok.Data;

@Data
public class SungJukDelete implements SungJuk{
	
	private List<SungJukDTO2> list;
	
	@Override
	public void execute() {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("삭제할 이름 입력 : ");
		String name = scan.next();
		
//		for(SungJukDTO2 sungJukDTO2 : list) {
//			if(sungJukDTO2.getName().equals(name)) {
//				list.remove(sungJukDTO2);
//				
//				System.out.println(sungJukDTO2.getName()+"님의 데이터를 삭제 하였습니다");
//				return;
//			}//if
//		}//for
//		System.out.println("찾고자 하는 삭제할 이름이 없습니다 ");
		int sw=0;
		Iterator<SungJukDTO2> it = list.iterator();
		while(it.hasNext()) {
			SungJukDTO2 sungJukDTO2 = it.next();
			
			if(sungJukDTO2.getName().equals(name)) {
				sw=1;
				it.remove();
			}
		}//while
		if(sw==0) System.out.println("삭제할 이름이 존재하지 않습니다");
		
	}
	
	
	
}
