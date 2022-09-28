package  com.LoginAndSignUp.CodeEncryption.codeObject;

public class CodeEntity {
	private String idCode;
	private String saltCode;
	private String hashCode;
	
	public CodeEntity() {}
	
	public CodeEntity(String idCode, String saltCode, String hashCode) {
		this.idCode=idCode;
		this.saltCode=saltCode;
		this.hashCode=hashCode;
	}
	public String getIdCode() {
		return idCode;
	}
	public void setIdCode(String idCode) {
		this.idCode = idCode;
	}
	public String getSaltCode() {
		return saltCode;
	}
	public void setSaltCode(String saltCode) {
		this.saltCode = saltCode;
	}
	public String getHashCode() {
		return hashCode;
	}
	public void setHashCode(String hashCode) {
		this.hashCode = hashCode;
	}
	
	
}
