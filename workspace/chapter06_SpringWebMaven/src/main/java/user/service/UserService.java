package user.service;

import user.bean.UserDTO;

public interface UserService {

	public void write(UserDTO userDTO);

	public String getUser(String id);
	
}
