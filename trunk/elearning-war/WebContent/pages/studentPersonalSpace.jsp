<%@ taglib uri="/struts-tags" prefix="s"%>

<div class="span4">
	<div class="well sidebar-nav">
		<ul class="nav nav-list">
			<s:iterator value="affiliates">
  			<li class="nav-header"><s:property value="key"/></li>
  				<s:iterator value="value">
  					<li>
  						<s:url var="supportFormation" action="" method="" namespace="/pages">
  						</s:url>
  						<s:a href="%{supportFormation}"><s:property value="name"/></s:a>
  					</li>
  				</s:iterator>
  			</s:iterator>
  		</ul>
	</div>
</div>
<div class="span8">
</div>