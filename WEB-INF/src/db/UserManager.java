package db;

import java.sql.ResultSet;
import java.util.LinkedList;

import common.DataBaseManager;
import model.User;


public class UserManager extends DataBaseManager{

	protected Object copyRecord(ResultSet rs) throws Exception{
		User user = new User();
		user.setRid(rs.getInt("RID"));
		user.setLoginName(rs.getString("LoginName").trim());
		user.setPassWord(rs.getString("PassWord").trim());
		user.setName(rs.getString("Name").trim());
		user.setEmail(rs.getString("Email").trim());
		user.setEmail(rs.getString("Email").trim());
		return user;
	}

	public User getUser(String loginName,String passWord){
		String sql = "";
		sql += "Select * from UserInfoX Where ";
		sql += " LoginName = '"+loginName +"'";
		sql += " AND ";
		sql += " PassWord = '"+passWord +"'";
		return (User)getRecord(sql);
	}

	public User getUserAdmin(String loginName,String passWord){
		String sql = "";
		sql += "Select * from UserInfoX Where ";
		sql += " LoginName = '"+loginName +"'";
		sql += " AND ";
		sql += " PassWord = '"+passWord +"'";
		sql += " AND ";
		sql += " UserType = 1";

		return (User)getRecord(sql);
	}
//	public void insertUser(User user){
//		String sql = "";
//		sql += "Insert Into UserInfo(";
//		sql +=    "LoginName,";
//		sql +=    "PassWord,";
//		sql +=    "Name,";
//		sql +=    "Email";
//		sql += ")Values(";
//		sql +=    "'"+user.getLoginName()+"'"+",";
//		sql +=    "'"+user.getPassWord()+"'"+",";
//		sql +=    "'"+user.getName()+"'"+",";
//		sql +=    "'"+user.getEmail()+"'";
//		sql += ")";
//		updateRecord(sql);
//	}
//
//	public void deleteAllUser(){
//		String sql = "";
//		sql += "Delete from UserInfo";
//		updateRecord(sql);
//	}
}
