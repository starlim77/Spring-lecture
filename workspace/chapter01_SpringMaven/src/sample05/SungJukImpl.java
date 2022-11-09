package sample05;

import java.util.Scanner;

import org.springframework.stereotype.Component;

@Component("sungJukImpl")
public class SungJukImpl implements SungJuk {
	
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int tot;
	private String avg;
	
	public SungJukImpl() {
		Scanner scan = new Scanner(System.in);
		System.out.print("이름 입력 : ");
		name = scan.next();
		System.out.print("국어 입력 : ");
		kor = scan.nextInt();
		System.out.print("영어 입력 : ");
		eng = scan.nextInt();
		System.out.print("수학 입력 : ");
		math = scan.nextInt();
	}
	
	
	@Override
	public void calc() {
		tot = kor + eng + math;
		avg = String.format("%.3f", tot / 3.);
	}

	@Override
	public void display() {
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균");
		System.out.println(name + "\t" +
						   kor + "\t" +
						   eng + "\t" +
						   math + "\t" +
						   tot + "\t" +
						   avg);
	}

}
