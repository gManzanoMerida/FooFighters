package test;

import com.gmm.dao.JDBCUserDAO;
import com.gmm.user.User;

public class Test {

	public static void main(String[] args) {

		User user = new User();
		user.setName("HMK");

		JDBCUserDAO jdbcUserDAO = new JDBCUserDAO();
		jdbcUserDAO.getConnection();
		jdbcUserDAO.insert(user);

		user.setName("Another Name");

		jdbcUserDAO.insert(user);

		jdbcUserDAO.select();
		jdbcUserDAO.closeConnection();
	}

}
