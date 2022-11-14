package user.dao;

import java.util.List;
import java.util.Map;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;

import user.bean.UserDTO;

//@Setter
//public class UserDAOImpl implements UserDAO{
//
//	private JdbcTemplate jdbcTemplate;
//	
//	@Override
//	public void write(UserDTO userDTO) {
//		String sql = "insert into usertable values(?,?,?)";
//		jdbcTemplate.update(sql
//				           ,userDTO.getName()
//				           ,userDTO.getId()
//				           ,userDTO.getPwd());
//		//update() => insert, update, delete
//	}
//
//	@Override
//	public List<UserDTO> getUserList() {
//		String sql = "select * from usertable";
//		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<UserDTO>(UserDTO.class));
//	}
//}

//@Setter
@Component
public class UserDAOImpl extends JdbcDaoSupport implements UserDAO{
	
	@Autowired
	public void setDataSource(BasicDataSource dataSource) {
		super.setDataSource(dataSource);
	}
	
	//private JdbcTemplate jdbcTemplate;
	
	@Override
	public void write(UserDTO userDTO) {
		String sql = "insert into usertable values(?,?,?)";
		getJdbcTemplate().update(sql
				           ,userDTO.getName()
				           ,userDTO.getId()
				           ,userDTO.getPwd());
		//update() => insert, update, delete
	}

	@Override
	public List<UserDTO> getUserList() {
		String sql = "select * from usertable";
		return getJdbcTemplate().query(sql, new BeanPropertyRowMapper<UserDTO>(UserDTO.class));
	}

	@Override
	public UserDTO getUser(String id){
		String sql="select * from usertable where id=?";
		UserDTO userDTO = null;
		try{
			userDTO = getJdbcTemplate().queryForObject(sql
					 								 , new BeanPropertyRowMapper<UserDTO>(UserDTO.class)
					 								 , id);
			return userDTO;
		}catch(EmptyResultDataAccessException e){
			System.out.println("해당하는 하는 아이디가 없습니다");
			return userDTO;
		}
	}

	@Override
	public void update(Map<String, String> map) {
		String sql = "update usertable set name=?, pwd=? where id=?";
		getJdbcTemplate().update(sql, map.get("name"), map.get("pwd"), map.get("id"));
	}

	@Override
	public void delete(String id) {
		String sql = "delete usertable where id=?";
		getJdbcTemplate().update(sql, id);
	}
}

