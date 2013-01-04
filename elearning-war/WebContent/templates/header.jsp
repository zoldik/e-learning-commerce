<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<s:set var="classRegister" value=""/>
<s:set var="classIndex" value=""/>
<s:set var="classContact" value=""/>
<s:set var="classRegister" value=""/>
<s:set var="actionName" value="com.opensymphony.xwork2.ActionContext.name"/>

<s:if test="%{#actionName=='registerStep1 || #actionName=='registerStudent' }">
	<s:set var="classRegister">active</s:set>
</s:if>
<s:elseif test="%{#actionName=='index'}">
	<s:set var="classIndex">active</s:set>
</s:elseif>
<s:elseif test="%{#actionName=='contact'}">
	<s:set var="classContact">active</s:set>
</s:elseif>

<div class="header-container">
	<div class="container">
		<a class="btn btn-navbar" data-toggle="collapse"
			data-target=".nav-collapse"> <span class="i-bar"></span> <span
			class="i-bar"></span> <span class="i-bar"></span> 
		</a>
		<div class="nav-collapse">
			<ul class="nav">
				<s:url var="indexUrl" action="index" namespace="/" />
				<li class="<s:property value="#classIndex"/>">
					<s:a href="%{indexUrl}">Accueil</s:a>
				</li>
				<s:url var="presenationUrl" action="presentation" namespace="/pages"/>
				<li>
					<s:a href="%{presenationUrl}"> Présentation </s:a>
				</li>

				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown"> 
						Filiale 
						<b class="caret"></b> 
					</a>
					
					<s:action name="listAffiliate" namespace="/pages" executeResult="true"/>
				</li>
				
				<s:url var="contactUrl" action="contact!input" namespace="/pages"/>
				<li class='<s:property value="#classContact"/>'>
					<s:a href="%{contactUrl}">Contact </s:a>
				</li>
			</ul>
			
			<ul class="nav pull-right">
				<s:if test="!(#session.user)">
					<s:url id="registerURL" action="registerStep1!input" namespace="/pages"/>
					 
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
						<ul class="dropdown-menu login-container">
							<li><s:fielderror theme="bootstrap" /></li>
							<li><s:actionmessage theme="bootstrap" /></li>
							<s:form action="login" method="post" namespace="/pages" theme="bootstrap" cssClass="form-vertical">
							<li>
								<s:textfield name="username" placeholder="nom d'utilisateur ou e-mail" />
							</li>
							<li>
								<s:password name="password" placeholder="mot de passe"/>
							</li>
							<li>
								<s:submit cssClass="btn btn-inverse pull-right" label="se connecter"/>
							</li>
							</s:form>
						</ul>
					</li>
				</s:if>
				<s:else>
					<s:url id="logoutURL" action="logout" namespace="/pages"/>
					<li>
					    <s:a href="%{logoutURL}">
							<s:text name="déconnexion" />
						</s:a>
					</li>
				</s:else>
				
			</ul>
		</div>
	</div>
</div>
<!--/.nav-collapse -->
