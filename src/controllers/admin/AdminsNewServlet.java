package controllers.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Admin;

/**
 * Servlet implementation class EmployeesNewServlet
 */
@WebServlet("/admins/new")
public class AdminsNewServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminsNewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("login_admin") == null) {
            response.sendRedirect(request.getContextPath() + "/");

        } else {

        request.setAttribute("_token", request.getSession().getId());
        request.setAttribute("admin", new Admin());

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/admins/new.jsp");
        rd.forward(request, response);
    }
    }
}