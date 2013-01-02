<%@ taglib uri="/struts-tags" prefix="s"%>
<div class="span8 offset2">
	<s:actionerror theme="bootstrap" />
	<s:actionmessage theme="bootstrap" />
	<s:fielderror theme="bootstrap" />
	<s:form action="registerStep1" theme="bootstrap"
		cssClass="form-horizontal">
		<s:radio tooltip="choissez parmi ces types"
			label="Type d'utilisateur" labelposition="inline" name="typeOfUser" value="1"
			list="#{'1':'Demandeur de formation','2':'Demandeur d\\'emploi','3':'Employeur'}" />
		<s:submit cssClass="btn btn-inverse" value="Suivant" />
	</s:form>
</div>