package com.user;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class User implements MailBox {
	public static final String exit     = "\u001B[0m";
	String id = "kk2522"; // 더미값
	String passwd;
	String name;
	int textColorindex;
	int shapeIndex;
	List<String> receiveMails = new ArrayList<String>();
	public void getBox() {
		
		String sql = "select textcolor, shape from MailBox where id =" + this.id;
		System.out.println(sql);
		this.setTextColorindex(5); // 더미값 대입
		this.setShapeIndex(3); // 더미값 대입
		
	}
	
	
	public void viewBox() {
		String sql = "select m.mail_title, m.mail_anonymity,"
				+ "m.mail_date,m.send_user_no from Mail m,"
				+ " User u where u.user_no = m.receive_user_no and"
				+ " user_id =" + this.id;
		
		String[] temp = { "aa", "bb", "cc" };
		for(String i : temp) {
			this.receiveMails.add(i); // 갖고온 mail receiveMail에 넣음
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
		this.setTextColorindex(textColor);
		this.setShapeIndex(shape);
		String sql = "update Mailbox m inner join User u"
				+ "on m.user_no = u.User_user_no"
				+ "set m.mailbox_color ="
		+ this.getTextColorindex()
		+", m.mailbox_shape = " 
		+ this.getShapeIndex() +
		"where u.user_id = " + this.id;
		
		
		
	}
	
	

}
