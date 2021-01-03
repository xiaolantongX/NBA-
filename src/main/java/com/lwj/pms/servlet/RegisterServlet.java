package com.lwj.pms.servlet;

import com.lwj.pms.dao.UserDao;
import com.lwj.pms.pojo.Common_User;
import com.lwj.pms.pojo.Super_Manager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //获取前台提交的email和密码
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String name = request.getParameter("rename");
        String sex = request.getParameter("gender");
        String telphone = request.getParameter("telphone");
        String birthday =  request.getParameter("birthday");

        //插入到数据库中，对数据库进行封装成一个对象
        Common_User user = new Common_User(userName,password,email,name,telphone,sex, birthday);

       // Applicant applicant = new Applicant(null,applicatPwd,applicatEmail,new Date());
        //保存对象（User）到数据库 UserDAO
        UserDao userDao = new UserDao();

        //判断是否有相同的该用户名
        Integer count = userDao.selectUserName(userName);

       /* System.out.println(count+"  1");*/
        if (count > 0){
            //数据库中已经有相同的用户名
            //通过response对象给客户端一个错误提示
            PrintWriter writer = response.getWriter();
            writer.write("<script>");
            writer.write("alert('申请注册的用户名已经被占用！');");
            writer.write("window.location.href = 'Register.html'");
            writer.write("</script>");
            writer.flush();
            writer.close();
            System.out.println("注册占用");
        }else {

            //flag是否注册成功
            boolean flag = userDao.saveUser(user);
            if (flag) {

                if(request.getSession().getAttribute("superM")!=null){
                    /*用户数据*/
                    List<Common_User> userlist = new ArrayList<>();
                    UserDao ud = new UserDao();
                    userlist = ud.getUsers();
                    System.out.println(userlist);
                    request.getSession().setAttribute("USERs",userlist);
                    System.out.println( request.getSession().getAttribute("USERs"));

                    request.getRequestDispatcher("/manage_user.jsp").forward(request,response);
                 /*   response.sendRedirect("/pms/manage_user.jsp");*/
                    System.out.println("注册成功");
                }else{
                    //注册成功就跳转到登录页面  重定向
                    response.sendRedirect("/pms/Login.html");
                    System.out.println("注册成功");
                }

            } else {
                //注册失败返回注册页面 请求转发
                RequestDispatcher dispatcher = request.getRequestDispatcher("/pms/Register.html");
                dispatcher.forward(request, response);
                System.out.println("注册失败");
            }
        }

    }
}
