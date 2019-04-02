package servlet;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ErrorServlet extends HttpServlet {
	 public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
		 
		 response.setContentType("text/html;charset=UTF-8");
     	response.getWriter().println("<p>404</p>");
	 }
//	 protected void service(HttpServletRequest request, HttpServletResponse response)
//	            throws  IOException {
//	 
//	                 response.sendRedirect("fail.html");
//	        
//	 
//	    }
//	
}
