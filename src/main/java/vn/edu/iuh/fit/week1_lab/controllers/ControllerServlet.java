package vn.edu.iuh.fit.week1_lab.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.edu.iuh.fit.week1_lab.entities.Account;
import vn.edu.iuh.fit.week1_lab.repositories.AccountRepository;

import java.io.IOException;

@WebServlet(name = "ControllerServlet", urlPatterns = {"/controller-servlet"})
public class ControllerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "login";
        }
        switch (action) {
            case "login":
                login(req, resp);
                break;
            case "register":
                register(req, resp);
                break;
            case "logout":
                logout(req, resp);
                break;
            default:
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Unknown action: " + action);
                break;
        }
    }

    private void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AccountRepository accountRepository = new AccountRepository();
        String accountId = req.getParameter("accountId");
        String password = req.getParameter("password");
        Account account = null;
        if (accountId != null && password != null) {
            account = accountRepository.checkLogin(accountId, password);
        }
        if (account != null) {
            HttpSession session = req.getSession();
            session.setAttribute("account", account);
            resp.sendRedirect("index.jsp");
        } else {
            req.setAttribute("message", "Invalid username or password");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }

    private void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Implement registration logic here
    }

    private void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        resp.sendRedirect("login.jsp");
    }
}