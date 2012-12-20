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
			data-target=".nav-collapse"> <span class="i-bar"></span> <span
			class="i-bar"></span> <span class="i-bar"></span> </a> <a class="brand"
			href="#"><s:text name="elearning.project.title" />
		</a>
		<div class="nav-collapse">
			<ul class="nav">
				<s:url var="indexUrl" action="index" namespace="/" />
				<li class="<s:property value="#classIndex"/>"><s:a href="%{indexUrl}">Home</s:a>
				</li>
				<li class="divider-vertical"></li>
				<s:url var="aboutUrl" action="about" />
				<li>
					<s:a href="%{aboutUrl}">About </s:a>
				</li>
			</ul>
			<ul class="nav pull-right">
			
				<s:url id="registerURL" action="register!input" namespace="/pages"/>
				 
			    <li  class="<s:property value="#classRegister"/>">
				    <s:a href="%{registerURL}">
						<s:text name="link.navigate.register" />
					</s:a>
				</li>
				
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown"> 
						<s:text name="link.navigate.login" /> 
						<b class="caret"></b> 
					</a>
				</li>
				
			</ul>
		</div>
	</div>
</div>
<!--/.nav-collapse -->
