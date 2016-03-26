package Impl;

import db.DBConn;
import pojo.User;
public class ImplUser {
	DBConn db = new DBConn();

	public boolean register(User user){
		return db.registerUser(user);
		
	}
	public boolean login(User user){
		return db.loginUser(user);
	}
}
