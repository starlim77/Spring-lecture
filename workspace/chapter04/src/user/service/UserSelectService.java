package user.service;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import lombok.Setter;
import user.bean.UserDTO;
import user.dao.UserDAO;

@Setter
public class UserSelectService implements UserService {
	private UserDAO userDAO;
	
	@Override
	public void execute() {
		//DB
		List<UserDTO> list = userDAO.getUserList();
		//응답
		for(UserDTO userDTO : list) {
			System.out.println(userDTO.getName() + "\t"
					         + userDTO.getId() + "\t"
					         + userDTO.getPwd());
		}
		
	}

}
