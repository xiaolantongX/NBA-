package com.lwj.pms.servlet;

import com.lwj.pms.dao.*;
import com.lwj.pms.pojo.*;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

@WebServlet(urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("进入登录servlet");
        String username = request.getParameter("user_name");
        String password = request.getParameter("password");
        String log_type = request.getParameter("log_type");
        //将数据库的数据加入session中
        HttpSession session = request.getSession();
        /*用户数据*/
        List<Common_User> userlist = new ArrayList<>();
        UserDao uaad = new UserDao();
        userlist = uaad.getUsers();
        session.setAttribute("USERs",userlist);
        /*球员数据*/
        List<Players_Message> arrayList ;
        PlayerDao paad = new PlayerDao();
        arrayList = paad.getPlayers();
        session.setAttribute("players",arrayList);
        /*球d队数据*/
        List<Team_Message> teamlist ;
        TeamDao taad = new TeamDao();
        teamlist = taad.getTeams();
        session.setAttribute("teams",teamlist);
        /*话题数据*/
      /*  TreeSet<Topic> topiclist = new TreeSet<>();*/
        List<Topic> arr = new ArrayList<>();
        TopicDao topicd = new TopicDao();
        arr = topicd.getTopics();
        /*for (int i = 0; i < arr.size() ; i++) {
            topiclist.add(arr.get(i));
        }*/

        /*System.out.println(topiclist.size());*/
        /*for (Topic topic:topicd.getTopics()) {
            *//*System.out.println(topic.toString());*//*
                topiclist.add(topic);
        }*//*对存储进来的判断置顶 置顶则排在前面*//*
        System.out.println(topiclist.size());*/
        session.setAttribute("topics",arr);
        /*评论数据*/
        List<Comment> allcommentslist ;
        CommentDao caad = new CommentDao();
        allcommentslist = caad.getAllComments();
        session.setAttribute("allcomments",allcommentslist);
       /* System.out.println(username);
        System.out.println(password);
        System.out.println(log_type);*/
       if(log_type.equals("user")){
           // 查询申请人
           UserDao userDao = new UserDao();
           Common_User user = userDao.getUserByUserNameAndPwd(username,password);

           /*System.out.println("----"+players+"----");*/
           /*System.out.println(user.getUser_name()+","+user.getPassword());*/
           //判断user == null ，返回登录页面，不为空，就进入主页
           if (user != null){
               //将登录用户对象保存到session里

               session.setAttribute("SESSION_USER",user);
               //登录成功就跳转到主页面  重定向
               response.sendRedirect("/pms/mainPage.jsp");
           }else{
               PrintWriter writer = response.getWriter();
               writer.write("<script>");
               writer.write("alert('用户名或者密码错误！');");
               writer.write("window.location.href = 'Login.html'");
               writer.write("</script>");
               writer.flush();
               writer.close();
               response.sendRedirect("/pms/Login.html");

           }

       }else if (log_type.equals("super_man")){
           if (username.equals("superadmin")&&password.equals("616891")){
               Super_Manager sm = new Super_Manager(username,password);
                session.setAttribute("superM",sm);
               PrintWriter writer = response.getWriter();
               writer.write("<script >");
               writer.write("alert('欢迎大哥！欢迎大哥！！');");
               writer.write("window.location.href = 'manage_user.jsp'");
               writer.write("</script>");
               writer.flush();
               writer.close();
               response.sendRedirect("/pms/manage_user.jsp");
           }
           else{
               PrintWriter writer = response.getWriter();
               writer.write("<script>");
               writer.write("alert('大胆小儿，竟敢冒充大哥，速速退下！！');");
               writer.write("window.location.href = 'Login.html'");
               writer.write("</script>");
               writer.flush();
               writer.close();
           }
       }else{
           PrintWriter writer = response.getWriter();
           writer.write("<script>");
           writer.write("alert('暂时没有管理员哦！！ 亲');");
           writer.write("window.location.href = Login.html'");
           writer.write("</script>");
           writer.flush();
           writer.close();
           response.sendRedirect("/pms/Login.html");
       }

        /*  String sub_name = req.getParameter("sub_name");*/

        /*   Common_User cuser = new Common_User(username,password);*/




    }
}
