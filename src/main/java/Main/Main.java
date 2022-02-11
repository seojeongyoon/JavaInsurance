package Main;

import java.util.List;

import Login.Login;
import Login.LoginDAO;
import Mybatis.Mybatis;

public class Main {

	public Main() {
		this.initialize();
	}
	private void initialize() {
		LoginDAO loginDAO = new LoginDAO(Mybatis.getSqlSessionFactory());
		
		List<Login> login = loginDAO.getAllLogin();
		for(Login loginlist:login) {
			System.out.println(loginlist.getId()+", "+loginlist.getPassword());
		}
	}
	
	public static void main(String[] args) {
		Main main = new Main();	
	}
}
