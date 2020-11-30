package com.revature.michael_mcauliffe_p1.daos;

import java.io.IOException;
import java.util.List;

public interface RequestDao<T> {

	public boolean insertRequest(T t) throws IOException;

	public boolean updateRequest(T t) throws IOException;

	public boolean deleteRequest(String ID);

	public T selectRequest(String ID) throws IOException;

	public boolean completeRequest(String ID);

	public boolean setPassOrFail(String ID, boolean isPassing);

	public boolean insertGrade(String ID, byte[] grade) throws IOException;

	public List<T> selectAllRequests() throws IOException;

	public List<T> selectRequestsByRequester(int ID) throws IOException;
}
