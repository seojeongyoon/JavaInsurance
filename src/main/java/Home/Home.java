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
	public void service(Scanner sc) { // service �и� �� ����
		while (true) {
			this.homeMenu(sc);
			this.provideService(sc); // �α��� ��� ���� �� �̵��ϱ�
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

	public void instantiation() { // �ٸ� Ŭ������ new

		this.employee = new Employee();
		this.customer = new Customer();
		this.login = new Login();
		this.insuranceItem = new InsuranceItem();
		this.insuranceItem.instantiation();

	}

	public void setSqlSession(SqlSession sqlSession) { // SQL ����
		this.login.setSqlSession(sqlSession);
	}

	public void associate() { // �ٸ� Ŭ������ ����
		this.employee.associate(this.customer, this.login, this.insuranceItem);
		this.customer.associate(this.insuranceItem);
		this.login.associate();
		this.insuranceItem.associate();
	}

	private int showHomeMenu(Scanner sc) {
		System.out.println("<�޴�>");
		System.out.println("-------------------");
		System.out.println("�޴����� ���ڸ� �������ּ���.");
		System.out.println("1. �α��� ");
		System.out.println("2. ȸ������ ");
		System.out.println("3. ���̵�, ��й�ȣ ã�� ");
		System.out.println("4. ������ ");
		return sc.nextInt();

	}

	private void showMenuErrorMessage() {
		System.out.println("-------------------");
		System.out.println("�߸� �Է��߽��ϴ�! �ùٸ� �޴��� �������ּ���.");
		System.out.println("-------------------");

	}

	private void loginIdMessage() {
		System.out.println("<�α���>");
		System.out.println("-------------------");
		System.out.println("1. ���̵� �Է����ּ���.");
	}

	private void loginPwMessage() {
		System.out.println("2. ��й�ȣ�� �Է����ּ���.");
	}

	private void wrongIdPwMessage() {
		System.out.println("-------------------");
		System.out.println("���̵� �Ǵ� ��й�ȣ�� �߸� �Է��߽��ϴ�. �Է��Ͻ� ������ �ٽ� Ȯ�����ּ���.");

	}

	private void showExitMessage() {
		System.out.println("-------------------");
		System.out.println("���α׷��� �����մϴ�.");
	}

}
