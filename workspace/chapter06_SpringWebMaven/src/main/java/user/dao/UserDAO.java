package user.dao;

import user.bean.UserDTO;

public interface UserDAO {

	public void write(UserDTO userDTO);

	public String getUser(String id);

}
