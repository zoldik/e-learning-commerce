<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<div class="pull-right">
	<ul>
		<s:url var="createURL" action="create!input"
			namespace="/admin/subject" />
		<li class="btn"><s:a href="%{createURL}">Ajouter une nouvelle matière</s:a>
		</li>
	</ul>
</div>
<div class="clearfix"></div>
<s:if test="subjects.size() > 0">
	<s:form action="batch" name="batch-actions" cssClass="form-horizontal">
		<div class="span12">
			<table class="table table-bordered">
				<thead>
					<tr class="">
						<th class=""><input type="checkbox" id="listBatchCheckbox" />
						</th>
						<th class="">Nom</th>
						<th class="">Formation</th>
						<th class="">Filiale</th>
						<th class="">Actions</th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="subjects" status="subjectStatus">
						<tr>
							<td class=""><input type="checkbox" name="idx[]"
								value="<s:property value="id" />" /></td>
							<td><s:property value="name" /></td>
							<td><s:property value="formation.name" /></td>
							<td><s:property value="formation.affiliate.name" /></td>
							<td><s:url id="editURL" action="edit"
									namespace="/admin/subject">
									<s:param name="id" value="%{id}" />
								</s:url> 
								<s:a href="%{editURL}">
									<img
										src="<s:url value="/backend/images/edit.png"/>" />
								</s:a>
								 <s:url id="deleteURL" action="delete"
									namespace="/admin/subject">
									<s:param name="id" value="%{id}" />
								</s:url> 
								<s:a href="%{deleteURL}">
									<img src="<s:url value="/backend/images/delete.png" />" />
								</s:a>
							</td>
						</tr>
					</s:iterator>
				</tbody>
				<tfoot>	
					<tr>
						<td colspan="5" class="pager">
							<div class="pagination">
								<ul>
									<li><s:url var="firstPageURL" action="list" namespace="">
											<s:param name="page" value="1"></s:param>
										</s:url> <s:a href="%{firstPageURL}" />
									</li>
								</ul>
							</div>
						</td>
					</tr>
				</tfoot>
			</table>
		</div>
		<div class="actions">
			<s:select name="action" list="{'Supprimer'}" headerKey=""
				headerValue="Selectionner une action" />
			<s:checkbox name="all_elements" label="tous les éléments" />
			<s:submit cssClass="btn primary" value="ok" />
		</div>
	</s:form>
</s:if>
<s:else>
	<p class="notice">no result</p>
</s:else>

<script language="javascript" type="text/javascript"
	src="<s:url value="/backend/js/list.js" namespace="/"/>"></script>