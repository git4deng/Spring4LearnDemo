<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="com.david.spring.web.bean.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		//1.从application域中获取到IOC容器实例
			ApplicationContext ac=WebApplicationContextUtils.getWebApplicationContext(application);
		//2.IOC 容器中获取bean
			Person person=ac.getBean(Person.class);
			person.hello();
	%>
</body>
</html>