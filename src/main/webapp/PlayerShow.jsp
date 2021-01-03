<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>球员信息展示</title>
    <link rel="stylesheet" href="css/playershow.css"/>
    <script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.5.1/jquery.js"></script>
    <script type="text/javascript">

    </script>
</head>
<body>
<div id="header">
    <img src="img/showheader.png" class="header_img"/>
</div>
<div class="top_line"></div>
<div id="midd">
    <div class="head_shot">
        <img src="img/头像/罗斯.jpg"/>
    </div>
    <span class="Player_name"><h5>${sessionScope.Splayer.PLAYER_NAME}</h5></span>
    <img src="img/team-icon/迈阿密热队.jpg"/><span class="Team_name">${sessionScope.Splayer.TEAM_NAME}</span>
    <ul class="list_mes">
        <li><strong>身高：</strong><span id="high">${sessionScope.Splayer.HEIGHT}</span></li>
        <li><strong>体重：</strong><span id="weight">${sessionScope.Splayer.WEIGHT}</span></li>
        <li><strong>位置：</strong><span id="position">${sessionScope.Splayer.POSITION}</span></li>
        <li><strong>生日：</strong><span id="birthday">${sessionScope.Splayer.BIRTH_DAY}</span></li>
        <li><strong>生涯总得分：</strong><span id="totalcount">${sessionScope.Splayer.COUNT}</span></li>
    </ul>

    <span class="line1">

				</span>
    <div class="data_show">
        <ul>
            <li><a href="javascript">评论</a></li>
            <!--<li><a href="javascript">赛季数据</a></li>
            <li><a href="javascript">生涯</a></li>-->
        </ul>

    </div>
    <div class="comment">
        <div class="show_com">
            <table border="" cellspacing="" cellpadding="" class="com_tab">
                <c:forEach items="${sessionScope.Comments}" var="comm">
                <tr>
                    <td class="com_user_name">${comm.NAME}:</td>
                    <td class="user_com">${comm.COMMENT}</td>
                </tr>
                </c:forEach>
                <%--<tr>
                    <td class="p_com_user_name">${comm.NAME}:</td>
                    <td class="p_user_com">${comm.COMMENT}</td>
                </tr>--%>
            </table>
        </div>

        <form action="/pms/CommentServlet" method="post" class="wit_com">
          <textarea name="com_text" id="comment_text" style="resize: none;" rows="4" cols="100"  placeholder="留下你的评论吧..."></textarea>
            <!--<input type="text" name="comment_text" id="com_text" placeholder="留下你的评论吧..." />-->
            <input type="submit" value="发布评论" class="sub_com" />
        </form>

       <%-- <script type="text/javascript">

            function sendComment() {
                $("#btn_com").click(function () {
                    var comm = $("#comment_text").val();
                    var name = ${sessionScope.SESSION_USER.name};
                    var player_name = ${sessionScope.Splayer.PLAYER_NAME};
                    console.log(com+"  "+name+"  "+player_name);
                    $.ajax({
                        url:"/pms/AjaxCommentServlet",
                        data:"comment="+comm+"&name="+name+"&player_name="+player_name,
                        type:'POST',
                        /*success:function () {
                        }*/
                    })
                })

            };

        </script>--%>
    </div>
</div>

<div id="foot">

</div>
</body>
</html>

