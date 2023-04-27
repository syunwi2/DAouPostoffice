package com.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.dao.DAO;
import com.dto.*;
import com.exception.*;

public class ServiceImpl implements Service{

	static SqlSessionFactory sqlSessionFactory;
    static {
    	String resource = "com/mybatis/Configuration.xml";
    	InputStream inputStream=null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
    	sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }//end static block
    
    /*
	   SqlSession session = sqlSessionFactory.openSession();
		try {
			
		}finally {
			session.close();
		}
	*/

    // ========== INSERT =========
	@Override
	public int insertUser(UserDTO dto) throws DuplicatedNumberException {
		SqlSession session = sqlSessionFactory.openSession();
		int n = 0;
		try {
			DAO dao = new DAO();
			n = dao.insertUser(session, dto);
			session.commit();
		} catch (Exception e) {
			throw new DuplicatedNumberException("사용자 고유 번호 " + dto.getUser_no() + "이 이미 사용 중입니다.");
		} finally {
			session.close();
		}
		return n;
	}
	@Override
	public int insertMailBox(MailBoxDTO dto) throws DuplicatedNumberException {
		SqlSession session = sqlSessionFactory.openSession();
		int n = 0;
		try {
			DAO dao = new DAO();
			n = dao.insertMailBox(session, dto);
			session.commit();
		} catch (Exception e) {
			throw new DuplicatedNumberException("이미 존재하는 사용자 " + dto.getUser_user_no() + "의 우체통을 새로 생성할 수 없습니다.");
		} finally {
			session.close();
		}
		return n;
	}
	@Override
	public int insertMail(MailDTO dto) throws DuplicatedNumberException {
		SqlSession session = sqlSessionFactory.openSession();
		int n = 0;
		try {
			DAO dao = new DAO();
			n = dao.insertMail(session, dto);
			session.commit();
		} catch (Exception e) {
			throw new DuplicatedNumberException("편지 고유 번호 " + dto.getMail_no() + "이 이미 사용 중입니다.");
		} finally {
			session.close();
		}
		return n;
	}
	@Override
	public int insertMailVisual(MailVisualDTO dto) throws DuplicatedNumberException {
		SqlSession session = sqlSessionFactory.openSession();
		int n = 0;
		try {
			DAO dao = new DAO();
			n = dao.insertMailVisual(session, dto);
			session.commit();
		} catch (Exception e) {
			throw new DuplicatedNumberException("이미 존재하는 편지 " + dto.getMail_mail_no() + "의 편지지를 새로 생성할 수 없습니다.");
		} finally {
			session.close();
		}
		return n;
	}
	
	// ========== UPDATE =========
	@Override
	public int updateUser(UserDTO dto) throws RecordNotFoundException {
		SqlSession session = sqlSessionFactory.openSession();
		int n = 0;
		try {
			DAO dao = new DAO();
			n = dao.updateUser(session, dto);
			if (n == 0) {
				throw new RecordNotFoundException("해당되는 레코드가 존재하지 않습니다.");
			}
			session.commit();
		}finally {
			session.close();
		}
		return n;
	}
	@Override
	public int updateMailBox(MailBoxDTO dto) throws RecordNotFoundException {
		SqlSession session = sqlSessionFactory.openSession();
		int n = 0;
		try {
			DAO dao = new DAO();
			n = dao.updateMailBox(session, dto);
			if (n == 0) {
				throw new RecordNotFoundException("해당되는 레코드가 존재하지 않습니다.");
			}
			session.commit();
		}finally {
			session.close();
		}
		return n;
	}
	
	// ========== DELETE =========
	@Override
	public int deleteUser(int user_no) throws RecordNotFoundException {
		SqlSession session = sqlSessionFactory.openSession();
		int n = 0;
		try {
			DAO dao = new DAO();
			n = dao.deleteUser(session, user_no);
			if (n == 0) {
				throw new RecordNotFoundException("해당되는 레코드가 존재하지 않습니다.");
			}
			session.commit();
		}finally {
			session.close();
		}
		return n;
	}
	@Override
	public int deleteMailBox(int user_user_no) throws RecordNotFoundException {
		SqlSession session = sqlSessionFactory.openSession();
		int n = 0;
		try {
			DAO dao = new DAO();
			n = dao.deleteUser(session, user_user_no);
			if (n == 0) {
				throw new RecordNotFoundException("해당되는 레코드가 존재하지 않습니다.");
			}
			session.commit();
		}finally {
			session.close();
		}
		return n;
	}
	@Override
	public int deleteMail(int mail_no) throws RecordNotFoundException {
		SqlSession session = sqlSessionFactory.openSession();
		int n = 0;
		try {
			DAO dao = new DAO();
			n = dao.deleteUser(session, mail_no);
			if (n == 0) {
				throw new RecordNotFoundException("해당되는 레코드가 존재하지 않습니다.");
			}
			session.commit();
		}finally {
			session.close();
		}
		return n;
	}
	@Override
	public int deleteMailVisual(int mail_mail_no) throws RecordNotFoundException {
		SqlSession session = sqlSessionFactory.openSession();
		int n = 0;
		try {
			DAO dao = new DAO();
			n = dao.deleteUser(session, mail_mail_no);
			if (n == 0) {
				throw new RecordNotFoundException("해당되는 레코드가 존재하지 않습니다.");
			}
			session.commit();
		}finally {
			session.close();
		}
		return n;
	}

	// ========== SELECT =========
	@Override
	public UserDTO findUser(UserDTO dto) {
		SqlSession session = sqlSessionFactory.openSession();
		UserDTO list = null;
		try {
			DAO dao = new DAO();
			list = dao.findUser(session, dto);
		}finally {
			session.close();
		}
		return list;
	}
	@Override
	public List<UserDTO> findUserAll(String user_name) {
		SqlSession session = sqlSessionFactory.openSession();
		List<UserDTO> list = null;
		try {
			DAO dao = new DAO();
			list = dao.findUserAll(session, user_name);
		}finally {
			session.close();
		}
		return list;
	}
	@Override
	public MailBoxDTO findMailBox(int user_user_no) {
		SqlSession session = sqlSessionFactory.openSession();
		MailBoxDTO list = null;
		try {
			DAO dao = new DAO();
			list = dao.findMailBox(session, user_user_no);
		}finally {
			session.close();
		}
		return list;
	}
	@Override
	public List<MailDTO> findMail(int receive_user_no) {
		SqlSession session = sqlSessionFactory.openSession();
		List<MailDTO> list = null;
		try {
			DAO dao = new DAO();
			list = dao.findMail(session, receive_user_no);
		}finally {
			session.close();
		}
		return list;
	}
	@Override
	public MailVisualDTO findMailVisual(int mail_mail_no) {
		SqlSession session = sqlSessionFactory.openSession();
		MailVisualDTO list = null;
		try {
			DAO dao = new DAO();
			list = dao.findMailVisual(session, mail_mail_no);
		}finally {
			session.close();
		}
		return list;
	}
	
}
