package com.zu.controler;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.zu.dao.UserDao;


/**
 * Servlet implementation class UserLogin
 */
@WebServlet("/UserLogin")
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLogin() {
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

	
		if(request.getParameter("loginInput") != null) {
			
			try {
				
				String email = request.getParameter("user_email");
				String password = request.getParameter("user_pass");
				
				UserDao userD = new UserDao();

				ResultSet res =  userD.userLogin(email ,password);
				res.next();
				if(res.getRow() == 1) {
					
					HttpSession session = request.getSession();
					
					session.setAttribute("USERNAME", res.getString("userName"));
					session.setAttribute("USERID", res.getString("id"));
					session.setAttribute("ISADMIN", res.getString("isAdmin"));
					
					response.sendRedirect("indexServlet");

				}
				
            	response.getWriter().println("The email or password is incorrect");

		
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
	}

}
