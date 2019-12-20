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
		$("#formUsuario").attr("action", url);
		document.getElementById('formUsuario').submit();

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
		document.getElementById("id").style.borderColor = "green";
		document.getElementById("nombre").style.borderColor = "green";
		document.getElementById("correo").style.borderColor = "green";
		document.getElementById("perfil").style.borderColor = "green";
		document.getElementById("telefono").style.borderColor = "green";
		document.getElementById("password").style.borderColor = "green";

		var id, nombre, correo, perfil, telefono, password;
		var form = document.getElementsByTagName("registro")[0];
		id = document.getElementById("id").value;
		nombre = document.getElementById("nombre").value;
		correo = document.getElementById("correo").value;
		perfil = document.getElementById("perfil").value;
		telefono = document.getElementById("telefono").value;
		password = document.getElementById("password").value;
		expresion2 = /[A-Za-z]+@[A-Za-z]+\.[A-Za-z]+/;

		if (id == "" || isNaN(id)) {

			error += "El campo id es vacio\r\n";
			document.getElementById("id").style.borderColor = "red";
			ok = false;
		}

		if (!isNaN(nombre) || nombre == "") {

			error += "El campo nombre es vacio\r\n";
			document.getElementById("nombre").style.borderColor = "red";
			ok = false;
		}

		if (!expresion2.test(correo)){
        	
           	error += "-.Introduce un correo Valido\n";
          	document.getElementById("correo").style.borderColor= "red";
         	ok = false;
    	
               }
		if (isNaN(perfil) || perfil == "") {

			error += "El campo perfil es vacio\r\n";
			document.getElementById("perfil").style.borderColor = "red";
			ok = false;
		}
		if (telefono == "" || isNaN(telefono)) {

			error += "El campo telefono es vacio\r\n";
			document.getElementById("telefono").style.borderColor = "red";
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
			changeAction('registrar', 'crudUsuario')
		}
	}
</script>
<title>Registro Usuarios</title>
</head>
<body>

<s:form action="rusuario" namespace="/usuario" id="formUsuario">

		<header class="container">
			<div class="jumbotron">
				<div class="row">
					<div class="col-2">
						<img src="<s:url value="/img/logo.jpg"/>" alt="" class="logotipo">
					</div>
					<div class="col-9">
						<div class="titulo">Registro Usuarios</div>
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
						<div class="subtitulo">Registro</div>
						<s:if test="( usuarioVO.mensaje != null && !usuarioVO.mensaje.equals(''))">
				          <div class="alert alert-danger" role="alert">
					     <a:property value="usuarioVO.mensaje" />
					</div>
				</s:if>
						<div class="row">
						    <div class="col-md-4">
								<!-- Etiqueta -->
								<label class="col-form-label">Id <i class="fa fa-question-circle icon-tooltip" data-toggle="tooltip" title="Id debe ser númerico"></i></label>
								<div class="row">
									<div class="col-md-8">
										<!-- Campo numerico -->
										<s:if test="banderaEnable == 0">
											<s:textfield class="result" name="usuarioVO.id" label="Customer Name" value="%{usuarioVO.id}" id="id" cssClass="form-control" placeholder="id de usuario"
												disabled="false" />
												
										</s:if>
										<s:elseif test="banderaEnable == 2 || banderaEnable == 3 || banderaEnable == 1">
											<s:hidden class="result" name="usuarioVO.id" label="Customer Name" value="%{usuarioVO.id}"></s:hidden>
											<s:textfield class="result" name="usuarioVO.id" label="Customer Name" value="%{usuarioVO.id}" id="id" cssClass="form-control" placeholder="id de usuario"
												disabled="true" />
										</s:elseif>
									</div>
									
								</div>
							</div>
						
						    <div class="col-md-4">
								<!-- Etiqueta -->
								<label class="col-form-label">Nombre <i class="fa fa-question-circle icon-tooltip" data-toggle="tooltip" title="Nombre completo del solicitante"></i>
								</label>
								<!-- Campo text -->
								<!-- data-isnull: coloca como obligatiorio un campo -->
								<!-- data-tipo: tipo de campo [texto -> recibe caracteres alfanumericos] -->
								<!-- data-toggle: Indica que utiliza tooltip  -->
								<s:if test="%{banderaEnable == 2 || banderaEnable == 0}">
								<s:textfield class="result" cssClass="form-control" name = "usuarioVO.nombre" label = "Customer Name"  value = "%{usuarioVO.nombre}" id="nombre" disabled="false"/>
								</s:if>
								<s:else>
								<s:textfield class="result" cssClass="form-control" name = "usuarioVO.nombre" label = "Customer Name"  value = "%{usuarioVO.nombre}" id="nombre" disabled="true"/>
							    </s:else>
							</div>						
							<div class="col-md-4">
								<!-- etiqueta -->
								<label class="col-form-label">Email <i class="fa fa-question-circle icon-tooltip" data-toggle="tooltip" title="Formato email: xxxxxx@xxxx.xxx"></i></label>
								<!-- Campo email -->
								<!-- data-tipo: tipo de campo [email -> recibe caracteres solo de email] -->
							   <s:if test="%{banderaEnable == 2 || banderaEnable == 0}">
								<s:textfield class="result" name = "usuarioVO.correo" cssClass="form-control" label = "Correo"  value = "%{usuarioVO.correo}" id="correo" disabled="false"/>
								</s:if>
								<s:else>
							    <s:textfield class="result" name = "usuarioVO.correo" cssClass="form-control" label = "Correo"  value = "%{usuarioVO.correo}" id="correo" disabled="true"/>
							    </s:else>
							</div>

						</div>
						<div class="row">
							<div class="col-md-4">
								<!-- Etiqueta -->
								<label class="col-form-label">Telefono <i class="fa fa-question-circle icon-tooltip" data-toggle="tooltip" title="Telefono debe contener 10 digitos"></i></label>
								<div class="row">
									<div class="col-md-12">
										<!-- Campo numerico -->
									   <s:if test="%{banderaEnable == 2 || banderaEnable == 0}">
							           	<s:textfield class="result" cssClass="form-control" name = "usuarioVO.telefono" label = "Correo"  value = "%{usuarioVO.telefono}" id="telefono" disabled="false"/>
								        </s:if>
								        <s:else>
									    <s:textfield class="result" cssClass="form-control" name = "usuarioVO.telefono" label = "Correo"  value = "%{usuarioVO.telefono}" id="telefono" disabled="true"/>
									    </s:else>
									</div>
								</div>
							</div>
							<div class="col-md-4">
								<!-- Etiqueta -->
								<label class="col-form-label">Contraseña<i class="fa fa-question-circle icon-tooltip" data-toggle="tooltip" title="Ejemplo numericos"></i></label>
								<div class="row">
									<div class="col-md-12">
										<!-- Campo numerico -->
										<s:if test="%{banderaEnable == 2 || banderaEnable == 0}">
							           	<s:textfield cssClass="form-control" class="result" name = "usuarioVO.password" label = "Password"  value = "%{usuarioVO.password}" id="password" disabled="false"/>
								        </s:if>
										<s:else>
									   <s:textfield cssClass="form-control" class="result" name = "usuarioVO.password" label = "Password"  value = "%{usuarioVO.password}" id="password" disabled="true"/>
									    </s:else>
									</div>
								</div>
							</div>
							<div class="col-md-4">
								<label for="selectEstados" class="col-form-label">Perfiles</label>
								<!-- Campo select -->
								
								<s:select list="usuarioVO.listaPerfiles" cssClass="form-control" listKey="id_perfil" listValue="perfil" name="usuarioVO.id_perfil" id="perfil" />
							    
							</div>
						
							
						</div>
					</div>
					
					<div class="row">
              <div class="col-md-12">
                <!--pruebaMensaje() funcion ejemplo para alert personalizado -->
               <s:if test="%{banderaEnable == 2}">
                  <button type="button" class="btn btn-primary btnsubmit" onclick="changeAction('modificar','crudUsuario')" >Modificar</button>
                </s:if>
                 <s:if test="%{banderaEnable == 3}">
                  <button type="button" class="btn btn-primary btnsubmit" onclick="validarEliminar()" >Eliminar</button>
                </s:if>
                <s:if test="%{banderaEnable == 0}">
                <button type="button" class="btn btn-primary btnsubmit" onclick="validar()" >Registrar</button>
                </s:if>
                <button type="button" class="btn btn-primary btnsubmit" onclick="changeAction('usuario','crudUsuario')" >Cancelar</button>
              </div>
            </div>
				</div>
			</div>
		</article>
	</s:form>
</body>
</html>