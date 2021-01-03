package com.lwj.pms.servlet;

import com.lwj.pms.dao.PlayerDao;
import com.lwj.pms.dao.TopicDao;
import com.lwj.pms.pojo.Players_Message;
import com.lwj.pms.pojo.Topic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

@WebServlet (urlPatterns = "/UpdateTopicServlet")
public class UpdateTopicServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("Utf-8");
        resp.setCharacterEncoding("Utf-8");
        resp.setContentType("text/html;charset=Utf-8");

        String topic_name = req.getParameter("topic_name");
        String topic_message = req.getParameter("topic_message");
        Integer istop = Integer.parseInt(req.getParameter("istop"));
        Integer isbright = Integer.parseInt(req.getParameter("isbright")) ;
        Topic topic = new Topic(topic_name,topic_message,istop,isbright);
        System.out.println(topic.toString());
        TopicDao td = new TopicDao();
        boolean isupdate = td.updateTopic(topic);
        if (isupdate){
                List<Topic> arrlist = new ArrayList<>();
                TopicDao tbbd = new TopicDao();
               arrlist = tbbd.getTopics();
                req.getSession().setAttribute("topics",arrlist);
                req.getRequestDispatcher("/topic.jsp").forward(req,resp);
            }else
            {
                resp.sendRedirect("topic.jsp");
                System.out.println("修改失败失败");
            }


    }
}
