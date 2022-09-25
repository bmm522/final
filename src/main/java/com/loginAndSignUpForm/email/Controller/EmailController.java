package com.loginAndSignUpForm.email.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.loginAndSignUpForm.email.Service.EmailServiceImpl;

@Controller
public class EmailController {
	EmailServiceImpl es = new EmailServiceImpl();
	
	public void sendEmail(Model m) {
		es.sendEamil(m);
	}
	
	@RequestMapping("/signup/email/checkresult/get")
	public ModelAndView checkEmail(Model m) {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("SignUpForm");
		mv.addObject("checkResult", );
		System.out.println("실행성공");
		return mv;
	}
	
	
	
	
}
