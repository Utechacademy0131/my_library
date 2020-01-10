package controllers.book;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.DBUtil;

/**
 * Servlet implementation class BookSearch
 */
@WebServlet("/books/search")
public class BookSearch extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookSearch() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = DBUtil.createEntityManager();




        em.close();

        request.setAttribute("_token", request.getSession().getId());
        request.setAttribute("book", b);
        request.setAttribute("errors", errors);


        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/books/search.jsp");
        rd.forward(request, response);
    }

}
