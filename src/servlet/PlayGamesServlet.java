package servlet;

import java.io.IOException;
import java.lang.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PlayGamesServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/**
		 * 获取用户名和密码
		 */
		String numberString=request.getParameter("number");
		String usernameString=request.getParameter("user");
		int number=Integer.valueOf(numberString);
		/**
		 * 随机生成数字
		 */
		int integer=(int)(1+Math.random()*10);
		
		String msgString=null;
		if(number>integer) {
			msgString="猜大啦！";
		}else if (number==integer) {
			msgString="猜中了！恭喜"; 
		}else {
			msgString="猜小了！";
		}
		request.setAttribute("msg", msgString);
		
		
		//封装request后需要用转发而不是重定向，不然数据传不过去
		request.getRequestDispatcher("doGames").forward(request, response);
		//response.sendRedirect("doGames");
	}

}
