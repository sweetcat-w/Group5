package com.system.controller.stock;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.system.pojo.Stock;
import com.system.service.StockService;
import com.system.service.StockServiceImpl;

//按商品名称查库存信息 FindStockByNameServlert

@WebServlet("/servlet/FindStockByNameServlert")
public class FindStockByNameServlert  extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	public FindStockByNameServlert() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//设置参数和页面的编码格式
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = resp.getWriter();
		//获取发送到HttpSession的数据来为新页面提供内容
		HttpSession session = req.getSession();
		
		//获取要查找的库存信息的商品名称
		String g_name = req.getParameter("g_name");
		
		//判断商品名称是否为空
		if(g_name.equals("")) {
			out.write("<script>");
			out.write("alert('【库存信息】请输入要查找的商品名称！');");
			out.write("location='GetStockListServlert';");
			out.write("</script>");
		}
		
		//实例化接口
		StockService stockServiceImpl = new StockServiceImpl();
		//调用接口的按商品名称查询进货明细方法，返回结果到页面并提示
		List<Stock> stockList = stockServiceImpl.getStockByName(g_name);
		
		if(stockList.size() > 0) {
			req.setAttribute("list", stockList);
			req.getRequestDispatcher("/manager/StockList.jsp").forward(req, resp);
		}else {
			out.write("<script>");
			out.write("alert('【库存信息】没有找到相关商品名称的信息！');");
			out.write("location='GetStockListServlert';");
			out.write("</script>");
			return;
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
