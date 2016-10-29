package db;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

import model.User;

public class UserManagerTest {

	@Test
	public void getRecordTest() {
		UserManager um=new UserManager();
		User user=um.getUser("test","xyz");

		assertThat(user.getLoginName(),is("test"));
		assertThat(user.getPassWord(),is("xyz"));
		assertThat(user.getName(),is("Mr.x"));
		assertThat(user.getEmail(),is("mrx@gmail.com"));

	}

}
