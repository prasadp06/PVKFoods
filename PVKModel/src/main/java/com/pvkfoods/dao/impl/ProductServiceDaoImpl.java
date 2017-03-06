package com.pvkfoods.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pvkfoods.DAOException;
import com.pvkfoods.dao.ProductServiceDao;
import com.pvkfoods.dao.bean.ProductBean;
import com.pvkfoods.dao.mapper.ProductServiceMapper;

/**
 * 
 * @author prasadprabhakaran
 *
 */
@Service
public class ProductServiceDaoImpl implements ProductServiceDao {

	@Autowired
	private SqlSession sqlSession;
	
	ProductServiceMapper productMapper;
	
	private void initMapper(){
		productMapper = sqlSession.getMapper(ProductServiceMapper.class);
	}
	
	@Override
	public boolean save(ProductBean product) throws DAOException {
		try {
			initMapper();
			productMapper.saveProduct(product);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("Error While Accessing Data", e);
		}finally {
		}
		return true;
	}

	@Override
	public boolean update(ProductBean product) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ProductBean get(Long prodcutId) throws DAOException {
		try {
			initMapper();
			return productMapper.getProduct(prodcutId);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("Error While Accessing Data", e);
		}finally {
		}
	}

	@Override
	public boolean delete(Long productId) throws DAOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<ProductBean> getAll() throws DAOException {
		try {
			initMapper();
			return productMapper.getAllProducts();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("Error While Accessing Data", e);
		}finally {
		}
	}

	@Override
	public List<ProductBean> searchProdcut(String productName) throws DAOException {
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
