package packages.controller;

import packages.service.DeathService;
import packages.service.DeathServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/richest")
public class RichestUser extends HttpServlet {
    private DeathService service = DeathServiceImpl.getService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("richest", service.getRichest().toString());
        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
