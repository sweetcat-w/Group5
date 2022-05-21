package com.system.controller.supplier;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.system.pojo.Supplier;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.system.service.SupplierService;
import com.system.service.SupplierServiceImpl;

/**
 * Servlet implementation class GetSupplierServlert
 */
@WebServlet("/GetSupplierServlert")
public class GetSupplierServlert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetSupplierServlert() {
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
				SupplierService supplierServiceImpl = new SupplierServiceImpl();
				
				try {
					count = supplierServiceImpl.getSupplierCount();
					if(count % size != 0) {
						allIndex = count / size + 1;
					}else {
						allIndex = count / size;
					}
					//调用接口的进货明细分页显示方法，并放回结果到页面提示
					List<Supplier> supplierList =  supplierServiceImpl.getPartAllSupplier(currentIndex, size);
					session.setAttribute("list", supplierList);
					session.setAttribute("currentIndex", currentIndex);
					session.setAttribute("allIndex", allIndex);
					req.getRequestDispatcher("/manager/SupplierList.jsp").forward(req, resp);
				}catch (Exception e) {
					System.out.println(e);
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
