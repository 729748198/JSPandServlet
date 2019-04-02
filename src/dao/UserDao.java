package dao;

import vo.User;

public interface UserDao {

	User selectByName(String name) throws Exception;
}
