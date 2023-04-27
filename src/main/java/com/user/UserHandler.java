package com.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.dto.UserDTO;
import com.service.Service;
import com.service.ServiceImpl;

public class UserHandler {
	
	User user = new User();
	UserDTO dto = new UserDTO();
	Scanner scan = new Scanner(System.in);

	//run
	public void run() {
		System.out.println("choice pz");
		System.out.println("1: sign === 2: login === ");		
		int ch=0;
		switch (ch=scan.nextInt()) {
			case 1:
				signup();
				break;
			case 2:
				login();
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

		System.out.println("id input pz");
		try {
			String idPut, pwPut, pwPut2;
			do {
				System.out.println(" 아이디를 입력하시오. ");
				idPut = scan.next();
				
				Service service = new ServiceImpl();
				UserDTO tdoi = service.isIDused(idPut);
				if (tdoi == null) {
					break;
				}
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
			} while(pwPut.equals(pwPut2));
			
			System.out.println(" 이름을 입력하시오. ");
			String namePut = scan.next();
			System.out.println(idPut+"\t"+namePut);
			
			UserDTO dto = new UserDTO(0, idPut, pwPut, namePut);
			Service service = new ServiceImpl();
			int n = service.insertUser(dto);
			
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
        if (dto != null)
        	System.out.println("login success.");
        
	}
	//logout
	public void logout() {
		
	}
}
