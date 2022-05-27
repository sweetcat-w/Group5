package com.system.mapper.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.system.mapper.DetailsMapper;
import com.system.pojo.Details;
import com.system.util.MybatisUtil;

public class DetailsMapperImpl implements DetailsMapper{

	@Override
	public int addDetails(Details details) {
		SqlSession session = null;
		session = MybatisUtil.createSqlSession();
		int count = session.getMapper(DetailsMapper.class).addDetails(details);
		session.commit();
		if(session != null)
			session.close();
		return count;
	}

	@Override
	public int delDetailsByNo(String g_barCode) {
		SqlSession session = null;
		session = MybatisUtil.createSqlSession();
		int count = session.getMapper(DetailsMapper.class).delDetailsByNo(g_barCode);
		session.commit();
		if(session != null)
			session.close();
		return count;
	}

	@Override
	public int editDetailsByNo(Details details) {
		SqlSession session = null;
		session = MybatisUtil.createSqlSession();
		int count = session.getMapper(DetailsMapper.class).editDetailsByNo(details);
		session.commit();
		if(session != null)
			session.close();
		return count;
	}

	@Override
	public List<Details> getDetailsByBarCode(String g_barCode) {
		SqlSession session = null;
		session = MybatisUtil.createSqlSession();
		List<Details> details = session.getMapper(DetailsMapper.class).getDetailsByBarCode(g_barCode);
		if(session != null)
			session.close();
		return details;
	}

	@Override
	public List<Details> getDetailsByName(String g_name) {
		SqlSession session = null;
		session = MybatisUtil.createSqlSession();
		List<Details> details = session.getMapper(DetailsMapper.class).getDetailsByName(g_name);
		if(session != null)
			session.close();
		return details;
	}

	@Override
	public List<Details> getDetailsByNo(String transactionNo) {
		SqlSession session = null;
		session = MybatisUtil.createSqlSession();
		List<Details> details = session.getMapper(DetailsMapper.class).getDetailsByNo(transactionNo);
		if(session != null)
			session.close();
		return details;
	}

	@Override
	public List<Details> getDetailsList() {
		SqlSession session = null;
		session = MybatisUtil.createSqlSession();
		List<Details> details = session.getMapper(DetailsMapper.class).getDetailsList();
		if(session != null)
			session.close();
		return details;
	}

	@Override
	public int getDetailsCount() {
		SqlSession session = null;
		session = MybatisUtil.createSqlSession();
		int count = session.getMapper(DetailsMapper.class).getDetailsCount();
		if(session != null)
			session.close();
		return count;
	}

}
