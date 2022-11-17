package user.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import user.bean.UserDTO;

@Repository
@Transactional
public class UserDAOMyBatis implements UserDAO {
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void write(UserDTO userDTO) {
		sqlSession.insert("userSQL.write", userDTO);
	}

	@Override
	public String getUser(String id) {
		UserDTO userDTO;
		userDTO = sqlSession.selectOne("userSQL.getUser", id);
		String isUser = "NO";
		
		if(userDTO!=null) {
			isUser = "YES";
		}
		return isUser;
	}
	
}
