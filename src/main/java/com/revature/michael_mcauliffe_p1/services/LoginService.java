package com.revature.michael_mcauliffe_p1.services;

public interface LoginService<T> {

	public boolean addLogin(T t);

	public boolean updateLogin(T t);

	public boolean deleteLogin(int ID);

	public T getLoginByID(int ID);

	public T getLoginByUsername(String username);
	
}
