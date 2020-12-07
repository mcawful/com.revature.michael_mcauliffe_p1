package com.revature.michael_mcauliffe_p1.Dao;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.michael_mcauliffe_p1.daos.RequestDaoPostgres;
import com.revature.michael_mcauliffe_p1.pojos.EventType;
import com.revature.michael_mcauliffe_p1.pojos.GradeFormat;
import com.revature.michael_mcauliffe_p1.pojos.Request;

public class RequestDaoPostgresTest {

	private static RequestDaoPostgres requestDao;
	private static Request request1, request2;
	private static byte[] grade;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		requestDao = new RequestDaoPostgres();

		LocalDateTime posting = LocalDateTime.now();
		LocalDateTime start1 = LocalDateTime.of(2021, Month.JANUARY, 8, 0, 0);
		LocalDateTime end1 = LocalDateTime.of(2021, Month.JANUARY, 10, 0, 0);

		request1 = new Request(200.00, "Test description.", EventType.SEMINAR, "Texas", 6, start1, end1, posting,
				GradeFormat.PASS_FAIL, null, null, false);

		LocalDateTime start2 = LocalDateTime.of(2021, Month.FEBRUARY, 8, 0, 0);
		LocalDateTime end2 = LocalDateTime.of(2021, Month.FEBRUARY, 12, 0, 0);

		request2 = new Request(100, "Other description.", EventType.TECHNICAL_TRAINING, "New York", 3, start2, end2,
				posting, GradeFormat.PASS_FAIL, null, null, false);

		FileInputStream fis = null;
		try {

			fis = new FileInputStream(
					"C:\\Java Programs\\com.revature.michael_mcauliffe_p1\\src\\test\\resources\\Test File.txt");
			grade = fis.readAllBytes();
			fis.close();
		} catch (FileNotFoundException fnf) {

			grade = null;
		}

		request1.setGrade(grade);

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {

		requestDao.insertRequest(request1);
	}

	@After
	public void tearDown() throws Exception {

		requestDao.deleteRequest(request1.getFormID());
	}

	@Test
	public void insertRequestTest() {

		assertTrue("Insert should return true.", requestDao.insertRequest(request2));
		requestDao.deleteRequest(request2.getFormID());
	}

	@Test
	public void selectExistingRequestTest() {

		Request selectedRequest = requestDao.selectRequest(request1.getFormID());

		assertEquals("Objects should be equal.", request1, selectedRequest);

	}

	@Test
	public void selectNonexistantRequestTest() {

		assertEquals("Returned object should be null.", null, requestDao.selectRequest("notanID"));
	}

	@Test
	public void updateExistingRequestTest() {

		request1.setDecription("This is now different.");

		assertTrue("Update will return true if successful.", requestDao.updateRequest(request1));

	}

	@Test
	public void updateNonExistingRequestTest() {

		assertFalse("No update should occur.", requestDao.updateRequest(request2));

	}

	@Test
	public void deleteExistingEmployeeTest() {

		assertTrue("Should return true if entry was deleted.", requestDao.deleteRequest(request1.getFormID()));
	}

	@Test
	public void deleteNonExistantEmployeeTest() {

		assertFalse("Should return false if entry wasn't found.", requestDao.deleteRequest(request2.getFormID()));
	}

	@Test
	public void completeRequestTest() {

		assertTrue("Should return true if dao call succeeded.", requestDao.completeRequest(request1.getFormID()));
	}

	@Test
	public void insertGradeTest() {

		assertTrue("Should return true if file upload was successful.",
				requestDao.insertGrade(request1.getFormID(), grade));
	}

	@Test
	public void setPassOrFailTest() {

		assertTrue("Should return true if dao call succeeded", requestDao.setPassOrFail(request1.getFormID(), false));
	}

	@Test
	public void selectAllRequestsTest() {

		List<Request> reqList = new ArrayList<>();

		reqList = requestDao.selectAllRequests();

		assertFalse("List should not be empty.", reqList.isEmpty());
	}

	/*@Test
	public void selectRequestsByRequesterTest() {

		List<Request> reqList = new ArrayList<>();

		reqList = requestDao.selectRequestsByRequester(request1.getEmployeeID());

		assertEquals("List should have one member.", 1, reqList.size());
	}*/
}
