package controller;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

import testbase.TestServlet;

import model.User;

public class LoginServletTest extends TestServlet {

	@Test
	public void ログインに成功する() throws Exception {
		setGet();
		webRequest.setParameter("LoginName", "test");
		webRequest.setParameter("PassWord", "xyz");
		callServlet();

		assertThat(request.getAttribute("User"),notNullValue());

		User user=(User)request.getAttribute("User");
//		webResponse.getU

		assertThat(user.getLoginName(),is("test"));
		assertThat(user.getPassWord(),is("xyz"));
		assertThat(user.getName(),is("Mr.x"));
	}

	@Test
	public void ログインに成功するPost() throws Exception {
		setPost();
		webRequest.setParameter("LoginName", "test");
		webRequest.setParameter("PassWord", "xyz");
		callServlet();

		assertThat(request.getAttribute("User"),notNullValue());

		User user=(User)request.getAttribute("User");
//		assertThat(request.getServletContext(),is(""));

		assertThat(user.getLoginName(),is("test"));
		assertThat(user.getPassWord(),is("xyz"));
		assertThat(user.getName(),is("Mr.x"));
	}
}
