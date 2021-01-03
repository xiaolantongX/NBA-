package com.lwj.pms.servlet;

import com.lwj.pms.dao.CommentDao;
import com.lwj.pms.dao.PlayerDao;
import com.lwj.pms.dao.UserDao;
import com.lwj.pms.pojo.Comment;
import com.lwj.pms.pojo.Players_Message;
import com.lwj.pms.utils.DBUtils;

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
@WebServlet (urlPatterns =  "/SearchServlet")
public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       req.setCharacterEncoding("UTF-8");
       resp.setCharacterEncoding("UTF-8");
       resp.setContentType("text/html;charset=UTF-8");
        String playerName = req.getParameter("playerName");
        System.out.println(playerName);
       /* System.out.println(searchName);*/
        Players_Message players_mes = new Players_Message();
        PlayerDao pd = new PlayerDao();
        CommentDao cd = new CommentDao();
        players_mes = pd.getPlayer(playerName);
       System.out.println(players_mes);
         List<Comment> comments = new ArrayList<>();
         comments = cd.getComments(playerName);
        HttpSession session = req.getSession();
        /*
       如果查询到数据库里面有数据 进入数据详情页
         */
          if (players_mes!=null){
                  if(comments!=null){
                  session.setAttribute("Comments",comments);
                  }
              /*将查询到的球员数据存储到sission中*/
             session.setAttribute("Splayer",players_mes);
             resp.sendRedirect("/pms/PlayerShow.jsp");
        }else
          {
              PrintWriter writer = resp.getWriter();
              writer.write("<script>");
              writer.write("alert('NO FIND!!!!');");
              writer.write("window.location.href = 'mainPage.html'");
              writer.write("</script>");
              writer.flush();
              writer.close();
              resp.sendRedirect("/pms/mainPage.jsp");
          }

    }
}
