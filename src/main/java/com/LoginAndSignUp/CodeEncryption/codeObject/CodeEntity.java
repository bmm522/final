package  com.LoginAndSignUp.CodeEncryption.codeObject;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
	
}
