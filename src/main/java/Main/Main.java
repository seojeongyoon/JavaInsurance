package Main;

import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;

import Home.Home;
import Mybatis.MyBatisConnection;

public class Main {

	private Scanner sc;
	private SqlSession sqlSession;

	private Home home;

	private Main() {
	}

	private void service() { // service 분리 및 연결
		this.sc = new Scanner(System.in);
		this.home.service(sc);
	}

	private void initialize() { // 초기화 하기
		this.instatntiation();
		this.setSqlSession();
		this.associate();
	}

	private void instatntiation() { // associate하는 다른 클래스 객체 만들기
		this.home = new Home();
		this.home.instantiation();
	}

	private void setSqlSession() { // SQL 연결
		this.sqlSession = MyBatisConnection.getSqlSessionFactory().openSession();
		this.home.setSqlSession(this.sqlSession);
	}

	private void associate() { // 다른 클래스와 연결
		this.home.associate();

	}

	public static void main(String[] args) {
		Main main = new Main();
		main.initialize();
		main.service();
	}

}
