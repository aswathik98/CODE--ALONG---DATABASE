package mainapp;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterDAO {
	public void adduser(RegisterPojo registerpojo) throws ClassNotFoundException, SQLException{
		 String firstname= registerpojo.getFirstname();
		 String lastname = registerpojo.getLastname();
		 String usrname = registerpojo.getUsername();
		 String password = registerpojo.getPassword();
		 String email = registerpojo.getEmail();
		 
		 ConnectionManager cm = new ConnectionManager();
		 //insert all the details into database
		 String sql ="insert into USRDETAILS(FIRSTNAME,LASTNAME,USRNAME,PASSWORD,EMAIL)VALUES(?,?,?,?,?)";
		 //create statement objects
		 PreparedStatement st = cm.getConnection().prepareStatement(sql);
		 
		 
		 st.setString(1, firstname);
		 st.setString(2, lastname);
		 st.setString(3, usrname);
		 st.setString(4, password);
		 st.setString(5, email);
		 
		st.executeUpdate();
		cm.getConnection().close();
		 
	}

}
