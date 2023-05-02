package com.mail;

import java.util.List;
import java.util.Scanner;

import com.dto.MailDTO;
import com.dto.UserDTO;
import com.service.ServiceImpl;



public class MailHandler {

	Mail mail = new Mail();
	Scanner scan = new Scanner(System.in);
	
	
public void sendMail(String user_id) {	

	
	//mail.view();
	
	/*
	 *
	 */
	int textcolor = 0;
	int backgroundcolor = 0;
	int bannerindex = 0;

	do {
	System.out.println("✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉");
	System.out.println("✉ 글자색을 입력하세요                                                               ✉");
	System.out.println("✉ 0: black, 1: red, 2: green, 3: yellow, 4: blue, 5: purple, 6: cyan, 7: white ✉");
	System.out.println("✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉ \n");
	textcolor = scan.nextInt();
	scan.nextLine();
	}while(textcolor<0 || textcolor > 7);
	
	System.out.println("˖◛⁺˖˖◛⁺˖˖◛⁺˖˖◛⁺˖˖◛⁺˖˖◛⁺˖˖◛⁺˖˖◛⁺˖˖◛⁺˖˖◛⁺˖ -메일 작성중- ˖◛⁺˖˖◛⁺˖˖◛⁺˖˖◛⁺˖˖◛⁺˖˖◛⁺˖˖◛⁺˖˖◛⁺˖˖◛⁺˖˖◛⁺˖\n");
	System.out.println();
	
	do {
	System.out.println("✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉");
	System.out.println("✉ 글자의 배경색을 입력하세요                                                          ✉");
	System.out.println("✉ 0: black, 1: red, 2: green, 3: yellow, 4: blue, 5: purple, 6: cyan, 7: white ✉");
	System.out.println("✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉ \n");
	backgroundcolor = scan.nextInt();
	scan.nextLine();}while(backgroundcolor<0 || backgroundcolor > 7);
	
	System.out.println("˖◛⁺˖˖◛⁺˖˖◛⁺˖˖◛⁺˖˖◛⁺˖˖◛⁺˖˖◛⁺˖˖◛⁺˖˖◛⁺˖˖◛⁺˖ -메일 작성중- ˖◛⁺˖˖◛⁺˖˖◛⁺˖˖◛⁺˖˖◛⁺˖˖◛⁺˖˖◛⁺˖˖◛⁺˖˖◛⁺˖˖◛⁺˖\n");
	System.out.println();

	//배너 예시 어떻게 보여주징,,,?
	do {
	System.out.println("✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉");
	System.out.println("✉ 배너를 선택하세요                                                                ✉");
	System.out.println("✉ 0: 풍선 1:선물 2: 축제 3: 꽃                                                     ✉");
	System.out.println("✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉ \n");
	bannerindex = scan.nextInt();
	scan.nextLine();
	}while(bannerindex<0 || bannerindex>3);
	
	System.out.println("˖◛⁺˖˖◛⁺˖˖◛⁺˖˖◛⁺˖˖◛⁺˖˖◛⁺˖˖◛⁺˖˖◛⁺˖˖◛⁺˖˖◛⁺˖ -메일 작성중- ˖◛⁺˖˖◛⁺˖˖◛⁺˖˖◛⁺˖˖◛⁺˖˖◛⁺˖˖◛⁺˖˖◛⁺˖˖◛⁺˖˖◛⁺˖\n");
	System.out.println();
	
	System.out.println("✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉");
	System.out.println("✉ 수신자 아이디를 입력하세요                                                        ✉");
	System.out.println("✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉ \n");
	String receiver = scan.nextLine();
	System.out.println("˖◛⁺˖˖◛⁺˖˖◛⁺˖˖◛⁺˖˖◛⁺˖˖◛⁺˖˖◛⁺˖˖◛⁺˖˖◛⁺˖˖◛⁺˖ -메일 작성중- ˖◛⁺˖˖◛⁺˖˖◛⁺˖˖◛⁺˖˖◛⁺˖˖◛⁺˖˖◛⁺˖˖◛⁺˖˖◛⁺˖˖◛⁺˖\n");
	System.out.println();
	
	System.out.println("✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉");
	System.out.println("✉ 편지의 제목을 입력하세요 (100자 이내)                                              ✉");
	System.out.println("✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉✉");
	String mailtitle = scan.nextLine();
	System.out.println("˖◛⁺˖˖◛⁺˖˖◛⁺˖˖◛⁺˖˖◛⁺˖˖◛⁺˖˖◛⁺˖˖◛⁺˖˖◛⁺˖˖◛⁺˖ -메일 작성중- ˖◛⁺˖˖◛⁺˖˖◛⁺˖˖◛⁺˖˖◛⁺˖˖◛⁺˖˖◛⁺˖˖◛⁺˖˖◛⁺˖˖◛⁺˖\n");
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
  
    System.out.println("︵‿︵‿︵‿︵‿︵‿︵‿︵‿︵‿︵‿︵‿︵‿︵‿︵‿︵‿︵‿︵‿︵‿︵‿︵‿︵‿︵‿︵‿︵‿︵‿︵‿︵‿︵‿︵‿︵‿︵‿︵‿︵‿︵‿︵‿︵‿︵‿︵‿︵‿︵‿︵");    

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
	    	mailtime = scan.nextLine();
	    	System.out.println(mailtime);
	    } while (mail.checkDateFormat(mailtime));

	    System.out.println("︵‿︵‿︵‿︵‿︵‿︵‿︵‿︵‿︵‿︵‿︵‿︵‿︵‿︵‿︵‿︵‿︵‿︵‿︵‿︵‿︵‿︵‿︵‿︵‿︵‿︵‿︵‿︵‿︵‿︵‿︵‿︵‿︵‿︵‿︵‿︵‿︵‿︵‿︵‿︵ \n");    
	    
	    //mail 멤버변수 설정
	    mail.setBackgroundColorindex(backgroundcolor);
	    mail.setBannerindex(bannerindex);
	    mail.setContent(text);
	    mail.setMail_anonymity(Integer.parseInt(anoy));//anoy를 그냥 숫자로 받는건 안되낭?
	    mail.setOpenDate(mailtime);
	    mail.setReceiver(receiver);//작성 필요
	    mail.setSender(user_id);//UserDTO 받아와야하나?
	    mail.setTextColorindex(textcolor);
	    mail.setTitle(mailtitle);
	    

	    
	    System.out.println("*.☆⸜(⑉˙ᗜ˙⑉)⸝♡.**.☆⸜(⑉˙ᗜ˙⑉)⸝♡.*작성한 메일 정보를 확인합니다.*.☆⸜(⑉˙ᗜ˙⑉)⸝♡.**.☆⸜(⑉˙ᗜ˙⑉)⸝♡.*");
	    System.out.println();
	    System.out.println();
	    
	    view_mail_writing(mail);
	    
	    System.out.println("메일을 발송하시겠습니까?");
	    System.out.println("1.예 2. 아니오");
	    
	    int n = 0;
	    do {
	    	String tmp = scan.nextLine();
	    	n = Integer.parseInt(tmp);
	    	}while(!(n == 1 || n ==  2));
	    
	    if(n == 1) {
	    mail.send();
	    }else {

	    	System.out.println("˖◛⁺˖˖◛⁺˖˖◛⁺˖˖◛⁺˖˖◛⁺˖˖◛⁺˖˖◛⁺˖˖◛⁺˖˖◛⁺˖˖◛⁺˖메일을 다시 작성합니다.˖◛⁺˖˖◛⁺˖˖◛⁺˖˖◛⁺˖˖◛⁺˖˖◛⁺˖˖◛⁺˖˖◛⁺˖˖◛⁺˖˖◛⁺˖");
	    	sendMail(user_id);
	    }
	    

	    
	}

public void view_mail_writing(Mail mail) {
	String exit = "\u001B[0m";
	System.out.println("<수신자 " + mail.getReceiver()+ ">");
	System.out.println(mail.BANNER[mail.getBannerindex()]);
	System.out.println(mail.BACKGROUDCOLOR[mail.getBackgroundColorindex()]+mail.TEXTCOLOR[mail.getTextColorindex()]+mail.getContent()+exit);
	}

	

	public void deleteMail(Mail mail) {
		int mail_no = mail.getMail_no();
		ServiceImpl serviceimpl = new ServiceImpl();
	    MailDTO dto = serviceimpl.findMailByMailNo(mail_no);
	    if (dto == null) {
	        System.out.println(" 메일이 존재하지 않습니다.");
	        return;
	    }
	    
	    int n = 0;
	    try {
	    	n = serviceimpl.deleteMail(mail_no);
	    } catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
	    	System.out.println(n + "개 메일이 삭제되었습니다.");
	    }
				
	}
	
	public void viewMail(Mail mail) {
		this.mail = mail;
		mail.view();
	}
	
}

