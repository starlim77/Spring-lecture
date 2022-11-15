package user.service;

import java.util.Scanner;
import lombok.Setter;
import user.bean.UserDTO;
import user.dao.UserDAO;

@Setter
public class UserDeleteService implements UserService {
	

	private UserDAO userDAO;
	
	@Override
	public void execute() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("삭제할 아이디 입력 : ");
		String id = scanner.next();
		
		UserDTO userDTO = userDAO.getUser(id);
		if(userDTO!=null) {
			System.out.println(userDTO.getName() + "\t"
			         + userDTO.getId() + "\t"
			         + userDTO.getPwd());
			userDAO.delete(id);
			System.out.println("DB에서 데이터 삭제 완료하였습니다");
		}else {
			System.out.println("해당하는 아이디가 없습니다");
		}

	}
}
