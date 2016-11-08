package controller;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.hamcrest.Matcher;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import db.Story01DataBase;
import db.UserManager;
import testbase.TestDataBase;
import testbase.TestServlet;

import model.User;

public class LoginServletTest extends TestServlet {
//	@Before
//	public void setUp() throws Exception{
//		super.setUp();
//		Story01DataBase.setUp();
//	}

//	@Test
//	public void ログインに成功するGet() throws Exception {
//		setGet();
//		webRequest.setParameter("LoginName", "test1");
//		webRequest.setParameter("PassWord", "xyz");
//		callServlet();
//
//		assertThat(request.getAttribute("User"),notNullValue());
//
//		User user=(User)request.getAttribute("User");
//
//		assertThat(user.getLoginName(),is("test1"));
//		assertThat(user.getPassWord(),is("xyz"));
//		assertThat(user.getName(),is("Mr.x"));
//	}

	@Test
	public void ログインに成功する() throws Exception {
		TestDataBase testdb=new TestDataBase();
		testdb.setTestData("./testdata/Story01TestData.xls");

		setPost();
		webRequest.setParameter("LoginName", "test1");
		webRequest.setParameter("PassWord", "xyz");
		callServlet();

		assertThat(request.getAttribute("User"),notNullValue());

		User user=(User)request.getAttribute("User");

		assertThat(user.getLoginName(),is("test1"));
		assertThat(user.getPassWord(),is("xyz"));
		assertThat(user.getName(),is("Mr.x"));
	}

	@Test
	public void ログインに失敗する() throws Exception {
		TestDataBase testdb=new TestDataBase();
		testdb.setTestData("./testdata/Story01TestData.xls");

		setPost();
		webRequest.setParameter("LoginName", "test");
		webRequest.setParameter("PassWord", "xyz");
		callServlet();

		assertThat(request.getAttribute("User"),nullValue());
	}

//	@After
//	public void tearDown(){
//		super.tearDown();
//		Story01DataBase.tearDown();
//	}

}
