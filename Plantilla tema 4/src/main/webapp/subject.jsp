<%@page import="entidades.Subject"%>
<%@page import="java.util.List"%>
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
	<div class="container">
		<div class="row">
			<div class="col-12 text-center">
				<h3>Mantenimiento de Cursos</h3>
			</div>
			<div class="col-12">
				<button type="button" class="btn btn-primary"
					onclick="window.location='subjectRegister.jsp'">Registrar</button>
			</div>
			<br>
			<div class="col-12">
					<table class="table">
						<thead>
							<tr>
								<th>Id</th>
								<th>Código</th>
								<th>Nombre</th>
								<th>Nivel</th>
								<th>Profesor</th>
								<th>Acciones</th>
							</tr>
						</thead>
						<tbody>
						<%List<Subject> listSubject=(List<Subject>) request.getAttribute("data");
						
							if(listSubject != null) {
								for(Subject item: listSubject) {%>
									<tr>
										<td><%=item.getId() %></td>
										<td><%=item.getCode() %></td>
										<td><%=item.getName() %></td>
										<td><%=item.getLevel() %></td>
										<td><%=item.getTeacher() %></td>
										<td>
											<a href="SubjectServlet?type=info&id=<%=item.getId()%>" id=""><img alt="" src="img/ic_info.png" width="20" height="20"></a>
											<a href="SubjectServlet?type=delete&id=<%=item.getId()%>" id=""><img alt="" src="img/ic_delete.png" width="20" height="20"></a>
										</td>
									</tr>
								<%	
								}
							}
						
						%>
							
						</tbody>
					</table>
			</div>
		</div>

		<div class="row"></div>
	</div>
</body>
</html>