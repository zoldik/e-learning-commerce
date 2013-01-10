<%@ taglib uri="/struts-tags" prefix="s"%>

<script type="text/javascript">
jQuery(document).ready(function(){
	jQuery('.nav-tabs a').click(function (e) {
	 	  e.preventDefault();
		  jQuery(this).tab('show');
		});	
});
</script>

<div class="span8">
<ul class="nav nav-tabs">
  	<li class="active">
    	<a href="#tab1">Emploi du temps</a>
  	</li>
  	<li>
 		<a href="#tab2">Cours</a>
	</li>
</ul>
<div class="tab-content">
	<div class="tab-pane active" id="tab1">
		<table cellpadding="0" cellspacing="0" class="table table-bordered">
			<thead>
				<tr class="success">
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
						<td class="time-slot" width="60" height="136"><span id="beginDate%{idTime}"><s:property value="beginTime"/></span>H00-<s:property value="endTime"/>H00</td>
						<s:iterator value="days">
							<s:set var="find" value="%{false}"/>
							<s:set var="idDay" value="id"/>
							<s:iterator value="schedule.sessions" >
								<s:if test="%{timeSlot.id==#idTime && day.id==#idDay}">
									<td class="dropped">	
										<s:include value="/backend/formation/success.jsp"/>
										<s:set var="find" value="%{true}"/>
									</td>
								</s:if>
							</s:iterator>
							<s:if test="%{#find==false}">
								<td class="" bgcolor="#FFFFFF">
								</td>
							</s:if>
						</s:iterator>
					</tr>
				</s:iterator>
			</tbody>
		</table>
    </div>
    
   	<div class="tab-pane" id="tab2">
			<s:iterator value="documents">
  			<li class="nav-header"><s:property value="key"/></li>
  				<s:iterator value="value">
  					<li>
  						<s:url var="previewCourse" action="" method="" namespace="/pages">
  						</s:url>
  						<s:a href="%{previewCourse}"><s:property value="name"/></s:a>
  					</li>
  				</s:iterator>
  			</s:iterator>
   	</div>
</div>
  	
	
</div>