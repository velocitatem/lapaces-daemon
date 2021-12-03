package velo.ladaalpha.fields.cryptography;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

// TODO: Auto-generated Javadoc
/**
 * The Class Hashing.
 */
// source https://www.geeksforgeeks.org/
public class Hashing {

	/**
	 * Gets the sha.
	 *
	 * @param input the input
	 * @return the sha
	 */
	private static byte[] getSHA(String input)
    { 
        MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} 
        return md.digest(input.getBytes(StandardCharsets.UTF_8)); 
    }
	
	/**
	 * To hex string.
	 *
	 * @param hash the hash
	 * @return the string
	 */
	private static String toHexString(byte[] hash)
    {
        BigInteger number = new BigInteger(1, hash);  
        StringBuilder hexString = new StringBuilder(number.toString(16)); 
        while (hexString.length() < 32) 
        { 
            hexString.insert(0, '0'); 
        }   
        return hexString.toString(); 
    }
	
	
	/**
	 * Sha 256.
	 *
	 * @param input the input
	 * @return the string
	 */
	public static String sha256(String input) {
		return toHexString(getSHA(input));
	}
	
	/**
	 * Sha 512.
	 *
	 * @param input the input
	 * @return the string
	 */
	public static String sha512(String input)
    {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);
            String hashtext = no.toString(16);  
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
	
	/**
	 * Sha 384.
	 *
	 * @param input the input
	 * @return the string
	 */
	public static String sha384(String input) {
        try {
            // getInstance() method is called with algorithm SHA-384
            MessageDigest md = MessageDigest.getInstance("SHA-384");
  
            // digest() method is called
            // to calculate message digest of the input string
            // returned as array of byte
            byte[] messageDigest = md.digest(input.getBytes());
  
            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);
  
            // Convert message digest into hex value
            String hashtext = no.toString(16);
  
            // Add preceding 0s to make it 32 bit
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
  
            // return the HashText
            return hashtext;
        }
  
        // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
	}
	
	/**
	 * Sha 224.
	 *
	 * @param input the input
	 * @return the string
	 */
	public static String sha224(String input) {
        try {
            // getInstance() method is called with algorithm SHA-224
            MessageDigest md = MessageDigest.getInstance("SHA-224");
  
            // digest() method is called
            // to calculate message digest of the input string
            // returned as array of byte
            byte[] messageDigest = md.digest(input.getBytes());
  
            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);
  
            // Convert message digest into hex value
            String hashtext = no.toString(16);
  
            // Add preceding 0s to make it 32 bit
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
  
            // return the HashText
            return hashtext;
        }
  
        // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
	}
	
	/**
	 * Md 2.
	 *
	 * @param input the input
	 * @return the string
	 */
	public static String md2(String input) {
        try {
            // getInstance() method is called with algorithm MD2
            MessageDigest md = MessageDigest.getInstance("MD2");
  
            // digest() method is called
            // to calculate message digest of the input string
            // returned as array of byte
            byte[] messageDigest = md.digest(input.getBytes());
  
            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);
  
            // Convert message digest into hex value
            String hashtext = no.toString(16);
  
            // Add preceding 0s to make it 32 bit
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
  
            // return the HashText
            return hashtext;
        }
  
        // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
	}
	
	/**
	 * Md 5.
	 *
	 * @param input the input
	 * @return the string
	 */
	public static String md5(String input) {
        try {
        	  
            // Static getInstance method is called with hashing MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
  
            // digest() method is called to calculate message digest
            //  of an input digest() return array of byte
            byte[] messageDigest = md.digest(input.getBytes());
  
            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);
  
            // Convert message digest into hex value
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } 
  
        // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
	}
	
	/**
	 * Sha 1.
	 *
	 * @param input the input
	 * @return the string
	 */
	public static String sha1(String input) {
        try {
            // getInstance() method is called with algorithm SHA-1
            MessageDigest md = MessageDigest.getInstance("SHA-1");
  
            // digest() method is called
            // to calculate message digest of the input string
            // returned as array of byte
            byte[] messageDigest = md.digest(input.getBytes());
  
            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);
  
            // Convert message digest into hex value
            String hashtext = no.toString(16);
  
            // Add preceding 0s to make it 32 bit
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
  
            // return the HashText
            return hashtext;
        }
  
        // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
	}
	

	
}	
