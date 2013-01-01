<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<s:actionerror theme="bootstrap" />
<s:actionmessage theme="bootstrap" />
<s:fielderror theme="bootstrap" />
<s:form action="create!save" theme="bootstrap"
	namespace="/admin/subject" cssClass="form-horizontal" enctype="multipart/form-data">
	<s:push value="subject">
		<s:hidden name="id" />
		<s:textfield name="name" key="Nom"
			tooltip="Inqiduez le nom de la matière" />
		<s:select list="formationSelect" name="formation" value="formation.id" label="formation" 
		tooltip="Inqiduez la formation associée" />
	</s:push>
		<s:submit cssClass="btn btn-inverse"
			key="form.register.submit" />
</s:form>
