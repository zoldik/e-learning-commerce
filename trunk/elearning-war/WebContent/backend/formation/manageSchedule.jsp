<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<s:url action="manageSchedule" namespace="/admin/formation" var="addSeanceURL" />

<s:set var="myURL"
	value="@org.apache.commons.lang.StringEscapeUtils@escapeJavaScript(addSeanceURL)" />

<s:property value="#myURL" />
<script type="text/javascript">
	$.subscribe('ondrop', function(event, data) {
		if (jQuery("#teacherSelect").val() != ""
				&& jQuery("#classRoomSelect").val() != ""
				&& jQuery("#subjectSelect").val() != "") {
			$(data).addClass('utessss');
			var col=$(data).parent().prevAll().length;
			console.log(col);
			var headerObj = $(data).parents('table').find('th').eq(col);
			var dataToSend = $('#sessionForm').serializeArray();
			dataToSend.push({name : 'day', value: jQuery(headerObj).html()});
			jQuery.ajax({
				url : "<s:property value='#addSeanceURL'/>",
				type : "post",
				data : dataToSend,
				success : function(serverData) {
					jQuery(data).html(serverData);
					jQuery(data).closest("td").addClass("dropped");
				},
				complete : function(){
					$("#classRoomSelect option[value='']").attr("selected",true);
					$("#teacherSelect option[value='']").attr("selected",true) ;
					jQuery("#subjectSelect option[value='']").attr("selected",true);
					$(event.originalEvent.ui.draggable).draggable({ revert : true });
				}
			});
		}
	});
</script>

<div class="span2">
	<sj:div id="draggable" draggable="true" 
		draggableRevert="true" cssClass="session-drag">
		<div class="seance-content">
			<s:form id="sessionForm" name="session">	
					<s:select id="teacherSelect" name="teacher" cssClass="span13"
						list="teacherSelect" headerKey=""
						headerValue="selectionner un enseignant" />
					<s:select id="classRoomSelect" name="classRoom" cssClass="span13"
						list="classroomSelect" headerKey=""
						headerValue="selectionner une salle" />
					<s:select id="subjectSelect" name="subject" cssClass="span13"
						list="subjectSelect" headerKey=""
						headerValue="selectionner une matière" />
			</s:form>
		</div>
	</sj:div>
</div>
<div class="span9">
	<table cellpadding="0" cellspacing="0" class="table table-bordered">
		<thead>
			<tr>
				<th bordercolor="#FFFFFF" bgcolor="#FFFFFF">&nbsp;</th>
				<s:iterator value="days">
					<th><s:property value="name" /></th>
				</s:iterator>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="timeSlots">
				<s:set var="idTime" value="id"/>
				<tr>
					<td width="78" height="136"><s:property value="beginTime"/>H00-<s:property value="endTime"/>H00</td>
					<s:iterator value="days">
						<td bgcolor="#FFFFFF">
							<sj:div id="droptarget%{id}%{idTime}" droppable="true"
								droppableOnDropTopics="ondrop"
								droppableActiveClass="ui-state-hover"
								droppableHoverClass="ui-state-active"
								droppableAccept=".session-drag" cssClass="session-drop">
							</sj:div>
						</td>
					</s:iterator>
				</tr>
			</s:iterator>
		</tbody>
	</table>
</div>