package sample05;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class SungJukDTO2 {
	private String name,avg;
	private int kor,eng,math,tot;
	
}
