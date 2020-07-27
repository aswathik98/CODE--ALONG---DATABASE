package mainapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

		System.out.println("1.Register here");
		System.out.println("2.Login");
		int x;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		x = Integer.parseInt(br.readLine());
		
		//objects
		
		RegisterPojo registerpojo = new RegisterPojo();
		RegisterDAO registerdao = new RegisterDAO();
		LoginPojo loginpojo = new LoginPojo();
		LoginDAO logindao = new LoginDAO();
		
		switch(x) {
		case 1 :
			System.out.println("Enter first name :");
			String firstname = br.readLine();
			System.out.println("ENter lastname:");
			String lastname = br.readLine();
			System.out.println("ENter username:");
			String usrname = br.readLine();
			System.out.println("ENter password:");
			String password = br.readLine();
			System.out.println("Enter email:");
			String email = br.readLine();
			registerpojo.setFirstname(firstname);
			registerpojo.setLastname(firstname);
			registerpojo.setUsername(usrname);
			registerpojo.setPassword(password);
			registerpojo.setEmail(email);
			
			registerdao.adduser(registerpojo);
			
			break;
		case 2: 
			System.out.println("ENter username:");
			String user = br.readLine();
			System.out.println("ENter password:");
			String pass = br.readLine();
			
			loginpojo.setUsrname(user);
			loginpojo.setPassword(pass);
			
			if(logindao.validate(loginpojo)==true) {
				Luck luck = new Luck();
				luck.display();
			}
			else {
				System.out.println("Incorrect username and password");
			}
			
			break;
	}

	}
}
