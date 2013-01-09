<%@ taglib uri="/struts-tags" prefix="s"%>
<div class="span9">
<object data="<s:url value="/test.pdf" />" type="application/pdf" width="100%" height="100%">
 
  <p>It appears you don't have a PDF plugin for this browser.
  No biggie... you can <a href="myfile.pdf">click here to
  download the PDF file.</a></p>
  
</object>

</div>

<script language="javascript" type="text/javascript"
	src="<s:url value="/js/pdfobject.js" namespace="/"/>"></script>