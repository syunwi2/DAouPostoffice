package com.user;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class User implements MailBox {
	String id = "kk2522";
	String passwd;
	String name;
	int textColorindex;
	int shapeIndex;
	List<String> receiveMails = new ArrayList<String>();
	public void getBox() {
		
		String sql = "select textcolor, shape from MailBox where id =" + this.id;
		System.out.println(sql);
		this.setTextColorindex(3); // 더미값 대입
		this.setShapeIndex(3); // 더미값 대입
		
	}
	
	
	public void viewBox() {
		
		
		
	}

	public void upDateBox(int textColor, int shape) {
		
	}
	
	

}
