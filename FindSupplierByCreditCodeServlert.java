package com.system.controller.supplier;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.system.pojo.Supplier;
import com.system.service.SupplierService;
import com.system.service.SupplierServiceImpl;

/**
 * Servlet implementation class FindSupplierByCreditCodeServlert
 */
@WebServlet("/FindSupplierByCreditCodeServlert")
public class FindSupplierByCreditCodeServlert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindSupplierByCreditCodeServlert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//设置参数和页面的编码格式
				req.setCharacterEncoding("utf-8");
				resp.setContentType("text/html;charset=utf-8");
				
				PrintWriter out = resp.getWriter();
				//获取发送到HttpSession的数据来为新页面提供内容
				HttpSession session = req.getSession();	
				
				//获取要查找的进货明细的商品条形码
				String creditCode = req.getParameter("creditCode");
				
				//判断商品条形码是否为空
				if(creditCode.equals("")) {
					out.write("<script>");
					out.write("alert('【供应商】请输入要查找的统一社会信用代码！');");
					out.write("location='GetSupplierListServlert';");
					out.write("</script>");
				}

				//实例化接口
				SupplierService spplierServiceImpl = new SupplierServiceImpl();
				//调用接口的按交易单号查询进货明细方法，返回结果到页面并提示
				List<Supplier> supplierList = spplierServiceImpl.getDetailsByBarCode(creditCode);
				
				if(supplierList.size() > 0) {
					req.setAttribute("list", supplierList);
					req.getRequestDispatcher("/manager/supplierList.jsp").forward(req, resp);
				}else {
					out.write("<script>");
					out.write("alert('【供应商】没有找到相关的统一社会信用代码信息！');");
					out.write("location='GetSupplierListServlert';");
					out.write("</script>");
					return;
				}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
