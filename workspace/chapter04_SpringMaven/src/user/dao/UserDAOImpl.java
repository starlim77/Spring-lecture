package user.dao;

import java.util.HashMap;
import java.util.List;

import java.util.Map;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.stereotype.Repository;

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
@Repository   // DB와 연동하는 클래스는 @Component 대신 @Repository 사용 기능은 같다.
//public class UserDAOImpl extends JdbcDaoSupport implements UserDAO{
public class UserDAOImpl extends NamedParameterJdbcDaoSupport implements UserDAO{ //JdbcDaoSupport의 자식 NamedParameterJdbcDaoSupport

//	@Autowired
//	public void setDataSource(BasicDataSource dataSource) {
//		super.setDataSource(dataSource);
//	}
	
	@Autowired
	public void setDS(BasicDataSource dataSource) {
		setDataSource(dataSource);
	}
	
	//private JdbcTemplate jdbcTemplate;
	
	@Override
	public void write(UserDTO userDTO) {
//		String sql = "insert into usertable values(?,?,?)";
//		getJdbcTemplate().update(sql
//				           ,userDTO.getName()
//				           ,userDTO.getId()
//				           ,userDTO.getPwd());
		
		String sql = "insert into usertable values( :name, :id, :pwd )";
		
		Map<String, String> map = new HashMap<>();	
		map.put("name", userDTO.getName());
		map.put("id", userDTO.getId());
		map.put("pwd", userDTO.getPwd());
		getNamedParameterJdbcTemplate().update(sql, map);
		
		//update() => insert, update, delete
	}

	@Override
	public List<UserDTO> getUserList() {
		String sql = "select * from usertable";
		return getJdbcTemplate().query(sql, new BeanPropertyRowMapper<UserDTO>(UserDTO.class));
	}

	@Override
	public UserDTO getUser(String id){
		String sql="select * from usertable where id=:id";
		UserDTO userDTO = null;
		Map<String, String> map = new HashMap<>();	
		map.put("id", id);
		try{
			userDTO = getJdbcTemplate().queryForObject(sql
					 								 , new BeanPropertyRowMapper<UserDTO>(UserDTO.class)
					 								 , id);
			return userDTO;
		}catch(EmptyResultDataAccessException e){
			System.out.println("해당하는 아이디가 없습니다");
			return userDTO;
		}
	}
	
	@Override
	public void update(Map<String, String> map) {
		String sql = "update usertable set name=:name, pwd=:pwd where id=:id";
		getNamedParameterJdbcTemplate().update(sql, map);
	}
	
	@Override
	public void delete(String id) {
		String sql = "delete usertable where id=?";
		getJdbcTemplate().update(sql, id);
	}
}

