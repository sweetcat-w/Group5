package com.system.mapper;

import java.util.List;

import com.system.pojo.Stock;

public class StockMapperImpl implements StockMapper {

	@Override
	public int addStock(Stock stock) {
		
		return 0;
	}

	@Override
	public int delStockByName(String g_name) {
		
		return 0;
	}

	@Override
	public int editStockByName(Stock stock) {
		
		return 0;
	}

	@Override
	public List<Stock> getStockByName(String g_name) {
		
		return null;
	}

	@Override
	public List<Stock> getStockByBarCode(String g_barCode) {
		
		return null;
	}

	@Override
	public List<Stock> getPartAllStock(int page, int size) {
		
		return null;
	}

	@Override
	public int getStockCount() {
		
		return 0;
	}

	@Override
	public List<Stock> getStockList() {
		
		return null;
	}

}
