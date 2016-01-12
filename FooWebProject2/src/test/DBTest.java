package test;

import com.gmm.fooWebProject2.dao.JDBCUserDAO;
import com.gmm.fooWebProject2.user.User;

public class DBTest {

	public static void main(String[] args) {

		User user = new User();
		user.setName("GMM");

		JDBCUserDAO jdbcUserDAO = new JDBCUserDAO();
		jdbcUserDAO.getConnection();
		jdbcUserDAO.insert(user);

		user.setName("Another Name");

		jdbcUserDAO.insert(user);

		jdbcUserDAO.select();
		jdbcUserDAO.closeConnection();
	}

}
