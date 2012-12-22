<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<s:actionerror theme="bootstrap" />
<s:actionmessage theme="bootstrap" />
<s:fielderror theme="bootstrap" />
<s:form action="create!save" theme="bootstrap" namespace="/admin/formation"
	cssClass="form-horizontal">
<%-- 	<s:push value="formation"> --%>
		<s:hidden name="id" />
		<s:textfield name="name" key="formation.name.label"
			tooltip="Enter the name of the formation here" />
		<s:select name="affiliate" list="affiliates" multiple="false"></s:select>
		<s:submit cssClass="btn btn-inverse pull-right"
			key="form.register.submit" />
<%-- 	</s:push> --%>
</s:form>
