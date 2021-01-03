package com.lwj.pms.servlet;

import com.lwj.pms.dao.UserDao;
import com.lwj.pms.pojo.Common_User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
@WebServlet (urlPatterns = "/DelServlet")
public class DelServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String user_name = request.getParameter("user_name");
            UserDao ud = new UserDao();
            boolean count = ud.delByUserName(user_name);

            /*用户数据*/
            List<Common_User> userlist = new ArrayList<>();
            userlist = ud.getUsers();
            System.out.println(userlist);
            request.getSession().setAttribute("USERs",userlist);
            System.out.println( request.getSession().getAttribute("USERs"));
            request.getRequestDispatcher("/manage_user.jsp").forward(request,response);
    }
}
