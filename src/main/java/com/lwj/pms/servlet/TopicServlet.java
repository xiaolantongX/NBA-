package com.lwj.pms.servlet;

import com.lwj.pms.dao.TopicDao;
import com.lwj.pms.pojo.Topic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet (urlPatterns = "/TopicServlet")
public class TopicServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("Utf-8");
        resp.setCharacterEncoding("Utf-8");
        resp.setContentType("text/html;charset=Utf-8");

        String topic_name = req.getParameter("topicname");
        System.out.println(topic_name);
            TopicDao td = new TopicDao();
        Topic topic = td.getTopic(topic_name);
          System.out.println(topic.toString());
            HttpSession session = req.getSession();
            session.setAttribute("topic",topic);
            resp.sendRedirect("/pms/updateTopic.jsp");
    }
}
