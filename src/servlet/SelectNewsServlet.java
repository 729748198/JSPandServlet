package servlet;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DBconnection;
import dao.NewsDaoImpl;
import vo.News;

public class SelectNewsServlet extends HttpServlet {
	 public void doGet(HttpServletRequest request, HttpServletResponse response){
         
	        try {
	        	request.setCharacterEncoding("UTF-8");
	        	
	        	NewsDaoImpl impl=new NewsDaoImpl();
	        	String id=request.getParameter("id");
	        	News news=impl.selectByID(Integer.parseInt(id));
	        	
	        	String nameString=(String) request.getSession().getAttribute("user");       
	        	
	        	response.setContentType("text/html;charset=UTF-8");
	        	response.getWriter().println("<p>您好"+nameString+"你要查询的新闻为");
	            response.getWriter().println("<p>作者："+news.getAdminName()+"<p>");
	            response.getWriter().println("<p>时间："+news.getNewsTime()+"<p>");
	            response.getWriter().println("<p>标题："+news.getNewsTitle()+"<p>");
	            response.getWriter().println("<p>内容："+news.getNewsContent()+"<p>");
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
}
