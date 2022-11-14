package user.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Setter;
import user.bean.UserDTO;
import user.dao.UserDAO;
@Component
public class UserUpdateService implements UserService {
	@Autowired
	private UserDAO userDAO;
	
	@Override
	public void execute() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("수정할 아이디 입력 : ");
		String id = scanner.next();
		UserDTO userDTO = null;
		userDTO = userDAO.getUser(id);
		if(userDTO!=null) {
			System.out.println(userDTO.getName() + "\t"
			         + userDTO.getId() + "\t"
			         + userDTO.getPwd());
			System.out.println();
			System.out.print("수정할 이름 입력 : ");
			String name = scanner.next();
			System.out.print("수정할 비밀번호 입력 : ");
			String pwd = scanner.next();
			
			Map<String, String> map = new HashMap<String, String>();
			map.put("id", id);
			map.put("name", name);
			map.put("pwd", pwd);
			
			userDAO.update(map);
			System.out.println("업데이트 완료");
		}
	}

}
