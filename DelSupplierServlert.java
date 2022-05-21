package com.system.controller.supplier;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.system.service.SupplierService;
import com.system.service.SupplierServiceImpl;

/**
 * Servlet implementation class DelSupplierServlert
 */
@WebServlet("/DelSupplierServlert")
public class DelSupplierServlert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelSupplierServlert() {
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
			
				//获取要删除的供应商的统一社会信用代码
				String creditCode = req.getParameter("creditCode");
				
				//实例化接口
				SupplierService supplierServiceImpl = new SupplierServiceImpl();
			
				//调用接口的根据交易单号删除方法
				if(supplierServiceImpl.delDetailsByNo(creditCode) > 0) {
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
