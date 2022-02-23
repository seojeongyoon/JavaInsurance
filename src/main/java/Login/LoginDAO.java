package Login;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class LoginDAO {

	private LoginVO loginVO;
	private SqlSession sqlSession;
	private SqlSessionFactory sqlSessionFactory;

	public LoginDAO(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;

	}

	public List<LoginVO> selectAllId() {
		List<LoginVO> allLoginList = this.sqlSession.selectList("login.selectAll");
		return allLoginList;

	}

	public List<LoginVO> selectOneId(LoginVO selectLoginId) {
		List<LoginVO> oneLoginList = this.sqlSession.selectOne("login.getlogin", selectLoginId);
		return oneLoginList;

	}

}
