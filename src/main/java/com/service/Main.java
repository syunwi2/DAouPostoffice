package com.service;

import java.util.Scanner;

import com.mail.*;
import com.user.*;
public class Main {
	
	public static void beforeLogin() {
		UserHandler user = new UserHandler();
		Scanner scan = new Scanner(System.in);
		
		int ch=0;
		do {
			System.out.println("choice pz");
			System.out.println("1: sign === 2: login === ");
			switch (ch=scan.nextInt()) {
			case 1:
				user.signup();
				break;
			case 2:
				user.login();
				ch = -1;
				break;
			}
		} while(ch != -1);
				
		afterLogin(user);
	} // beforeLogin

	public static void afterLogin(UserHandler user) {
		Scanner scan = new Scanner(System.in);
		
		int ch=0;
		do {
			System.out.println("choice pz");
			System.out.println("1: check my Mailbox === 2: send Mail === 3: logout === 4: withdrawal");
			switch (ch=scan.nextInt()) {
			case 1:
				// 우체통 꾸미기(UserHandler: 요한, 프런트: 건희), 조회한 메일 내용 보기(나연), 받은 메일 삭제하기(표준 입출력 받고 함수에 연결: 요한, 건희)
				checkMailBox(user);
				break;
			case 2:
				MailHandler mail = new MailHandler();
				mail.sendMail(user.getUser().getId());
				break;
			case 3:
				user.logout();
				ch = -1;
				break;
			case 4:
				user.withdrawal();
				ch = -1;
				break;
			}
		} while (ch != -1);

		beforeLogin();
	} // afterLogin
	
	public static void checkMailBox(UserHandler user) {
		Scanner scan = new Scanner(System.in);
		
		int ch=0;
		do {
			user.getUser().viewBox(); // 서버에서 메일 받아오기: 연준, 메일 리스트 뜨도록 수정 후 표준 입출력으로 읽을 메일 선택받기: 요한
			System.out.println("choice pz");
			System.out.println("1: update my Mailbox === 2: read Mail === 3: delete Mail === 4: return to main menu");
			switch (ch=scan.nextInt()) {
			case 1:
				// 우체통 꾸미기
				break;
			case 2:
				// 조회한 메일 내용 보기
				break;
			case 3:
				// 받은 메일 삭제하기
				break;
			case 4:
				ch = -1;
				break;
			}
		} while (ch != -1);
		
		afterLogin(user);
	} // end checkMailBox
	
	public static void main(String[] args) {
		beforeLogin();
		
		System.out.println("end of main.");
	} // end main

}
