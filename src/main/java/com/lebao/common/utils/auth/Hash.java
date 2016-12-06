package com.lebao.common.utils.auth;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;


public class Hash {
	private static Logger logger = Logger.getLogger(Hash.class);
	
	private static final int BYTE_LENGTH_SHA256 = 32;
	
	private static final String ALGORITHM_SHA256 = "SHA-256";
	
	private static final String CHARSET_UTF8 = "UTF-8";
	/**
	 * 
	 * @param input
	 * @return byte[]
	 */
	public static byte[] sha2(byte[] input) {
		return sha2(input, BYTE_LENGTH_SHA256);
	}
	/**
	 * 
	 * @param input
	 * @return btye[]
	 */
	public static byte[] sha2(byte[] input, int byteLength) {
    	byte[] out = null;
        try {
			MessageDigest messageDigest = MessageDigest.getInstance(ALGORITHM_SHA256);
	        messageDigest.update(input);
	        byte[] hashed = messageDigest.digest();
	        if (hashed.length > byteLength) {
	        	out = new byte[byteLength];
	        	System.arraycopy(hashed, 0, out, 0, byteLength);
	        } else {
	        	out = hashed;
	        }
        } catch (NoSuchAlgorithmException e) {
        	logger.error("Failed to hash SHA-256", e);
		}
        return out;
	}
	
	/**
	 * 
	 * @param input
	 * @return byte[]
	 */
	public static byte[] sha2(String input) {
		return sha2(input, false);
	}
	/**
	 * 
	 * @param input
	 * @return byte[]
	 */
	public static byte[] sha2(String input, boolean utf) {
		return sha2(input, utf, BYTE_LENGTH_SHA256);
	}
	
	private static byte[] getBytes(String input, boolean utf) {
		byte[] inputBytes = null;
		if (utf) {
			try {
				inputBytes = input.getBytes(CHARSET_UTF8);
			} catch (UnsupportedEncodingException e) {
				logger.error("charset error!");
			}
		} else {
			inputBytes = input.getBytes();
		}
		return inputBytes;
	}
	
	/**
	 * 
	 * @param input
	 * @return byte[]
	 */
	public static byte[] sha2(String input, boolean utf, int byteLength) {
		if (input == null) {
			return null;
		}
		return sha2(getBytes(input, utf), byteLength);
	}
	
	/**
	 * 
	 * @param input
	 * @return String
	 */
	public static String sha2InHex(String input) {		
		return sha2InHex(input, false, BYTE_LENGTH_SHA256);
	}
	
	/**
	 * 
	 * @param input
	 * @return String
	 */
	public static String sha2InHex(String input, boolean utf) {
		return sha2InHex(input, utf, BYTE_LENGTH_SHA256);
	}
	/**
	 * 
	 * @param input
	 * @return String
	 */
	public static String sha2InHex(String input, boolean utf, int byteLength) {
		if (input == null) {
			return null;
		}
		
		byte[] sha2 = sha2(getBytes(input, utf), byteLength);
		return Hex.encodeHexString(sha2);
	}
	
	/**
	 * 
	 * @param input
	 * @return String
	 */
	public static String sha2InBase64(String input) {
		return sha2InBase64(input, false);
	}
	
	/**
	 * 
	 * @param input
	 * @return String
	 */
	public static String sha2InBase64(String input, int byteLength) {
		return sha2InBase64(input, false, byteLength);
	}

	/**
	 * 
	 * @param input
	 * @return String
	 */
	public static String sha2InBase64(String input, boolean utf) {
		return sha2InBase64(input, utf, BYTE_LENGTH_SHA256);
	}

	/**
	 * 
	 * @param input
	 * @return String
	 */
	public static String sha2InBase64(String input, boolean utf, int byteLength) {
		if (input == null) {
			return null;
		}
		byte[] sha2 = sha2(getBytes(input, utf), byteLength);
		String base64Encoded = Base64.encodeURL(sha2); 
		return base64Encoded;
	}
	
	public static String MD5(String sourceStr) {
	        String result = "";
	        if(StringUtils.isBlank(sourceStr)){
	        	return "";
	        }
	        try {
	            MessageDigest md = MessageDigest.getInstance("MD5");
	            md.update(sourceStr.getBytes());
	            byte b[] = md.digest();
	            int i;
	            StringBuffer buf = new StringBuffer("");
	            for (int offset = 0; offset < b.length; offset++) {
	                i = b[offset];
	                if (i < 0)
	                    i += 256;
	                if (i < 16)
	                    buf.append("0");
	                buf.append(Integer.toHexString(i));
	            }
	            result = buf.toString();
	            System.out.println("MD5(" + sourceStr + ",32) = " + result);
	            System.out.println("MD5(" + sourceStr + ",16) = " + buf.toString().substring(8, 24));
	            result = buf.toString().substring(8, 24);
	        } catch (NoSuchAlgorithmException e) {
	            System.out.println(e);
	        }
	        return result;
	    }
	
	public static void main(String args[]){
		System.out.println(MD5(""));
	}
	
}
