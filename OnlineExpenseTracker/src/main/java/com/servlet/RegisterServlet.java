package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.db.HibernateUtil;
import com.entity.User;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/userRegister")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String fullName = request.getParameter("fullName");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String about = request.getParameter("about");

			User user = new User(fullName, email, password, about);
			System.out.println(user);

			UserDao userDao = new UserDao(HibernateUtil.getSessionFactory());
			boolean f = userDao.saveUser(user);

			HttpSession session = request.getSession();

			if (f) {
				// Success case
				session.setAttribute("msg", "User registered successfully");
				response.sendRedirect("register.jsp");
			} else {
				// Failure case
				session.setAttribute("msg", "Failed to register! Something went wrong!!");
				response.sendRedirect("register.jsp"); // Redirect to the same page to handle the display uniformly
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
