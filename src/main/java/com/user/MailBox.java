package com.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public interface MailBox {
	
	public String[] textColor = {"\u001B[30m","\u001B[31m",
			"\u001B[32m","\u001B[33m","\u001B[34m"
			,"\u001B[35m","\u001B[36m","\u001B[37m","\u001B[0m"};
	public String[] shape = new String[10];
	public abstract void viewBox();
	public abstract void upDateBox(int textColor, int shape);
	
}
