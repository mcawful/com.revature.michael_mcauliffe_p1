package com.revature.michael_mcauliffe_p1.daos;

import java.util.List;

public interface LoginDao<T> {

	public boolean insertLogin(T t);

	public boolean updateLogin(T t);

	public boolean deleteLogin(int ID);

	public boolean checkIfUsernameExists(String username);

	public T selectLoginByID(int ID);

	public T selectLoginByUsername(String username);

	public List<T> selectLoginList();

}
