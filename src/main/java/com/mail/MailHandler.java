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

        if (len > 50) {
            while (len > 0) {
                int endIndex = len > 50 ? 50 : len;
                text += line.substring(0, endIndex) + "\n";
                line = line.substring(endIndex);
                len = line.length();
                count += 50;
                if (count >= 300) {
                    break;
                }
            }
        } else {
            text += line + "\n";
            count += len + 1;
        }

        if (line.contains("올림") || count >= 300) {
            break;
        }
    }
    System.out.println(text);
	    System.out.println("==============================================================");
	    return mail;
	}
	
	
	
	
	
	
//	String text = scan.nextLine();
//	System.out.println("==============================================================");
//	return mail;
//}

public void deleteMail() {	

}
	
}