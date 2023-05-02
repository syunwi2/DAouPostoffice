package com.service;

import java.util.Scanner;
import java.util.regex.Pattern;

import com.mail.*;
import com.user.*;

public class Main {
	
	public static void beforeLogin() {
		UserHandler user = new UserHandler();
		Scanner scan = new Scanner(System.in);
		
		int ch=0;
		String str;
		System.out.println("\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
	+Mail.TEXTCOLOR[1]	+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀ ⢀⣤⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⡶⠖⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" +Mail.TEXTCOLOR[8]
	+Mail.TEXTCOLOR[1]	+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠟⠋⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" +Mail.TEXTCOLOR[8]
	+Mail.TEXTCOLOR[1]	+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠟⠋⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" +Mail.TEXTCOLOR[8]
	+Mail.TEXTCOLOR[1]	+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠙⠿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠟⠋⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" +Mail.TEXTCOLOR[8]
	+Mail.TEXTCOLOR[1]	+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⣹⠿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⣿"+Mail.TEXTCOLOR[3]+"⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⠤ "+Mail.TEXTCOLOR[7]+" ⣀⣤⣤⡤ ⢀⣠⣤⡤⠄⠀⠀⠀⠀⠀⠀\r\n" +Mail.TEXTCOLOR[8] 
	+Mail.TEXTCOLOR[1]	+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣤⣶⣿⡟⠀⠈⠙⠿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⠛⠁⠀"+Mail.TEXTCOLOR[3]+"⣼⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠟⠉"+Mail.TEXTCOLOR[7]+"⣤⣶⡿⠟⢋⣡⣴⡾⠟⠋⠁⠀⠀⠀⠀⠀⠀⠀⠀\r\n" +Mail.TEXTCOLOR[8]
	+Mail.TEXTCOLOR[1]	+ "⠀⠀⠀⠀⠀⠀⣀⣤⣶⣿⣿⣿⣿⣿⠇⠀⠀⠀⠀⠈⠙⠿⣿⣿⣿⣿⣿⣿⣿⠿⠛⠉⠀⠀⠀⠀"+Mail.TEXTCOLOR[3]+"⢀⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠟⠋"+Mail.TEXTCOLOR[7]+"⣠⣴⡿⠟⢋⣡⣴⡾⠟⠋⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" +Mail.TEXTCOLOR[8]
	+Mail.TEXTCOLOR[1]	+ "⠀⠀⢀⣤⣶⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠈⠙⢿⡿⠛⠉⠀⠀⠀⠀⠀⠀⠀⠀"+Mail.TEXTCOLOR[3]+"⣸⣿⣿⣿⣿⣿⡿⠟⠋"+Mail.TEXTCOLOR[7]+"⣠⣴⣾⠟⠋⣡⣴⣾⠿⠛⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" +Mail.TEXTCOLOR[8]
	+Mail.TEXTCOLOR[1]	+ "⠀⠀⠀⠉⠻⢿⣿⣿⣿⣿⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⣀⣤⣾⣿⣿⣶⣄⡀⠀⠀⠀⠀⠀⠀⠀"+Mail.TEXTCOLOR[3]+"⣿⣿⣿⣿⣿⣿⣿⣷⣤⡀"+Mail.TEXTCOLOR[7]+"⠛⢿⣷⣦⣈⠙⠿⣿⣦⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" +Mail.TEXTCOLOR[8]
	+Mail.TEXTCOLOR[1]	+ "⠀⠀⠀⠀⠀⠀⠉⠟⢿⣿⣿⣿⣿⠁⠀⠀⠀⣀⣤⣶⣿⣿⣿⣿⣿⣿⣿⣿⣿⣶⣄⡀⠀⠀⠀"+Mail.TEXTCOLOR[3]+"⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣤⡀"+Mail.TEXTCOLOR[7]+"⠛⢿⣷⣦⣈⠙⠿⣿⣦⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" +Mail.TEXTCOLOR[8]
	+Mail.TEXTCOLOR[1]	+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠻⢿⡟⣀⣤⣶⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣶⣄⡀"+Mail.TEXTCOLOR[3]+"⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣤⣀"+Mail.TEXTCOLOR[7]+"⠙⢿⣷⣦⣀⠙⠻⣿⣦⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" +Mail.TEXTCOLOR[8]
	+Mail.TEXTCOLOR[1]	+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣤⣶⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣍"+Mail.TEXTCOLOR[3]+"⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠀ "+Mail.TEXTCOLOR[7]+"⠈⠉⠉⠁⠀⠀⠉⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" +Mail.TEXTCOLOR[8]
	+Mail.TEXTCOLOR[1]	+ "⠀⠀⠀⠀⠀⢀⣠⣶⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣶⣄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" +Mail.TEXTCOLOR[8]
	+Mail.TEXTCOLOR[1]	+ "⠀⠀⠀⠀⢠⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣶⣄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" +Mail.TEXTCOLOR[8]
	+Mail.TEXTCOLOR[1]	+ "⠀⠀⠀⠀⠸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣶⣄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" +Mail.TEXTCOLOR[8]
	+Mail.TEXTCOLOR[1]	+ "⠀⠀⠀⠀⠀⠉⠙⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠒⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" +Mail.TEXTCOLOR[8]
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
	+Mail.TEXTCOLOR[4]	+ "⠀⠀⠀⠀⠀⠀⢰⣿⠿⠿⣿⡄⠀⠀⣾⣿⡄⠀⠀⣴⡾⠿⢷⣆  ⣿⡇⠀ ⢸⣿⠀⠀⠀⣿⡿⠿⣶⡆⢠⣶⠿⠿⣶⡄⢀⣶⠿⠿⣶⡀⠸⠿⣿⡿⠿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
	+Mail.TEXTCOLOR[6]	+ "⠀⠀⠀⠀⠀⠀⢸⣿⠀⠀⣿⡇⠀⣸⡟ ⣿⡄⢸⣿⠀⠀ ⢸⣿⠀⣿⡇⠀ ⢸⣿⠀⠀⠀⣿⣧⣤⣾⠇⢼⡏⠀⠀⢸⣿⠈⠻⠷⣶⣦⡀⠀⠀⢸⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
	+Mail.TEXTCOLOR[7]	+ "⠀⠀⠀⠀⠀⠀⢸⣿⣤⣤⣿⠃⢠⣿⠛⠛⢿⣇⠈⢿⣦⣤⣾⠟⠀ ⢻⣷⣤⣼⡟⠀⠀⠀⣿⣿⠀⠀⠀⠘⢿⣤⣤⣾⠏⠐⣿⣤⣤⣿⠇⠀⠀⢸⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "");
		do {
			while(true) {
				System.out.println("choice pz");
				System.out.println("1: sign === 2: login === 3: exit");
				str = scan.next();
				if (Pattern.matches("^[0-9]*$", str)) {
					ch = Integer.parseInt(str);
					break;
				}
				System.out.println("형식에 맞게 입력해주세요.");
			}
			switch (ch) {
			case 1:
				user.signup();
				break;
			case 2:
				user.login();
				break;
			case 3:
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			default:
				System.out.println("형식에 맞게 입력해주세요.");
				break;
			}
		} while(true);
	} // beforeLogin

	public static void afterLogin(UserHandler user) {
		Scanner scan = new Scanner(System.in);
		
		int ch=0;
		String str;
		do {
			while(true) {
				System.out.println("choice pz");
				System.out.println("1: check my Mailbox === 2: send Mail === 3: logout === 4: withdrawal");
				str = scan.next();
				if (Pattern.matches("^[0-9]*$", str)) {
					ch = Integer.parseInt(str);
					break;
				}
				System.out.println("형식에 맞게 입력해주세요.");
			}
			switch (ch) {
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
			default:
				System.out.println("형식에 맞게 입력해주세요.");
				break;
			}
		} while (ch != -1);

		beforeLogin();
	} // afterLogin
	
	public static void checkMailBox(UserHandler user) {
		// 서버에서 메일 받아오기: 연준, 메일 리스트 뜨도록 수정 후 표준 입출력으로 읽을 메일 선택받기: 요한
		Scanner scan = new Scanner(System.in);
		MailHandler mail = new MailHandler();
		int ch=0;
		String str;
		do {
			while(true) {
				user.getUser().viewBox();
				System.out.println("choice pz");
				System.out.println("1: update my Mailbox === 2: read Mail === 3: delete Mail === 4: return to main menu");
				str = scan.next();
				if (Pattern.matches("^[0-9]*$", str)) {
					ch = Integer.parseInt(str);
					break;
				}
				System.out.println("형식에 맞게 입력해주세요.");
			}
			switch (ch) {
			case 1:
				// 우체통 꾸미기
				user.mailBoxDeco();
				break;
			case 2:
				// 조회한 메일 내용 보기
				mail.viewMail(user.selectMailChoice());
				break;
			case 3:
				// 받은 메일 삭제하기
				mail.deleteMail(user.deleteMailChoice());
				break;
			case 4:
				ch = -1;
				break;
			default:
				System.out.println("형식에 맞게 입력해주세요.");
				break;
			}
		} while (ch != -1);
		
		afterLogin(user);
	} // end checkMailBox
	
	public static void main(String[] args) {
		beforeLogin();
	} // end main

}
