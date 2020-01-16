package controllers.book;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Book;
import utils.DBUtil;

/**
 * Servlet implementation class BookSearch
 */
@WebServlet("/books/search")
public class BookSearchServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = DBUtil.createEntityManager();

        String keyword = request.getParameter("keyword");

        List<Book> b = em.createNamedQuery("getSearchBooks",Book.class)
                              .setParameter("keyword", "%" + keyword + "%")
                              .getResultList();
        long books_count = (long) em.createNamedQuery("getSearchBooksCount", Long.class)
                                        .setParameter("keyword", "%" + keyword + "%")
                                        .getSingleResult();

        em.close();

        request.setAttribute("books", b);
        request.setAttribute("books_count", books_count);

        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("login_admin") == null) {
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/topPage/index.jsp");
            rd.forward(request, response);

        } else {

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/books/index.jsp");
        rd.forward(request, response);
    }
    }
}