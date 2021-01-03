package com.lwj.pms.servlet;

import com.lwj.pms.dao.AjaxDao;
import com.lwj.pms.dao.PlayerDao;
import com.lwj.pms.dao.UserDao;
import com.lwj.pms.pojo.Players_Message;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet (urlPatterns = "/AjaxRegisterServlet")
public class AjaxRegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String user_name = req.getParameter("user_name");
        AjaxDao ad = new AjaxDao();
        Integer count = ad.selectByUserName(user_name);

        if(count!=null&&count>0)
        {
            resp.getWriter().print("账户已存在！！");
        }else {
            String regex = "[a-z0-9A-Z]+";
            if(user_name.matches(regex)){
                resp.getWriter().print("合法账户名");
            }else{
                resp.getWriter().print("账户名不合法");
            }

        }

    }
}
