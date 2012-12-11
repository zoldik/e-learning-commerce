<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><s:text name="register.title"/></title>
</head>
<body>
	<s:form action="register">
		<s:textfield name="login" key="username.label"/>
		<s:textfield name="email" key="email.label"/>
		<s:password name="password" key="password.label"/>
		<s:textfield name="firstName" key="firstname.label"/>
		<s:textfield name="lastName" key="lastname.label"/>
		<s:submit key="form.register.submit"/>
	</s:form>
</body>
</html>
