<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="<s:url value="/css/bootstrap2.min.css"/>" />
<link rel="stylesheet" href="<s:url value="/css/font-awesome.min.css"/>" />
<link rel="stylesheet" href="<s:url value="/css/login.css"/>">

<script type="text/javascript" src="<s:url value="/js/jquery.min.js"></s:url>"></script>
<script type="text/javascript" src="<s:url value="/js/bootstrap.min.js"></s:url>"></script>

<script type="text/javascript">
	function changeAction(action, parameter) {
		var url = "<s:url value='/"+parameter+"/"+action+".action'/>";
		$("#formPermisos").attr("action", url);
		document.getElementById('formPermisos').submit();

	}
</script>
<title>Sin permiso</title>
</head>
<body>

<s:form action="menu" namespace="/principal" id="formPermisos"  >
	<div class="wrapper fadeInDown">
		<div id="formContent">
			<header class="row">
				<div class="col-md-3">
					<img src="<s:url value="/img/logo.jpg"/>" id="icon" alt="User Icon" />
				</div>
				<div class="col-md-9  ">
					<div class="titulo">Sin permisos</div>
				</div>
			</header>

			<div class="row">
				<div class="col-md-12">
					Tu no tienes permisos para poder ingresar a este catalogo
					<button type="button" class="btn btn-primary btnsubmit" onclick="changeAction('usuario','crudUsuario')" >Regresar</button>
				</div>
			</div>

			<div id="formFooter">
				<span class="version">Versión: 29.0.0</span>
			</div>
		</div>
		<span class="derechos">SUBASTAS VENTURA S.A. DE C.V. TODOS LOS
			DERECHOS RESERVADOS 2019 ®</span>
	</div>
</s:form>
</body>
</html>