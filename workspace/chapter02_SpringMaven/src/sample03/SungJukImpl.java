package sample03;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

//@AllArgsConstructor
@Component
public class SungJukImpl implements SungJuk {
	
	private SungJukDTO sungJukDTO;
	
	@Autowired
	public SungJukImpl(SungJukDTO sungJuckDTO) {
		this.sungJukDTO = sungJuckDTO;
	}
	
	@Override
	public void calcTot() {
		int tot = sungJukDTO.getKor()+sungJukDTO.getEng()+sungJukDTO.getMath();
		sungJukDTO.setTot(tot);
	}

	@Override
	public void calcAvg() {
		double avg = sungJukDTO.getTot()/3.;
		sungJukDTO.setAvg(String.format("%.3f", avg));
	}

	@Override
	public void display() {
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균");
		System.out.println(sungJukDTO.getName()+"\t"
				          +sungJukDTO.getKor()+"\t"
				          +sungJukDTO.getEng()+"\t"
				          +sungJukDTO.getMath()+"\t"
				          +sungJukDTO.getTot()+"\t"
				          +sungJukDTO.getAvg()+"\t");
	}

	@Override
	public void modify() {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("이름 입력 : ");
		String name = scan.next();
		System.out.print("국어 입력 : ");
		int kor = scan.nextInt();
		System.out.print("영어 입력 : ");
		int eng = scan.nextInt();
		System.out.print("수학 입력 : ");
		int math = scan.nextInt();
		
		sungJukDTO.setName(name);
		sungJukDTO.setKor(kor);
		sungJukDTO.setEng(eng);
		sungJukDTO.setMath(math);
		
	}

}
