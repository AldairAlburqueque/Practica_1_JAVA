<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<body>
<div class="container min-vh-100 d-flex justify-content-center align-items-center">
<div class="col-6">
		<h3>Registrar Curso</h3>
		<form action="SubjectServlet" method="post">
			<input type="hidden" name="type" value="register">
			<div class="form-group">
				<label>Código</label> <input class="form-control" type="text"
					name="txtCode">
			</div>
			<div class="form-group">
				<label>Nombre</label> <input class="form-control" type="text"
					name="txtName">
			</div>
			<div class="form-group">
				<label>Nivel</label> <input class="form-control" type="text"
					name="txtLevel">
			</div>
			<div class="form-group">
				<label>Profesor</label> <input class="form-control" type="text"
					name="txtTeacher">
			</div>
			<br>
			<input type="submit" class="btn btn-primary" value="Enviar Datos">
			<button type="button" class="btn btn-primary" onclick="location.href='SubjectServlet?type=list'">Regresar</button>
		</form>
	</div>
</div>
	
</body>
</html>