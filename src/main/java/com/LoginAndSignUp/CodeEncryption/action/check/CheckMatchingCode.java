package com.LoginAndSignUp.CodeEncryption.action.check;

import com.LoginAndSignUp.CodeEncryption.action.hash.HashCode;

public class CheckMatchingCode {
//	private CodeEntity cObj = new CodeEntity();
//	private Salt ms = new Salt();
	private HashCode hc = new HashCode();
	
	
	public boolean checkMatchingCode(String pwdCode, String salt, String hashCode) {
		return checkMatchingHashCode(pwdCode, salt, hashCode);
	}
	
	private boolean checkMatchingHashCode(String pwdCode, String salt, String hashCode) {
		if(hc.actionOfEncryption(hc.plusStr(salt, pwdCode)).equals(hashCode)){
			return true;
		}
		return false;
	}
	
	
}
