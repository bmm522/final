package  com.LoginAndSignUp.CodeEncryption.action.salt;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class Salt {
	private String salt="";
	
	public String actionOfMakeSalt() {
		byte[] randomByte = makeRandomByteArray();
		String salt = new String(Base64.getEncoder().encode(randomByte));
		this.salt = salt;
		return salt;
	}
	
	private byte[] makeRandomByteArray() {
		byte[] randomByte = null;
		try {
			SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
			randomByte = new byte[16];
			random.nextBytes(randomByte);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return randomByte;
	}
	
	public String getSalt() {
		return salt;
	}

}
