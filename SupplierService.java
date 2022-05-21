package com.system.service;

import java.util.List;

import com.system.pojo.Supplier;

public interface SupplierService {



	int addSupplier(Supplier supplier);

	int delDetailsByNo(String creditCode);

	Object getDetailsByNo(String creditCode);

	int editDetailsByNo(Supplier supplier);

	List<Supplier> getDetailsByBarCode(String creditCode);

}
