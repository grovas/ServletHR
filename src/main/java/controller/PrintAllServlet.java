package controller;

import dao.WorkersDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PrintAllServlet extends HttpServlet {

    @Override
    protected void doGet (HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        WorkersDAO workersDAO = new WorkersDAO();
        if (workersDAO.getSize() > 0) {
            req.setAttribute("workers", workersDAO.getWorkers());
            req.getRequestDispatcher("/printall.jsp").forward(req, resp);
        }
        else {
            req.setAttribute("emptyList", "empty");
            req.getRequestDispatcher("/welcome.jsp").forward(req, resp);
        }
    }
}