package com.system.controller.stock;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.system.service.StockService;
import com.system.service.StockServiceImpl;

//删除商品库存信息 DelStockServlert

@WebServlet("/servlet/DelStockServlert")
public class DelStockServlert  extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public DelStockServlert() {
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//设置参数和页面的编码格式
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = resp.getWriter();
	
		//获取要删除的进货明细的交易单号
		String transactionNo = req.getParameter("transactionNo");
		
		//实例化接口
		StockService stockServiceImpl = new StockServiceImpl();
	
		//调用接口的根据交易单号删除方法
		if(stockServiceImpl.delStockByName(transactionNo) > 0) {
			out.write("<script>");
			out.write("alert('删除成功');");
			out.write("location='GetClassesListServlert';");
			out.write("</script>");
		}else {
			out.write("<script>");
			out.write("alert('删除失败');");
			out.write("location='GetClassesListServlert';");
			out.write("</script>");
		}
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}

