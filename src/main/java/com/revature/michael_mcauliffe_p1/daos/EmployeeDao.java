package com.revature.michael_mcauliffe_p1.daos;

import java.util.List;

public interface EmployeeDao<T> {

	public int insertEmployee(T t);

	public boolean updateEmployee(T t);

	public boolean deleteEmployee(int ID);

	public T selectEmployee(int ID);

	public List<T> selectEmployeeList();

}
