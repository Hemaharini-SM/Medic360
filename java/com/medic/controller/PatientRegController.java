package com.medic.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.medic.dao.PatientDao;
import com.medic.model.PatientModel;

/**
 * Servlet implementation class PatientRegController
 */
@WebServlet("/PatientRegController")
public class PatientRegController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PatientRegController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		String address=request.getParameter("address");
		String gender=request.getParameter("gender");
		String mailid=request.getParameter("mailid");
		String password=request.getParameter("password");
		String confrimpassword=request.getParameter("confrimpassword");
		
		
		int mobile=Integer.parseInt(request.getParameter("phno"));
		int age=Integer.parseInt(request.getParameter("age"));
		
		PatientModel model=new PatientModel();
		model.setFname(fname);
		model.setLname(lname);
		model.setAddress(address);
		model.setGender(gender);
		model.setMailid(mailid);
		model.setPassword(password);
		model.setAge(age);
		model.setPhno(mobile);
		
		
		PatientDao dao=new PatientDao();
		try {
			boolean status=dao.insertData(model);
			if(status)
			{
				RequestDispatcher rd=request.getRequestDispatcher("EmployeeFetchController");
				rd.forward(request, response);
			}else
			{
				System.out.println("not inserted");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		

	}

}
}