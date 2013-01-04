<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/struts-tags" prefix="s" %>
<s:fielderror theme="bootstrap" />
<s:if test="hasActionErrors()">
	<s:actionerror  theme="bootstrap" />
</s:if>
<s:actionmessage theme="bootstrap" />
<s:form action="login" method="post" namespace="/pages">
	<s:textfield name="username" label="Nom d'utilisateur ou e-mail"/>
	<s:password name="password" key="password.label"/>
	<s:submit cssClass="btn" label="connexion"/>
</s:form>