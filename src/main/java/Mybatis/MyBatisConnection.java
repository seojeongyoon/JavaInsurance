package Mybatis;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisConnection {
	private static SqlSessionFactory sqlSessionFactory;

	static {
        try {
        	initalize();
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
	}
	
	private static void initalize() throws IOException {
		String resource = "config.xml";
        Reader reader = Resources.getResourceAsReader(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
	}
	
    public static SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }
}
