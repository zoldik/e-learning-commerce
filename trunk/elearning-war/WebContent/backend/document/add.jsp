<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<s:actionerror theme="bootstrap" />
<s:actionmessage theme="bootstrap" />
<s:fielderror theme="bootstrap" />
<s:form action="create!save" theme="bootstrap"
	namespace="/admin/document" cssClass="form-horizontal" enctype="multipart/form-data">
	<s:push value="document">
		<s:hidden name="id" />
		<s:textfield name="name" key="Nom"
			tooltip="Inqiduez le nom du document" />
		<s:select list="formationSelect" key="formation" 
			tooltip="Inqiduez la formation associée" />			
	</s:push>
		<s:file name="upload" label="fichier"/>
		<s:submit cssClass="btn btn-inverse"
			key="form.register.submit" />
</s:form>
