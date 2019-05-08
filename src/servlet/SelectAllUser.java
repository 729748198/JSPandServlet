package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.NewsDaoImpl;
import dao.UserDaoImpl;

public class SelectAllUser extends HttpServlet {

	 public void doGet(HttpServletRequest request, HttpServletResponse response){
        
	        try {
	        	//禁用缓存，确保网页信息是最新数据  
	            response.setHeader("Pragma","No-cache");      
	            response.setHeader("Cache-Control","no-cache");      
	            response.setDateHeader("Expires", -10);  
	            response.setContentType("text/json; charset=utf-8");
	        	Gson gson=new Gson();
	        	UserDaoImpl userDaoImpl=new UserDaoImpl();
	        	
	        	Map<String, Object>map=new HashMap<String, Object>(5);
	        	map.put("code", 0);
	        	map.put("msg", "succ");
	        	map.put("conut", 1000);
	        	map.put("data",userDaoImpl.selectAll());
	        	PrintWriter out = response.getWriter();
	        	String jsonString=gson.toJson(map);
	        	out.print(jsonString);  
	            out.flush();
	        	
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
}
