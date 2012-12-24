<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>

<div class="span5 offset3">
	<s:actionerror theme="bootstrap" />
	<s:actionmessage theme="bootstrap" />
	<s:fielderror theme="bootstrap" />
	<s:form action="contact" theme="bootstrap" cssClass="form-horizontal">
		<s:textfield name="fullName" label="Nom complet" />
		<s:textfield name="mailFrom" label="Adresse email" />
		<s:textfield name="phone" label="Num Téléphone" />
		<s:textfield name="subject" label="Objet" />
		<s:textarea name="message" label="Suggestion" />
		<s:submit cssClass="btn btn-inverse pull-right" value="Envoyer" />
	</s:form>
</div>
<div class="span3 offset0">
	<img alt="gmap-static" id="staticmap"
		src="http://maps.googleapis.com/maps/api/staticmap?center=10,9
                        &amp;markers=color:red|10,9&amp;key=ABQIAAAAeh1YBmFcaHd1emslzp6ZrxSIzwvUoQf9cbTOY7TSCw9T7qhXkxSKv0wYCDaaynqM9k_yqlIXeelS5g&amp;zoom=12&amp;size=250x280&amp;sensor=false" />
</div>
