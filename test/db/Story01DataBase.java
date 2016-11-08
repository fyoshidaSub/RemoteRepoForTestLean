package db;

import model.User;

public class Story01DataBase {
	public static void setUp(){
		UserManager um=new UserManager();
		um.deleteAllUser();
		um.insertUser(Story01DataBase.getTestUser1());
		um.insertUser(Story01DataBase.getTestUser2());
	}

	public static User getTestUser1(){
		User user=new User();
		user.setLoginName("test1");
		user.setPassWord("xyz");
		user.setName("Mr.x");
		user.setEmail("mrx@gmail.com");
		return user;
	}

	public static User getTestUser2(){
		User user=new User();
		user.setLoginName("test2");
		user.setPassWord("abc");
		user.setName("Ms.z");
		user.setEmail("msz@gmail.com");
		return user;
	}

	public static void tearDown(){
		UserManager um=new UserManager();
		um.deleteAllUser();
	}
}
