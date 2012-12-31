<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<s:actionerror theme="bootstrap" />
<s:actionmessage theme="bootstrap" />
<s:fielderror theme="bootstrap" />
<s:form action="create!save" theme="bootstrap"
	cssClass="form-horizontal">
	<s:push value="teacher">
		<s:hidden name="id" />
		<s:textfield name="username" key="username.label"
			tooltip="Enter your username here" />
		<s:textfield name="email" key="email.label" tooltip="Enter your email" />
		<s:password name="password" key="password.label"
			tooltip="Entrez le mot de passe" />
		<s:textfield name="firstName" key="firstname.label" />
		<s:textfield name="lastName" key="lastname.label" />
		<s:textfield name="adress" key="adress.label" />
		<s:select list="formationSelect" multiple="true" name="formations" value="formations" label="formatios"
		tooltip="Entrez les formations associées"/>
		<s:checkbox name="enabled" label="Actif"/>
<%-- 		<s:optiontransferselect --%>
<!--                         tooltip="Entrez les formations associées" -->
<!--                         label="Formatios" -->
<!--                         name="formationSelect" -->
<!--                         leftTitle="Formations disponibles" -->
<!--                         rightTitle="Formations affectées" -->
<!--                         list="formationSelect" -->
<!--                         multiple="true" -->
<!--                         headerKey="headerKey" -->
<!--                         headerValue="--- Veuillez selectionner ---" -->
<!--                         emptyOption="true" -->
<!--                         doubleList="{}" -->
<!--                         doubleName="formations" -->
<!--                         doubleHeaderKey="doubleHeaderKey" -->
<!--                         doubleHeaderValue="--- Veuillez selectionner ---" -->
<!--                         doubleEmptyOption="true" -->
<!--                         doubleMultiple="true"/> -->
	</s:push>
		<s:submit cssClass="btn btn-inverse pull-right"
			key="form.register.submit" />
</s:form>
