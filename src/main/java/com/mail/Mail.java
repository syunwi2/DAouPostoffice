package com.mail;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.dto.MailDTO;
import com.service.ServiceImpl;
import lombok.*;
import com.exception.OutofDateException;

@Data
@NoArgsConstructor
public class Mail implements MailVisual {

	int textColorindex;
	int backgroundColorindex;
	int bannerindex;
	int mail_anonymity;//_하나 빼야하지 않
	String sender;
	String receiver;
	String title;
	String content;
	String openDate;//Date로 변경
	
	//String 형태로 받은 날짜 정보를 db에 넣기 위해 date 타입으로 변환하는 함수
	
//	private boolean isRightFormat(String date) {
//		
//		return date ==
//	}
	private Date transformDate(String date)
	    {
	        SimpleDateFormat beforeFormat = new SimpleDateFormat("yyyymmdd");
	        
	        // Date로 변경하기 위해 날짜 형식 yyyy-mm-dd로 변경
	        SimpleDateFormat afterFormat = new SimpleDateFormat("yyyy-mm-dd");
	        
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
	
	public void view() {//파라미터로 db에 저장된 거 가져오기
//		ServiceImpl serviceimpl = new ServiceImpl();
//		this.bannerindex = serviceimpl.findMailVisual(i).getBanner();//findMailVisul(메일번호)
//		this.backgroundColorindex = serviceimpl.findMailVisual(0).getBackground_color();
//		this.textColorindex = serviceimpl.findMailVisual(0).getText_color();
//		this.content = serviceimpl.findMail(DTO.user_no).get().getMail_contents();		
		//findMail(수신자번호 = 로그인한 유저 번호).get(mail_no).getMail_contents()
		//로그인한 유저 아이디 main 함수에서 저장해놔야할듯 ㅇㅅㅇ
//		
//		this.bannerindex = 0;
//		this.backgroundColorindex = 7;
//		this.textColorindex = 0;
//		this.content = "삼성전자는 메모리 반도체 시장 불황에 경쟁사들이 투자 축소와 감산 기조를 밝혔을 때도 ‘(삼성전자에) 인위적인 감산은 없다’는 입장을 고수해 왔다. 하지만 손실이 커지자, 반도체 생산 유지를 통한 점유율 확대보다 감산으로 수익성을 확대하는 길을 택했다. 삼성전자는 앞서 지난 7일 1분기 잠정 실적 발표 시 “의미 있는 수준까지 메모리 생산량을 하향 조정 중”이라고 했었다. 이라며 사실상 감산을 처음으로 공식 인정했다.";
//		System.out.printf(BANNER[this.bannerindex]);
		
		//String[] contentsBuffer = this.content.split("(?<=\\G.{" + 50 + "})"); 
		
		System.out.println(BACKGROUDCOLOR[this.backgroundColorindex]+TEXTCOLOR[this.textColorindex]+this.content);}
		
	public void send() {
			MailDTO dto = new MailDTO();
			ServiceImpl serviceimpl = new ServiceImpl();
			//receiver_no랑 sender_no는 user 클래스 구현하는 거 보고 바뀔 수 있당!
			int receiver_no = serviceimpl.isIDused(receiver).getUser_no();
			int sender_no = serviceimpl.isIDused(sender).getUser_no();
			Date date = this.transformDate(this.openDate);
			dto.setMail_contents(this.content);
			dto.setMail_date(date);
			dto.setMail__anonymity(this.mail_anonymity);
			dto.setMail_title(this.title);
			dto.setReceive_user_no(receiver_no);
			dto.setSend_user_no(sender_no);
			
			int n = 0;
			try{
				n = serviceimpl.insertMail(dto);
			}catch(Exception e) {
				e.getMessage();
			} finally {
				System.out.println(n + "개의 편지가 발송되었습니다.");
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

	
	