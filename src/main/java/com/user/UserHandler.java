package com.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.dto.MailBoxDTO;
import com.dto.UserDTO;
import com.exception.RecordNotFoundException;
import com.service.Service;
import com.service.ServiceImpl;

public class UserHandler {
	
	User user = new User();
	UserDTO dto = new UserDTO();
	Scanner scan = new Scanner(System.in);

	//run
	public void run() {
		System.out.println("choice pz");
		System.out.println("1: sign === 2: login === 3: logout === 4: withdrawal");		
		int ch=0;
		switch (ch=scan.nextInt()) {
			case 1:
				signup();
				break;
			case 2:
				login();
				break;
			case 3:
				logout();
				break;
			case 4:
				withdrawal();
				break;
		}
	}
	
	
	//sign up
	//user에서 유저 클래스를 받아와서 객체 만들고 이 형식에 맞게 저장.
	//user_no, user_id, user_pw, user_name
	public void signup() {
		System.out.println(" signup");
		System.out.println(" ======================== ");

		//id check

		//System.out.println("id input pz");
		try {
			//유저테이블 행 추가
			String idPut, pwPut, pwPut2;
			do {
				System.out.println("아이디를 입력해 주세요. ");
				idPut = scan.next();
				
				Service service = new ServiceImpl();
				UserDTO tdoi = service.isIDused(idPut);
				if (tdoi == null) {
					break;
				}
				System.out.println("아이디가 이미 존재합니다. ");
				System.out.println("다시 입력해 주세요. ");
			} while(true);
			
			do {
				System.out.println(" 비밀번호를 입력하시오. ");
				pwPut = scan.next();
				System.out.println(" 비밀번호를 한번 더 입력하시오. ");
				pwPut2 = scan.next();
				if (pwPut.equals(pwPut2)) {
					System.out.println("비밀번호가 일치합니다.");
				} else {
					System.out.println("비밀번호가 일치하지 않습니다.");
				}
			} while(!pwPut.equals(pwPut2));
			
			System.out.println(" 이름을 입력하시오. ");
			String namePut = scan.next();
			System.out.println(idPut+"\t"+namePut);
			
			UserDTO dto = new UserDTO(0, idPut, pwPut, namePut);
			Service service = new ServiceImpl();
			int n = service.insertUser(dto);
			//메일박스 테이블 행 추가
			MailBoxDTO dtom = new MailBoxDTO(0, 0, dto.getUser_no());
			Service service2 = new ServiceImpl();
			int m = service2.insertMailBox(dtom);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}

		
	}
	//login in
	public void login() {
		System.out.println(" login");
		System.out.println(" ======================== ");
		
		System.out.print("아이디를 입력하세요 : ");
        dto.setUser_id(scan.next());
        
        System.out.print("비밀번호를 입력하세요 : ");
        dto.setUser_passwd(scan.next());
        
        Service service = new ServiceImpl();
        dto = service.findUser(dto);
        System.out.println(dto);
        if (dto != null) {
        	user.setUser_no(dto.getUser_no());
        	user.setId(dto.getUser_id());
        	user.setPasswd(dto.getUser_passwd());
        	user.setName(dto.getUser_name());
        	System.out.println(user);
        	System.out.println("로그인에 성공하였습니다.");
        }
        //withdrawal();
	}
	//logout
	public void logout() {
		// 로그인이 되지 않으면 로그아웃 선택지는 없음
		// 로그아웃을 하면 메인페이지 이동
		User user = null;
		UserDTO dto = null;
		System.out.println("로그아웃");
		System.out.println(dto);
		run();
	}
	
	//메일박스 업데이트
	public void mailBoxUpdate() {
		
	}
	//회원탈퇴
	public void withdrawal() {
		System.out.println("회원탈퇴 시작");
		System.out.println("정말 탈퇴하시겠습니까? 탈퇴하시려면 1번을 눌러주세요. ");
		System.out.println("다른키를 누르면 메인화면으로 돌아갑니다. ");
		int h = scan.nextInt();
		if (h==1)
		{
			Service service = new ServiceImpl();
			try {
				//유저테이블 행 삭제
				int n = service.deleteUser(user.getUser_no());
				//메일박스 행 삭제
				//int m = service.deleteMailBox(user.getUser_no());
				//메일 삭제
				
			} catch (RecordNotFoundException e) {
				System.out.println(e.getMessage());
			}
			System.out.println("회원탈퇴에 성공하였습니다.");
			//자동 로그아웃 및 메인페이지이동 ->  logout?
		}
		else {
			System.out.println("회원탈퇴 취소합니다.");
		}
	}
	
}
