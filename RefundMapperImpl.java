package com.system.mapper.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.system.mapper.RefundMapper;
import com.system.pojo.Refund;
import com.system.util.MybatisUtil;

public class RefundMapperImpl implements RefundMapper{

	@Override
	public int addRefund(Refund refund) {
		SqlSession session = null;
		session = MybatisUtil.createSqlSession();
		int count = session.getMapper(RefundMapper.class).addRefund(refund);
		session.commit();
		if(session != null)
			session.close();
		return count;
	}

	@Override
	public int delRefundByNo(String g_barCode) {
		SqlSession session = null;
		session = MybatisUtil.createSqlSession();
		int count = session.getMapper(RefundMapper.class).delRefundByNo(g_barCode);
		session.commit();
		if(session != null)
			session.close();
		return count;
	}

	@Override
	public int editRefundByNo(Refund refund) {
		SqlSession session = null;
		session = MybatisUtil.createSqlSession();
		int count = session.getMapper(RefundMapper.class).editRefundByNo(refund);
		session.commit();
		if(session != null)
			session.close();
		return count;
	}

	@Override
	public List<Refund> getRefundByBarCode(String g_barCode) {
		SqlSession session = null;
		session = MybatisUtil.createSqlSession();
		List<Refund> refund = session.getMapper(RefundMapper.class).getRefundByBarCode(g_barCode);
		if(session != null)
			session.close();
		return refund;
	}

	@Override
	public List<Refund> getRefundByDate(String r_date) {
		SqlSession session = null;
		session = MybatisUtil.createSqlSession();
		List<Refund> refund = session.getMapper(RefundMapper.class).getRefundByDate(r_date);
		if(session != null)
			session.close();
		return refund;
	}

	@Override
	public List<Refund> getRefundByNo(String transactionNo) {
		SqlSession session = null;
		session = MybatisUtil.createSqlSession();
		List<Refund> refund = session.getMapper(RefundMapper.class).getRefundByNo(transactionNo);
		if(session != null)
			session.close();
		return refund;
	}

	@Override
	public List<Refund> getRefundList() {
		SqlSession session = null;
		session = MybatisUtil.createSqlSession();
		List<Refund> refund = session.getMapper(RefundMapper.class).getRefundList();
		if(session != null)
			session.close();
		return refund;
	}

	@Override
	public int getRefundCount() {
		SqlSession session = null;
		session = MybatisUtil.createSqlSession();
		int count = session.getMapper(RefundMapper.class).getRefundCount();
		if(session != null)
			session.close();
		return count;
	}



}
