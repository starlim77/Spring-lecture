package user.service;

import java.util.Scanner;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import user.bean.UserDTO;
import user.dao.UserDAO;

@Service
public class UserDeleteService implements UserService {
	
	@Autowired
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
		}

	}
}
