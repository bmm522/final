package com.LoginAndSignUp.CodeEncryption.main;

import java.util.ArrayList;

import com.LoginAndSignUp.CodeEncryption.action.hash.HashCode;
import com.LoginAndSignUp.CodeEncryption.action.salt.Salt;
import com.LoginAndSignUp.CodeEncryption.codeObject.CodeEntity;

public class CodeEncryptionOfOneWay {
	private String idCode;
	private String pwdCode;
	
	private Salt ms = new Salt();
	private HashCode hc = new HashCode();
	
	public CodeEncryptionOfOneWay(String idCode, String pwdCode) {
		this.idCode = idCode;
		this.pwdCode = pwdCode;
	}
	
	public ArrayList<CodeEntity> getEncryptingCode() {
		return getArrayListOfCodeEncryptionOfOneWay();
	}

	private ArrayList<CodeEntity> getArrayListOfCodeEncryptionOfOneWay() {
		ArrayList<CodeEntity> ceArr = new ArrayList<CodeEntity>();
		ceArr.add(actionOfEncryptingCode(idCode, pwdCode));
		return ceArr;
	}
	
	private CodeEntity actionOfEncryptingCode(String idCode, String pwdCode) {
		CodeEntity cObj = new CodeEntity(idCode,ms.actionOfMakeSalt(),hc.actionOfMakeHash(ms.getSalt(), pwdCode));
		return cObj;
	}
	
	
}
