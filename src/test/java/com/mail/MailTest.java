package com.mail;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.jupiter.api.Test;

import com.exception.OutofDateException;

class MailTest {

	@Test
	void checkDateFormat() {
    	boolean flag = false;
    	String date = "20230603";
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
    	assertEquals(false, flag);
    }

}
