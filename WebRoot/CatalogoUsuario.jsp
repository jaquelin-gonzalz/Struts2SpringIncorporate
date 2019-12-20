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
<link rel="stylesheet" href="<s:url value="/css/dataTables.bootstrap4.min.css"/>" />

<script type="text/javascript" src="<s:url value="/js/jquery.min.js"/>"></script>
<script type="text/javascript" src="<s:url value="/js/popper.min.js"/>"></script>
<script type="text/javascript" src="<s:url value="/js/bootstrap.min.js"/>"></script>
<script type="text/javascript" src="<s:url value="/js/jquery.dataTables.min.js"/>"></script>
<script type="text/javascript" src="<s:url value="/js/dataTables.bootstrap4.min.js"/>"></script>
<script type="text/javascript" src="<s:url value="/js/moment.min.js"/>"></script>
<script type="text/javascript" src="<s:url value="/js/utilSV.js"/>"></script><head>

<meta charset="ISO-8859-1">

<script type="text/javascript">
function changeAction(action, parameter) {
	var url = "<s:url value='/"+parameter+"/"+action+".action'/>";
	$("#formUsuario").attr("action", url);
	document.getElementById('formUsuario').submit();
}

</script>
<title>Catalogo Usuario</title>
</head>
<body>
<s:form action="usuario" namespace="/usuario" id="formUsuario">

    <header class="container">
		<div class="jumbotron">
			<div class="row">
				<div class="col-2">
					<img src="<s:url value="/img/logo.jpg"/>" alt="" class="logotipo">
				</div>
				<div class="col-10">
					<div class="titulo">Catalogo Usuario</div>
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

					<!--  subtitulo  -->
					<div class="subtitulo">
						<!-- div listado -->
						<span>Catálogo Usuarios</span>
					</div>
					<br>
					<div class="listado">
						<!-- Tabla dinamica -->
						<!-- Contiene ejemplo de checkbox para seleccionar todo -->
						<!-- Contiene ejemplo para busqueda de informacion -->
						<!-- Contiene ejemplo para organizar datos -->
						
						<table name="tabla" class="table table-hover table-sm">

							<thead>
								<tr>
									<!--  Celdad de titulos  -->
									

                                 
									<th scope="col">Acciones</th>
									<th scope="col">ID</th>
									<th scope="col">NOMBRE</th>
									<th scope="col">PERFIL</th>

								</tr>
							</thead>
							<tbody>
							

								<s:iterator value="usuarioVO.listaUsuarios">
									<tr>
										<!--  Celdad de titulos  -->
										<td><a href="<s:url action="crudUsuario/resultadoBuscar.action"  > <s:param name="usuarioVO.id"><s:property value="id"/></s:param> <s:param name="banderaEnable" >1</s:param> </s:url>"><i class="fa fa-search-plus fa-lg" data-toggle="tooltip" title="Busqueda" ></i></a> 
										    <a href="<s:url action="crudUsuario/resultadoBuscar.action"  > <s:param name="usuarioVO.id"><s:property value="id"/></s:param> <s:param name="banderaEnable" >2</s:param></s:url>"><i class="fa fa-pencil-square-o fa-lg" data-toggle="tooltip" title="Modificar" ></i></a>
										    <a href="<s:url action="crudUsuario/resultadoBuscar.action"  > <s:param name="usuarioVO.id"><s:property value="id"/></s:param> <s:param name="banderaEnable" >3</s:param></s:url>"><i class="fa fa-trash-o fa-lg" data-toggle="tooltip" title="Eliminar" ></i></a>
										</td>
										<td><s:property value="id" /></td>
										<td><s:property value="nombre" /></td>
										<td><s:property value="perfil" /></td>

									</tr>
								</s:iterator>
							</tbody>
						</table>
					</div>
					<br>
					<div class="row">
						<div class="col-md-12">
							<button type="button" class="btn btn-primary btnsubmit" onclick="changeAction('inicioCrudUsuario','crudUsuario') " >
								<i class="fa fa-plus"></i>Nuevo
							</button>
						</div>
					</div>
				</div>
				<br>
				<div class="row">
					<div class="col-md-12">
						<!--pruebaMensaje() funcion ejemplo para alert personalizado -->
						<button type="button" class="btn btn-primary btnsubmit"
							onclick="changeAction('regresar','principal')">Regresar</button>
					</div>
				</div>
			</div>
		</article>
	
	
</s:form>
</body>
</html>