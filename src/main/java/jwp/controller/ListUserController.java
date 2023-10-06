package jwp.controller;

import core.db.MemoryUserRepository;
import jwp.controller.enums.Keys;
import jwp.controller.enums.RequestURL;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/list")
public class ListUserController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute(Keys.USER_LIST_SESSION_KEY.getValue(), MemoryUserRepository.getInstance().findAll());
        RequestDispatcher rd = req.getRequestDispatcher(RequestURL.USER_LIST_JSP.getUrl());
        rd.forward(req,resp);
    }
}
