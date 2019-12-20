<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link rel="stylesheet" href="<s:url value="/css/plantilla.css"/>" />
<link rel="stylesheet" href="<s:url value="/css/bootstrap.min.css"/>" />
<link rel="stylesheet" href="<s:url value="/css/font-awesome.min.css"/>" />

<script type="text/javascript" src="<s:url value="/js/jquery.min.js"/>"></script>
<script type="text/javascript" src="<s:url value="/js/popper.min.js"/>"></script>
<script type="text/javascript"
	src="<s:url value="/js/bootstrap.min.js"/>"></script>
<script type="text/javascript" src="<s:url value="/js/moment.min.js"/>"></script>
<script type="text/javascript" src="<s:url value="/js/utilSV.js"/>"></script><head>
<meta charset="ISO-8859-1">

<script type="text/javascript">
	function changeAction(action, parameter) {
		var url = "<s:url value='/"+parameter+"/"+action+".action'/>";
		$("#formMenu").attr("action", url);
		document.getElementById('formMenu').submit();
		$("#forMenu").submit();
	}

</script>

<title>Menu</title>
</head>
<body>

<s:form action="usuario" namespace="/usuario" id="formMenu">
	<header class="container">
		<div class="jumbotron">
			<div class="row">
				<div class="col-2">
					<img src="<s:url value="/img/logo.jpg"/>" alt="" class="logotipo">
				</div>
				<div class="col-9">
					<div class="titulo">MENÚ</div>
				</div>
			</div>
		</div>
	</header>
	<article class="container">
		<!-- Contenedor margen gris inferior rojo -->
		<!-- Nota: para cambiar el color de los bordes ir a la clase "cuerpo" -->
		<div class="cuerpo">

			<div class="contenedor">
				<!--  Campos listado  -->
				<div class="container">
					<div class="row">
						<div class="col-md-3"></div>

						<div class="col-md-3">
							<div class="opc-menu"
								onclick="changeAction('usuario','crudUsuario')">
								<img src="<s:url value="/img/img-add-user.png"/>" class="titulo-imagen" alt="">
								<p class="titulo-menu">Usuarios</p>
							</div>
						</div>
						<div class="col-md-3">
							<div class="opc-menu"
								onclick="changeAction('cperfiles','cperfiles')">
								<img src="<s:url value="/img/perfiles.png"/>" class="titulo-imagen" alt="">
								<p class="titulo-menu">Perfiles</p>
							</div>
						</div>
					</div>
					<div class="col-md-3"></div>
					<div class="row">
						<div class="col-md-12">
							<!--pruebaMensaje() funcion ejemplo para alert personalizado -->
							<button type="button" class="btn btn-primary btnsubmit" onclick="changeAction('logout','principal')">Salir</button>
						</div>
					</div>
				</div>
			</div>

		</div>
	</article>
</s:form>
</body>
</html>