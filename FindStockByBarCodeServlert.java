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

//按商品条码查询库存信息 FindStockByBarCodeServlert

@WebServlet("/servlet/FindStockByBarCodeServlert")
public class FindStockByBarCodeServlert extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	public FindStockByBarCodeServlert() {
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
		
		//获取要查找的库存中的商品条形码
		String g_barCode = req.getParameter("g_barCode");
		
		//判断商品条形码是否为空
		if(g_barCode.equals("")) {
			out.write("<script>");
			out.write("alert('【库存信息】请输入要查找的商品条形码！');");
			out.write("location='GetStockListServlert';");
			out.write("</script>");
		}

		//实例化接口
		StockService stockServiceImpl = new StockServiceImpl();
		//调用接口的按交易单号查询进货明细方法，返回结果到页面并提示
		List<Stock> stockList = stockServiceImpl.getStockByBarCode(g_barCode);
		
		if(stockList.size() > 0) {
			req.setAttribute("list", stockList);
			req.getRequestDispatcher("/manager/StockList.jsp").forward(req, resp);
		}else {
			out.write("<script>");
			out.write("alert('【库存信息】没有找到相关商品条形码的信息！');");
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

