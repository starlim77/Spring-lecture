package com.bean;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SumDTO {
	private int x,y,sum;
	
	public void sum() {
		sum = x + y;
	}
}
