<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<s:actionerror theme="bootstrap" />
<s:actionmessage theme="bootstrap" />
<s:fielderror theme="bootstrap" />
<s:form action="create!save" theme="bootstrap"
	namespace="/admin/formation" cssClass="form-horizontal">
	<s:push value="formation">
		<s:hidden name="id" />
		<s:textfield name="name" key="Nom"
			tooltip="Inqiduez le nom de la formation" />
		<sj:datepicker name="startDate" id="startDate"
			parentTheme="bootstrap" displayFormat="dd/mm/yy" label="Date début"
			tooltip="Date début de formation" />
		<sj:datepicker name="endDate" id="endDate"
			parentTheme="bootstrap" displayFormat="dd/mm/yy" label="Date fin"
			tooltip="Date fin de formation" />
		<s:if test="#session.roles.contains('admin')">
			<s:select list="affiliateSelect" name="affiliate" value="affiliate.id"
			label="filiate" tooltip="Indiquez la filiale"/>
		</s:if>
		<s:submit cssClass="btn btn-inverse pull-right"
			key="form.register.submit" />
	</s:push>
</s:form>
