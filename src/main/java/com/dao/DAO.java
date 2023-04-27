package com.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.*;

public class DAO {

	// insert
	public int insertUser(SqlSession session, UserDTO dto) {
		int n = session.insert("insertUser", dto);
		return n;
	}
	
	public int insertMailBox(SqlSession session, MailBoxDTO dto) {
		int n = session.insert("insertMailBox", dto);
		return n;
	}
	
	public int insertMail(SqlSession session, MailDTO dto) {
		int n = session.insert("insertMail", dto);
		return n;
	}
	
	public int insertMailVisual(SqlSession session, MailVisualDTO dto) {
		int n = session.insert("insertMailVisual", dto);
		return n;
	}
	
	// update
	public int updateUser(SqlSession session, UserDTO dto) {
		int n = session.update("updateUser", dto);
		return n;
	}
	
	public int updateMailBox(SqlSession session, MailBoxDTO dto) {
		int n = session.update("updateMailBox", dto);
		return n;
	}
	
	// delete
	public int deleteUser(SqlSession session, int user_no) {
		int n = session.delete("deleteUser", user_no);
		return n;
	}
	
	public int deleteMailBox(SqlSession session, int user_user_no) {
		int n = session.delete("deleteMailBox", user_user_no);
		return n;
	}
	
	public int deleteMail(SqlSession session, int mail_no) {
		int n = session.delete("deleteMail", mail_no);
		return n;
	}
	
	public int deleteMailVisual(SqlSession session, int mail_mail_no) {
		int n = session.delete("deleteMailVisual", mail_mail_no);
		return n;
	}
	
	// select
	public UserDTO isIDused(SqlSession session, String user_id) {
		UserDTO list = session.selectOne("isIDused", user_id);
		return list;
	}
	public UserDTO findUser(SqlSession session, UserDTO dto) {
		UserDTO list = session.selectOne("findUser", dto);
		return list;
	}
	
	public List<UserDTO> findUserAll(SqlSession session, String user_name) {
		List<UserDTO> list = session.selectList("findUserAll", user_name);
		return list;
	}
	
	public MailBoxDTO findMailBox(SqlSession session, int user_user_no) {
		MailBoxDTO list = session.selectOne("findMailBox", user_user_no);
		return list;
	}
	
	public List<MailDTO> findMail(SqlSession session, int receive_user_no) {
		List<MailDTO> list = session.selectList("findMailBox", receive_user_no);
		return list;
	}
	
	public MailVisualDTO findMailVisual(SqlSession session, int mail_mail_no) {
		MailVisualDTO list = session.selectOne("findMailBox", mail_mail_no);
		return list;
	}
}
