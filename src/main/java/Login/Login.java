package Login;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import Mybatis.Mybatis;

public class Login {
	private boolean isLogin;
	private LoginDAO loginDAO;

	public Login() {
		this.loginDAO = new LoginDAO(Mybatis.getSqlSessionFactory());
	}

	public void associate() {

	}

	public void setSqlSession(SqlSession sqlSession) {
		this.loginDAO.setSqlSession(sqlSession);

	}

	// login은 VO에 직접적으로 접근하지 못하고, DAO를 통해서만 가능하다.
	public boolean login(String id, String password) {
		List<LoginVO> allLoginList = this.loginDAO.selectAllId();
		for (LoginVO selectLoginId : allLoginList) {
			if (selectLoginId.getId().equals(id) && selectLoginId.getPassword().equals(password)) {
				this.loginSuccessMessage(selectLoginId);

				return true;

			}
		}
		return false;
	}

	private void loginSuccessMessage(LoginVO selectLoginId) {
		System.out.println("-------------------");
		System.out.println("로그인 성공! " + selectLoginId.getId() + "님 안녕하세요.");
	}

}
