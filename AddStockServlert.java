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
import javax.servlet.http.HttpSession;

import com.system.pojo.Stock;
import com.system.service.StockService;
import com.system.service.StockServiceImpl;
//新增商品库存信息 AddStockServlert

@WebServlet("/servlet/AddStockServlert")
public class AddStockServlert  extends HttpServlet{


	private static final long serialVersionUID = 1L;
	
    public AddStockServlert() {
        super();
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	//设置参数和页面的编码格式
    	req.setCharacterEncoding("utf-8");
    	resp.setContentType("text/html;charset=utf-8");
		//实例化接口
    	StockService stockServiceImpl = new StockServiceImpl();
		//返回调用方法返回获得的进货明细集合
		req.setAttribute("stockList", stockServiceImpl.getStockList());
		//返回到添加进货明细页面
		req.getRequestDispatcher("/manager/stockAdd.jsp").forward(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
    	//设置参数和页面的编码格式
    	req.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		//获取发送到HttpSession的数据来为新页面提供内容
		HttpSession session = req.getSession();	
		
		//获取库存中的商品名称
		String g_name = req.getParameter("g_name"); 
		
		//判断交易单号不存在则进行添加操作
		if(stockServiceImpl.getStockByName(g_name).size() == 0) {
			
			//设置日期格式
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");
		
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
			stock.setG_name(g_name);
			stock.setG_barCode(g_barCode);
			stock.setG_shelfLife(g_shelfLife);
			stock.setG_type(g_type);
			stock.setS_num(s_num);
			stock.setG_nuit(g_nuit);
			stock.setG_lsexpired(g_lsexpired);
			

			//实例化接口
			StockService serviceImpl = new StockServiceImpl();
			//调用接口的添加进货明细方法，返回结果到页面并提示
			
			if(serviceImpl.addStock(stock) > 0){
				out.write("<script>");
				out.write("alert('【商品库存信息】添加成功！');");
				out.write("location='GetStockListServlert';");
				out.write("</script>");
			}else {
				out.write("<script>");
				out.write("alert('【商品库存信息】添加失败！');");
				out.write("location='AddStockServlert';");
				out.write("</script>");
			}
		}else {
			out.write("<script>");
			out.write("alert('【商品库存信息】商品名称已存在，请重新输入！');");
			out.write("location='AddStockServlert';");
			out.write("</script>");
		}
    }   
}
