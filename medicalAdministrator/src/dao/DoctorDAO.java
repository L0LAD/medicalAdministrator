package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import control.Doctor;

public class DoctorDAO {

	public List<Doctor> findAll() {
		List<Doctor> doctors = new ArrayList<> () ;
		try {
	         String sql = "SELECT * FROM doctor ORDER BY last_name" ;
	         Connection conn = DBUtil.getConnection () ;
	         PreparedStatement ps = conn.prepareStatement (sql) ;
	         ResultSet rs = ps.executeQuery () ;
	         while (rs.next ()) {
	            Doctor doctor = new Doctor (rs.getInt("doctor_id"), rs.getString ("last_name"), rs.getString ("first_name")) ;
	              doctors.add (doctor) ;
	         }
	         rs.close () ;
	         ps.close () ;
	         conn.close () ;
		} catch (SQLException sqle) {
	         try {
				throw new MedicalRecordException (sqle.getMessage ()) ;
			} catch (MedicalRecordException e) {
				e.printStackTrace();
			}
	      }
		return doctors;
	}

}
