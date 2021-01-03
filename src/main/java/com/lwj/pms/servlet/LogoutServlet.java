package com.lwj.pms.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet (urlPatterns = "/LogoutServlet")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            req.getSession().invalidate();
         HttpSession httpSession = req.getSession();
            req.getRequestDispatcher("/Login.html").forward(req,resp);

         /*   resp.sendRedirect("/pms/Login.html");*/
         System.out.println("注销成功");
        }
}
