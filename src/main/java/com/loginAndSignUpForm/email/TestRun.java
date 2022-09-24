package com.loginAndSignUpForm.email;

import org.springframework.ui.Model;

import com.loginAndSignUpForm.email.Controller.EmailController;

public class TestRun {
	
	public static void main(String[] args) {
		
		EmailController ec = new EmailController(); 
		
		
		ec.checkEmail();
	}
}
