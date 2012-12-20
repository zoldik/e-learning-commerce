<%@ taglib uri="/struts-tags" prefix="s"%>
<div class="span9">
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