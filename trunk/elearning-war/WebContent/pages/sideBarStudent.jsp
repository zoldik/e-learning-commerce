<%@ taglib uri="/struts-tags" prefix="s"%>
<div class="span3">
	<div class="well sidebar-nav">
		<ul class="nav nav-list">
			<s:iterator value="affiliates">
  			<li class="nav-header"><s:property value="key"/></li>
  				<s:iterator value="value">
  					<li class="">
  						<s:url var="supportFormation" action="personalSpace" namespace="/pages">
  							<s:param name="id" value="%{id}"/>
  						</s:url>
  						<s:a href="%{supportFormation}"><s:property value="name"/></s:a>
  					</li>
  				</s:iterator>
  			</s:iterator>
  		</ul>
	</div>
</div>