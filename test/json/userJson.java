package json;

import org.junit.Test;

import com.google.gson.Gson;

import dao.NewsDaoImpl;
import dao.UserDao;
import dao.UserDaoImpl;
import vo.User;

public class userJson {
	//教程
	//https://www.jianshu.com/p/e740196225a4
	@Test
	public void testUser() throws Exception {
		User user;
		UserDao userDao=new UserDaoImpl();
		user=userDao.selectByName("HWJ");
		Gson gson=new Gson();
		System.out.println(gson.toJson(user));
	}
	

}
