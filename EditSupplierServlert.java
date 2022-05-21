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
		
		//ʵ�����ӿ�
		SupplierService supplierServiceImpl = new SupplierServiceImpl();
		//��ȡҪ�޸ĵĽ�����ϸ�Ľ��׵���
		String creditCode = req.getParameter("creditCode");
		
		req.setAttribute("details", supplierServiceImpl.getDetailsByNo(creditCode).get(0));
		((ServletRequest) resp).getRequestDispatcher("/manager/SupplierEdit.jsp").forward(req, resp);	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				//���ò�����ҳ��ı����ʽ
		    	req.setCharacterEncoding("utf-8");
				resp.setContentType("text/html;charset=utf-8");
				
				PrintWriter out = resp.getWriter();
				
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
					SupplierService supplierServiceImpl = new SupplierServiceImpl();
					//���ýӿڵ���ӹ�Ӧ�̷��������ؽ����ҳ�沢��ʾ
					if(supplierServiceImpl.editDetailsByNo(supplier) > 0){
						out.write("<script>");
						out.write("alert('����Ӧ�̡��޸ĳɹ���');");
						out.write("location='GetSupplierListServlert';");
						out.write("</script>");
					}else {
						out.write("<script>");
						out.write("alert('����Ӧ�̡��޸�ʧ�ܣ�');");
						out.write("location='AddSupplierServlert';");
						out.write("</script>");
					}
					
	}
}
