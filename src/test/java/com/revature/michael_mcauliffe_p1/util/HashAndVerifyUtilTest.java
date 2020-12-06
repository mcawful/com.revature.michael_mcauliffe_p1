package com.revature.michael_mcauliffe_p1.util;

import static org.junit.Assert.*;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import com.revature.michael_mcauliffe_p1.utils.HashAndVerifyUtil;

@RunWith(MockitoJUnitRunner.class)
public class HashAndVerifyUtilTest {

	private String firstPass = "password";
	private String secondPass = "1234567890";
	private String firstHash, secondHash;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		this.firstHash = HashAndVerifyUtil.hash(this.firstPass);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void correctPasswordTest() throws NoSuchAlgorithmException, InvalidKeySpecException {

		assertTrue("Should return the same hash.", HashAndVerifyUtil.verify(firstPass, firstHash));
	}

	@Test
	public void incorrectPasswordTest() throws NoSuchAlgorithmException, InvalidKeySpecException {
		
		assertFalse("Should return different hashes. Hash collisions ARE still possible.",
				HashAndVerifyUtil.verify(secondPass, firstHash));
	}
	
	@Test
	public void samePasswordDifferentHashTest() throws NoSuchAlgorithmException, InvalidKeySpecException {
		
		this.secondHash = HashAndVerifyUtil.hash(secondPass);
		
		assertNotEquals("Should return different hashes. Hash collisions ARE still possible.",
				firstHash, secondHash);
	}
	
}
