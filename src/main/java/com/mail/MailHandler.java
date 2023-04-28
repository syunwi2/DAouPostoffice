package com.mail;

import java.util.Scanner;

public class MailHandler {
	
public static Mail sendMail() {	
	
	Mail mail = new Mail();
	Scanner scan = new Scanner(System.in);
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

	    System.out.println("상대방이 편지를 읽을 수 있는 시간을 설정해주세요 (yyyy/mm//dd)");
	    String mailtime = scan.nextLine();
	    do {
	        if (!mailtime.matches("\\d{4}/\\d{2}/\\d{2}")) {
	            System.out.println("날짜 형식에 맞게 다시 입력하세요");
	            mailtime = scan.nextLine();
	        }
	    } while (!mailtime.matches("\\d{4}/\\d{2}/\\d{2}"));
	    
	    return mail;
	    

	    
	    
	    
	}
	

public void deleteMail() {	

}
	
}
