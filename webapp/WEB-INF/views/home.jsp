<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Bienvenido a Cineapp</title>
</head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
<spring:url value="/resources" var="urlPublic" />
<body>

${urlPublic}
<div class="panel panel-default">
  <div class="panel-heading">Panel heading without title</div>
  <div class="panel-body">
    Panel content
  </div>
</div>

	<div class="panel panel-default">
	  <div class="panel-heading">Tabla de Peliculas</div>
	  <div class="panel-body">
		<table class="table table-striped table-hover table-bordered"> 
			<thead>
				<tr>
					<th>Id</th>
					<th>Titulo</th>
					<th>Duracion</th>
					<th>Clasificacion</th>
					<th>Genero</th>
					<th>Imagen</th>
					<th>Fecha Estreno</th>
					<th>Estatus</th>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach items="${peliculas}" var="pelicula">
					<tr>
						<td>${pelicula.id}</td>
						<td>${pelicula.titulo}</td>
						<td>${pelicula.duracion}</td>
						<td>${pelicula.clasificacion}</td>
						<td>${pelicula.genero}</td>
						<td> <img src="${urlPublic}/images/${pelicula.imagen}" alt="${pelicula.titulo}" width="80px" height="100px" > </td>
						<td>
							<fmt:formatDate value="${pelicula.fechaEstreno}" pattern="dd-MM-yyyy"/>	
						</td>
						<td>
						<c:choose>
							<c:when test="${pelicula.estatus=='Activa'}">
							<span class="label label-success"> ${pelicula.estatus} </span>
							</c:when>
							<c:otherwise>
							<span class="label label-danger"> ${pelicula.estatus} </span>
							</c:otherwise>
						</c:choose>
						</td>
					</tr>
				</c:forEach>	
			
			</tbody>
		
		</table>
	  </div>
	</div>
	
</body>
</html>