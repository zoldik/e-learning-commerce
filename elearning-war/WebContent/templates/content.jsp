<%@ taglib uri="/struts-tags" prefix="s"%>
<div class="row-fluid">
	<div class="presentation">
		<div class="logo2"></div>
		<div>je teste amineamine amine amine amine amine amine amine</div>
	</div>
	<div class="container affiliates-container">
		<s:iterator value="affiliates">
			<s:url var="affiliateURL" action="index" namespace="/">

			</s:url>
			<div class="span3 inline">
				<s:a href="%{affiliateURL%}">
					<div class="affiliate-element">
						<s:property value="name" />
					</div>
				</s:a>
			</div>
		</s:iterator>
	</div>
</div>