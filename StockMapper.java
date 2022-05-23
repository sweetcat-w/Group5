package com.system.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.system.pojo.Stock;

public interface StockMapper {
	
	/**添加库存信息
	 * @param stock添加的信息
	 * @return 影响行数
	 */
	public int addStock(Stock stock);


	/**
	 * 按商品名称删除库存信息
	 * @param g_name商品名称
	 * @return
	 */
	public int delStockByName(@Param("g_name") String g_name);

	/**按商品名称修改库存信息
	 * @param g_name商品名称
	 * @return
	 */
	public int editStockByName(Stock stock);


	/**按商品名称查询库存信息
	 * @param g_name商品名称
	 * @return 查询结果
	 */
	public List<Stock> getStockByName(@Param("g_name") String g_name);
	


	/**按商品查询条形码库存信息
	 * @param g_barCode条形码
	 * @return 查询结果
	 */
	public List<Stock> getStockByBarCode(@Param("g_barCode")String g_barCode);


	/**分页处理库存信息
	 * @param page 页
	 * @param size 分页大小
	 * @return
	 */
	public List<Stock> getPartAllStock(int page, int size);

	/**
	 * 获取全部库存总数
	 * @return 统计结果
	 */
	public int getStockCount();

	/**
	 * 获取全部库存信息
	 * @return 库存列表
	 */
	public List<Stock> getStockList();

	

}
