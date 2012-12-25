<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<s:iterator value="#parameters['classRoom']" var="classRoom">
	Salle: <s:property value="#classRoom"/>
</s:iterator>