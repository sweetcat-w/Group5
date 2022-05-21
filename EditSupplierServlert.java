package com.system.controller.supplier;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.system.pojo.Supplier;
import com.system.service.SupplierService;
import com.system.service.SupplierServiceImpl;

/**
 * Servlet implementation class EditSupplierServlert
 */
@WebServlet("/EditSupplierServlert")
public class EditSupplierServlert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditSupplierServlert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		//实例化接口
		SupplierService supplierServiceImpl = new SupplierServiceImpl();
		//获取要修改的进货明细的交易单号
		String creditCode = req.getParameter("creditCode");
		
		req.setAttribute("details", supplierServiceImpl.getDetailsByNo(creditCode).get(0));
		((ServletRequest) resp).getRequestDispatcher("/manager/SupplierEdit.jsp").forward(req, resp);	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				//设置参数和页面的编码格式
		    	req.setCharacterEncoding("utf-8");
				resp.setContentType("text/html;charset=utf-8");
				
				PrintWriter out = resp.getWriter();
				
				//设置日期格式
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");
				
					//获取页面上需要添加的信息
					String creditCode = req.getParameter("creditCode");	//统一社会信用代码 
					String s_name = req.getParameter("s_name");	//供应商姓名
					String s_type = req.getParameter("s_type");	//供应商状态
					String s_liaisoner = req.getParameter("s_liaisoner");	//联系人
					String liaisonPhone = req.getParameter("liaisonPhone");	//联系电话
					
					//创建一个供应商对象
					Supplier supplier=new Supplier();
					//将相应的信息添加到对象中
					supplier.setCreditCode(creditCode);
					supplier.setLiaisonPhone(liaisonPhone);
					supplier.setS_liaisoner(s_liaisoner);
					supplier.setS_type(s_type);
					supplier.setS_name(s_name);

					//实例化接口
					SupplierService supplierServiceImpl = new SupplierServiceImpl();
					//调用接口的添加供应商方法，返回结果到页面并提示
					if(supplierServiceImpl.editDetailsByNo(supplier) > 0){
						out.write("<script>");
						out.write("alert('【供应商】修改成功！');");
						out.write("location='GetSupplierListServlert';");
						out.write("</script>");
					}else {
						out.write("<script>");
						out.write("alert('【供应商】修改失败！');");
						out.write("location='AddSupplierServlert';");
						out.write("</script>");
					}
					
	}
}
