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
		//ʵ�����ӿ�
    	SupplierService supplierServiceImpl = new SupplierServiceImpl();
		//���ص��÷������ػ�õĹ�Ӧ�̼���
		req.setAttribute("suppliersList", supplierServiceImpl.getSuppliersList());
		//���ص���ӹ�Ӧ��ҳ��
		req.getRequestDispatcher("/manager/supplierAdd.jsp").forward(req, resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//���ò�����ҳ��ı����ʽ
    	req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = resp.getWriter();
		//��ȡ���͵�HttpSession��������Ϊ��ҳ���ṩ����
		HttpSession session = req.getSession();	
		
		//��ȡ������ϸ�Ľ��׵���
		String creditCodeNo = req.getParameter("creditCode"); 
		
		//�жϽ��׵��Ų������������Ӳ���
		if(
				
				
				SupplierServiceImpl.getBySupplierCreditCode(creditCodeNo).size() == 0) {
			
			//�������ڸ�ʽ
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");
			
			//��ȡҳ������Ҫ��ӵ���Ϣ
			String creditCode = req.getParameter("creditCode");	//ͳһ������ô��� 
			String s_name = req.getParameter("s_name");	//��Ӧ������
			String s_type = req.getParameter("s_type");	//��Ӧ��״̬
			String s_liaisoner = req.getParameter("s_liaisoner");	//��ϵ��
			String liaisonPhone = req.getParameter("liaisonPhone");	//��ϵ�绰
			
			//����һ����Ӧ�̶���
			Supplier supplier=new Supplier();
			//����Ӧ����Ϣ��ӵ�������
			supplier.setCreditCode(creditCode);
			supplier.setLiaisonPhone(liaisonPhone);
			supplier.setS_liaisoner(s_liaisoner);
			supplier.setS_type(s_type);
			supplier.setS_name(s_name);

			//ʵ�����ӿ�
			SupplierService serviceImpl = new SupplierServiceImpl();
			//���ýӿڵ���ӹ�Ӧ�̷��������ؽ����ҳ�沢��ʾ
			
			if(serviceImpl.addSupplier(supplier) > 0){
				out.write("<script>");
				out.write("alert('����Ӧ�̡���ӳɹ���');");
				out.write("location='GetSupplierListServlert';");
				out.write("</script>");
			}else {
				out.write("<script>");
				out.write("alert('����Ӧ�̡����ʧ�ܣ�');");
				out.write("location='AddSupplierServlert';");
				out.write("</script>");
			}
		}else {
			out.write("<script>");
			out.write("alert('����Ӧ�̡��Ѵ��ڣ����������룡');");
			out.write("location='AddSupplierServlert';");
			out.write("</script>");
		}
	}

}
