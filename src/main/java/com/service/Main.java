package com.service;
import com.mail.*;

public class Main {

	public static void main(String[] args) {
	
		Mail mail = new Mail();
		MailHandler userHandler = new MailHandler();
		
		System.out.printf(Mail.BANNER[0]);
		
		Mail.send(MailHandler.sendMail());

		
	}

}
