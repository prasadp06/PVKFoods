package com.pvkfoods.dao;

import java.util.List;

import com.pvkfoods.DAOException;
import com.pvkfoods.dao.bean.UserBean;

/**
 * @author prasadprabhakaran
 *
 */
public interface UserServiceDao {
	
	public boolean save(UserBean user) throws DAOException;
	
	public boolean update(UserBean user) throws DAOException;
	
	public UserBean get(Long userId) throws DAOException;
	
	public UserBean get(String username) throws DAOException;
	
	public boolean delete(Long userId) throws DAOException;
	
	public List<UserBean> getAll() throws DAOException;
	
	public List<UserBean> searchUser(String firstName, String lastName) throws DAOException;
}
