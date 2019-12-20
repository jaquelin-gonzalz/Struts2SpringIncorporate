<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="a" uri="/struts-tags"%>
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
<script type="text/javascript" src="<s:url value="/js/utilSV.js"/>"></script>

<script type="text/javascript">
	function changeAction(action, parameter) {
		var url = "<s:url value='/"+parameter+"/"+action+".action'/>";
		$("#formPerfil").attr("action", url);
		document.getElementById('formPerfil').submit();

	}
</script>

<script type="text/javascript">


	function validarEliminar() {

		var r = confirm("Deseas eliminar este registro?");
		if (r == true) {
			txt = "You pressed OK!";
			changeAction('eliminar', 'crudUsuario')
		} else {
			txt = "You pressed Cancel!";
		}
	}
	function validar() {

		var error = "Erro de Validación\r\n";
		var ok = true;
		document.getElementById("idPerfil").style.borderColor = "green";
		document.getElementById("perfil").style.borderColor = "green";

		var id, perfil;
		var form = document.getElementsByTagName("registro")[0];
		id = document.getElementById("idPerfil").value;
		perfil = document.getElementById("perfil").value;

		if (id == "" || isNaN(id)) {

			error += "El id es vacio\r\n";
			document.getElementById("idPerfil").style.borderColor = "red";
			ok = false;
		}
		if (!isNaN(perfil) || perfil == "") {

			error += "El perfil es vacio\r\n";
			document.getElementById("perfil").style.borderColor = "red";
			ok = false;
		}
		if (ok == false) {
			alert("" + error);
		} else {
			changeAction('registrar', 'cperfiles');
		}

	}
</script>


<title>Registro Perfiles</title>
</head>
<body>

	<s:form  id="formPerfil">
		<header class="container">
			<div class="jumbotron">
				<div class="row">
					<div class="col-2">
						<img src="<s:url value="/img/logo.jpg"/>" alt="" class="logotipo">
					</div>
					<div class="col-9">
						<div class="titulo">Registro Perfiles</div>
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

						<div class="subtitulo">REGISTRO</div>
						<s:if test="( perfilVO.mensaje != null && !perfilVO.mensaje.equals(''))">
				          <div class="alert alert-danger" role="alert">
					            <a:property value="perfilVO.mensaje" />
					     </div>
				       </s:if>
				       
				       <div class="row">
						    <div class="col-md-6">
								<!-- Etiqueta -->
								<label class="col-form-label">Id perfil<i class="fa fa-question-circle icon-tooltip" data-toggle="tooltip" title="ID PERFIL"></i></label>
										<!-- Campo numerico -->
										<s:if test="banderaEnable == 4">
										<s:textfield class="result"  maxlength="30" id="idPerfil" cssClass="form-control" placeholder="id de perfil" name = "perfilVO.id_perfil" label = "Customer Name"  value = "%{perfilVO.id_perfil}" disabled="false"/>
					                    </s:if>
					                    <s:elseif test="banderaEnable == 2 || banderaEnable == 3 || banderaEnable == 1">
					                    <s:textfield class="result"  maxlength="30" id="idPerfil" cssClass="form-control" placeholder="id de perfil" name = "perfilVO.id_perfil" label = "Customer Name"  value = "%{perfilVO.id_perfil}" disabled="true"/>
					                    <s:hidden class="result"  name = "perfilVO.id_perfil" label = "Customer Name"  value = "%{perfilVO.id_perfil}" ></s:hidden>
										 </s:elseif>					            
							</div>
						
							<div class="col-md-6">
								<!-- Etiqueta -->
								<label class="col-form-label">Perfil <i class="fa fa-question-circle icon-tooltip" data-toggle="tooltip" title="PERFILES"></i></label>
										<!-- Campo numerico -->
										
										<s:if test="%{banderaEnable == 2 || banderaEnable == 4}">
										<s:textfield class="result" maxlength="30"  id="perfil" cssClass="form-control" placeholder="perfil" name = "perfilVO.perfil" label = "Customer Name"  value = "%{perfilVO.perfil}" disabled="false"/>
							            </s:if>
							            <s:else>
							            <s:textfield class="result" maxlength="30"  id="perfil" cssClass="form-control" placeholder="perfil" name = "perfilVO.perfil" label = "Customer Name"  value = "%{perfilVO.perfil}" disabled="true"/>
							            </s:else>
							            
							</div>							
						</div>
					</div>
					<div class="row">
              <div class="col-md-12">
                <!--pruebaMensaje() funcion ejemplo para alert personalizado -->
                <s:if test="%{banderaEnable == 2}">
                <button type="button" class="btn btn-primary btnsubmit" onclick="changeAction('modificar','cperfiles')">Modificar</button>
                </s:if>
                <s:if test="%{banderaEnable == 3}">
                 <button type="button" class="btn btn-primary btnsubmit" onclick="validarEliminar()">Eliminar</button>
                </s:if>
                 <s:if test="%{banderaEnable == 4}">
                   <button type="button" class="btn btn-primary btnsubmit"  onclick="validar()">Registrar</button>
                 </s:if>
                <button type="button" class="btn btn-primary btnsubmit" onclick="changeAction('regresarMenu','cperfiles')">Cancelar</button>
      
              </div>
            </div>
				</div>
			</div>

		</article>
		</s:form>
</body>
</html>