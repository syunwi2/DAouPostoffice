package com.user;
import com.mail.Mail;
import com.dto.MailBoxDTO;
import com.dto.MailDTO;
import com.dto.MailVisualDTO;
import com.exception.RecordNotFoundException;
import com.service.Service;
import com.service.ServiceImpl;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.dto.UserDTO;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class User implements MailBox {
	public static final String exit     = "\u001B[0m";
	int user_no;
	String id; // 더미값
	String passwd;
	String name;
	int textColorindex;
	int shapeIndex;
	List<Mail> receiveMails = new ArrayList<Mail>();
	
	public void getBox() {
		MailBoxDTO box = new MailBoxDTO();
		Service service = new ServiceImpl();
		box = service.findMailBox(this.user_no);
		this.setTextColorindex(box.getMailbox_color()); // 더미값 대입
		this.setShapeIndex(box.getMailbox_shape()); // 더미값 대입
		
	}
	
	
	public void viewBox() {
		List<MailDTO> m = new ArrayList<MailDTO>();

		Service service = new ServiceImpl();
		m = service.findMail(user_no);
		
		for(MailDTO i : m) {
			
			MailVisualDTO m2 = service.findMailVisual(i.getMail_no());
	
			UserDTO m3 = service.findUserByUserNo(i.getSend_user_no());
			UserDTO m4 = service.findUserByUserNo(i.getReceive_user_no());
			receiveMails.add(new Mail(i.getMail_no(),m2.getText_color(),
					m2.getBackground_color(),m2.getBanner(),
					i.getMail__anonymity(), m3.getUser_name(),m4.getUser_name(),
					i.getMail_title(),i.getMail_contents(),i.getMail_date().toString()
					));
			
		}
		
		String tmp = null;
		switch(this.textColorindex)// shapeindex 별로 출력
		{
		case 0:
			tmp = MailBox.textColor[0];
			break;
		case 1:
			tmp = MailBox.textColor[1];
			break;
		case 2:
			tmp = MailBox.textColor[2];
			break;
		case 3:
			tmp = MailBox.textColor[3];
			break;
		case 4:
			tmp = MailBox.textColor[4];
			break;
		case 5:
			tmp = MailBox.textColor[5];
			break;
		case 6:
			tmp = MailBox.textColor[6];
			break;
		case 7:
			tmp = MailBox.textColor[7];
			break;
		
		}
		
		switch(this.shapeIndex)// shapeindex 별로 출력
		{
		case 0:
			System.out.println(tmp + MailBox.shape[0] + exit);
			break;
		case 1:
			System.out.println(tmp + MailBox.shape[1] + exit);
			break;
		case 2:
			System.out.println(tmp + MailBox.shape[2] +exit);
			break;
		case 3:
			System.out.println(tmp + MailBox.shape[3] + exit);
			break;
		
		}
		
		
	}

	public void upDateBox(int textColor, int shape) {
		
		MailBoxDTO box = new MailBoxDTO(textColor,shape,user_no);
		Service service = new ServiceImpl();
		try {
			service.updateMailBox(box);
			getBox();
		} catch (RecordNotFoundException e) {
			e.getMessage();
		}
		
	}
	
	

}

