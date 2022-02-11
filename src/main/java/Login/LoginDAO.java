package Login;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class LoginDAO {
	private SqlSessionFactory sqlSessionFactory;


	public LoginDAO(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}


	public List<Login> getAllLogin() {
		List<Login> login = null;
		SqlSession sqlsession = sqlSessionFactory.openSession();
		try {
			login = sqlsession.selectList("Login.selectAll");
		} finally {
			sqlsession.close();
		}
		return login;
	}

}
