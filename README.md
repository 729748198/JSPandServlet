# JSPandServlet

这是江科大软件工程大三 JSP&Servlet 课程的课堂项目，我会把每次的作业都上传至此。

## 前言
### 1.运行环境：
* jdk1.8.0_201 
* apache-tomcat-9.0.16
* mysql-5.7.25-winx64

### 2.编译器：Eclipse

请注意！此项目实现了每次的作业功能，但是没有按书上的代码编写！

## 项目简介

## 4月15日更新——使用自定义标签
### 1.新建tld文件
在WEB-IBF 文件下新建hello.tld

```
<?xml version="1.0" encoding="UTF-8"?>
<taglib>
  <tlib-version>1.0</tlib-version>
  <jsp-version>2.0</jsp-version>
  <short-name>Example TLD</short-name>
  <tag>
    <name>Hello</name>
    <tag-class>tools.HelloTag</tag-class>
    <body-content>empty</body-content>
  </tag>
</taglib>
```
### 2.新建处理Tag类，tolls.HelloTag.java

<pre name="code" class="java">
package tools;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class HelloTag extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
	    out.println("Hello Tag By 贺文杰!");
	}
	

}
</pre>

### 3.在JSP页面引用：
新建usingTag.jsp文件

```
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="ex" uri="WEB-INF/hello.tld"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <ex:Hello/>
</body>
</html>
```

这样，就在页面显示 Hello Tag By 贺文杰!

## 4月22日——使用EL表达式
1.在JSP页面第一句%@中加入一句声明isELIgnored="false"
2.直接在页面中使用${}。
3.获取JavaBean的属性，只需要通过.符号操作就可以了。

像这样 ${hero.name} ，就会自动调用getName方法了

## 4月24日——使用JSTL表达式。
作业目录：jstl.jsp

首先要下载依赖jar包，jstl.jar和standard.jar

在头文件中引入声明

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

今天的作业是用if表达式

<c:if test="写判断语句">
</c:if>

没有else

<b>这是我的作业：判断当前用户是否登录，登录成功就显示Hello, Welcome,否则显示请登录<b>

```
<body>
<c:if test="${user!=null}">
Hello ,Welcome ${user }
</c:if>
<c:if test="${user==null}">
请登录
</c:if>
</body>
```