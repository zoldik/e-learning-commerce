<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<s:set var="classRegister" value=""/>
<s:set var="classIndex" value=""/>
<s:set var="actionName" value="com.opensymphony.xwork2.ActionContext.name"/>

<s:if test="%{#actionName=='register'}">
	<s:set var="classRegister">active</s:set>
</s:if>
<s:elseif test="%{#actionName=='index'}">
	<s:set var="classIndex">active</s:set>
</s:elseif>

<div class="navbar-inner">
	<div class="container">
		<a class="btn btn-navbar" data-toggle="collapse"
			data-target=".nav-collapse"> 
			<span class="i-bar"></span> 
			<span class="i-bar"></span> 
			<span class="i-bar"></span> 
		</a> 
		<a class="brand" href="#">
			<s:text name="elearning.project.admin.title" />
		</a>
		<div class="nav-collapse">
			<ul class="nav">
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown"> 
						Utilisateurs 
						<b class="caret"></b> 
					</a>
					<ul class="dropdown-menu">
						<s:url var="listTeachers" action="list" namespace="/admin"/> 
						<li>
							<s:a href="%{listTeachers}">Gestion des enseignants</s:a>
						</li>
						<s:url var="listStudents" action="list" namespace="/admin"/>
						<li>
							<s:a href="%{listStudents}">Gestion des élèves</s:a>
						</li>
					</ul>
				</li>
			</ul>
		</div>
	</div>
</div>
<!--/.nav-collapse -->