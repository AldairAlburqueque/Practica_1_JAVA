package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Subject;
import modelo.SubjectModel;

/**
 * Servlet implementation class SubjectServlet
 */
@WebServlet("/SubjectServlet")
public class SubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String type=request.getParameter("type");
		System.out.println("El type enviado es: " + type);
		
		switch(type) {
		case "list" : listSubject(request, response); break;
		case "register" : registerSubject(request, response); break;
		case "info" : getSubject(request, response); break;
		case "edit": editSubject(request,response);break;
		case "delete" : deleteSubject(request, response); break;
		default : 
			request.setAttribute("mesagge", "ocurrio un problema");
			request.getRequestDispatcher("subject.jsp").forward(request, response);
		}
		
	}


	private void deleteSubject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id=request.getParameter("id");
		
		SubjectModel subjectModel=new SubjectModel();
		int value=subjectModel.deleteSubject(id);
		
		if(value==0) {
			System.out.println("Envia al listado");
			listSubject(request, response);
		}else {
			request.setAttribute("mensaje", "Ocurrio un problema");
			request.getRequestDispatcher("subject.jsp");
		}
		
	}


	private void editSubject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String code = request.getParameter("txtCode");
		String name = request.getParameter("txtName");
		String level = request.getParameter("txtLevel");
		String teacher = request.getParameter("txtTeacher");
		String idSubject = request.getParameter("idSubject");
		
		Subject subject = new Subject();
		subject.setCode(code);
		subject.setName(name);
		subject.setLevel(level);
		subject.setTeacher(teacher);
		subject.setId(idSubject);
		
		SubjectModel model = new SubjectModel();
		int value=model.updateSubject(subject);
		
		if(value==0) {
			System.out.println("Envio al listado");
			listSubject(request, response);
		}else {
			request.setAttribute("mensaje", "Ocurrio un problema");
			request.getRequestDispatcher("subject.jsp");
		}
		
		
	}


	private void getSubject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idSubject = request.getParameter("id");
		
		SubjectModel subject = new SubjectModel();		
		Subject data = subject.getSubject(idSubject);
;		
		request.setAttribute("data", data);
	
		request.getRequestDispatcher("subjectInfo.jsp").forward(request, response);
		
	}


	private void registerSubject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String code = request.getParameter("txtCode");
		String name = request.getParameter("txtName");
		String level = request.getParameter("txtLevel");
		String teacher = request.getParameter("txtTeacher");
		
		Subject subject = new Subject();
		subject.setCode(code);
		subject.setName(name);
		subject.setLevel(level);
		subject.setTeacher(teacher);
		
		SubjectModel model = new SubjectModel();
		int value = model.createSubject(subject);
		
		if (value == 0) {
			listSubject(request, response);
		} else {
			request.setAttribute("mensage", "Ocurrio un problema");
			request.getRequestDispatcher("subject.jsp");
		}
	}


	private void listSubject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		SubjectModel subjectModel = new SubjectModel();
		
		List<Subject> data = subjectModel.listSubject();
		
		request.setAttribute("data", data);
		request.getRequestDispatcher("subject.jsp").forward(request, response);
		
	}

}
