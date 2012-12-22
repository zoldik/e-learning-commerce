<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<s:actionerror theme="bootstrap" />
<s:actionmessage theme="bootstrap" />
<s:fielderror theme="bootstrap" />
<s:form action="create!save" theme="bootstrap"
	namespace="/admin/formation" cssClass="form-horizontal">
	<%-- 	<s:push value="formation"> --%>
	<s:hidden name="id" />
	<s:textfield name="formation.name" key="formation.name.label"
		tooltip="Enter the name of the formation here" />
	<sj:datepicker name="formation.startDate" id="startDate" parentTheme="bootstrap"
		label="Date début" tooltip="Date début de formation" />
	<sj:datepicker name="formation.endDate" id="endDate" parentTheme="bootstrap"
		label="Date fin" tooltip="Date fin de formation" />
	<s:submit cssClass="btn btn-inverse pull-right"
		key="form.register.submit" />
	<%-- 	</s:push> --%>
</s:form>
