package com.venkatesh.util;

import javax.mail.internet.MimeMessage;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class Emailhelper {
	@Autowired
	private JavaMailSender mailsender;
	
	public boolean email(String to,String sub,String body) {
		
		boolean isSent=false;
		try {
			
			MimeMessage mimemessage=mailsender.createMimeMessage();
			MimeMessageHelper helper=new MimeMessageHelper(mimemessage);
			helper.setTo(to);
			helper.setSubject(sub);
			helper.setText(body, true);
			mailsender.send(mimemessage);
			isSent=true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return true;
	}

}
