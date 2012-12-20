<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<s:actionerror theme="bootstrap" />
<s:actionmessage theme="bootstrap" />
<s:fielderror theme="bootstrap" />
<s:form action="register" theme="bootstrap" cssClass="form-horizontal">
	<s:textfield name="username" key="username.label"
		tooltip="Enter your username here" />
	<s:textfield name="email" key="email.label" tooltip="Enter your email" />
	<s:password name="password" key="password.label"
		tooltip="Enter your password" />
	<s:textfield name="firstName" key="firstname.label" 
		tooltip="Enter your firstname here"/>
	<s:textfield name="lastName" key="lastname.label" 
		tooltip="Enter your lastname here" />
	<s:textfield name="adress" key="adress.label" 
		tooltip="Enter your adress here" />
	<s:submit cssClass="btn btn-inverse pull-right"
		key="form.register.submit" />
</s:form>
