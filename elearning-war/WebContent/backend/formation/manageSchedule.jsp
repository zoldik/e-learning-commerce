<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<div class="span2">
	<sj:div id="draggable" draggable="true" draggableHandle="#seance"
		draggableRevert="invalid"
		cssClass="seance-drag"
		cssStyle="width: 100px; height: 100px; padding: 0.5em; float: left; margin: 10px 10px 10px 0;">
			<div class="seance-header" id="seance"></div>
			<div class="seance-content"></div>
	</sj:div>

</div>
<div class="span10">
	<table class="table table-bordered table-striped">
		<thead>
			<tr>
				<th class=""></th>
				<td bordercolor="#FFFFFF" bgcolor="#FFFFFF">&nbsp;</td>
				<th class="">Lundi</th>
				<th class="">Mardi</th>
				<th class="">Mercredi</th>
				<th class="">Jeudi</th>
				<th class="">Vendredi</th>
				<th class="">Samedi</th>
				<th class="">Dimanche</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td width="44" bgcolor="#FFFFFF" bordercolor="#FFFFFF">&nbsp;</td>
				<td width="78" height="136">8H00-9H30</td>
				<td bordercolor="#FFFFFF" bgcolor="#FFFFFF">&nbsp;</td>
				<td bgcolor="#FFFFFF"></td>
				<td bgcolor="#FFFFFF">&nbsp;</td>
				<td bgcolor="#FFFFFF">&nbsp;</td>
				<td bgcolor="#FFFFFF">&nbsp;</td>
				<td bgcolor="#FFFFFF">&nbsp;</td>
				<td bgcolor="#FFFFFF">&nbsp;</td>
			</tr>
			<tr>
				<td width="44" bgcolor="#FFFFFF" bordercolor="#FFFFFF">&nbsp;</td>
				<td width="78" height="126" bgcolor="#FFFFFF">9H30-11H15</td>
				<td bgcolor="#C0C0C0">&nbsp;</td>
				<td bgcolor="#C0C0C0">&nbsp;</td>
				<td bgcolor="#C0C0C0">&nbsp;</td>
				<td bgcolor="#C0C0C0">&nbsp;</td>
				<td bgcolor="#C0C0C0">&nbsp;</td>
				<td bgcolor="#C0C0C0">&nbsp;</td>
				<td bgcolor="#FFFFFF">&nbsp;</td>
			</tr>
			<tr>
				<td width="44" bgcolor="#FFFFFF" bordercolor="#FFFFFF">&nbsp;</td>
				<td width="78" height="129">11H30-13H00</td>
				<td bgcolor="#FFFFFF">&nbsp;</td>
				<td bgcolor="#FFFFFF">&nbsp;</td>
				<td bgcolor="#FFFFFF">&nbsp;</td>
				<td bgcolor="#FFFFFF">&nbsp;</td>
				<td bgcolor="#FFFFFF">&nbsp;</td>
				<td bgcolor="#FFFFFF">&nbsp;</td>
				<td bgcolor="#FFFFFF">&nbsp;</td>
			</tr>
			<tr>
				<td width="44" bgcolor="#FFFFFF" bordercolor="#FFFFFF">&nbsp;</td>
				<td width="78" height="109">13H30-15H00</td>
				<td bgcolor="#C0C0C0">&nbsp;</td>
				<td bgcolor="#C0C0C0">&nbsp;</td>
				<td bgcolor="#C0C0C0">&nbsp;</td>
				<td bgcolor="#C0C0C0">&nbsp;</td>
				<td bgcolor="#C0C0C0">&nbsp;</td>
				<td bgcolor="#C0C0C0">&nbsp;</td>
				<td bgcolor="#FFFFFF">&nbsp;</td>
			</tr>
			<tr>
				<td width="44" bgcolor="#FFFFFF" bordercolor="#FFFFFF">&nbsp;</td>
				<td width="78" height="128">15H15-16H45</td>
				<td bgcolor="#FFFFFF">&nbsp;</td>
				<td bgcolor="#FFFFFF">&nbsp;</td>
				<td bgcolor="#FFFFFF">&nbsp;</td>
				<td bgcolor="#FFFFFF">&nbsp;</td>
				<td bgcolor="#FFFFFF">&nbsp;</td>
				<td bgcolor="#FFFFFF">&nbsp;</td>
				<td bgcolor="#FFFFFF">&nbsp;</td>
			</tr>
			<tr>
				<td width="44" bgcolor="#FFFFFF" bordercolor="#FFFFFF">&nbsp;</td>
				<td width="78" height="125">17H00-18H30</td>
				<td bgcolor="#C0C0C0">&nbsp;</td>
				<td bgcolor="#C0C0C0">&nbsp;</td>
				<td bgcolor="#C0C0C0">&nbsp;</td>
				<td bgcolor="#C0C0C0">&nbsp;</td>
				<td bgcolor="#C0C0C0">&nbsp;</td>
				<td bgcolor="#C0C0C0">&nbsp;</td>
				<td bgcolor="#FFFFFF">&nbsp;</td>
			</tr>

		</tbody>
	</table>
</div>

<script language="javascript" type="text/javascript"
	src="<s:url value="/backend/js/schedule.js" namespace="/"/>"></script>