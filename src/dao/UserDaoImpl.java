package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;

import vo.User;

public class UserDaoImpl implements UserDao {
	private Connection conn = null;
    private Statement pstmt = null;
	@Override
	public User selectByName(String name) throws Exception {
		// TODO Auto-generated method stub
		this.conn=new DBconnection().getConnection();
		String sSql = "select * from admin where AdminName= '"+name+"'";
		pstmt=conn.prepareStatement(sSql);
		ResultSet rs=  pstmt.executeQuery(sSql) ;
		User user=new User();
		while(rs.next())
		{
			
			user.setName(rs.getString("AdminName"));
			user.setPassword(rs.getString("AdminPwd"));
		}
		return user;
	}
	@Override
	public List<User> selectAll() throws Exception {
		// TODO Auto-generated method stub
		this.conn=new DBconnection().getConnection();
		String sSql = "select * from admin";
		pstmt=conn.prepareStatement(sSql);
		ResultSet rs=  pstmt.executeQuery(sSql) ;
		List<User> users=new ArrayList<User>(10);
		while(rs.next())
		{
			User user=new User();
			user.setId(Integer.valueOf(rs.getString("AdminID")));
			user.setName(rs.getString("AdminName"));
			user.setPassword(rs.getString("AdminPwd"));
			user.setType(Integer.valueOf(rs.getString("AdminType")));
			
			users.add(user);
		}
		return users;
	}
	

}
