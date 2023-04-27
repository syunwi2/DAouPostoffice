package com.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.dto.UserDTO;
import com.service.Service;
import com.service.ServiceImpl;

public class UserHandler {
	
	
	Scanner scan = new Scanner(System.in);
	List<UserDTO> list = new ArrayList<UserDTO>();
	
	String inputId, inputPasswd;
	User user = new User();
	UserDTO dto = new UserDTO();
	
	//run
	public void run() {
		System.out.println("choice pz");
		System.out.println("1: sign === 2: login === 3: member check ");		
		int ch=0;
		switch (ch=scan.nextInt()) {
			case 1:
				signup();
				break;
			case 2:
				login();
				break;
			case 3:
				memch();
				break;
		}
		
	}
	
	public void memberPut() {
		
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
			System.out.println(" 아이디를 입력하시오. ");
			String idPut = scan.next();
			System.out.println(" 비밀번호를 입력하시오. ");
			String pwPut = scan.next();
			System.out.println(" 이름을 입력하시오. ");
			String namePut = scan.next();
			System.out.println(idPut+"\t"+pwPut+"\t"+namePut);
			UserDTO dto = new UserDTO(3, idPut, pwPut, namePut);
			Service service = new ServiceImpl();
			int n = service.insertUser(dto);
			
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}

		//passward check
		
		//name check
		
	}
	//login in
	public void login() {
		System.out.println(" login");
		System.out.println(" ======================== ");
		System.out.print("아이디를 입력하세요 : ");
        inputId = scan.next();
        System.out.print("비밀번호를 입력하세요 : ");
        inputPasswd = scan.next();
        
	}
	//logout
	public void logout() {
		
	}
	
	//memch
	public void memch() {
		
	}
}
