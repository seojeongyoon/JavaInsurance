package Home;

import Employee.Employee;

import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;

import Customer.Customer;
import Login.Login;
import InsuranceItem.InsuranceItem;

public class Home {

	private boolean isLogin;
	private int menuNum;
	private String id;
	private String password;

	private Employee employee;
	private Customer customer;
	private Login login;
	private InsuranceItem insuranceItem;

	@SuppressWarnings("resource")
	public void service(Scanner sc) { // service 분리 및 연결
		while (true) {
			this.homeMenu(sc);
			this.provideService(sc); // 로그인 기능 구현 시 이동하기
		}
	}

	private void homeMenu(Scanner sc) {
		this.menuNum = this.showHomeMenu(sc);
		if (menuNum == 1) {
			this.login(sc);
		} else if (menuNum == 2) {
			this.signUp();
		} else if (menuNum == 3) {
			this.findIdPw();
		} else if (menuNum == 4) {
			this.exit();
		} else {
			this.showMenuErrorMessage();

		}

	}

	private void signUp() {

	}

	private void findIdPw() {

	}

	private void exit() {
		this.showExitMessage();
		System.exit(0);
	}

	private void login(Scanner sc) {
		this.isLogin = false;
		while (!isLogin) {
			this.id = this.getLoginId(sc);
			this.password = this.getLoginPw(sc);

			if (this.login.login(id, password)) {

				this.isLogin = true;

			} else {
				this.wrongIdPwMessage();

				this.login(sc);
			}
		}
	}

	private String getLoginId(Scanner sc) {
		this.loginIdMessage();

		return sc.next();
	}

	private String getLoginPw(Scanner sc) {
		this.loginPwMessage();

		return sc.next();
	}

	private void provideService(Scanner sc) {
	}

	public void instantiation() { // 다른 클래스를 new

		this.employee = new Employee();
		this.customer = new Customer();
		this.login = new Login();
		this.insuranceItem = new InsuranceItem();
		this.insuranceItem.instantiation();

	}

	public void setSqlSession(SqlSession sqlSession) { // SQL 연결
		this.login.setSqlSession(sqlSession);
	}

	public void associate() { // 다른 클래스와 연결
		this.employee.associate(this.customer, this.login, this.insuranceItem);
		this.customer.associate(this.insuranceItem);
		this.login.associate();
		this.insuranceItem.associate();
	}

	private int showHomeMenu(Scanner sc) {
		System.out.println("<메뉴>");
		System.out.println("-------------------");
		System.out.println("메뉴에서 숫자를 선택해주세요.");
		System.out.println("1. 로그인 ");
		System.out.println("2. 회원가입 ");
		System.out.println("3. 아이디, 비밀번호 찾기 ");
		System.out.println("4. 나가기 ");
		return sc.nextInt();

	}

	private void showMenuErrorMessage() {
		System.out.println("-------------------");
		System.out.println("잘못 입력했습니다! 올바른 메뉴를 선택해주세요.");
		System.out.println("-------------------");

	}

	private void loginIdMessage() {
		System.out.println("<로그인>");
		System.out.println("-------------------");
		System.out.println("1. 아이디를 입력해주세요.");
	}

	private void loginPwMessage() {
		System.out.println("2. 비밀번호를 입력해주세요.");
	}

	private void wrongIdPwMessage() {
		System.out.println("-------------------");
		System.out.println("아이디 또는 비밀번호를 잘못 입력했습니다. 입력하신 내용을 다시 확인해주세요.");

	}

	private void showExitMessage() {
		System.out.println("-------------------");
		System.out.println("프로그램을 종료합니다.");
	}

}
