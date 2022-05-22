package com.system.controller.stock;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.system.pojo.Stock;
import com.system.service.StockService;
import com.system.service.StockServiceImpl;

//修改商品库存信息 EditStockServlert

@WebServlet("/servlet/EditStockServlert")
public class EditStockServlert extends HttpServlet{

private static final long serialVersionUID = 1L;
	
	public EditStockServlert() {
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		//实例化接口
		StockService stockServiceImpl = new StockServiceImpl();
		//获取库存中的商品名称
		String g_name = req.getParameter("g_name"); 
		
		req.setAttribute("stock", stockServiceImpl.getStockByName(g_name).get(0));
		resp.getRequestDispatcher("/manager/StockEdit.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resps.getWriter();
		
		//设置日期格式
//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");
		
		//获取页面上需要添加的信息
		String g_barCode = req.getParameter("g_barCode");	//商品条形码
		int g_shelfLife =Integer.parseInt(req.getParameter("g_shelfLife")) ;//交易日期
		String g_type = req.getParameter("g_type");	//商品类型
		int s_num = Integer.parseInt(req.getParameter("s_num"));	//库存数量
		String g_nuit = req.getParameter("g_nuit");	//单位
		int g_lsexpired = Integer.parseInt("g_lsexpired");	//是否过期
		
		
		//创建一个商品库存对象
		Stock stock = new Stock();
		//将相应的信息添加到对象中
//		stock.setG_name(g_name);
		stock.setG_barCode(g_barCode);
		stock.setG_shelfLife(g_shelfLife);
		stock.setG_type(g_type);
		stock.setS_num(s_num);
		stock.setG_nuit(g_nuit);
		stock.setG_lsexpired(g_lsexpired);
		
		//实例化接口
		StockService stockServiceImpl = new StockServiceImpl();
		
		//调用接口的修改进货明细方法，返回结果到页面并提示
		if(stockServiceImpl.editStockByName(stock) > 0){
			out.write("<script>");
			out.write("alert('【库存信息】修改成功！');");
			out.write("location='GetStockListServlert';");
			out.write("</script>");
		}else {
			out.write("<script>");
			out.write("alert('【库存】修改失败！');");
			out.write("location='AddStockServlert';");
			out.write("</script>");
		}
	}

}
