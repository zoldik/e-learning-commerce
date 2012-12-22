<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<sj:head compressed="false" />
<sb:head />
<link rel="stylesheet"
	href="<s:url value="/css/main.css" namespace="/"/>" type="text/css">
<title><tiles:insertAttribute name="title" /></title>
</head>
<body>
	<div class="container-fluid">
	<div class="row-fluid">
		<div class="header">
			<div class="banner">
				<div class="container">
					<h3>Centre Islamique Abdullah Ben Massoud</h3>
				</div>
			</div>

			<div class="navbar navbar-inverse">
				<tiles:insertAttribute name="header" />
			</div>
		</div>

		
			<tiles:insertAttribute name="menu" />

			<tiles:insertAttribute name="body" />
		
		<div class="footer">
			<tiles:insertAttribute name="footer" />
		</div>
		
		</div>		
	</div>

	<script type="text/javascript">
		// 	jQuery(document).ready(function(){
		// 		jQuery("ul.nav").children("li").click(function(){
		// 			jQuery(this).addClass("active");
		// 			jQuery("ul.nav").children("li").each(function(){
		// 				jQuery(this).removeClass("active");
		// 			});
		// 		});
		// 	});
	</script>
</body>
</html>