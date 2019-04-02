import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class web1 {
	private static final String DBDRIVER="com.mysql.cj.jdbc.Driver";
	private static final String URL="jdbc:mysql://localhost:3306/webdb?useSSL=false&serverTimezone=GMT";
	private static final String USER="root";
	private static final String PASSWORD="hemysql8888";
	static Connection conn=null;
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		while(true) {
			System.out.println("");
				System.out.println("根据提示，输入相应数字完成查询");
				int s=chose();
				switch (s) {
				case 1:
					selectall();
					break;
				case 2:
					selectbyId();
					break;
				case 3:
					updata();
					break;
				case 4:
					add();
					break;
				case 5:
					delete();
				default:
					break;
				}
				System.out.println("");
		}

	}
	public static void selectall() throws SQLException, ClassNotFoundException {
		Class.forName(DBDRIVER);
	
		conn=(Connection)DriverManager.getConnection(URL, USER, PASSWORD);
		String sSql = "select * from news order by NewsID desc";
		Statement stmt = conn.createStatement() ;    // 实例化Statement对象
	     ResultSet rs=  stmt.executeQuery(sSql) ;        // 执行数据库更新操作
//		PreparedStatement stmt=conn.prepareStatement(sSql);
//		ResultSet rs=stmt.executeQuery();
		while(rs.next())
		{
			int NewsID = rs.getInt("NewsID");
			String NewsTitle = rs.getString("NewsTitle");
			String NewsTime = rs.getString("NewsTime");
			String AdminName = rs.getString("AdminName");
			System.out.println(NewsID+" "+NewsTitle+" "+NewsTime+" "+AdminName+" ");
		}
		conn.close();
	}
	public static void selectbyId() throws ClassNotFoundException, SQLException {
		System.out.println("请输入你要查找的新闻ID");
		Scanner in=new Scanner(System.in);
		int id=in.nextInt();
		
		Class.forName(DBDRIVER);
		
		conn=(Connection)DriverManager.getConnection(URL, USER, PASSWORD);
		String sSql = "select * from news where NewsID="+id;
		Statement stmt = conn.createStatement() ;    // 实例化Statement对象
	     ResultSet rs=  stmt.executeQuery(sSql) ;        // 执行数据库更新操作
//		PreparedStatement stmt=conn.prepareStatement(sSql);
//		ResultSet rs=stmt.executeQuery();
		while(rs.next())
		{
			int NewsID = rs.getInt("NewsID");
			String NewsTitle = rs.getString("NewsTitle");
			String NewsTime = rs.getString("NewsTime");
			String AdminName = rs.getString("AdminName");	
			String NewsContent=rs.getString("NewsContent");
			System.out.println(NewsID+" "+NewsTitle+" "+NewsContent+" "+NewsTime+" "+AdminName+" ");
		}
		conn.close();
	}
	public static void delete() throws ClassNotFoundException, SQLException {
		Class.forName(DBDRIVER);
		conn=(Connection)DriverManager.getConnection(URL, USER, PASSWORD);
		String sql="delete from news where NewsID=4";
		PreparedStatement pStatement=conn.prepareStatement(sql);
		int i=pStatement.executeUpdate();
		System.out.println("删除成功");
		pStatement.close();
		conn.close();
	}
	public static void updata() throws ClassNotFoundException, SQLException {
		Class.forName(DBDRIVER);
		conn=(Connection)DriverManager.getConnection(URL, USER, PASSWORD);
		String sql="update news	set NewsContent='小米发布了5G手机' where NewsID=2";
		PreparedStatement pStatement=conn.prepareStatement(sql);
		int i=pStatement.executeUpdate();
		System.out.println("修改完成");
		pStatement.close();
		conn.close();
	}
	public static void add() throws ClassNotFoundException, SQLException {
		Class.forName(DBDRIVER);
		conn=(Connection)DriverManager.getConnection(URL, USER, PASSWORD);
		String sSql = "insert into news (NewsID,NewsTitle,NewsContent,NewsTime,AdminName) values (4,'第四条新闻','华为发布新手机','2019-2-8','HWJ')";
		PreparedStatement stmt=conn.prepareStatement(sSql);
		int len1=stmt.executeUpdate(sSql);
		System.out.println("插入成功");
		conn.close();
	}
	public static int chose() {
		System.out.println("1:查询所有新闻");
		System.out.println("2:根据ID查找新闻");
		System.out.println("3:更新一条新闻");
		System.out.println("4:增加一条新闻");
		System.out.println("5:删除一条新闻");
		System.out.println("6:结束程序");
		int temp;
		Scanner in=new Scanner(System.in);
		temp=in.nextInt();
		return temp;
	}

}
