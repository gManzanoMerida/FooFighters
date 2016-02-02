package test;

import com.gmm.fooWebProject2.dao.DBConnection;
import com.gmm.fooWebProject2.dao.UserDAO;
import com.gmm.fooWebProject2.user.User;

public class DBTest {

	public static void main(String[] args) {

		User user = new User();
		user.setName("AMM");

		 
		UserDAO dao = new UserDAO();
		dao.insert(user);

		user.setName("SMJ");

		dao.insert(user); 
		
		DBConnection.closeConnection();
	}

}
