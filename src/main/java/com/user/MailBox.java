package com.user;

import lombok.Data;

@Data

public interface MailBox {
	
	public String[] textColor = new String[10];
	public String[] shape = new String[10];
	public abstract void viewBox();
	public abstract void upDateBox();
	
}
