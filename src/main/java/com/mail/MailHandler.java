package com.mail;

import java.util.List;
import java.util.Scanner;

import com.dto.MailDTO;
import com.dto.UserDTO;
import com.service.ServiceImpl;


public class MailHandler {
	
public void sendMail(UserDTO dto) {	
	
	Mail mail = new Mail();
	Scanner scan = new Scanner(System.in);
	
	//mail.view();
	
	//입력받는 부분 : textcolor, backgroundcolor, reciever, title
	System.out.println("편지의 제목을 입력하세요 (100자 이내)");
	String mailtitle = scan.nextLine();
	System.out.println("---------------------------------------------------------------");
	
	System.out.printf("글자수가 300자가 넘어가면 글자 입력은 종료되고 OOO올림을 입력하시면 입력이 종료됩니다.\n");
	
	String text = "";
    int count = 0;
    while (scan.hasNextLine()) {
        String line = scan.nextLine();
        int len = line.length();

        if (len > 50) {												// 한줄에 50자씩 입력받고 글자수가 초과되면 줄이 넘어감
            while (len > 0) {
                int endIndex = len > 50 ? 50 : len;
                text += line.substring(0, endIndex) + "\n";
                line = line.substring(endIndex);
                len = line.length();
                count += 50;
                if (count >= 300) {								   // 글자수가 300자가 넘어가면 편지쓰기 기능이 종료됨
                    break;
                }
            }
        } else {
            text += line + "\n";
            count += len + 1;
        }

        if (line.contains("올림") || count >= 300) {				  // "올림"을 입력시 편지쓰기 기능 종료됨
            break;
        }
    }
  
	    System.out.println("==============================================================");
	    
	    System.out.println("익명을 원하시면 0, 기명을 원하시면 1을 눌러주세요");
	    String anoy = scan.nextLine();
	    do {
	        if (!anoy.equals("0") && !anoy.equals("1")) {
	            System.out.println("다시 입력해주세요");
	            anoy = scan.nextLine();
	        }
	    } while (!anoy.equals("0") && !anoy.equals("1"));

	    System.out.println("상대방이 편지를 읽을 수 있는 시간을 설정해주세요 (yyyymmdd)");
	    String mailtime = null;
	    do {
	    	{
	            mailtime = scan.nextLine();
	        }
	    } while (mail.checkDateFormat(mailtime));
	    
	    
	    //mail 멤버변수 설정
	    mail.setBackgroundColorindex(count);
	    mail.setBannerindex(count);
	    mail.setContent(text);
	    mail.setMail_anonymity(Integer.parseInt(anoy));//anoy를 그냥 숫자로 받는건 안되낭?
	    mail.setOpenDate(mailtime);
	    mail.setReceiver(mailtime);//작성 필요
	    mail.setSender(dto.getUser_id());//UserDTO 받아와야하나?
	    mail.setTextColorindex(count);
	    mail.setTitle(mailtime);
	    
	    mail.send();
	    
	    
	}
	

public void deleteMail(int mail_no) {	
	ServiceImpl serviceimpl = new ServiceImpl();
	    List<MailDTO> mail = serviceimpl.findMail(mail_no);
	    if (mail == null) {
	        System.out.println(" 메일이 존재하지 않습니다.");
	        return;
	    }
	    
	    int n = 0;
	    try {
	    	n = serviceimpl.deleteMail(mail_no);
	    } catch (Exception e) {
			e.getMessage();
		} finally {
	    	System.out.println(n + "개 메일이 삭제되었습니다.");
	    }
			
	}
	
}
