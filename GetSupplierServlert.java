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
		//���ò�����ҳ��ı����ʽ
				req.setCharacterEncoding("utf-8");
				resp.setContentType("text/html;charset=utf-8");
				
				PrintWriter out = resp.getWriter();
				//��ȡ���͵�HttpSession��������Ϊ��ҳ���ṩ����
				HttpSession session = req.getSession();	
				
				//�ж��Ƿ��ѵ�¼
				if(session.getAttribute("isLogin") == null||!session.getAttribute("isLogin").equals("1")) {
					out.write("<script>");
					out.write("alert('���¼�˺�');");
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
				
				//ʵ�����ӿ�
				SupplierService supplierServiceImpl = new SupplierServiceImpl();
				
				try {
					count = supplierServiceImpl.getSupplierCount();
					if(count % size != 0) {
						allIndex = count / size + 1;
					}else {
						allIndex = count / size;
					}
					//���ýӿڵĽ�����ϸ��ҳ��ʾ���������Żؽ����ҳ����ʾ
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
