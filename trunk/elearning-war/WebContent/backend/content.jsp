<%@ taglib uri="/struts-tags" prefix="s"%>
<div class="span7">
	<table class="table table-bordered">
		<thead>
			<tr>
				<th colspan="3">Utilisateurs</th>
			</tr>
		</thead>

		<tbody>
			<tr>
				<td class="">Enseignants</td>
				<s:url var="createURL" action="create!input" namespace="/admin/teacher" />
				<td>
					<s:a href="%{createURL}">
						<img src="<s:url value="/backend/images/add.png" />" />
					</s:a>
				</td>
				<s:url var="listTeachers" action="list" namespace="/admin/teacher" />
				<td><s:a href="%{listTeachers}">Liste</s:a></td>
			</tr>
			<s:if test="#session.roles.contains('admin')">
				<tr>
					<td class="">Administrateurs</td>
					<s:url var="createURL" action="create" method="input" namespace="/admin/administrator" />
					<td>
						<s:a href="%{createURL}">
							<img src="<s:url value="/backend/images/add.png" />" />
						</s:a>
					</td>
					<s:url var="listAdministrators" action="list" namespace="/admin/administrator" />
					<td><s:a href="%{listAdministrators}">Liste</s:a></td>
				</tr>
			</s:if>
		</tbody>
	</table>
	
	<table class="table table-bordered">
		<thead>
			<tr>
				<th colspan="3">Formations</th>
			</tr>
		</thead>

		<tbody>
			<tr>
				<td class="">Formations</td>
				<s:url var="createURL" action="create" method="input" namespace="/admin/formation" />
				<td>
					<s:a href="%{createURL}">
						<img src="<s:url value="/backend/images/add.png" />" />
					</s:a>
				</td>
				<s:url var="listFormation" action="list" namespace="/admin/formation" />
				<td><s:a href="%{listFormation}">Liste</s:a></td>
			</tr>
			<tr>
				<td class="">Salles</td>
				<s:url var="createURL" action="create" method="input" namespace="/admin/school-room" />
				<td>
					<s:a href="%{createURL}">
						<img src="<s:url value="/backend/images/add.png" />" />
					</s:a>
				</td>
				<s:url var="listClassroom" action="list" namespace="/admin/school-room" />
				<td><s:a href="%{listClassroom}">Liste</s:a></td>
			</tr>
			<tr>
				<td class="">Documents</td>
				<s:url var="createURL" action="create" method="input" namespace="/admin/document" />
				<td>
					<s:a href="%{createURL}">
						<img src="<s:url value="/backend/images/add.png" />" />
					</s:a>
				</td>
				<s:url var="listDocument" action="list" namespace="/admin/document" />
				<td><s:a href="%{listDocument}">Liste</s:a></td>
			</tr>
			
			<tr>
				<td class="">Matières</td>
				<s:url var="createURL" action="create" method="input" namespace="/admin/subject" />
				<td>
					<s:a href="%{createURL}">
						<img src="<s:url value="/backend/images/add.png" />" />
					</s:a>
				</td>
				<s:url var="listSubject" action="list" namespace="/admin/subject" />
				<td><s:a href="%{listSubject}">Liste</s:a></td>
			</tr>
		</tbody>
	</table>
</div>