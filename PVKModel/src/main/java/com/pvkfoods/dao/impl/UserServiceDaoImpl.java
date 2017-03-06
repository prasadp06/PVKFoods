package com.pvkfoods.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pvkfoods.DAOException;
import com.pvkfoods.dao.UserServiceDao;
import com.pvkfoods.dao.bean.UserBean;
import com.pvkfoods.dao.mapper.UserServiceMapper;

/**
 * 
 * @author prasadprabhakaran
 *
 */
@Service
public class UserServiceDaoImpl implements UserServiceDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	UserServiceMapper userMapper;

	private UserServiceMapper getMapper(){
		userMapper = sqlSession.getMapper(UserServiceMapper.class);
		return userMapper;
	}
	
	@Override
	public boolean save(UserBean user) throws DAOException {
		try {
			userMapper = getMapper();
					
			userMapper.saveUser(user);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("Error While Accessing Data", e);
		}finally {
		}
		return true;
	}

	@Override
	public boolean update(UserBean user) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public UserBean get(Long userId) throws DAOException {
		try {
			userMapper = getMapper();
			return userMapper.getUser(userId);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("Error While Accessing Data", e);
		}finally {
		}
	}

	@Override
	public UserBean get(String username) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Long userId) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<UserBean> getAll() throws DAOException {
		try {
			userMapper = getMapper();
			return userMapper.getAllUsers();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("Error While Accessing Data", e);
		}finally {
		}
		
	}

	@Override
	public List<UserBean> searchUser(String firstName, String lastName) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	public SqlSession getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

}
