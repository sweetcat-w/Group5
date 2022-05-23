package com.system.service;

import java.util.ArrayList;
import java.util.List;
import com.system.mapper.DetailsMapper;
import com.system.mapper.DetailsMapperImpl;
import com.system.pojo.Details;

public class DetailsServiceImpl implements DetailsService {
	
	private DetailsMapper detailsMapper = new DetailsMapperImpl();;

	@Override
	public int addDetails(Details details) {
		return detailsMapper.addDetails(details);
	}

	@Override
	public int delDetailsByNo(String transactionNo) {
		return detailsMapper.delDetailsByNo(transactionNo);
	}

	@Override
	public int editDetailsByNo(Details details) {
		return detailsMapper.editDetailsByNo(details);
	}

	@Override
	public List<Details> getDetailsByBarCode(String g_barCode) {
		return detailsMapper.getDetailsByBarCode(g_barCode);
	}

	@Override
	public List<Details> getDetailsByName(String g_name) {
		return detailsMapper.getDetailsByName(g_name);
	}

	@Override
	public List<Details> getDetailsByNo(String transactionNo) {
		return detailsMapper.getDetailsByNo(transactionNo);
	}

	@Override
	public List<Details> getDetailsList() {
		return detailsMapper.getDetailsList();
	}

	@Override
	public int getDetailsCount() {
		return detailsMapper.getDetailsCount();
	}

	@Override
	public List<Details> getPartAllDetails(int page, int size) {
		
		int pageSize = 0;
		List<Details> dList = detailsMapper.getDetailsList();
		
		//创建detailsLists存放分页处理后的数据
		List<Details> detailsList = new ArrayList<Details>();
		//分页处理
        if((page-1) * size + size > dList.size()){	
            pageSize = dList.size();
        }else {
            pageSize = (page-1) * size + size;
        }
        for (int i = (page-1) * size; i < pageSize; i++) {
        	Details details = dList.get(i);
        	detailsList.add(details);
        }
		return detailsList;
	}

}
