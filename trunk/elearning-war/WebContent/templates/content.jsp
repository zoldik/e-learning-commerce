<%@ taglib uri="/struts-tags" prefix="s"%>
<div class="span12">
	<div class="container affiliates-container">
		<s:iterator value="affiliates">
		<s:url var="affiliateURL" action="index" namespace="/" >
			
		</s:url>
		<div class="span2 inline">
			<s:a href="%{affiliateURL%}">
				<s:property value="name" />
			</s:a>
		</div>
	</s:iterator>
	</div>
</div>