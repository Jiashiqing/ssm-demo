package com.justin.ssm.utils;

import java.security.MessageDigest;

public class MD5Util {

	public final static String MD5(String s) {

		char[] hexDigits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

		try {
			byte[] strTemp = s.getBytes();
			MessageDigest mdTemp = MessageDigest.getInstance("MD5");
			mdTemp.update(strTemp);
			byte[] md = mdTemp.digest();
			int j = md.length;
			char[] str = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte b0 = md[i];
				str[k++] = hexDigits[b0 >>> 4 & 0xf];
				str[k++] = hexDigits[b0 & 0xf];
			}
			return new String(str);

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	
	public static void main(String[] args) {
		System.out.println(MD5Util.MD5("jiashiqing"));
	}
	
	
}
