<%@ taglib uri="/struts-tags" prefix="s" %>
<ul class="dropdown-menu">
	<s:iterator value="affiliates">
		<s:url var="affiliateURL" action="listAffiliate" namespace="/pages" method="viewAffiliate" >
			 <s:param name="id" value="%{id}"/>
		</s:url>
		<li>
			<s:a href="%{affiliateURL}">
				<s:property value="name" />
			</s:a>
		</li>
	</s:iterator>
</ul>