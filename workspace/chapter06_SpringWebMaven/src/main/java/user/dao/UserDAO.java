package user.dao;

import java.util.List;

import user.bean.UserDTO;

public interface UserDAO {

	public void write(UserDTO userDTO);

	public String getUser(String id);

	public List<UserDTO> getList();

	public UserDTO getUpdateUser(String id);

}
