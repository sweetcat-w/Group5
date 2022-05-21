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
		//���ò�����ҳ��ı����ʽ
				req.setCharacterEncoding("utf-8");
				resp.setContentType("text/html;charset=utf-8");
				
				PrintWriter out = resp.getWriter();
				//��ȡ���͵�HttpSession��������Ϊ��ҳ���ṩ����
				HttpSession session = req.getSession();	
				
				//��ȡҪ���ҵĽ�����ϸ����Ʒ������
				String creditCode = req.getParameter("creditCode");
				
				//�ж���Ʒ�������Ƿ�Ϊ��
				if(creditCode.equals("")) {
					out.write("<script>");
					out.write("alert('����Ӧ�̡�������Ҫ���ҵ�ͳһ������ô��룡');");
					out.write("location='GetSupplierListServlert';");
					out.write("</script>");
				}

				//ʵ�����ӿ�
				SupplierService spplierServiceImpl = new SupplierServiceImpl();
				//���ýӿڵİ����׵��Ų�ѯ������ϸ���������ؽ����ҳ�沢��ʾ
				List<Supplier> supplierList = spplierServiceImpl.getDetailsByBarCode(creditCode);
				
				if(supplierList.size() > 0) {
					req.setAttribute("list", supplierList);
					req.getRequestDispatcher("/manager/supplierList.jsp").forward(req, resp);
				}else {
					out.write("<script>");
					out.write("alert('����Ӧ�̡�û���ҵ���ص�ͳһ������ô�����Ϣ��');");
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
