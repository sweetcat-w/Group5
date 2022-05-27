package com.system.mapper.impl;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import com.system.mapper.StockMapper;
import com.system.pojo.Stock;
import com.system.util.MybatisUtil;

public class StockMapperImpl implements StockMapper {

	@Override
	public int addStock(Stock stock) {
		SqlSession session = null;
		session = MybatisUtil.createSqlSession();
		int count = session.getMapper(StockMapper.class).addStock(stock);
		session.commit();
		if(session != null)
			session.close();
		return count;
	}

	@Override
	public int delStockByBarCode(String g_barCode) {
		SqlSession session = null;
		session = MybatisUtil.createSqlSession();
		int count = session.getMapper(StockMapper.class).delStockByBarCode(g_barCode);
		session.commit();
		if(session != null)
			session.close();
		return count;
	}

	@Override
	public int editStockByBarCode(Stock stock) {
		SqlSession session = null;
		session = MybatisUtil.createSqlSession();
		int count = session.getMapper(StockMapper.class).editStockByBarCode(stock);
		session.commit();
		if(session != null)
			session.close();
		return count;
	}

	@Override
	public List<Stock> getStockByName(String g_name) {
		SqlSession session = null;
		session = MybatisUtil.createSqlSession();
		List<Stock> stock = session.getMapper(StockMapper.class).getStockByName(g_name);
		if(session != null)
			session.close();
		return stock;
	}

	@Override
	public List<Stock> getStockByBarCode(String g_barCode) {
		SqlSession session = null;
		session = MybatisUtil.createSqlSession();
		List<Stock> stock = session.getMapper(StockMapper.class).getStockByBarCode(g_barCode);
		if(session != null)
			session.close();
		return stock;
	}



	@Override
	public int getStockCount() {
		SqlSession session = null;
		session = MybatisUtil.createSqlSession();
		int count = session.getMapper(StockMapper.class).getStockCount();
		if(session != null)
			session.close();
		return count;
	}

	@Override
	public List<Stock> getStockList() {
		SqlSession session = null;
		session = MybatisUtil.createSqlSession();
		List<Stock> stock = session.getMapper(StockMapper.class).getStockList();
		if(session != null)
			session.close();
		return stock;
	}
}
