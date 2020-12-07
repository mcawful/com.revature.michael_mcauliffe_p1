package com.revature.michael_mcauliffe_p1.Dao;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.michael_mcauliffe_p1.daos.ApprovalDaoPostgres;
import com.revature.michael_mcauliffe_p1.pojos.RequestApproval;

public class ApprovalDaoPostgresTest {

	private static ApprovalDaoPostgres approvalDao;
	private static String requestID1, requestID2;
	private static int firstApprover1, firstApprover2;
	private static int secondApprover1, secondApprover2;
	private static int finalApprover1, finalApprover2;
	private static RequestApproval approval1, approval2;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		approvalDao = new ApprovalDaoPostgres();

		requestID1 = "000009-211017-19";
		requestID2 = "000005-210710-83";
		firstApprover1 = 7;
		secondApprover1 = 7;
		finalApprover1 = 8;
		firstApprover2 = 4;
		secondApprover2 = 2;
		finalApprover2 = 8;

		approval1 = new RequestApproval(firstApprover1, secondApprover1, finalApprover1, requestID1);
		approval2 = new RequestApproval(firstApprover2, secondApprover2, finalApprover2, requestID2);

		approval1.setApprovalID(approvalDao.insertApproval(approval1));
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {

		approvalDao.deleteApproval(approval1.getApprovalID());
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void insertApprovalTest() {

		approval2.setApprovalID(approvalDao.insertApproval(approval2));
		assertTrue("Insert should return value greater than 0.", approval2.getApprovalID() > 0);
		approvalDao.deleteApproval(approval2.getApprovalID());
	}

	@Test
	public void selectExistingApprovalTest() {

		// approval2.setApprovalID(approvalDao.insertApproval(approval2));
		RequestApproval selectedApproval = approvalDao.selectApproval(approval1.getApprovalID());

		assertEquals("Objects should be equal.", approval1, selectedApproval);
		// approvalDao.deleteApproval(approval2.getApprovalID());
	}

	@Test
	public void selectNonexistantApprovalTest() {

		assertEquals("Returned object should be null.", null, approvalDao.selectApproval(0));
	}

	@Test
	public void updateExistingApprovalTest() {

		approval1.setFinalApproval(true);
		approval1.setFinalApprovalDateAndTime(LocalDateTime.now());

		assertTrue("Update will return true if successful.", approvalDao.updateApproval(approval1));
	}

	@Test
	public void updateNonExistingApprovalTest() {

		assertFalse("No update should occur.", approvalDao.updateApproval(approval2));

	}

	@Test
	public void deleteExistingApprovalTest() {

		assertTrue("Should return true if entry was deleted.", approvalDao.deleteApproval(approval1.getApprovalID()));
	}

	@Test
	public void deleteNonExistantApprovalTest() {

		assertFalse("Should return false if entry wasn't found.", approvalDao.deleteApproval(0));
	}

	@Test
	public void selectAllApprovalsTest() {

		List<RequestApproval> approvalList = new ArrayList<>();

		approval2.setApprovalID(approvalDao.insertApproval(approval2));

		approvalList = approvalDao.selectAllApprovals();

		assertFalse("List should not be empty.", approvalList.isEmpty());

		approvalDao.deleteApproval(approval2.getApprovalID());
	}

	@Test
	public void selectApprovalsByFirstApproverTest() {

		List<RequestApproval> approvalList = new ArrayList<>();

		approval2.setApprovalID(approvalDao.insertApproval(approval2));

		approvalList = approvalDao.selectApprovalsByFirstApprover(approval2.getFirstApproverID());

		assertFalse("List should not be empty.", approvalList.isEmpty());

		approvalDao.deleteApproval(approval2.getApprovalID());
	}

	@Test
	public void selectApprovalsBySecondApproverTest() {

		List<RequestApproval> approvalList = new ArrayList<>();

		approval2.setApprovalID(approvalDao.insertApproval(approval2));

		approvalList = approvalDao.selectApprovalsBySecondApprover(approval2.getSecondApproverID());

		assertFalse("List should not be empty.", approvalList.isEmpty());

		approvalDao.deleteApproval(approval2.getApprovalID());
	}

	@Test
	public void selectApprovalsByFinalApproverTest() {

		List<RequestApproval> approvalList = new ArrayList<>();

		approval2.setApprovalID(approvalDao.insertApproval(approval2));

		approvalList = approvalDao.selectApprovalsByFinalApprover(approval2.getFinalApproverID());

		assertFalse("List should not be empty.", approvalList.isEmpty());

		approvalDao.deleteApproval(approval2.getApprovalID());
	}

}
