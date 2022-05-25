package com.system.service;

import java.util.ArrayList;
import java.util.List;

import com.system.mapper.StockMapper;
import com.system.mapper.StockMapperImpl;
import com.system.pojo.Details;
import com.system.pojo.Stock;

public class StockServiceImpl implements StockService {
	private StockMapper stockMapper = new StockMapperImpl();
	
	@Override
	public int addStock(Stock stock) {
		return stockMapper.addStock(stock);
	}


	@Override
	public int delStockByName(String g_name) {
		return stockMapper.delStockByName(g_name);
	}
	


	@Override
	public List<Stock> getStockByBarCode(String g_barCode) {
		return stockMapper.getStockByBarCode(g_barCode);
	}

	@Override
	public int editStockByName(Stock stock) {
		return stockMapper.editStockByName(stock);
	}

	@Override
	public List<Stock> getStockByName(String g_name) {	
		return stockMapper.getStockByName(g_name);
	}


	@Override
	public int getStockCount() {
		return stockMapper.getStockCount();
	}

	@Override
	public List<Stock> getStockList() {
		return stockMapper.getStockList();
	}


	@Override
	public List<Stock> getPartAllStock(int page, int size) {
		int pageSize = 0;
		List<Stock> sList = stockMapper.getStockList();
		//创建detailsLists存放分页处理后的数据
		List<Stock> stockList = new ArrayList<Stock>();
		//分页处理
        if((page-1) * size + size > sList.size()){	
            pageSize = sList.size();
        }else {
            pageSize = (page-1) * size + size;
        }
        for (int i = (page-1) * size; i < pageSize; i++) {
        	Stock stock = sList.get(i);
        	stockList.add(stock);
        }
		return stockList;
	}





}
