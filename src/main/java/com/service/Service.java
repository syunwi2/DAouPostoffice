package com.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.*;
import com.exception.*;

public interface Service {
	
	// insert
	public int insertUser(UserDTO dto) throws DuplicatedNumberException;
	public int insertMailBox(MailBoxDTO dto) throws DuplicatedNumberException;
	public int insertMail(MailDTO dto) throws DuplicatedNumberException;
	public int insertMailVisual(MailVisualDTO dto) throws DuplicatedNumberException;
	
	// update
	public int updateUser(UserDTO dto) throws RecordNotFoundException;
	public int updateMailBox(MailBoxDTO dto) throws RecordNotFoundException;
	
	// delete
	public int deleteUser(int user_no) throws RecordNotFoundException;
	public int deleteMailBox(int user_user_no) throws RecordNotFoundException;
	public int deleteMail(int mail_no) throws RecordNotFoundException;
	public int deleteMailVisual(int mail_mail_no) throws RecordNotFoundException;
	
	// select
	public UserDTO isIDused(String user_id);
	public UserDTO findUser(UserDTO dto);
	public List<UserDTO> findUserAll(String user_name);
	public UserDTO findUserByUserNo(int user_no);
	public MailBoxDTO findMailBox(int user_user_no);
	public List<MailDTO> findMail(int receive_user_no);
	public MailDTO findMailByMailNo(int mail_no);
	public MailVisualDTO findMailVisual(int mail_mail_no);
}
