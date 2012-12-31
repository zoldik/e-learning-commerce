<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<s:actionerror theme="bootstrap" />
<s:actionmessage theme="bootstrap" />
<s:fielderror theme="bootstrap" />
<s:form action="create!save" theme="bootstrap"
	cssClass="form-horizontal">
	<s:push value="administrator">
		<s:hidden name="id" />
		<s:textfield name="username" key="username.label"
			tooltip="Indiquer le nom d'utilisateur"/>
		<s:textfield name="email" key="email.label" tooltip="Indiquer l'adresse e-mail" />
		<s:password name="password" key="password.label"
			tooltip="Indiquer le mot de passe" />
		<s:select list="affiliateSelect" name="affiliate" label="La filiale à administer" value="affiliate.id" 
		tooltip="Indiquer la filiale que cet administrateur doit administrer"/>
		<s:checkbox name="enabled" label="Actif"/>
	</s:push>
		<s:submit cssClass="btn btn-inverse pull-right"
			key="form.register.submit" />
</s:form>
