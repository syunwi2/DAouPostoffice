package com.mail;

import lombok.*;

@Getter @Setter
@NoArgsConstructor
public class Mail implements MailVisual {

	public void view() {//파라미터로 db에 저장된 거 가져오기
		System.out.println(BANNER[0]);//인덱스 : db에 저장된 값 가져오기
		System.out.println(BACKGROUDCOLOR[1]+TEXTCOLOR[4]+ "DB.CONTENT");//인덱스 : db에 저장된 값 가져오기
		System.out.println();
	}
	 
}
