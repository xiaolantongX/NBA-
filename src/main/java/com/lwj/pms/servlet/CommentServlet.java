package com.lwj.pms.servlet;

import com.lwj.pms.dao.CommentDao;
import com.lwj.pms.dao.PlayerDao;
import com.lwj.pms.pojo.Comment;
import com.lwj.pms.pojo.Common_User;
import com.lwj.pms.pojo.Players_Message;
import com.lwj.pms.utils.DBUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet (urlPatterns = "/CommentServlet")
public class CommentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("Utf-8");
        resp.setCharacterEncoding("Utf-8");
        resp.setContentType("text/html;charset=Utf-8");

        String com = req.getParameter("com_text");
        Players_Message pmess = (Players_Message) req.getSession().getAttribute("Splayer");
        String name = pmess.getPLAYER_NAME();
        Common_User cuser = (Common_User)req.getSession().getAttribute("SESSION_USER");
     /*   System.out.println(cuser.toString()+cuser.getName());*/
        String username = cuser.getName();
      /*  System.out.println(com+" "+name+" "+username);*/
 /*    Comment comment = new Comment(name,username,com);*/
        CommentDao cd = new CommentDao();
        boolean issave =  cd.saveComment(name,username,com);
        System.out.println(issave);
        if(issave){
                List<Comment> commentlist = new ArrayList<>();
                commentlist =  new CommentDao().getComments(name);
                req.getSession().setAttribute("Comments",commentlist);


                PrintWriter writer = resp.getWriter();
                writer.write("<script>");
                writer.write("alert('评论成功！！');");
                writer.write("window.location.href = 'PlayerShow.jsp'");
                writer.write("</script>");
                writer.flush();
                writer.close();
                System.out.println("评论成功");
                resp.sendRedirect("/pms/PlayerShow.jsp");
        }
    }
}
