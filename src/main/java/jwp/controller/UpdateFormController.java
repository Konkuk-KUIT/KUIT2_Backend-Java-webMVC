package jwp.controller;

import core.db.MemoryUserRepository;
import jwp.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet("/user/updateForm")
public class UpdateFormController implements Controller {

    @Override
    public String excute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String userId = req.getParameter("userId");
        User user = MemoryUserRepository.getInstance().findUserById(userId);
        if (user != null) {
            req.setAttribute("user", user);
//            RequestDispatcher rd = req.getRequestDispatcher("/user/updateForm.jsp");
//            rd.forward(req, resp);
            return "/user/updateForm.jsp";
        }
//        resp.sendRedirect("/");

        return "/";
    }
}
