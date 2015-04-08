package com.tcs.ilp.util;

import java.util.Random;
import java.security.SecureRandom;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordGeneratorAndEncryptor
{
	private static final Random RANDOM = new SecureRandom();
	/** Length of password. @see #generateRandomPassword() */
	public static final int PASSWORD_LENGTH = 8;

	public static String generateRandomPassword()
	{
		// Pick from some letters that won't be easily mistaken for each
		// other. So, for example, omit o O and 0, 1 l and L.
		String letters = "abcdefghjkmnpqrstuvwxyzABCDEFGHJKMNPQRSTUVWXYZ23456789";
		String pw = "";
		for (int i=0; i<PASSWORD_LENGTH; i++)
		{
			int index = (int)(RANDOM.nextDouble()*letters.length());
			pw += letters.substring(index, index+1);
		}
		return pw;
	}
	
	private static MessageDigest md;
	
	public static String cryptWithMD5(String pass)
	{
		try
		{
			md = MessageDigest.getInstance("MD5");
			byte[] passBytes = pass.getBytes();
			md.reset();
			byte[] digested = md.digest(passBytes);
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < digested.length; i++)
			{
				sb.append(Integer.toHexString(0xff & digested[i]));
			}
			return sb.toString();
		}
		catch (NoSuchAlgorithmException ex)
		{
			ex.printStackTrace();
		}
		return null;
	}
}