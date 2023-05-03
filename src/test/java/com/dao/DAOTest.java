package com.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;

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
		
		// delete user not exists.
	}

	@Test
	void testDeleteMailBox() {
		SqlSession session = sqlSessionFactory.openSession();
		DAO dao = new DAO();
	}

	@Test
	void testDeleteMail() {
		SqlSession session = sqlSessionFactory.openSession();
		DAO dao = new DAO();
	}

	@Test
	void testDeleteMailVisual() {
		SqlSession session = sqlSessionFactory.openSession();
		DAO dao = new DAO();
	}

	@Test
	void testIsIDused() {
		SqlSession session = sqlSessionFactory.openSession();
		DAO dao = new DAO();
	}

	@Test
	void testFindUser() {
		SqlSession session = sqlSessionFactory.openSession();
		DAO dao = new DAO();
	}

	@Test
	void testFindUserAll() {
		SqlSession session = sqlSessionFactory.openSession();
		DAO dao = new DAO();
	}

	@Test
	void testFindUserByUserNo() {
		SqlSession session = sqlSessionFactory.openSession();
		DAO dao = new DAO();
	}

	@Test
	void testFindMailBox() {
		SqlSession session = sqlSessionFactory.openSession();
		DAO dao = new DAO();
	}

	@Test
	void testFindMail() {
		SqlSession session = sqlSessionFactory.openSession();
		DAO dao = new DAO();
	}

	@Test
	void testFindMailByMailNo() {
		SqlSession session = sqlSessionFactory.openSession();
		DAO dao = new DAO();
	}

	@Test
	void testFindMailVisual() {
		SqlSession session = sqlSessionFactory.openSession();
		DAO dao = new DAO();
	}

}
