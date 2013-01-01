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
		<s:url var="adminIndex" action="dashboard" namespace="/admin"/>
		<s:a cssClass="brand" href="%{adminIndex}">
			<s:text name="elearning.project.admin.title" />
		</s:a>
		<div class="nav-collapse">
			<ul class="nav">
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown"> 
						Utilisateurs 
						<b class="caret"></b> 
					</a>
					<ul class="dropdown-menu">
						<s:url var="listTeachers" action="list" namespace="/admin/teacher"/> 
						<li>
							<s:a href="%{listTeachers}">Gestion des enseignants</s:a>
						</li>
						<s:if test="#session.roles.contains('admin')">
							<s:url var="listAdministrators" action="list" namespace="/admin/administrator"/> 
							<li>
								<s:a href="%{listAdministrators}">Gestion des administrateurs de filiales</s:a>
							</li>
						</s:if>
					</ul>
				</li>
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown"> 
						Formations 
						<b class="caret"></b> 
					</a>
					<ul class="dropdown-menu">
						<s:url var="listFormation" action="list" namespace="/admin/formation"/> 
						<li>
							<s:a href="%{listFormation}">Gestion des formations</s:a>
						</li>
						<s:url var="listClassroom" action="list" namespace="/admin/school-room"/>
						<li>
							<s:a href="%{listClassroom}">Gestion des salles</s:a>
						</li>
						<s:url var="listDocument" action="list" namespace="/admin/document"/>
						<li>
							<s:a href="%{listDocument}">Gestion de la bibliothèque</s:a>
						</li>
					</ul>
				</li>
			</ul>
			<ul class="nav pull-right">
				<li class="logged-user" >
					Bienvenu(e) <s:property value="#session.user.username"/>
				</li>
				<s:url id="logoutURL" action="logout" namespace="/pages"/>
				<li>
				    <s:a href="%{logoutURL}">
						<s:text name="déconnexion" />
					</s:a>
				</li>
			</ul>
		</div>
	</div>
</div>
<!--/.nav-collapse -->
