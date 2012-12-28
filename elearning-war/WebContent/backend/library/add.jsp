<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<s:actionerror theme="bootstrap" />
<s:actionmessage theme="bootstrap" />
<s:fielderror theme="bootstrap" />
<s:form action="create!save" theme="bootstrap"
	namespace="/admin/libraray" cssClass="form-horizontal">
	<s:push value="library">
		<s:hidden name="id" />
		<s:textfield name="name" key="Nom"
			tooltip="Inqiduez le nom de la salle" />
		<s:select list="categorySelect" key="catégorie" 
			tooltip="Inqiduez la catégorie de la librairie" />			
	</s:push>
		<s:file name="upload" label="fichier"/>
		<s:submit cssClass="btn btn-inverse"
			key="form.register.submit" />
</s:form>
