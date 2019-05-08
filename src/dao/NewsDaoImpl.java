package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.Gson;

import vo.News;

public class NewsDaoImpl implements NewsDao {
	private Connection conn = null;
    private Statement pstmt = null;
	@Override
	public List<News> selectAll() throws Exception {
		// TODO Auto-generated method stub
		this.conn=new DBconnection().getConnection();
		String sSql = "select * from news order by NewsID desc";
		pstmt=conn.prepareStatement(sSql);
		ResultSet rs=  pstmt.executeQuery(sSql) ;
		List<News> list=new ArrayList<News>();
		while(rs.next())
		{
			int NewsID = rs.getInt("NewsID");
			String NewsTitle = rs.getString("NewsTitle");
			String content=rs.getString("NewsContent");
			String NewsTime = rs.getString("NewsTime");
			String AdminName = rs.getString("AdminName");
			News news=new News();
			news.setNewsID(NewsID);
			news.setNewsTitle(NewsTitle);
			news.setNewsContent(content);
			news.setNewsTime(NewsTime);
			news.setAdminName(AdminName);
			list.add(news);
			
		}
		Gson gson=new Gson();
		System.out.println(gson.toJson(list));
		return list;
	}

	@Override
	public News selectByID(int id) throws Exception {
		// TODO Auto-generated method stub
		this.conn=new DBconnection().getConnection();
		String sSql = "select * from news where NewsID="+id;
		pstmt = conn.createStatement() ;   
		ResultSet rs=  pstmt.executeQuery(sSql) ;
		News news=new News();
		while(rs.next())
		{
			int NewsID = rs.getInt("NewsID");
			String NewsTitle = rs.getString("NewsTitle");
			String NewsTime = rs.getString("NewsTime");
			String AdminName = rs.getString("AdminName");
			
			news.setNewsID(NewsID);
			news.setNewsTitle(NewsTitle);
			news.setNewsTime(NewsTime);
			news.setAdminName(AdminName);
		}
		return news;
	}

	@Override
	public int add(News news) throws Exception {
		// TODO Auto-generated method stub
		this.conn=new DBconnection().getConnection();
		String sSql = "insert into news values (?,?,?,?,?)";
		Integer id=news.getNewsID();
		String title=news.getNewsTitle();
		String content=news.getNewsContent();
		String date=news.getNewsTime();
		String name=news.getAdminName();
		PreparedStatement ppstmt=conn.prepareStatement(sSql);
		ppstmt.setInt(1, id);
		ppstmt.setString(2, title);
		ppstmt.setString(3, content);
		ppstmt.setString(4,date);
		ppstmt.setString(5, name);
		int len1=ppstmt.executeUpdate();
		return len1;
	}
	
	@Override
	public int update(News news) throws Exception {
		// TODO Auto-generated method stub
		this.conn=new DBconnection().getConnection();
		String sql="update news	set NewsContent='小米发布了5G手机' where NewsID=2";
		pstmt=conn.prepareStatement(sql);
		int i=pstmt.executeUpdate(sql);
		return i;
	}

	@Override
	public int delete(int id) throws Exception {
		// TODO Auto-generated method stub
		this.conn=new DBconnection().getConnection();
		String sql="delete from news where NewsID=2";
		pstmt=conn.prepareStatement(sql);
		int i=pstmt.executeUpdate(sql);
		return i;
	}
	public static void main(String[] args) {
		
	}

}
