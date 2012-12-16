<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
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