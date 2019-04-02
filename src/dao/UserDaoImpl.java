package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

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

}
