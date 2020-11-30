package com.revature.michael_mcauliffe_p1.utils;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class HashAndVerifyUtil {

	public static String hash(String input) {

		byte[] salt = makeSalt();

		byte[] hash = makeHash(input, salt);

		String output = byteArrToString(salt) + byteArrToString(hash);

		return output;
	}

	public static boolean verify(String input, String storedHash) {

		byte[] salt = stringToByteArr(storedHash.substring(0, 24));

		byte[] hash = makeHash(input, salt);

		String output = byteArrToString(salt) + byteArrToString(hash);

		if (output.endsWith(storedHash))
			return true;

		else
			return false;
	}

	private static byte[] makeHash(String input, byte[] salt) {

		KeySpec spec = new PBEKeySpec(input.toCharArray(), salt, 65536, 512);
		SecretKeyFactory factory = null;
		try {
			factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
		} catch (NoSuchAlgorithmException e) {
			// TODO Add logging
			e.printStackTrace();
			return null;
		}

		byte[] hash = null;
		try {
			hash = factory.generateSecret(spec).getEncoded();
		} catch (InvalidKeySpecException e) {
			// TODO Add logging
			e.printStackTrace();
			return null;
		}

		return hash;
	}

	private static byte[] makeSalt() {

		byte[] salt = new byte[16];
		SecureRandom random = new SecureRandom();
		random.nextBytes(salt);

		return salt;
	}

	private static String byteArrToString(byte[] arr) {

		return new String(Base64.getEncoder().encode(arr));
	}

	private static byte[] stringToByteArr(String str) {

		return Base64.getDecoder().decode(str.getBytes());
	}

}
