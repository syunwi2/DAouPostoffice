package com.dto;

import java.util.Calendar;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MailDTO {
	int mail_no;
	String mail_title;
	String mail_content;
	int mail__anonymity;
	Calendar mail_date;
	int send_user_no;
	int receive_user_no;
}
