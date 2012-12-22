<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="span3">
<div class="well">
	<h1>
		<s:text name="pageIndex.title"></s:text>
	</h1>
	<ul class="unstyled">
		<li><s:url id="URL" action="translate">
				<s:param name="request_locale">
		en
	</s:param>
			</s:url> <s:a href="%{URL}">
				<s:text name="link_translate_en.label" />
			</s:a>
		</li>

		<li><s:url id="URL" action="translate">
				<s:param name="request_locale">
		fr
	</s:param>
			</s:url> <s:a href="%{URL}">
				<s:text name="link_translate_fr.label" />
			</s:a>
		</li>
	</ul>
</div>
</div>