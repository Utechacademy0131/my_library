package controllers.book;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Book;

/**
 * Servlet implementation class ReportsNewServlet
 */
@WebServlet("/books/new")
public class BooksNewServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public BooksNewServlet() {
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


        Book b = new Book();
        b.setBook_date(new Date(System.currentTimeMillis()));
        request.setAttribute("book", b);

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/books/new.jsp");
        rd.forward(request, response);
    }
    }
}
