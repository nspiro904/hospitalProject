package com.example.demo.service;

import java.sql.*;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.example.demo.api.model.Department;
import com.example.demo.api.model.Doctor;
import com.example.demo.api.model.HealthRecord;
import com.example.demo.api.model.Interaction;
import com.example.demo.api.model.Medication;
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
		
		String qInteractions = "SELECT IDate, Description, Interaction_ID, Time "
				+ "FROM interaction_record "
				+ "WHERE Patient = '" + pssn + "'";
		Statement stmtI = conn.createStatement();
		ResultSet iset = stmtI.executeQuery(qInteractions);
		
		while( iset.next() ) {
			String date = iset.getString(1);
			String description = iset.getString(2);
			String iid = iset.getString(3);
			String time = iset.getString(4);
			
			ilist.add(new Interaction(patient, iid, date, description, time ));
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
		
		conn.close();
		return record;
	}
	
	public Boolean addPatient(Patient p) throws SQLException {
		
		Boolean success;
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

			String prepared = "INSERT INTO PATIENT(Ssn, Patient_id, First_name, Middle_init, Last_name, Curr_address, Curr_phone, Perm_address, Perm_phone, Condition, Birth_date, Sex, Primary_doc, Secondary_doc)" +
			"VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		PreparedStatement insert = conn.prepareStatement( prepared);

		insert.setString(1, p.getSsn());
		insert.setString(2, p.getId());
		insert.setString(3, p.getFname());
		insert.setString(4, Character.toString(p.getMinit()));
		insert.setString(5, p.getLname());
		insert.setString(6, p.getAddressCurrent());
		insert.setString(7, p.getPhoneCurrent());
		insert.setString(8, p.getAddressPermanent());
		insert.setString(9, p.getPhonePermanent());
		insert.setString(10, p.getCondition());
		insert.setString(11, p.getBdate());
		insert.setString(12, p.getSex());
		insert.setString(13, p.getDocPrimary());
		insert.setString(14, p.getDocSecondary());
		
		
		
		
		success = insert.execute();
		conn.close();	
		return success;
		
	}
	
	public Boolean addDepartment(Department d) throws SQLException {
		
		Boolean success;
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
		
		success = insert.execute();
		conn.close();	
		return success;
		
	}

	public Boolean addDoctor(Doctor d) throws SQLException {

		Boolean success;
		String uid = "G06";
		String password = "3iz2a6uT";
		String url = "jdbc:oracle:thin:@cisvm-oracle.unfcsd.unf.edu:1521:orcl";
		
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		 
				Connection conn = DriverManager.getConnection (url, uid, password);

		PreparedStatement insert = conn.prepareStatement("INSERT INTO DOCTOR(Ssn, Doctor_id, First_name, Middle_init, Last_name, Address, Phone_num, Contact_num, Birth_date, Works_in) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		
		insert.setString(1, d.getSsn());
		insert.setString(2, d.getDid());
		insert.setString(3, d.getFname());
		insert.setString(4, Character.toString(d.getMinit()));
		insert.setString(5, d.getLname());
		insert.setString(6, d.getAddress());
		insert.setString(7, d.getPhone());
		insert.setString(8, d.getPhoneContact());
		insert.setString(9, d.getBdate());
		insert.setString(10, d.getDepartment());

		success = insert.execute();
		conn.close();	
		return success;
		
	}


	public Boolean addProcedure(Procedure p) throws SQLException {

		Boolean success;
		String uid = "G06";
		String password = "3iz2a6uT";
		String url = "jdbc:oracle:thin:@cisvm-oracle.unfcsd.unf.edu:1521:orcl";
		
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		 
						Connection conn = DriverManager.getConnection (url, uid, password);

		PreparedStatement insert = conn.prepareStatement("INSERT INTO PROCEDURE(Proc_num, Name, Description, Offered_by, Duration) VALUES(?, ?, ?, ?, ?)");

		insert.setString(1, p.getProcNum());
		insert.setString(2, p.getName());
		insert.setString(3, p.getDescription());
		insert.setString(4, p.getOfferedBy());
		insert.setInt(5, p.getDuration());
		
		success = insert.execute();
		conn.close();	
		return success;
		
		
	}

	public Boolean addInteraction(Interaction i) throws SQLException {

		Boolean success;
		String uid = "G06";
		String password = "3iz2a6uT";
		String url = "jdbc:oracle:thin:@cisvm-oracle.unfcsd.unf.edu:1521:orcl";
		
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
						Connection conn = DriverManager.getConnection (url, uid, password);

		
		PreparedStatement insert = conn.prepareStatement("INSERT INTO INTERACTION_RECORD(Patient, Interaction_ID, IDate, Time) VALUES(?, ?, ?, ?)");

		insert.setString(1, i.getPatient().getSsn());
		insert.setString(2, i.getId());
		insert.setString(3, i.getDate());
		insert.setString(4, i.getTime());
		
		success = insert.execute();
		conn.close();	
		return success;
		
		}

		
	public Boolean addMedication(Medication m) throws SQLException {

		Boolean success;
		String uid = "G06";
		String password = "3iz2a6uT";
		String url = "jdbc:oracle:thin:@cisvm-oracle.unfcsd.unf.edu:1521:orcl";
		
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		 				Connection conn = DriverManager.getConnection (url, uid, password);


			PreparedStatement insert = conn.prepareStatement("INSERT INTO MEDICATION(Name, Manufacturer, Description) VALUES(?, ?, ?)");

			insert.setString(1, m.getName());
			insert.setString(2, m.getManufacturer());
			insert.setString(3, m.getDescription());
			
			success = insert.execute();
		conn.close();	
		return success;
		
			}


	public Boolean recordProcedure(ProcedureRecord r) {

		Boolean success;
		String uid = "G06";
		String password = "3iz2a6uT";
		String url = "jdbc:oracle:thin:@cisvm-oracle.unfcsd.unf.edu:1521:orcl";
		
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		Connection conn = DriverManager.getConnection (url, uid, password);

		PreparedStatement insert = conn.prepareStatement("INSERT INTO PROCEDURES_UNDERTAKEN(Patient, Proc_num, PDate, Time, Doctor, Description) VALUES(?, ?, ?, ?, ?, ?)");

		insert.setString(1, r.getPatient().getSsn());
		insert.setString(2, r.getProcedure().getProcNum());
		insert.setString(3, r.getPdate());
		insert.setString(4, r.getTime());
		insert.setString(5, r.getDoctor().getSsn());
		insert.setString(6, r.getDescription());

		success = insert.execute();
		conn.close();	
		return success;
		

	}

	public Boolean addPrescription(Prescription p) {

		Boolean success;
		String uid = "G06";
		String password = "3iz2a6uT";
		String url = "jdbc:oracle:thin:@cisvm-oracle.unfcsd.unf.edu:1521:orcl";
		
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		Connection conn = DriverManager.getConnection (url, uid, password);

		PreparedStatement insert = conn.prepareStatement("INSERT INTO PRESCRIPTIONS(Patient, Medication, Prescriber, PDate) VALUES(?,?,?,?)");

		insert.setString(1, p.getPatient().getSsn());
		insert.setString(2, p.getMedication());
		insert.setString(3, p.getPrescriber().getSsn());
		insert.setString(4, p.getDate());

		success = insert.execute();
		conn.close();	
		return success;
		
		
	}

	public Object[] getProceduresCode(String dcode) {

		ArrayList<Procedure> list = new ArrayList<Procedure>();

		String uid = "G06";
		String password = "3iz2a6uT";
		String url = "jdbc:oracle:thin:@cisvm-oracle.unfcsd.unf.edu:1521:orcl";
		
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		Connection conn = DriverManager.getConnection (url, uid, password);

		Statement stmt = conn.createStatement();

		String query = "SELECT P.PROC_NUM as procnum, P.NAME as pname " +
					"FROM PROCEDURE P " +
					"JOIN DEPARTMENT D ON P.OFFERED_BY = D.CODE " +
					"WHERE D.CODE = '" + dcode + "'";

		ResultSet rset = stmt.executeQuery(query);

		while(rset.next()) {
			String pnum = rset.getString("procnum");
			String pname = rset.getString("pname");
			list.add(new Procedure(pnum, pname, "", "", 0));
		}

		return list.toArray();
	}
		

}
