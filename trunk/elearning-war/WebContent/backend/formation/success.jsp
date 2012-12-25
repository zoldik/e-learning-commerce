<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<s:iterator value="#parameters['teacher']" var="teacher">
	Enseignant: <s:property value="#teacher"/><br/>
</s:iterator>

<s:iterator value="#parameters['classRoom']" var="classRoom">
	Salle: <s:property value="#classRoom"/><br/>
</s:iterator>

<s:iterator value="#parameters['subject']" var="subject">
	Matière: <s:property value="#subject"/>
</s:iterator>