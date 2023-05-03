package com.user;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.dto.MailBoxDTO;
import com.dto.MailDTO;
import com.dto.UserDTO;
import com.exception.RecordNotFoundException;
import com.mail.Mail;
import com.service.Main;
import com.service.Service;
import com.service.ServiceImpl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserHandler {
	
	User user = new User();
	Scanner scan = new Scanner(System.in);
	
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
				System.out.println("아이디를 입력해 주세요(Q: 회원 가입 그만 두기). ");
				idPut = scan.next();
				if (idPut.equals("Q")) {
					return;
				}
				
				Service service = new ServiceImpl();
				UserDTO tdoi = service.isIDused(idPut);
				if (tdoi == null) {
					break;
				}
				System.out.println("아이디가 이미 존재합니다. ");
				System.out.println("다시 입력해 주세요. ");
			} while(true);
			
			do {
				System.out.println(" 비밀번호를 입력하시오(Q: 회원 가입 그만 두기). ");
				pwPut = scan.next();
				if (pwPut.equals("Q")) {
					return;
				}
				
				System.out.println(" 비밀번호를 한번 더 입력하시오(Q: 회원 가입 그만 두기). ");
				pwPut2 = scan.next();
				if (pwPut2.equals("Q")) {
					return;
				}
				
				if (pwPut.equals(pwPut2)) {
					System.out.println("비밀번호가 일치합니다.");
				} else {
					System.out.println("비밀번호가 일치하지 않습니다.");
				}
			} while(!pwPut.equals(pwPut2));
			
			System.out.println(" 이름을 입력하시오(Q: 회원 가입 그만 두기). ");
			String namePut = scan.next();
			if (namePut.equals("Q")) {
				return;
			}
			
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
	} //login in
	
	public void login() {
		UserDTO dto = new UserDTO();
		
		System.out.println(" login");
		System.out.println(" ======================== ");
		
		System.out.print("아이디를 입력하세요(Q: 로그인 그만 두기). : ");
        dto.setUser_id(scan.next());
        if (dto.getUser_id().equals("Q")) {
        	return;
        }
        
        System.out.print("비밀번호를 입력하세요(Q: 로그인 그만 두기). : ");
        dto.setUser_passwd(scan.next());
        if (dto.getUser_passwd().equals("Q")) {
        	return;
        }
        
        Service service = new ServiceImpl();
        dto = service.findUser(dto);

        if (dto != null) {
        	user.setUser_no(dto.getUser_no());
        	user.setId(dto.getUser_id());
        	user.setPasswd(dto.getUser_passwd());
        	user.setName(dto.getUser_name());
        	
        	System.out.println("로그인에 성공하였습니다.");
        	
        	user.getBox();
        	
        	Main.afterLogin(this);
        }
        else {
        	System.out.println("입력한 로그인 정보가 올바르지 않습니다.");
        	return;
        }
        
	} //logout
	
	public void logout() {
		// 로그인이 되지 않으면 로그아웃 선택지는 없음
		// 로그아웃을 하면 메인페이지 이동
		user = null;

		System.out.println("로그아웃");
		
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
	
	public void mailBoxDeco() {
		String exit = "\u001B[0m";
		int textColor;
		int shape;
		int i=0;
		System.out.println("색상선택");
		for (String c : MailBox.textColor) {
			System.out.println(c + i + exit);
			i++;
		}
		
		do {
			int colorCh = scan.nextInt();
			if (colorCh<MailBox.textColor.length) {				
				textColor = colorCh;
				System.out.println(exit);
				break;
			}
			System.out.println("번호를 다시 확인해 주세요");
		} while(true);
		int j=0;
		System.out.println("모양선택");
		for (String s : MailBox.shape) {
			System.out.println(j+" \t "+s);
			j++;
		}
		do {
			int shapeCh = scan.nextInt();
			if (shapeCh<MailBox.shape.length) {				
				shape = shapeCh;
				System.out.println(exit);
				break;
			}
			System.out.println("번호를 다시 확인해 주세요");
		} while(true);
		System.out.println("메일박스 수정 원할 시 0번 입력 // 뒤로 돌아가기 1번 입력");
		int ch = scan.nextInt();
		if (ch==0) {
			user.upDateBox(textColor, shape);			
		} 
	}
	
	public Mail selectMailChoice() {
		Hashtable<Integer, Mail> ht = user.getReceiveMails();
		if (ht.isEmpty()) {
			System.out.println("우편함이 비었습니다.");
			return null;
		}

		for (Integer key: ht.keySet()) {
            System.out.println(key+" \t "+ht.get(key).getTitle());
        }
		do {
			System.out.print("확인할 메일번호 입력(-1: 메일 확인 종료) : ");
			int mail_no = scan.nextInt();
			if(mail_no == -1) {
				return null;
			}
			if(ht.containsKey(mail_no)) {
				return ht.get(mail_no);
			}
			System.out.println("번호를 다시 확인해 주세요");
		} while(true);
	}
	
	public Mail deleteMailChoice() {
		Hashtable<Integer, Mail> ht = user.getReceiveMails();
		if (ht.isEmpty()) {
			System.out.println("우편함이 비었습니다.");
			return null;
		}
		
		for (Integer key: ht.keySet()) {
            System.out.println(key+" \t "+ht.get(key).getTitle());
        }
		do {
			System.out.print("삭제할 메일번호 입력(-1: 메일 삭제 종료) : ");
			int mail_no = scan.nextInt();
			if(mail_no == -1) {
				return null;
			}
			if(ht.containsKey(mail_no)) {
				return ht.get(mail_no);
			}
			System.out.println("번호를 다시 확인해 주세요");
		} while(true);
	}
	
}
