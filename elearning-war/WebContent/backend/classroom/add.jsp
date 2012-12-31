<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<s:actionerror theme="bootstrap" />
<s:actionmessage theme="bootstrap" />
<s:fielderror theme="bootstrap" />
<s:form action="create" method="save" theme="bootstrap"
	namespace="/admin/school-room" cssClass="form-horizontal">
	<s:push value="classroom">
		<s:hidden name="id" />
		<s:textfield name="name" key="Nom"
			tooltip="Inqiduez le nom de la salle" />
		<s:textfield name="capacity" key="capacité" 
			tooltip="Inqiduez la capactiy de la salle" />
	</s:push>
		<s:submit cssClass="btn btn-inverse pull-right"
			key="form.register.submit" />
</s:form>
