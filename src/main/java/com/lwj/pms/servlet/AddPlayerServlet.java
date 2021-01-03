package com.lwj.pms.servlet;

import com.lwj.pms.dao.PlayerDao;
import com.lwj.pms.dao.UserDao;
import com.lwj.pms.pojo.Common_User;
import com.lwj.pms.pojo.Players_Message;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/AddPlayerServlet")
public class AddPlayerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("Utf-8");
        response.setCharacterEncoding("Utf-8");
        response.setContentType("text/html;charset=Utf-8");
        String player_name = request.getParameter("playername");
        String team_name = request.getParameter("teamname");
        String birth_day = request.getParameter("birthday");
        Float height = Float.parseFloat(request.getParameter("high"));
        Float weight = Float.parseFloat(request.getParameter("weight"));
        String position = request.getParameter("position");
        Integer count = Integer.parseInt(request.getParameter("count"));

        Players_Message pm = new Players_Message(player_name,team_name,birth_day,height,weight,position,count);
        System.out.println(pm.toString());
        PlayerDao pd = new PlayerDao();
        boolean issave = pd.savePlayer(pm);
        if(issave){
            List<Players_Message> playerlist = new ArrayList<>();
            PlayerDao plad = new PlayerDao();
            playerlist = plad.getPlayers();
            request.getSession().setAttribute("players",playerlist);
            request.getRequestDispatcher("/playermanage.jsp").forward(request,response);
        }else
        {
            System.out.println("保存失败");
        }
    }
}
