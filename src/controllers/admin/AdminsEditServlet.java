package controllers.admin;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Admin;
import utils.DBUtil;

/**
 * Servlet implementation class EmployeesEditServlet
 */
@WebServlet("/admins/edit")
public class AdminsEditServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminsEditServlet() {
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

        EntityManager em = DBUtil.createEntityManager();

        Admin a = em.find(Admin.class, Integer.parseInt(request.getParameter("id")));

        em.close();

        request.setAttribute("admin", a);
        request.setAttribute("_token", request.getSession().getId());
        request.getSession().setAttribute("admin_id", a.getId());

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/admins/edit.jsp");
        rd.forward(request, response);
    }
    }
}