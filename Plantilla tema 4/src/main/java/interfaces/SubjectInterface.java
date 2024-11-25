package interfaces;

import java.util.List;

import entidades.Subject;

public interface SubjectInterface {
	
	public int createSubject(Subject subject);
	public List<Subject> listSubject();
	public Subject getSubject (String id);
	public int updateSubject(Subject subject);
	public int deleteSubject(String id);

}
