package com.bean;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SungJukDTO {
	private String name;
	private int kor,eng,math,tot;
	private double avg;
	
	public void calcTot() {
		tot = kor+eng+math;
	}
	public void calcAvg() {
		avg = tot/3.;
	}
	
	@Override
	public String toString() {
		String result = "<h3>***" + name + " 성적 ***</h3>" + "<br>" +
						"총점 : " + tot + "<br>" +"평균 : " + String.format("%.3f", avg);
		return result;
	}
}
