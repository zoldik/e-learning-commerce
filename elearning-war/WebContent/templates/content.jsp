<%@ taglib uri="/struts-tags" prefix="s"%>
<div class="span12">
	<div class="container affiliates-container">
		<s:iterator value="affiliates">
			<s:url var="affiliateURL" action="index" namespace="/">

			</s:url>
			<div class="span2 inline">
				<s:a href="%{affiliateURL%}">
					<div class="affiliate-element">
						<s:property value="name" />
					</div>
				</s:a>
			</div>
		</s:iterator>
	</div>
</div>