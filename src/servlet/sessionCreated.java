package servlet;

import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.xml.crypto.Data;

public class sessionCreated implements HttpSessionListener {
	
	Date d1,d2;
	
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		
		 ServletContext ctx =se.getSession( ).getServletContext( );  
		 System.out.println("创建Session:"+new Date());
		 d1=new Date();
	}


	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		HttpSessionListener.super.sessionDestroyed(se);
		System.out.println("销毁ession"+new Date());
		d2=new Date();
		System.out.println("登录时间"+(d2.getTime()-d1.getTime())/1000+"秒");
	}

}
