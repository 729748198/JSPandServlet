package dao;

import java.util.List;

import vo.User;

public interface UserDao {

	User selectByName(String name) throws Exception;
	List<User> selectAll() throws Exception;
}
