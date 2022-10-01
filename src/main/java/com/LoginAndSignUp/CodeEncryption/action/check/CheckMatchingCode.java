package com.LoginAndSignUp.CodeEncryption.action.check;

import com.LoginAndSignUp.CodeEncryption.action.hash.HashCode;

public class CheckMatchingCode {
//	private CodeEntity cObj = new CodeEntity();
//	private Salt ms = new Salt();
	private HashCode hc = new HashCode();
	
	
	public boolean checkMatchingCode(String pwdCode, String salt, String hashCode) {
	
		System.out.println(pwdCode+"/1");
		System.out.println(salt+"/2");
		System.out.println(hashCode+"/3");
		System.out.println(hc.actionOfEncryption(hc.plusStr(salt, pwdCode))+"/4");
		System.out.println(checkMatchingHashCode(pwdCode, salt,hashCode)+"/5");
		System.out.println("-------------------------------------");
		return checkMatchingHashCode(pwdCode, salt, hashCode);
	}
	
	private boolean checkMatchingHashCode(String pwdCode, String salt, String hashCode) {
		System.out.println(pwdCode+"/6");
		System.out.println(salt+"/7");
		System.out.println(hashCode+"/8");
		if(hc.actionOfEncryption(hc.plusStr(salt, pwdCode)).equals(hashCode)){
			return true;
		}
		return false;
	}
	
	
}
