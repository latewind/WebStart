package com.latewind.common.tools;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.List;

import javax.ws.rs.ForbiddenException;

import org.apache.taglibs.standard.tag.common.core.NullAttributeException;

public class PassKeyEncoder {

	private final static String[] hexDigits = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d",
			"e", "f" };
	private Object salt;
	private String algorithm;

	public PassKeyEncoder(Object salt, String algorithm) {
		this.salt = salt;
		this.algorithm = algorithm;
	}
	
	public static String encodePassword(String salt,String password,String algorithm){
		
		String 	result=null; 
		try {
			MessageDigest md = MessageDigest.getInstance(algorithm);
			String mergePassword=salt+password;
			
			result= byteArrayToHexString(md.digest(mergePassword.getBytes("utf-8")));
			
			
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			
			e.printStackTrace();
		}
		
		return result;
		
	}
	public static String encodePassKey(String agrs,String algorithm ){
	
		
		if(agrs==null){
			
			throw new NullPointerException();
		}
		
		return encode(agrs,algorithm);
	}
	
	
	private static String encode(String preString,String algorithm) {
		String result = null;
		try {
			MessageDigest md = MessageDigest.getInstance(algorithm);
			// 加密后的字符串
			result = byteArrayToHexString(md.digest(preString.getBytes("utf-8")));
		} catch (Exception ex) {
		}
		return result;
	}

//	public boolean isPasswordValid(String encPass, String rawPass) {
//		String pass1 = "" + encPass;
//		String pass2 = encode(rawPass,);
//
//		return pass1.equals(pass2);
//	}
	public static String generateSalt(){
		SecureRandom secureRandom=new SecureRandom();
		byte [] bytes =new byte[16];
		secureRandom.nextBytes(bytes);
		return byteArrayToHexString(bytes);
		
	}
	
//	private String mergePasswordAndSalt(String password) {
//		if (password == null) {
//			password = "";
//		}
//
//		if ((salt == null) || "".equals(salt)) {
//			return password;
//		} else {
//			return password + "{" + salt.toString() + "}";
//		}
//	}

	/**
	 * 转换字节数组为16进制字串
	 * 
	 * @param b
	 *            字节数组
	 * @return 16进制字串
	 */
	private static String byteArrayToHexString(byte[] b) {
		StringBuffer resultSb = new StringBuffer();
		for (int i = 0; i < b.length; i++) {
			resultSb.append(byteToHexString(b[i]));
		}
		return resultSb.toString();
	}

	private static String byteToHexString(byte b) {
		int n = b;
		if (n < 0)
			n = 256 + n;
		int d1 = n / 16;
		int d2 = n % 16;
		return hexDigits[d1] + hexDigits[d2];
	}

	public static void main(String[] args) {
		
		
//		String salt = "helloworld";
//		PasswordEncoder encoderMd5 = new PasswordEncoder(salt, "MD5");
//		String encode = encoderMd5.encode("test");
//		System.out.println(encode);
//		boolean passwordValid = encoderMd5.isPasswordValid("1bd98ed329aebc7b2f89424b5a38926e", "test");
//		System.out.println(passwordValid);
//
//		PasswordEncoder encoderSha = new PasswordEncoder(salt, "SHA");
//		String pass2 = encoderSha.encode("test");
//		System.out.println(pass2);
//		boolean passwordValid2 = encoderSha.isPasswordValid("1bd98ed329aebc7b2f89424b5a38926e", "test");
//		System.out.println(passwordValid2);
	}

}