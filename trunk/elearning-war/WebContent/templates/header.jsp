<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
	<ul>
		<li><s:url id="URL" action="login!input" /> <s:a href="%{URL}">
				<s:text name="link.navigate.login" />
			</s:a></li>

		<li><s:url id="URL" action="register!input" /> <s:a href="%{URL}">
				<s:text name="link.navigate.register" />
			</s:a></li>
	</ul>