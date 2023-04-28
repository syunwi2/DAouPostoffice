package com.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MailDTO {
	int mail_no;
	String mail_title;
	String mail_contents;
	int mail__anonymity;
	Date mail_date;
	int send_user_no;
	int receive_user_no;
}
