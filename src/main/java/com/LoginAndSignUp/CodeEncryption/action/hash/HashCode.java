package com.LoginAndSignUp.CodeEncryption.action.hash;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashCode {

	
	public String actionOfMakeHash(String salt, String pwdCode) {
		return actionOfEncryption(plusStr(salt, pwdCode));
	}


	public String actionOfEncryption(String plusStr) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA-256");
			md.update(plusStr.getBytes());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return String.format("%064x", new BigInteger(1, md.digest()));
	}

	public String plusStr(String salt, String pwdCode) {
		return salt+pwdCode;
	}
	
	
//	public boolean checkMachingHashCode(String idCode, String pwdCode, String salt, String hashCode) {
//		if(actionOfEncryption(plusStr(salt, pwdCode)).equals(hashCode)){
//			return true;
//		}
//		return false;
//	}
}
