package com.venkatesh.util;

import java.io.File;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class Emailfetch {
	
	@Autowired
	private JavaMailSender mailsender;
	
	public boolean emailsender(String subject,String to,String body,File f) {
		
		try {
			
			MimeMessage msg =mailsender.createMimeMessage();
			MimeMessageHelper helper=new MimeMessageHelper(msg,true);
			
			helper.setSubject(subject);
			helper.setText(body,true);
			helper.setTo(to);
			
			helper.addAttachment("plans-info", f);
			mailsender.send(msg);
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		
		
		
		return true;
		
	}

}
