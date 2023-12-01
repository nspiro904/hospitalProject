package com.example.demo.service;

import java.sql.*;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.example.demo.api.model.Department;
import com.example.demo.api.model.HealthRecord;
import com.example.demo.api.model.Interaction;
import com.example.demo.api.model.Patient;
import com.example.demo.api.model.Prescription;
import com.example.demo.api.model.Procedure;
import com.example.demo.api.model.ProcedureRecord;

@Service
public class ApiService {

	
	
	public HealthRecord getHealthRecord(String id) throws SQLException {
		
		Patient patient;
		Object[] interactions;
		Object[] prescriptions;
		Object[] procedures;
		HealthRecord record = null;
		
		String uid = "G06";
		String password = "3iz2a6uT";
		String url = "jdbc:oracle:thin:@cisvm-oracle.unfcsd.unf.edu:1521:orcl";
		
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		 
		Connection conn = DriverManager.getConnection (url, uid, password);
		
		Statement stmt = conn.createStatement();
		
		//test pid is 7654321
		
		String q = "SELECT p.First_name, p.Last_name, p.Middle_init, p.Curr_address, p.Curr_phone, p.Primary_doc"
				+ ", d.First_name as Doc_fname, d.Last_name as Doc_lname, p.ssn as pssn "
				+ " FROM PATIENT p"
				+ " JOIN doctor d ON d.ssn = p.Primary_doc"
				+ " WHERE p.Patient_id = '" + id + "'";
		
		
		ResultSet rset = stmt.executeQuery(q);
		// Switch to using numerical col indices in getString, or give col aliases.
		while( rset.next()) {
		String fname = rset.getString(1);
		String minit= rset.getString("Middle_init");
		String lname = rset.getString("Last_name");
		String address = rset.getString("Curr_address");
		String phone = rset.getString("Curr_phone");
		String primary = rset.getString("Doc_fname") + " " + rset.getString("Doc_lname");
		String pssn = rset.getString("pssn");
		
		patient = new Patient(pssn, id, fname, lname);
		patient.setMinit(minit.charAt(0));
		patient.setAddressCurrent(address);
		patient.setPhoneCurrent(phone);
		patient.setDocPrimary(primary);
		
		ArrayList<ProcedureRecord> plist = new ArrayList<ProcedureRecord>();
		
		String qProcedures = "SELECT proc.Name, pund.PDate "
				+ "FROM procedures_undertaken pund "
				+ "JOIN procedure proc ON pund.Proc_num = proc.Proc_num "
				+ "WHERE Patient = '" + pssn + "'";
		Statement stmtP = conn.createStatement();
		ResultSet pset = stmtP.executeQuery(qProcedures);
		while( pset.next() ) {
			String procedure = pset.getString(1);
			String pdate = pset.getString(2);
			plist.add(new ProcedureRecord(patient, procedure, pdate));
		}
		procedures = plist.toArray();
		
		ArrayList<Interaction> ilist = new ArrayList<Interaction>();
		
		String qInteractions = "SELECT IDate, Description, Interaction_ID "
				+ "FROM interaction_record "
				+ "WHERE Patient = '" + pssn + "'";
		Statement stmtI = conn.createStatement();
		ResultSet iset = stmtI.executeQuery(qInteractions);
		
		while( iset.next() ) {
			String date = iset.getString(1);
			String description = iset.getString(2);
			String iid = iset.getString(3);
			
			ilist.add(new Interaction(patient, iid, date, description ));
		}
		interactions = ilist.toArray();
		
		ArrayList<Prescription> slist = new ArrayList<Prescription>();
		
		String qPrescriptions = "SELECT medication, PDate "
				+ "FROM prescriptions "
				+ "WHERE Patient = '" + pssn + "'";
		Statement stmtM = conn.createStatement();
		ResultSet mset = stmtM.executeQuery(qPrescriptions);
		while( mset.next() ) {
			String medication = mset.getString(1);
			String date = mset.getString(2);
			slist.add(new Prescription(patient, medication, date));
			
		}
		
		prescriptions = slist.toArray();
		record = new HealthRecord( patient, prescriptions, interactions, procedures);
		}
		
		return record;
	}
	
	public void addPatient(Patient p) throws SQLException {
		
		 String uid = "G06";
			
		    //System.out.print("password: ");
		    String pword = "3iz2a6uT";
		
		    String url = "jdbc:oracle:thin:@cisvm-oracle.unfcsd.unf.edu:1521:orcl";
		
		    // Load the Oracle JDBC driver
		
		    DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		
		    // Connect to the database
		    
		    Connection conn = DriverManager.getConnection (url, uid, pword);
		    System.out.println("Connection Successful");
		
		    // Create a Statement
		
		    Statement stmt = conn.createStatement();
		    
		    
		String insert = "INSERT INTO PATIENT(Ssn, Patient_id, First_name, Middle_init, Last_name, Curr_address, Curr_phone, Perm_address, Perm_phone, Condition, Birth_date, Sex, Primary_doc, Secondary_doc) VALUES(";
		
		
		
		stmt.executeQuery(insert);
		
	}
	
	public Boolean addDepartment(Department d) throws SQLException {
		
		String uid = "G06";
		String password = "3iz2a6uT";
		String url = "jdbc:oracle:thin:@cisvm-oracle.unfcsd.unf.edu:1521:orcl";
		
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		 
		Connection conn = DriverManager.getConnection (url, uid, password);
		
		
		PreparedStatement insert = conn.prepareStatement("INSERT INTO DEPARTMENT(Code, Name, Office_num, Office_phone, Head_of)"
				+ " VALUES(?, ?, ?, ?, ?)");
		
		insert.setString(1, d.getDcode());
		insert.setString(2, d.getName());
		insert.setInt(3, d.getOfficeNumber());
		insert.setString(4, d.getOfficePhone());
		insert.setString(5, d.getOfficeHead());
		
		return insert.execute();
	}

}
