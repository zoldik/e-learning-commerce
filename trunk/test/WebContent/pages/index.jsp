<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><s:text name="page.title" /></title>
</head>
<body>
<ul>
	<li>
	<s:url id="URL" action="login!input"/>
	
			<s:a href="%{URL}">
		<s:text name="link.navigate.login" />
	</s:a>
	</li>
	
		<li>
		<s:url id="URL" action="register!input"/>	 
		<s:a href="%{URL}">
			<s:text name="link.navigate.register" />
		</s:a>
		</li>
</ul>

	<h1>
		<s:text name="pageIndex.title"></s:text>
	</h1>
	<ul>
		<li><s:url id="URL" action="translate">
				<s:param name="request_locale">
		en
	</s:param>
			</s:url> <s:a href="%{URL}">
				<s:text name="link_translate_en.label" />
			</s:a></li>

		<li><s:url id="URL" action="translate">
				<s:param name="request_locale">
		fr
	</s:param>
			</s:url> <s:a href="%{URL}">
				<s:text name="link_translate_fr.label" />
			</s:a></li>
	</ul>

</body>
</html>