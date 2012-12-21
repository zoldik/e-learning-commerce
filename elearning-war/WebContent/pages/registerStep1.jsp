<%@ taglib uri="/struts-tags" prefix="s" %>
<s:actionerror theme="bootstrap" />
	<s:actionmessage theme="bootstrap" />
	<s:fielderror theme="bootstrap" />
<s:form action="registerStep1" theme="bootstrap" cssClass="form-horizontal">
	<s:radio cssClass="inline" name="typeOfUser" list="{'Demandeur de formation','Demandeur d\'emploi','Employeur'}"></s:radio>
	<s:submit cssClass="btn btn-inverse pull-right" value="Suivant" />
</s:form>