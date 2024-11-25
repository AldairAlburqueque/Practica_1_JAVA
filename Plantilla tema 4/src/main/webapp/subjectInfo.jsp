<%@page import="entidades.Subject"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- Procurar que en este apartado siempre vayan los css -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<body>
<div class="container min-vh-100 d-flex justify-content-center align-items-center">


<div class="col-6">
	<form action="SubjectServlet" method="post">
	<%
		Subject subject= (Subject) request.getAttribute("data");
	%>
	<input type="hidden" name="type" value="edit">
	<input type="hidden" name="idSubject" value="<%=subject.getId()%>"> 
	<div class="form-group">
		<label class="text-secondary">Codigo</label>
		<input class="form-control" type="text" name="txtCode" 
		value="<%=(subject!=null)? subject.getCode():""%>">
	</div>
	<div class="form-group">
		<label class="text-secondary">Nombre</label>
		<input class="form-control" type="text" name="txtName" 
		value="<%=(subject!=null)? subject.getName():""%>">
	</div>
	<div class="form-group">
		<label class="text-secondary">Nivel</label>
		<input class="form-control" type="text" name="txtLevel" 
		value="<%=(subject!=null)? subject.getLevel():""%>">
	</div>
	<div class="form-group">
		<label class="text-secondary">Profesor</label>
		<input class="form-control" type="text" name="txtTeacher"
		value="<%=(subject!=null)? subject.getTeacher():""%>">
	</div>
	<br>
	<input type="submit" class="btn btn-primary" value="Actualizar datos">
	<button type="button" class="btn btn-primary" onclick="location.href='SubjectServlet?type=list'">Regresar</button>
</form>
</div>
</div>

</body>
</html>