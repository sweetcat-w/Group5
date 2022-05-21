package com.system.controller.supplier;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;


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
 * Servlet implementation class AddSupplierServlert
 */
@WebServlet("/AddSupplierServlert")
public class AddSupplierServlert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddSupplierServlert() {
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
		//返回调用方法返回获得的供应商集合
		req.setAttribute("suppliersList", supplierServiceImpl.getSuppliersList());
		//返回到添加供应商页面
		req.getRequestDispatcher("/manager/supplierAdd.jsp").forward(req, resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//设置参数和页面的编码格式
    	req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = resp.getWriter();
		//获取发送到HttpSession的数据来为新页面提供内容
		HttpSession session = req.getSession();	
		
		//获取进货明细的交易单号
		String creditCodeNo = req.getParameter("creditCode"); 
		
		//判断交易单号不存在则进行添加操作
		if(
				
				
				SupplierServiceImpl.getBySupplierCreditCode(creditCodeNo).size() == 0) {
			
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
			SupplierService serviceImpl = new SupplierServiceImpl();
			//调用接口的添加供应商方法，返回结果到页面并提示
			
			if(serviceImpl.addSupplier(supplier) > 0){
				out.write("<script>");
				out.write("alert('【供应商】添加成功！');");
				out.write("location='GetSupplierListServlert';");
				out.write("</script>");
			}else {
				out.write("<script>");
				out.write("alert('【供应商】添加失败！');");
				out.write("location='AddSupplierServlert';");
				out.write("</script>");
			}
		}else {
			out.write("<script>");
			out.write("alert('【供应商】已存在，请重新输入！');");
			out.write("location='AddSupplierServlert';");
			out.write("</script>");
		}
	}

}
