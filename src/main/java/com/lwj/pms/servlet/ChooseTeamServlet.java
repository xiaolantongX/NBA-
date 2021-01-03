package com.lwj.pms.servlet;

import com.lwj.pms.dao.PlayerDao;
import com.lwj.pms.pojo.Players_Message;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@WebServlet (urlPatterns = "/ChooseTeamServlet")
public class ChooseTeamServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String teamname = req.getParameter("team_name");
        PlayerDao pd = new PlayerDao();
        List<Players_Message> playerlist = new ArrayList<>();
        playerlist = pd.getPlayersByTeam(teamname);

        req.getSession().setAttribute("players",playerlist);

        resp.sendRedirect("/pms/mainPage.jsp");
    }
}
