package com.system.mapper.impl;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import com.system.mapper.RegistrationMapper;
import com.system.pojo.Registration;
import com.system.util.MybatisUtil;

public class RegistrationsMapperImpl implements RegistrationMapper{

	@Override
	public int addRegistration(Registration registration) {
		SqlSession session = null;
		session = MybatisUtil.createSqlSession();
		int count = session.getMapper(RegistrationMapper.class).addRegistration(registration);
		session.commit();
		if(session != null)
			session.close();
		return count;
	}

	@Override
	public int delRegistrationByNo(String transactionNo) {
		SqlSession session = null;
		session = MybatisUtil.createSqlSession();
		int count = session.getMapper(RegistrationMapper.class).delRegistrationByNo(transactionNo);
		session.commit();
		if(session != null)
			session.close();
		return count;
	}

	@Override
	public int editRegistrationByNo(Registration registration) {
		SqlSession session = null;
		session = MybatisUtil.createSqlSession();
		int count = session.getMapper(RegistrationMapper.class).editRegistrationByNo(registration);
		session.commit();
		if(session != null)
			session.close();
		return count;
	}

	@Override
	public List<Registration> getRegistrationByDate(String transactionDate) {
		SqlSession session = null;
		session = MybatisUtil.createSqlSession();
		List<Registration> registration = session.getMapper(RegistrationMapper.class).getRegistrationByDate(transactionDate);
		if(session != null)
			session.close();
		return registration;
	}

	@Override
	public List<Registration> getRegistrationBySupplier(String supplier) {
		SqlSession session = null;
		session = MybatisUtil.createSqlSession();
		List<Registration> registration = session.getMapper(RegistrationMapper.class).getRegistrationBySupplier(supplier);
		if(session != null)
			session.close();
		return registration;
	}

	@Override
	public List<Registration> getRegistrationByNo(String transactionNo) {
		SqlSession session = null;
		session = MybatisUtil.createSqlSession();
		List<Registration> registration = session.getMapper(RegistrationMapper.class).getRegistrationByNo(transactionNo);
		if(session != null)
			session.close();
		return registration;
	}

	@Override
	public List<Registration> getRegistrationList() {
		SqlSession session = null;
		session = MybatisUtil.createSqlSession();
		List<Registration> registration = session.getMapper(RegistrationMapper.class).getRegistrationList();
		if(session != null)
			session.close();
		return registration;
	}

	@Override
	public int getRegistrationCount() {
		SqlSession session = null;
		session = MybatisUtil.createSqlSession();
		int count = session.getMapper(RegistrationMapper.class).getRegistrationCount();
		if(session != null)
			session.close();
		return count;
	}

}
