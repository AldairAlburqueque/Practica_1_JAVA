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
	integrity="sha384-
1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h2>Iniciar Sesión</h2>
		<form action="SubjectServlet2" method="post">
		<input type="hidden" name="type" value="load">
			<label for="email">Correo</label> <input type="email" name="email"
				id="email" placeholder="Correo" /> <label for="password">Clave</label>
			<input type="password" name="password" id="password"
				placeholder="Contraseña" />
			<button type="submit" class="btn btn-primary">Iniciar Sesión</button>
		</form>
	</div>
</body>
</html>