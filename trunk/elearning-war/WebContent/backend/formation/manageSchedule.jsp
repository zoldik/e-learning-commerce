<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<s:url action="manageSchedule" var="addSeanceURL" />

<s:set var="myURL"
	value="@org.apache.commons.lang.StringEscapeUtils@escapeJavaScript(addSeanceURL)" />

<s:property value="#myURL" />
<script type="text/javascript">
	$.subscribe('ondrop', function(event, data) {
		if (jQuery("#teacherSelect").val() != ""
				&& jQuery("#classRoomSelect").val() != ""
				&& jQuery("#subjectSelect").val() != "") {
			$(data).addClass('utessss');
			console.log(jQuery("#seanceForm"));

			jQuery.ajax({
				url : "<s:property value='#addSeanceURL'/>",
				type : "post",
				data : jQuery("#seanceForm").serialize(),
				success : function(dataServer) {
					jQuery(data).html(dataServer);
				}
			});
		}
	});
	// 	jQuery(document).ready(function(){
	// 		ondrop();
	// 	});
</script>

<div class="span2">
	<sj:div id="draggable" draggable="true" draggableHandle="#seance"
		draggableRevert="invalid" cssClass="seance-drag"
		cssStyle="width: 186px; height: 100px; padding: 0.5em;">
		<div class="seance-header" id="seance"></div>
		<div class="seance-content">
			<s:form id="seanceForm">
				<s:select id="teacherSelect" name="teacher" cssClass="span13"
					list="#{'1':'amine','2':'aymen'}" headerKey=""
					headerValue="enseignant" />
				<s:select id="classRoomSelect" name="classRoom" cssClass="span13"
					list="#{'01':'A15','02':'A16','03':'A12','04':'A13'}" headerKey="0"
					headerValue="salle" />
				<s:select id="subjectSelect" name="subject" cssClass="span13"
					list="#{'01':'math','02':'physique'}" headerKey="0"
					headerValue="mati�re" />
			</s:form>
		</div>
	</sj:div>
</div>
<div class="span10">
	<table cellpadding="0" cellspacing="0" class="table table-bordered">
		<thead>
			<tr>
				<th class=""></th>
				<td bordercolor="#FFFFFF" bgcolor="#FFFFFF">&nbsp;</td>
				<th class="">Lundi</th>
				<th class="">Mardi</th>
				<th class="">Mercredi</th>
				<th class="">Jeudi</th>
				<th class="">Vendredi</th>
				<th class="">Samedi</th>
				<th class="">Dimanche</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td width="44" bgcolor="#FFFFFF" bordercolor="#FFFFFF"></td>
				<td width="78" height="136">8H00-9H30</td>
				<td bordercolor="#FFFFFF" bgcolor="#FFFFFF">&nbsp;</td>

				<td bgcolor="#FFFFFF"><sj:div id="droptarget" droppable="true"
						droppableOnDropTopics="ondrop"
						droppableActiveClass="ui-state-hover"
						droppableHoverClass="ui-state-active"
						droppableAccept=".seance-drag" cssClass="dropSeance1"
						cssStyle="width:150px;height:100px;">
					</sj:div>
				</td>
				<td bgcolor="#FFFFFF">&nbsp;</td>
				<td bgcolor="#FFFFFF">&nbsp;</td>
				<td bgcolor="#FFFFFF">&nbsp;</td>
				<td bgcolor="#FFFFFF">&nbsp;</td>
				<td bgcolor="#FFFFFF">&nbsp;</td>
			</tr>
			<tr>
				<td width="44" bgcolor="#FFFFFF" bordercolor="#FFFFFF">&nbsp;</td>
				<td width="78" height="126" bgcolor="#FFFFFF">9H30-11H15</td>
				<td bgcolor="#C0C0C0">&nbsp;</td>
				<td bgcolor="#C0C0C0">&nbsp;</td>
				<td bgcolor="#C0C0C0">&nbsp;</td>
				<td bgcolor="#C0C0C0">&nbsp;</td>
				<td bgcolor="#C0C0C0">&nbsp;</td>
				<td bgcolor="#C0C0C0">&nbsp;</td>
				<td bgcolor="#FFFFFF">&nbsp;</td>
			</tr>
			<tr>
				<td width="44" bgcolor="#FFFFFF" bordercolor="#FFFFFF">&nbsp;</td>
				<td width="78" height="129">11H30-13H00</td>
				<td bgcolor="#FFFFFF">&nbsp;</td>
				<td bgcolor="#FFFFFF">&nbsp;</td>
				<td bgcolor="#FFFFFF">&nbsp;</td>
				<td bgcolor="#FFFFFF">&nbsp;</td>
				<td bgcolor="#FFFFFF">&nbsp;</td>
				<td bgcolor="#FFFFFF">&nbsp;</td>
				<td bgcolor="#FFFFFF">&nbsp;</td>
			</tr>
			<tr>
				<td width="44" bgcolor="#FFFFFF" bordercolor="#FFFFFF">&nbsp;</td>
				<td width="78" height="109">13H30-15H00</td>
				<td bgcolor="#C0C0C0">&nbsp;</td>
				<td bgcolor="#C0C0C0">&nbsp;</td>
				<td bgcolor="#C0C0C0">&nbsp;</td>
				<td bgcolor="#C0C0C0">&nbsp;</td>
				<td bgcolor="#C0C0C0">&nbsp;</td>
				<td bgcolor="#C0C0C0">&nbsp;</td>
				<td bgcolor="#FFFFFF">&nbsp;</td>
			</tr>
			<tr>
				<td width="44" bgcolor="#FFFFFF" bordercolor="#FFFFFF">&nbsp;</td>
				<td width="78" height="128">15H15-16H45</td>
				<td bgcolor="#FFFFFF">&nbsp;</td>
				<td bgcolor="#FFFFFF">&nbsp;</td>
				<td bgcolor="#FFFFFF">&nbsp;</td>
				<td bgcolor="#FFFFFF">&nbsp;</td>
				<td bgcolor="#FFFFFF">&nbsp;</td>
				<td bgcolor="#FFFFFF">&nbsp;</td>
				<td bgcolor="#FFFFFF">&nbsp;</td>
			</tr>
			<tr>
				<td width="44" bgcolor="#FFFFFF" bordercolor="#FFFFFF">&nbsp;</td>
				<td width="78" height="125">17H00-18H30</td>
				<td bgcolor="#C0C0C0">&nbsp;</td>
				<td bgcolor="#C0C0C0">&nbsp;</td>
				<td bgcolor="#C0C0C0">&nbsp;</td>
				<td bgcolor="#C0C0C0">&nbsp;</td>
				<td bgcolor="#C0C0C0">&nbsp;</td>
				<td bgcolor="#C0C0C0">&nbsp;</td>
				<td bgcolor="#FFFFFF">&nbsp;</td>
			</tr>

		</tbody>
	</table>
</div>