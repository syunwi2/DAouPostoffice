package com.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import com.dto.MailBoxDTO;
import com.dto.MailDTO;
import com.dto.MailVisualDTO;
import com.dto.UserDTO;

class DAOTest {
	
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

	@Test
	void testInsertUser() {
		SqlSession session = sqlSessionFactory.openSession();
		DAO dao = new DAO();
		
		// insert new user
		assertEquals(1, dao.insertUser(session, new UserDTO(-1, "myTestCase", "0000", "myTestCase")));
		// insert new user with id already used.
		assertEquals(1, dao.insertUser(session, new UserDTO(-1, "master", "0000", "master")));
		
		session.close();
	}

	@Test
	void testInsertMailBox() {
		SqlSession session = sqlSessionFactory.openSession();
		DAO dao = new DAO();
		UserDTO user = new UserDTO(-1, "myTestCase", "0000", "myTestCase");
		
		dao.insertUser(session, user);
		
		// insert new MailBox
		assertEquals(1, dao.insertMailBox(session, new  MailBoxDTO(0, 0, user.getUser_no())));
		
		session.close();
	}

	@Test
	void testInsertMail() {
		SqlSession session = sqlSessionFactory.openSession();
		DAO dao = new DAO();
		
		// insert new mail
		assertEquals(1, dao.insertMail(session, new MailDTO(-1, "title", "contents", 0, new Date(2023, 0, 1), 9, 9)));
	
		session.close();
	}

	@Test
	void testInsertMailVisual() {
		SqlSession session = sqlSessionFactory.openSession();
		DAO dao = new DAO();
		MailDTO mail = new MailDTO(-1, "title", "contents", 0, new Date(2023, 0, 1), 9, 9);
		
		dao.insertMail(session, mail);
		
		// insert new MailVisual
		assertEquals(1, dao.insertMailVisual(session, new MailVisualDTO(0, 0, 0, mail.getMail_no())));
		
		session.close();
	}

	@Test
	void testUpdateUser() {
		SqlSession session = sqlSessionFactory.openSession();
		DAO dao = new DAO();
		
		// update user
		assertEquals(1, dao.updateUser(session, new UserDTO(9, "myTestCase", "0000", "myTestCaseUpate")));
		
		session.close();
	}

	@Test
	void testUpdateMailBox() {
		SqlSession session = sqlSessionFactory.openSession();
		DAO dao = new DAO();
		
		// update MailBox
		assertEquals(1, dao.updateMailBox(session, new MailBoxDTO(0, 0, 9)));
		
		session.close();
	}

	@Test
	void testDeleteUser() {
		SqlSession session = sqlSessionFactory.openSession();
		DAO dao = new DAO();
		
		// delete user
		assertEquals(1, dao.deleteUser(session, 9));
		
		// delete user not exists.
		assertEquals(0, dao.deleteUser(session, -1));
		
		session.close();
	}

	@Test
	void testDeleteMailBox() {
		SqlSession session = sqlSessionFactory.openSession();
		DAO dao = new DAO();
		
		// delete MailBox
		assertEquals(1, dao.deleteMailBox(session, 9));
		
		// delete MailBox not exists.
		assertEquals(0, dao.deleteMailBox(session, -1));
		
		session.close();
	}

	@Test
	void testDeleteMail() {
		SqlSession session = sqlSessionFactory.openSession();
		DAO dao = new DAO();
		
		// delete Mail
		assertEquals(1, dao.deleteMail(session, 3));
		
		// delete Mail not exists.
		assertEquals(0, dao.deleteMail(session, -1));
		
		session.close();
	}

	@Test
	void testDeleteMailVisual() {
		SqlSession session = sqlSessionFactory.openSession();
		DAO dao = new DAO();
		
		// delete MailVisual
		assertEquals(1, dao.deleteMail(session, 3));
		
		// delete MailVisual not exists.
		assertEquals(0, dao.deleteMail(session, -1));
		
		session.close();
	}

	@Test
	void testIsIDused() {
		SqlSession session = sqlSessionFactory.openSession();
		DAO dao = new DAO();
		UserDTO dto = new UserDTO();
		
		// select id used
		assertInstanceOf(dto.getClass(), dao.isIDused(session, "master"));
		
		// select id not used
		assertNull(dao.isIDused(session, "myTestCase"));
		
		session.close();
	}

	@Test
	void testFindUser() {
		SqlSession session = sqlSessionFactory.openSession();
		DAO dao = new DAO();
		UserDTO dto = new UserDTO();
		
		// select user with right data
		assertInstanceOf(dto.getClass(), dao.findUser(session, new UserDTO(-1, "master", "0000", "master")));
		
		// select user with wrong data
		assertNull(dao.findUser(session, new UserDTO(-1, "master", "1111", "master")));
		
		session.close();
	}

	@Test
	void testFindUserAll() {
		SqlSession session = sqlSessionFactory.openSession();
		DAO dao = new DAO();
		List<UserDTO> list = new ArrayList<>();
		
		// select user with id used
		assertInstanceOf(list.getClass(), dao.findUserAll(session, "master"));
		
		session.close();	
	}

	@Test
	void testFindUserByUserNo() {
		SqlSession session = sqlSessionFactory.openSession();
		DAO dao = new DAO();
		UserDTO dto = new UserDTO();
		
		// select user with right data
		assertInstanceOf(dto.getClass(), dao.findUserByUserNo(session, 9));
		
		session.close();
	}

	@Test
	void testFindMailBox() {
		SqlSession session = sqlSessionFactory.openSession();
		DAO dao = new DAO();
		MailBoxDTO dto = new MailBoxDTO();
		
		assertInstanceOf(dto.getClass(), dao.findMailBox(session, 9));
		
		session.close();
	}

	@Test
	void testFindMail() {
		SqlSession session = sqlSessionFactory.openSession();
		DAO dao = new DAO();
		List<MailDTO> list = new ArrayList<>();
		
		assertInstanceOf(list.getClass(), dao.findMail(session, 9));
		
		session.close();
	}

	@Test
	void testFindMailByMailNo() {
		SqlSession session = sqlSessionFactory.openSession();
		DAO dao = new DAO();
		MailDTO dto = new MailDTO();
		
		assertInstanceOf(dto.getClass(), dao.findMailByMailNo(session, 3));
		
		session.close();
	}

	@Test
	void testFindMailVisual() {
		SqlSession session = sqlSessionFactory.openSession();
		DAO dao = new DAO();
		MailVisualDTO dto = new MailVisualDTO();
		
		assertInstanceOf(dto.getClass(), dao.findMailVisual(session, 3));
		
		session.close();
	}

}
