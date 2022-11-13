package sample05;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SungJukDTO2 {
	private String name,avg;
	private int kor,eng,math,tot;
	
	@Override
	public String toString() {
		return name + "\t" + kor + "\t" + eng + "\t" + math + "\t" + tot + "\t" + avg;
	}
	
	
}
