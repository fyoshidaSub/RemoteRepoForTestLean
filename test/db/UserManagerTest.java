package db;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.User;
import testbase.TestDataBase;

public class UserManagerTest extends TestDataBase{
//	@Before
//	public void setUp(){
//		Story01DataBase.setUp();
//	}

	@Test
	public void getUserTest() {
		setTestData("./testdata/Story01TestData.xls");

		UserManager um=new UserManager();
		User user=um.getUser("test1","xyz");

		assertThat(user.getLoginName(),is("test1"));
		assertThat(user.getPassWord(),is("xyz"));
		assertThat(user.getName(),is("Mr.x"));
		assertThat(user.getEmail(),is("mrx@gmail.com"));

//		removeData();
	}

//	@After
//	public void tearDown(){
//		Story01DataBase.tearDown();
//	}

}
