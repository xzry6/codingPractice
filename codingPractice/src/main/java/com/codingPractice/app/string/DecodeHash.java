package com.codingPractice.app.string;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashSet;

public class DecodeHash {
	
	public String decodeMD5(String s) throws NoSuchAlgorithmException {
		if(s.length()%32 != 0) return null;
		String original = new String();
		for(int i=0; i<s.length(); i += 32) {
			String objective = s.substring(i, i+32);
			original = verify(objective, original);
			System.out.println(original);
		}
		return original;
	}
	
	private String byteArr2Hex(byte[] arr) {
		final char[] hexArray = "0123456789abcdef".toCharArray();
		StringBuilder sb = new StringBuilder("");
		for(byte b:arr) {
			int temp = b & 0xFF;
			sb.append(hexArray[temp >>> 4]);
			sb.append(hexArray[temp & 0x0F]);
		}
		return sb.toString();
	}
	
	private String encodeMD5(String s) throws NoSuchAlgorithmException{
		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] a = md.digest(s.getBytes());
		return byteArr2Hex(a);
	}
	
	private String verify(String objective, String original) throws NoSuchAlgorithmException {
		final char[] dictionary = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_.@+".toCharArray();
		String email = "xzry6@mail.missouri.edu";
		String md5 = encodeMD5(email);
		for(char c1:dictionary) {
			for(char c2:dictionary) {
				String temp = original+c1+c2;
				String MD5 = encodeMD5(md5+temp+encodeMD5(temp));
				if(MD5.equals(objective)) return temp;
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		DecodeHash dh = new DecodeHash();
		String s = "b806fd37c5dcc4eeb53427d05b4381171102608bf32f16c071841e7cb8c7cdb4c07f71fec46b26ff6bef2f2c7992fb11f7f2ac62aeb1da6a1b0417e2eecff2b68d6101c3b142aa45791bba9bad0e95bc92d2eaad86e797492c5db42b50f788be315f2bc3291141ad3b513ec261d653aaeb48a8751ab0f49c38d21d33871eaf3953d079781d2da4b3e48a07c443048e54669b887e8c06aab97506ea26cf1de8481431fbb1c421561b0d4070dd98d4ecc54bb1500eca49f6e98e2ff7578d9f04f78e839a2344e5dce4a58d945ba7656b415e5e7bd934c57570b2c98f552a011c7fd2d1d6d3be6ad67ad107b29b25f39cdf20a665dad034b6be801eb72d121623ba74b07f58f7afdd80180192f06e305a09320240bd315d8e103a462d2c351df5bbaa1e3b9b2ceb4ba5edf3c4c4182fd5905f72e5b92eb5e860fcbf1122e0da05bd32cc8435d7d3ecf3dce9042a53b64176bfcdc151bd087450d1b03bb384f1e54109bf6885d690d56ad2a9811d46d24c1f6f5c9044ebe32f7079b46847d29b71e3ac7e371fb319e629f699b62598edcd35610b0a7e8fbf62fc70f65e175ecb120464d26b8598854cf023c2361acc81bbf47d3924bbb357152b5510e845de5d34a8";
		try {
			dh.decodeMD5(s);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
}
