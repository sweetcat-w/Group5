package com.system.mapper.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.system.mapper.SupplierMapper;
import com.system.pojo.Supplier;
import com.system.util.MybatisUtil;

public  class SupplierMapperImpl implements SupplierMapper{

	@Override
	public int addSupplier(Supplier supplier) {
		SqlSession session = null;
		session = MybatisUtil.createSqlSession();
		int count = session.getMapper(SupplierMapper.class).addSupplier(supplier);
		session.commit();
		if(session != null)
			session.close();
		return count;
	}

	@Override
	public int delSupplierByNo(String creditCode) {
		SqlSession session = null;
		session = MybatisUtil.createSqlSession();
		int count = session.getMapper(SupplierMapper.class).delSupplierByNo(creditCode);
		session.commit();
		if(session != null)
			session.close();
		return count;
	}

	@Override
	public int editSupplierByNo(Supplier supplier) {
		SqlSession session = null;
		session = MybatisUtil.createSqlSession();
		int count = session.getMapper(SupplierMapper.class).editSupplierByNo(supplier);
		session.commit();
		if(session != null)
			session.close();
		return count;
	}

	@Override
	public List<Supplier> getSupplierByCreditCode(String creditCode) {
		SqlSession session = null;
		session = MybatisUtil.createSqlSession();
		List<Supplier> suppliers= session.getMapper(SupplierMapper.class).getSupplierByCreditCode(creditCode);
		if(session != null)
			session.close();
		return suppliers;
	}

	@Override
	public List<Supplier> getSupplierByName(String s_name) {
		SqlSession session = null;
		session = MybatisUtil.createSqlSession();
		List<Supplier> suppliers = session.getMapper(SupplierMapper.class).getSupplierByName(s_name);
		if(session != null)
			session.close();
		return suppliers;
	}

	@Override
	public List<Supplier> getSupplierList() {
		SqlSession session = null;
		session = MybatisUtil.createSqlSession();
		List<Supplier> suppliers = session.getMapper(SupplierMapper.class).getSupplierList();
		if(session != null)
			session.close();
		return suppliers;
	}

	@Override
	public int getSupplierCount() {
		SqlSession session = null;
		session = MybatisUtil.createSqlSession();
		int count = session.getMapper(SupplierMapper.class).getSupplierCount();
		if(session != null)
			session.close();
		return count;
	}

	@Override
	public List<Supplier> getPartAllSupplier(int currentIndex, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
