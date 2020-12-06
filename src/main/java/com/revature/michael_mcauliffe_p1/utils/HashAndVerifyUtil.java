package com.revature.michael_mcauliffe_p1.utils;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class HashAndVerifyUtil {

	public static String hash(String input) throws NoSuchAlgorithmException, InvalidKeySpecException {

		return hash(input, Strength.STANDARD);
	}

	public static String hash(String input, Strength strength)
			throws NoSuchAlgorithmException, InvalidKeySpecException {

		byte[] salt = makeSalt();

		byte[] hash = makeHash(input, salt, strength);

		String output = byteArrToString(salt) + byteArrToString(hash);

		return output;
	}

	public static boolean verify(String input, String storedHash)
			throws NoSuchAlgorithmException, InvalidKeySpecException {

		return verify(input, storedHash, Strength.STANDARD);
	}

	public static boolean verify(String input, String storedHash, Strength strength)
			throws NoSuchAlgorithmException, InvalidKeySpecException {

		byte[] salt = stringToByteArr(storedHash.substring(0, 24));

		byte[] hash = makeHash(input, salt, strength);

		String output = byteArrToString(salt) + byteArrToString(hash);

		if (output.endsWith(storedHash))
			return true;

		else
			return false;
	}

	public static enum Strength {
		LOW, STANDARD, HIGH
	}

	private static int encryptionLevel(Strength strength) {

		switch (strength) {
		case LOW:
			return 128;
		default:
			return 256;
		case HIGH:
			return 512;
		}
	}

	private static byte[] makeHash(String input, byte[] salt, Strength strength)
			throws NoSuchAlgorithmException, InvalidKeySpecException {

		KeySpec spec = new PBEKeySpec(input.toCharArray(), salt, 65536, encryptionLevel(strength));
		SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
		return factory.generateSecret(spec).getEncoded();

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
