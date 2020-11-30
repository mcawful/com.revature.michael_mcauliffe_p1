package com.revature.michael_mcauliffe_p1.Dao;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.michael_mcauliffe_p1.daos.AttachmentDaoPostgres;
import com.revature.michael_mcauliffe_p1.pojos.RequestAttachment;

public class AttachmentDaoPostgresTest {

	private static AttachmentDaoPostgres attachmentDao;
	private static RequestAttachment attachment1, attachment2;
	private static String requestID1, requestID2;
	private static byte[] file1, file2;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		attachmentDao = new AttachmentDaoPostgres();

		requestID1 = "000009-211017-19";
		requestID2 = "000005-210710-83";

		FileInputStream fis = null;
		try {

			fis = new FileInputStream(
					"C:\\Java Programs\\com.revature.michael_mcauliffe_p1\\src\\test\\resources\\Test File.txt");
			file1 = fis.readAllBytes();
			fis.close();
		} catch (FileNotFoundException fnf) {

			file1 = null;
		}

		try {

			fis = new FileInputStream(
					"C:\\Java Programs\\com.revature.michael_mcauliffe_p1\\src\\test\\resources\\Test File 2.txt");
			file2 = fis.readAllBytes();
			fis.close();
		} catch (FileNotFoundException fnf) {

			file2 = null;
		}

		attachment1 = new RequestAttachment(requestID1, file1, "First file attachment.");
		attachment2 = new RequestAttachment(requestID2, file2, "Yest another file.");

		attachment1.setAttachmentID(attachmentDao.insertAttachment(attachment1));
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {

		attachmentDao.deleteAttachment(attachment1.getAttachmentID());
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void insertAttachmentTest() {

		attachment2.setAttachmentID(attachmentDao.insertAttachment(attachment2));
		assertTrue("Insert should return value greater than 0.", attachment2.getAttachmentID() > 0);
		attachmentDao.deleteAttachment(attachment2.getAttachmentID());
	}

	@Test
	public void selectExistingAttachmentTest() {

		attachment1.setAttachmentID(attachmentDao.insertAttachment(attachment1));
		RequestAttachment selectedAttachment = attachmentDao.selectAttachment(attachment1.getAttachmentID());

		assertEquals("Objects should be equal.", attachment1, selectedAttachment);

	}

	@Test
	public void selectNonexistantAttachmentTest() {

		assertEquals("Returned object should be null.", null, attachmentDao.selectAttachment(0));
	}

	@Test
	public void updateExistingAttachmentTest() {

		attachment1.setAttachmentID(attachmentDao.insertAttachment(attachment1));
		attachment1.setDescription("This is now different.");

		assertTrue("Update will return true if successful.", attachmentDao.updateAttachment(attachment1));
		attachmentDao.deleteAttachment(attachment1.getAttachmentID());
	}

	@Test
	public void updateNonExistingAttachmentTest() {

		assertFalse("No update should occur.", attachmentDao.updateAttachment(attachment2));

	}

	@Test
	public void deleteExistingAttachmentTest() {

		assertTrue("Should return true if entry was deleted.",
				attachmentDao.deleteAttachment(attachment1.getAttachmentID()));
	}

	@Test
	public void deleteNonExistantAttachmentTest() {

		assertFalse("Should return false if entry wasn't found.", attachmentDao.deleteAttachment(0));
	}

	@Test
	public void selectAllAttachmentsTest() {

		List<RequestAttachment> mesList = new ArrayList<>();

		attachment2.setAttachmentID(attachmentDao.insertAttachment(attachment2));

		mesList = attachmentDao.selectAllAttachments();

		assertFalse("List should not be empty.", mesList.isEmpty());

		attachmentDao.deleteAttachment(attachment2.getAttachmentID());
	}

	@Test
	public void selectAttachmentsByRequestTest() {

		List<RequestAttachment> mesList = new ArrayList<>();

		attachment2.setAttachmentID(attachmentDao.insertAttachment(attachment2));

		mesList = attachmentDao.selectAttachmentsByRequest(attachment2.getRequestID());

		assertEquals("List should have one member.", 1, mesList.size());

		attachmentDao.deleteAttachment(attachment2.getAttachmentID());
	}

}
