<%@ taglib uri="/struts-tags" prefix="s"%>

<s:url value="/test.pdf" var="pdfViewer" />

<s:set var="myURL"
	value="@org.apache.commons.lang.StringEscapeUtils@escapeJavaScript(pdfViewer)" />

<script language="javascript" type="text/javascript"
	src="<s:url value="/js/pdfobject.js" namespace="/"/>"></script>

<script type="text/javascript">

jQuery(document).ready(function(){
	var myPDF = new PDFObject({url: "<s:property value='#pdfViewer'/>",
				pdfOpenParams: { view: 'FitB'}}).embed('pdfDoc');	
});

</script>
<div class="media" id="pdfDoc">

</div>

