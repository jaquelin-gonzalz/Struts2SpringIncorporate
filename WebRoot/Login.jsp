<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="a" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script type="text/javascript">
	function limpiar() {
		document.getElementById("nombre").value = "";
		document.getElementById("password").value = "";
	}
	function validar() {
		var error = "Erro de Validación\r\n";
		var ok = true;
		document.getElementById("nombre").style.borderColor = "green";
		document.getElementById("password").style.borderColor = "green";
		
		var nombre,password;
		nombre = document.getElementById("nombre").value;
		password = document.getElementById("password").value;
		
		if ( nombre == "") {

			error += "El campo nombre es vacio\r\n";
			document.getElementById("nombre").style.borderColor = "red";
			ok = false;
		}
		if ( password == "") {

			error += "El campo password es vacio\r\n";
			document.getElementById("password").style.borderColor = "red";
			ok = false;
		}
		if (ok == false) {
			alert("" + error);
		} else {
			document.login.submit();
		}
		
	}
	
</script>

<link rel="stylesheet" href="<s:url value="/css/bootstrap2.min.css"/>" />
<link rel="stylesheet" href="<s:url value="/css/font-awesome.min.css"/>" />
<link rel="stylesheet" href="<s:url value="/css/login.css"/>">

<script type="text/javascript" src="<s:url value="/js/jquery.min.js"></s:url>"></script>
<script type="text/javascript" src="<s:url value="/js/bootstrap.min.js"></s:url>"></script>

            
<title>Login</title>
</head>
<body>
	<div class="wrapper fadeInDown">
		<div id="formContent">
			<header class="row">
				<div class="col-md-3">
					<img src="<s:url value="/img/logo.jpg"/>" id="icon" alt="User Icon" />
				</div>
				<div class="col-md-9  ">
					<div class="titulo">LOGIN</div>
				</div>
			</header>
			<div style="border-top: 1px solid #e0e0e0; margin: 10px 0px 10px 0px;"></div>

			<s:form action="login" namespace="/principal" name="login">

				<s:if test="( loginVO.mensaje != null && !loginVO.mensaje.equals(''))">
					<div class="alert alert-danger" role="alert">
						<a:property value="loginVO.mensaje" />
					</div>
				</s:if>

				<s:textfield name="loginVO.usuarioVO.nombre" class="fadeIn second" id="nombre" placeholder="Usuario" theme="simple"></s:textfield>
				<s:password name="loginVO.usuarioVO.password" class="fadeIn third" id="password" placeholder="Contraseña" theme="simple"></s:password>
				<br>
				<div class="row">
					<div class="col-md-12">
						<button type="button" onclick="limpiar()">
							<i class="fa fa-times "></i> Cancelar
						</button>
						<button type="button" onclick="validar()">
							<i class="fa fa-share-square-o " ></i> Ingresar
						</button>

					</div>
				</div>
			</s:form>
			<div id="formFooter">
				<span class="version">Versión: 29.0.0</span>
			</div>
		</div>
		<span class="derechos">SUBASTAS VENTURA S.A. DE C.V. TODOS LOS
			DERECHOS RESERVADOS 2019 ®</span>
	</div>
</body>
</html>