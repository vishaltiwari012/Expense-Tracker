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

/**
 * Servlet implementation class DeleteExpenseServlet
 */
@WebServlet("/deleteExpense")
public class DeleteExpenseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteExpenseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			ExpenseDao dao = new ExpenseDao(HibernateUtil.getSessionFactory());
			boolean f = dao.deleteExpense(id);
			
			HttpSession session = request.getSession();
			if (f) {
				// Success case
				session.setAttribute("msg", "Expense deleted successfully");
				response.sendRedirect("user/view_expense.jsp");
			} else {
				// Failure case
				session.setAttribute("msg", "Failed to delete expense! Something went wrong!!");
				response.sendRedirect("user/view_expense.jsp"); // Redirect to the same page to handle the display
																// uniformly
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
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
