package packages.controller;

import packages.service.DeathService;
import packages.service.DeathServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/sumAccounts")
public class SumAccounts extends HttpServlet {
    private DeathService projectService = DeathServiceImpl.getService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int accounts = projectService.getSumAccounts();

        req.setAttribute("accounts", accounts);
        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
