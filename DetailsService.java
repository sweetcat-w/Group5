package com.system.service;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.system.pojo.Details;

public interface DetailsService {
	
	/**
	 * 添加商品进货明细
	 * @param details 添加的信息
	 * @return 影响行数
	 */
	public int addDetails(Details details);
	
	/**
	 * 按交易单号删除进货明细
	 * @param transactionNo 交易单号
	 * @return 影响行数
	 */
	public int delDetailsByNo(@Param("transactionNo") String transactionNo);
	
	/**
	 * 按交易单号修改进货明细
	 * @param transactionNo 交易单号
	 * @return  
	 */
	public int editDetailsByNo(Details details);
	
	/**
	 * 按商品条形码查询进货明细
	 * @param g_barCode 商品条形码
	 * @return 查询结果
	 */
	public List<Details> getDetailsByBarCode(@Param("g_barCode") String g_barCode);

	/**
	 * 按商品名称查询进货明细
	 * @param g_name 商品名称
	 * @return 查询结果
	 */
	public List<Details> getDetailsByName(@Param("g_name") String g_name);
	
	/**
	 * 按交易单号查询进货明细
	 * @return 查询结果
	 */
	public List<Details> getDetailsByNo(@Param("transactionNo") String transactionNo);
		
	/**
	 * 获取全部进货明细
	 * @return 进货明细列表
	 */
	public List<Details> getDetailsList();
	
	/**
	 * 获取全部进货明细总数
	 * @return 统计结果
	 */
	public int getDetailsCount();
	
	/**
	 * 分页处理进货明细
	 * @param page 页
	 * @param size 分页大小
	 * @return
	 */
	public List<Details> getPartAllDetails(int page, int size);

}
