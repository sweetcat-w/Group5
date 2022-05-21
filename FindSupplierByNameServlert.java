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
 * Servlet implementation class FindSupplierByNameServlert
 */
@WebServlet("/FindSupplierByNameServlert")
public class FindSupplierByNameServlert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindSupplierByNameServlert() {
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
		
		//��ȡҪ���ҵĽ�����ϸ����Ʒ����
		String s_name = req.getParameter("s_name");
		
		//�ж���Ʒ�����Ƿ�Ϊ��
		if(s_name.equals("")) {
			out.write("<script>");
			out.write("alert('����Ӧ�̡�������Ҫ���ҵĹ�Ӧ�����ƣ�');");
			out.write("location='GetSupplierListServlert';");
			out.write("</script>");
		}
		
		//ʵ�����ӿ�
		SupplierService supplierServiceImpl = new SupplierServiceImpl();
		//���ýӿڵİ���Ʒ���Ʋ�ѯ������ϸ���������ؽ����ҳ�沢��ʾ
		List<Supplier> supplierList = supplierServiceImpl.getSupplierByName(s_name);		
		if(supplierList.size() > 0) {
			req.setAttribute("list", supplierList);
			req.getRequestDispatcher("/manager/SupplierList.jsp").forward(req, resp);
		}else {
			out.write("<script>");
			out.write("alert('����Ӧ�̡�û���ҵ���ع�Ӧ�̵���Ϣ��');");
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
