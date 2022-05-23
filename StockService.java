package com.system.service;

import java.util.List;

import com.system.pojo.Stock;

public interface StockService {
	/**添加库存信息
	 * @param details添加的信息
	 * @return 影响行数
	 */
	public int addStock(Stock stock);

	public Object getStockList();

//	public Object getStockByName(String g_name);

	public int delStockByName(String transactionNo);

	public List<Stock> getStockByName(String g_name);

	public List<Stock> getStockByBarCode(String g_barCode);

	public int editStockByName(Stock stock);

	public List<Stock> getPartAllStock(int currentIndex, int size);

	public int getStockCount();

	

}
