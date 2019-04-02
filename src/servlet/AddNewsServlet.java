package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.NewsDaoImpl;
import vo.News;

/**
 * Servlet implementation class AddNewsServlet
 */
@WebServlet("/AddNewsServlet")
public class AddNewsServlet extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
    	NewsDaoImpl impl=new NewsDaoImpl();
    	String id=request.getParameter("id");
    	String title=request.getParameter("title");
    	String content=request.getParameter("content");
    	String data=request.getParameter("time");
    	String name=request.getParameter("name");
    	News news=new News();
    	news.setNewsID(Integer.parseInt(id));
    	news.setNewsTitle(title);
    	news.setNewsContent(content);
    	news.setNewsTime(data);
    	news.setAdminName(name);
    	try {
			int i= impl.add(news);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	response.setContentType("text/html;charset=UTF-8");
        response.getWriter().println("<p>"+"插入成功"+"<p>");
	}



}
