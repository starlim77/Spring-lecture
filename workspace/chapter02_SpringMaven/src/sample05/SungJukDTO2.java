package sample05;

import org.springframework.context.annotation.Scope;


import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@Scope("prototype")
public class SungJukDTO2 {
	private String name,avg;
	private int kor,eng,math,tot;
	
}
