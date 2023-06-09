package com.mail;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import com.exception.OutofDateException;

import com.dto.MailDTO;
import com.dto.MailVisualDTO;
import com.service.ServiceImpl;
import lombok.*;
import com.exception.OutofDateException;



@Data
@NoArgsConstructor
@AllArgsConstructor

public class Mail implements MailVisual {
	int mail_no;
	int textColorindex;
	int backgroundColorindex;
	int bannerindex;
	int mail_anonymity;
	String sender;
	String receiver;
	String title;
	String content;
	String openDate;
	
	//String 형태로 받은 날짜 정보를 db에 넣기 위해 date 타입으로 변환하는 함수
 	private Date transformDate(String date)
	    {
	        SimpleDateFormat beforeFormat = new SimpleDateFormat("yyyyMMdd");
	        
	        // Date로 변경하기 위해 날짜 형식 yyyy-mm-dd로 변경
	        SimpleDateFormat afterFormat = new SimpleDateFormat("yyyy-MM-dd");
	        
	        java.util.Date tempDate = null;
	        
	        try {
	            // 현재 날짜 형식(yyyymmdd)으로 java.util.Date객체를 생성
	            tempDate = beforeFormat.parse(date);
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }
	        
	        // java.util.Date를 yyyy-mm-dd 형식으로 변경하여 String로 반환한다.
	        String transDate = afterFormat.format(tempDate);
	        
	        // 반환된 String 값을 Date로 변경한다.
	        Date d = Date.valueOf(transDate);
	        
	        return d;
	    }
	
	public void view() {
		System.out.println("보낸 사람: "+ (mail_anonymity == 0? "익명의 작성자": sender));
		String exit = "\u001B[0m";
		System.out.printf(BANNER[bannerindex]);
		System.out.println(BACKGROUDCOLOR[backgroundColorindex]+TEXTCOLOR[textColorindex]+content+exit);
    }

		
	public void send() {
			MailDTO mail_dto = new MailDTO();
			MailVisualDTO visual_dto = new MailVisualDTO();
			ServiceImpl serviceimpl = new ServiceImpl();
			int receiver_no = serviceimpl.isIDused(this.receiver).getUser_no();
			int sender_no = serviceimpl.isIDused(this.sender).getUser_no();
			Date date = this.transformDate(this.openDate);
			
			mail_dto.setMail_no(-1);
			mail_dto.setMail_contents(this.content);
			mail_dto.setMail_date(date);
			mail_dto.setMail__anonymity(this.mail_anonymity);
			mail_dto.setMail_title(this.title);
			mail_dto.setReceive_user_no(receiver_no);
			mail_dto.setSend_user_no(sender_no);
			
			visual_dto.setText_color(this.textColorindex);
			visual_dto.setBackground_color(this.backgroundColorindex);
			visual_dto.setBanner(this.bannerindex);
			
			int n = 0;
			try{
				n = serviceimpl.insertMail(mail_dto);
				visual_dto.setMail_mail_no(mail_dto.getMail_no());
				n = serviceimpl.insertMailVisual(visual_dto);
			}catch(Exception e) {
				System.out.println(e.getMessage());
			} finally {
				System.out.println(" 💜 " + n + "개의 편지가 발송되었습니다. 💜 ");
			}
	}
	public boolean checkDateFormat(String date) {
    	boolean flag = false;
    	String curTime = new SimpleDateFormat("yyyyMMdd").format(new java.util.Date()).toString();
    	SimpleDateFormat dateFormatParser = new SimpleDateFormat("yyyyMMdd");//검증할 날짜 포맷 설정
    	try {
            dateFormatParser.setLenient(false); //입력한 값 잘못된 형식일 경우 오류 발생
            dateFormatParser.parse(date); //대상 값 포맷에 적용되는지 확인
            
            if(Integer.parseInt(date)<Integer.parseInt(curTime)) {
            	//과거 날짜 입력 시 예외 발생
            	throw new OutofDateException("유효한 날짜를 입력해주세요.");
            }

        } catch (ParseException e) {
            flag =  true;
            System.out.println("형식에 맞게 입력해주세요(yyyymmdd)");
        } catch(OutofDateException e) {
        	flag = true;
        	System.out.println("유효한 날짜를 입력해주세요.");
        }
    	return flag;
    }
		
		 
}

	
	