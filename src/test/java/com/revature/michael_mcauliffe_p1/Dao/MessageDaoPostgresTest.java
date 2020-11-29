package com.revature.michael_mcauliffe_p1.Dao;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.michael_mcauliffe_p1.daos.MessageDaoPostgres;
import com.revature.michael_mcauliffe_p1.pojos.RequestMessage;

public class MessageDaoPostgresTest {

	private static MessageDaoPostgres messageDao;
	private static RequestMessage message1, message2;
	private static String requestID1, requestID2;
	private static int sender1, sender2, receiver1, receiver2;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		messageDao = new MessageDaoPostgres();
		
		requestID1 = "000009-211017-19";
		requestID2 = "000005-210710-83";
		sender1 = 9;
		sender2 = 5;
		receiver1 = 7;
		receiver2 = 4;
		LocalDateTime posting = LocalDateTime.now().truncatedTo(ChronoUnit.MILLIS);

		message1 = new RequestMessage(requestID1, "Test message", sender1, receiver1, posting);
		message2 = new RequestMessage(requestID2, "Another message", sender2, receiver2, posting);
		message1.setMessageID(messageDao.insertMessage(message1));
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
		messageDao.deleteMessage(message1.getMessageID());
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void insertMessageTest() {
		
		message2.setMessageID(messageDao.insertMessage(message2)); 
		assertTrue("Insert should return value greater than 0.", message2.getMessageID() > 0);
		messageDao.deleteMessage(message2.getMessageID());
	}
	
	@Test
	public void selectExistingMessageTest() {
		
		message1.setMessageID(messageDao.insertMessage(message1));
		RequestMessage selectedMessage = messageDao.selectMessage(message1.getMessageID());
		
		assertEquals("Objects should be equal.", message1, selectedMessage);

	}
	
	@Test
	public void selectNonexistantMessageTest() {

		assertEquals("Returned object should be null.", null, messageDao.selectMessage(0));
	}
	
	@Test
	public void updateExistingMessageTest() {
		
		message1.setMessageID(messageDao.insertMessage(message1));
		message1.setMessage("This is now different.");
		
		assertTrue("Update will return true if successful.", messageDao.updateMessage(message1));
		messageDao.deleteMessage(message1.getMessageID());
	}
	
	@Test
	public void updateNonExistingMessageTest() {
		
		assertFalse("No update should occur.", messageDao.updateMessage(message2));
		
	}
	
	@Test
	public void deleteExistingMessageTest() {
		
		assertTrue("Should return true if entry was deleted.", messageDao.deleteMessage(message1.getMessageID()));
	}
	
	@Test
	public void deleteNonExistantMessageTest() {
		
		assertFalse("Should return false if entry wasn't found.", messageDao.deleteMessage(0));
	}
	
	@Test
	public void setMessageReadTest() {
		
		message1.setMessageID(messageDao.insertMessage(message1));
		assertTrue("Should return true if dao call succeeded", messageDao.setMessageAsRead(message1.getMessageID()));
		messageDao.deleteMessage(message1.getMessageID());
	}
	
	@Test
	public void selectAllMessagesTest() {
		
		List<RequestMessage> mesList = new ArrayList<>();
		
		message2.setMessageID(messageDao.insertMessage(message2));
		
		mesList = messageDao.selectAllMessages();
		
		assertFalse("List should not be empty.", mesList.isEmpty());
		
		messageDao.deleteMessage(message2.getMessageID());
	}
	
	@Test
	public void selectMessagesByReceiverTest () {
		
		List<RequestMessage> mesList = new ArrayList<>();
		
		message2.setMessageID(messageDao.insertMessage(message2));
		
		mesList = messageDao.selectMessagesByRecipient(message2.getRecipientID());
		
		assertEquals("List should have one member.", 1, mesList.size());
		
		messageDao.deleteMessage(message2.getMessageID());
	}

	@Test
	public void selectMessagesByRequestTest () {
		
		List<RequestMessage> mesList = new ArrayList<>();
		
		message2.setMessageID(messageDao.insertMessage(message2));
		
		mesList = messageDao.selectMessagesByRequest(message2.getRequestID());
		
		assertEquals("List should have one member.", 1, mesList.size());
		
		messageDao.deleteMessage(message2.getMessageID());
	}
	
}
