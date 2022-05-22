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

//查询全部库存信息 GetStockServlert

@WebServlet("/servlet/GetStockServlert")
public class GetStockServlert  extends HttpServlet {

private static final long serialVersionUID = 1L;
	
	public GetStockServlert() {
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
		
		//判断是否已登录
		if(session.getAttribute("isLogin") == null||!session.getAttribute("isLogin").equals("1")) {
			out.write("<script>");
			out.write("alert('请登录账号');");
			out.write("location='manager/login.jsp';");
			out.write("</script>");
			return;
		}
		
		int currentIndex, size = 5;
		int allIndex,count;
		String index = req.getParameter("index");
		if (index == null)
			index = "1";
		currentIndex = Integer.parseInt(index);
		
		//实例化接口
		StockService stockServiceImpl = new StockServiceImpl();
		
		try {
			count = stockServiceImpl.getStockCount();
			if(count % size != 0) {
				allIndex = count / size + 1;
			}else {
				allIndex = count / size;
			}
			//调用接口的进货明细分页显示方法，并放回结果到页面提示
			List<Stock> stockList =  stockServiceImpl.getPartAllStock(currentIndex, size);
			session.setAttribute("list", stockList);
			session.setAttribute("currentIndex", currentIndex);
			session.setAttribute("allIndex", allIndex);
			req.getRequestDispatcher("/manager/StockList.jsp").forward(req, resp);
		}catch (Exception e) {
			System.out.println(e);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
