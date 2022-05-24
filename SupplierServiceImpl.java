package com.system.service;

import java.util.List;

import com.system.pojo.Supplier;

public class SupplierServiceImpl implements SupplierService{
	
	/**
	 * 添加商品进货明细
	 * @param supplier 添加的信息
	 * @return 影响行数
	 */
	@Override
	public int addSupplier(Supplier supplier) {
		
		return 0;
	}

	
	/**
	 * 按社会统一信用代码删除供应商
	 * @param creditCode 社会统一信用代码
	 * @return 影响行数
	 */
	@Override
	public int delSupplierByNo(String creditCode) {
	
		return 0;
	}

	
	/**
	 * 按社会统一信用代码修改供应商
	 * @param creditCode 社会统一信用代码
	 * @return  
	 */
	@Override
	public int editSupplierByNo(Supplier supplier) {

		return 0;
	}

	/**
	 * 按商品条形码查询进货明细
	 * @param g_barCode 商品条形码
	 * @return 查询结果
	 */
	@Override
	public List<Supplier> getSupplierByCreditCode(String creditCode) {
	
		return null;
	}

	/**
	 * 按供应商名称查询供应商
	 * @param s_name 供应商名称
	 * @return 查询结果
	 */
	@Override
	public List<Supplier> getSupplierByName(String s_name) {
		
		return null;
	}

	
	/**
	 * 获取全部供应商总数
	 * @return 统计结果
	 */
	@Override
	public int getSupplierCount() {
	
		return 0;
	}

	/**
	 * 分页处理供应商
	 * @param page 页
	 * @param size 分页大小
	 * @return
	 */
	@Override
	public List<Supplier> getPartAllSupplier(int currentIndex, int size) {
	
		return null;
	}

	/**
	 * 获取全部供应商
	 * @return 供应商表
	 */
	@Override
	public List<Supplier> getSupplierList() {
				return null;
	}





}
