<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
    
 Enseignant: <s:property value="teacher.firstname"/> <br/>
   
 Matière: <s:property value="subject.name" /> <br/>
   
 Salle: <s:property value="classRoom.name" />