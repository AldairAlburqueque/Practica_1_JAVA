package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entidades.Subject;
import interfaces.SubjectInterface;
import util.MySqlConexion;

public class SubjectModel implements SubjectInterface {

	@Override
	public int createSubject(Subject subject) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub

		int value=0;
		Connection cn=null;
		PreparedStatement psm=null;

		try {
		cn=MySqlConexion.getConexion();
		/*query nativo**/
		String sql="INSERT INTO Subject VALUES (null,?,?,?,?)";
		psm=cn.prepareStatement(sql);
		/***/
		//psm=cn.prepareStatement("{call sp_RegisterCursos(null,?,?,?,?)}");
	
		psm.setString(1, subject.getCode());
		psm.setString(2, subject.getName());
		psm.setString(3, subject.getLevel());
		psm.setString(4, subject.getTeacher());

		value=psm.executeUpdate();
		} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		} finally {
			try {
				if(psm !=null) psm.close();
				if(cn !=null) cn.close();
		} catch (Exception e2) {
		// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return 0;
	}

	@Override
	public List<Subject> listSubject() {
		// TODO Auto-generated method stub
		List<Subject> listSubject = new ArrayList<Subject>();
		
		Connection cn = null;
		PreparedStatement psm = null;
		ResultSet rs = null;
		
		try {
			cn = MySqlConexion.getConexion();
			String sql = "SELECT * FROM Subject";
			psm = cn.prepareStatement(sql);
			rs=psm.executeQuery();
			
			while(rs.next()) {
				Subject subj = new Subject();
				subj.setId(rs.getString("idSubject"));
				subj.setCode(rs.getString("code"));
				subj.setName(rs.getString("name"));
				subj.setLevel(rs.getString("level"));
				subj.setTeacher(rs.getString("teacher"));
				listSubject.add(subj);
			}
		} catch(Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if(rs != null) rs.close();
					if(rs != null) psm.close();
					if(rs != null) cn.close();
				}catch (Exception e2){
					e2.printStackTrace();
				}
		}
		
		return listSubject;
	}

	@Override
	public Subject getSubject(String id) {
		// TODO Auto-generated method stub
		Subject subject = null;
		
		Connection cn=null;
		PreparedStatement psm =null;
		ResultSet rs = null;
		
		try {
			cn=MySqlConexion.getConexion();
			
			String sql="SELECT * FROM subject where idSubject=?";
			psm=cn.prepareStatement(sql);
			
			psm.setString(1, id);
			rs=psm.executeQuery();
			
			if(rs.next()) {
				subject = new Subject();
				subject.setId(rs.getString("idSubject"));
				subject.setCode(rs.getString("code"));
				subject.setName(rs.getString("name"));
				subject.setLevel(rs.getString("level"));
				subject.setTeacher(rs.getString("teacher"));
			}
			
		} catch (Exception e) {
			e.fillInStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(psm != null) psm.close();
				if(cn != null) cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return subject;
	}

	@Override
	public int updateSubject(Subject subject) {
		// TODO Auto-generated method stub
		int value=0;
		Connection cn = null;
		PreparedStatement psm = null;
		
		try {
			cn=MySqlConexion.getConexion();
			
			String sql ="UPDATE Subject SET code=?,name=?,level=?,teacher=? where idSubject=?";
			psm=cn.prepareStatement(sql);
			
			psm.setString(1, subject.getCode());
			psm.setString(2, subject.getName());
			psm.setString(3, subject.getLevel());
			psm.setString(4, subject.getTeacher());
			psm.setString(5, subject.getId());
			
			value=psm.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		} finally {
			try {
				if(psm !=null) psm.close();
				if(cn !=null) cn.close();
			} catch (Exception e2) {
			// TODO: handle exception
					e2.printStackTrace();
				}
			}

			return 0;
	}

	@Override
	public int deleteSubject(String id) {
		// TODO Auto-generated method stub
		int value=0;
		Connection cn = null;
		PreparedStatement psm = null;
		
		try {
			cn=MySqlConexion.getConexion();
			
			String sql ="DELETE FROM Subject where idSubject=?";
			psm=cn.prepareStatement(sql);
			
			psm.setString(1, id);
		
			value=psm.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			} finally {
				try {
					if(psm !=null) psm.close();
					if(cn !=null) cn.close();

			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();

				}
			}

			return 0;
	}

}
