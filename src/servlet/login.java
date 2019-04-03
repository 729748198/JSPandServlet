package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import dao.UserDaoImpl;
import javafx.application.Application;
import vo.User;

public class login extends HttpServlet {

	

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				/**
				 * 获取上下文变量
				 */
				ServletContext context=this.getServletContext();
				Integer count=(Integer)context.getAttribute("count");
		
				UserDao userDao=new UserDaoImpl();
				//正确的验证码
		        String piccode=(String) request.getSession().getAttribute("piccode");
		        //填入的验证码
		        String checkCode=request.getParameter("yzm");  
		        //填入的用户名和密码
		        String username=request.getParameter("User");
		        String password=request.getParameter("Pwd");
		        Boolean boolean1=true;
		        try {
					User user=userDao.selectByName(username);
					if(!user.getPassword().equals(password)) {
					boolean1=false;
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        checkCode=checkCode.toUpperCase();  
		        response.setContentType("text/html;charset=UTF-8");
		        PrintWriter out=response.getWriter();
		        //判断验证码
		        if(checkCode.equals(piccode)&&boolean1)
		        {
		        	
		        	//遍历Cookie
		        	Boolean isUserBoolean=true;
		        	Cookie[] Cookies = request.getCookies();  
		        	for(int i =0;i<Cookies.length;i++){  
		        	    Cookie c = Cookies[i];  
		        	    if(c.getName().equals(username)) {
		        	    	/**
		        	    	 * 不是第一次登录，Cookie中有数据
		        	    	 */
		        	    	isUserBoolean=false;
		        	    	/**
		        	    	 * 也要检查上下文总人数
		        	    	 */
		        	    	if(count==null) {
				        		
								context.setAttribute("count", 1);
							}
		        	    	/**
		        	    	 * 当前用户登录的次数
		        	    	 */
		        	    	int now=Integer.valueOf(c.getValue());
		  
		        	    	/**
		        	    	 * +1后重新写入Cookie
		        	    	 */
		        	    	now++;
		        	    	Cookie cookie=new Cookie(username,String.valueOf(now));
		        	    	cookie.setMaxAge(60*5);
		        	    	cookie.setPath("/");
		        	    	response.addCookie(cookie);
		        	    }
		        	}
		        	//如果是第一次登录
			        if(isUserBoolean) {
			        	//新建Cookie
			        	Cookie cookie=new Cookie("name", username);
			        	Cookie cookie2=new Cookie(username, String.valueOf(1));
			        	cookie2.setMaxAge(60*5);
			        	cookie.setMaxAge(60*5);
			        	cookie2.setPath("/");
			        	cookie.setPath("/");
			        	response.addCookie(cookie2);
			        	response.addCookie(cookie);
			        
			        	/**
			        	 * 新用户登录就+1
			        	 */
			        	if(count!=null) {
			        		context.setAttribute("count", ++count);
			        	}else {
							context.setAttribute("count", 1);
						}
			        }
			        /**
			         * 设置Session
			         */
		        	request.getSession().setAttribute("user",username);
		        	request.getRequestDispatcher("index.jsp").forward(request,response);
		        }
		        else
		        {
		        	response.sendRedirect("error.jsp");
		        }
		        out.flush();
		        out.close();
	}

}
