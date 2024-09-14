package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.ExpenseDao;
import com.db.HibernateUtil;
import com.entity.Expense;
import com.entity.User;

/**
 * Servlet implementation class UpdateExpenseServlet
 */
@WebServlet("/updateExpense")
public class UpdateExpenseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateExpenseServlet() {
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
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			String title = request.getParameter("title");
			String date = request.getParameter("date");
			String time = request.getParameter("time");
			String price = request.getParameter("price");
			String description = request.getParameter("description");
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("loginUser");

			Expense ex = new Expense(title, date, time, description, price, user);
			ex.setId(id);
			System.out.println(ex);

			ExpenseDao expenseDao = new ExpenseDao(HibernateUtil.getSessionFactory());
			boolean f = expenseDao.saveExpense(ex);

			if (f) {
				// Success case
				session.setAttribute("msg", "Expense updated successfully");
				response.sendRedirect("user/view_expense.jsp");
			} else {
				// Failure case
				session.setAttribute("msg", "Failed to update expense! Something went wrong!!");
				response.sendRedirect("user/edit_expense.jsp"); // Redirect to the same page to handle the display
																// uniformly
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}