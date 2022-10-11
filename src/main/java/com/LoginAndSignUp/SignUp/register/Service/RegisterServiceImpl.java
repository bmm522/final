package com.LoginAndSignUp.SignUp.register.Service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LoginAndSignUp.CodeEncryption.codeObject.CodeEntity;
import com.LoginAndSignUp.CodeEncryption.main.CodeEncryptionOfOneWay;
import com.LoginAndSignUp.Repository.Member;
import com.LoginAndSignUp.Repository.MemberCode;
import com.LoginAndSignUp.SignUp.register.DAO.MemberCodeDAOImpl;
import com.LoginAndSignUp.SignUp.register.DAO.MemberDAOImpl;
import com.LoginAndSignUp.SignUp.register.DTO.RegisterDTO;

@Service
public class RegisterServiceImpl  implements RegisterService{
	ArrayList<CodeEntity> hashCodeArr = new ArrayList<CodeEntity>();
	
	@Autowired
	private MemberDAOImpl memberDAO;
	
	@Autowired
	private MemberCodeDAOImpl memberCodeDAO;
	
	public void registerMember(RegisterDTO registerDTO) {
		hashCodeArr =changePwdToHashCode(registerDTO.getUserId(), registerDTO.getUserPwd());
		memberDAO.registerMember(getMemberDTO(registerDTO,hashCodeArr.get(0).getHashCode()));
		memberCodeDAO.registerMemberCode(getMemberCodeDTO(registerDTO,hashCodeArr.get(0).getSaltCode()));
		
	}
	
	private Member getMemberDTO(RegisterDTO registerDTO, String hashCode) {
		return  Member.MemberBuilder()
					 	.userId(registerDTO.getUserId())
					 	.userPwd(hashCode)
						.userName(registerDTO.getUserName())
						.userEmail(registerDTO.getUserEmail())
						.userBirth(registerDTO.getUserEmail())
						.userPhone(registerDTO.getUserPhone())
						.userAddress(registerDTO.getUserAddress())
						.build();
	}
	
	private MemberCode getMemberCodeDTO(RegisterDTO registerDTO, String salt) {
		return MemberCode.MemberCodeBuilder()
						.userId(registerDTO.getUserId())
						.salt(salt)
						.userEmail(registerDTO.getUserEmail())
						.userPhone(registerDTO.getUserPhone())
						.build();
	}
	
	public ArrayList<CodeEntity> changePwdToHashCode(String userId, String userPwd){
		ArrayList<CodeEntity> ceArr = new ArrayList<CodeEntity>();
		CodeEncryptionOfOneWay cw = new CodeEncryptionOfOneWay(userId, userPwd);
		ceArr =  cw.getEncryptingCode();
		return ceArr;
	}
	
}
