package com.mail;
import java.util.Calendar;

import com.service.ServiceImpl;
import lombok.*;

@Data
@NoArgsConstructor
public class Mail implements MailVisual {

	int textColorindex;
	int backgroundColorindex;
	int bannerindex;
	String sender;
	String receiver;
	String title;
	String content;
	Calendar openDate;
	
	public void view() {//파라미터로 db에 저장된 거 가져오기
//		ServiceImpl serviceimpl = new ServiceImpl();
//		this.bannerindex = serviceimpl.findMailVisual(i).getBanner();//findMailVisul(메일번호)
//		this.backgroundColorindex = serviceimpl.findMailVisual(0).getBackground_color();
//		this.textColorindex = serviceimpl.findMailVisual(0).getText_color();
//		this.content = serviceimpl.findMail(DTO.user_no).get().getMail_contents();		
		//findMail(수신자번호 = 로그인한 유저 번호).get(mail_no).getMail_contents()
		//로그인한 유저 아이디 main 함수에서 저장해놔야할듯 ㅇㅅㅇ
		
//		this.bannerindex = 0;0
//		this.backgroundColorindex = 3;
//		this.textColorindex = 4;
//		this.content = "삼성전자는 메모리 반도체 시장 불황에 경쟁사들이 투자 축소와 감산 기조를 밝혔을 때도 ‘(삼성전자에) 인위적인 감산은 없다’는 입장을 고수해 왔다. 하지만 손실이 커지자, 반도체 생산 유지를 통한 점유율 확대보다 감산으로 수익성을 확대하는 길을 택했다. 삼성전자는 앞서 지난 7일 1분기 잠정 실적 발표 시 “의미 있는 수준까지 메모리 생산량을 하향 조정 중”이라고 했었다. 이라며 사실상 감산을 처음으로 공식 인정했다.";
		System.out.printf(BANNER[this.bannerindex]);
		
		String[] contentsBuffer = this.content.split("(?<=\\G.{" + 50 + "})"); 
		
		for(String content:contentsBuffer) {
		System.out.printf("%s%s%s\n",BACKGROUDCOLOR[this.backgroundColorindex],TEXTCOLOR[this.textColorindex], content );}

		
	}
	 
}
