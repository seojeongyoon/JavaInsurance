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

	private void service() { // service �и� �� ����
		this.sc = new Scanner(System.in);
		this.home.service(sc);
	}

	private void initialize() { // �ʱ�ȭ �ϱ�
		this.instatntiation();
		this.setSqlSession();
		this.associate();
	}

	private void instatntiation() { // associate�ϴ� �ٸ� Ŭ���� ��ü �����
		this.home = new Home();
		this.home.instantiation();
	}

	private void setSqlSession() { // SQL ����
		this.sqlSession = MyBatisConnection.getSqlSessionFactory().openSession();
		this.home.setSqlSession(this.sqlSession);
	}

	private void associate() { // �ٸ� Ŭ������ ����
		this.home.associate();

	}

	public static void main(String[] args) {
		Main main = new Main();
		main.initialize();
		main.service();
	}

}
