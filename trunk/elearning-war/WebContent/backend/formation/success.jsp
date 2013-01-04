<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
    
 <span class="session-label"> Enseignant: </span> <br/> <s:property value="teacher.firstName"/> <s:property value="teacher.lastName"/>  <br/>
   
 <span class="session-label"> Matière: </span> <br/> <s:property value="subject.name" /> <br/>
   
 <span class="session-label"> Salle: </span> <br/> <s:property value="classRoom.name" />