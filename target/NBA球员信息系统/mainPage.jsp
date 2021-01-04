<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>球员信息系统</title>
    <link rel="stylesheet" href="css/mainpage.css"/>
    <link rel="stylesheet" href="css/bootstrap.min.css"/>
    <link rel="stylesheet" href="css/font-awesome.min.css"/>
    <link rel="stylesheet" href="css/bootstrap-theme.min.css">
     <script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.5.1/jquery.js"></script>
    <script src="js/jquery-2.1.4.min.js"></script>
    <script src="js/bootstrap.min.js"></script>

    <script>
        $(function () {
            $(".circleUl li" ).eq(0).css("background-color","#90EE90");
            $(".roll_move li").eq(0).css("visibility","visible");
            let index = 0;
            $(".left_btn").click(function(){

                index--;
                if(index<0){
                    index = 4;
                }
                $(".roll_move li").eq(index).css("visibility","visible").siblings().css("visibility","hidden");
                $('.circleUl li').eq(index).css("background-color","#90EE90").siblings().css("background-color","white");
            });
            $(".right_btn").click(function(){
                index++;
                if(index>4){
                    index = 0;
                }
                $(".roll_move li").eq(index).css("visibility","visible").siblings().css("visibility","hidden");
                $('.circleUl li').eq(index).css("background-color","#90EE90").siblings().css("background-color","white");
            })
        });
    /*
        $(function () {
            $(window).onload(function () {
                $.get("/MainPageServlet");
            })
    })*/
       /* window.onload = function f() {

        }*/
        /*$(document).ready(function(){
            alert("登录成功，欢迎用户");
        });*/
    </script>

</head>
<body class="page">
<div id="head">
            <!--<h1>搜索</h1>-->
            <img src="img/NBA.png" class="log_left"/>
            <img src="img/head1.jpg" class="head_img"/>
            <img src="img/NBA.png" class="log_right"/>
            <div class="single_btn"><button id="title"><strong>球   员   信   息   系   统</strong></button></div>
    </div>
    <div id="mid">
        <div class="menue_bg">
         <form action="/pms/SearchServlet" class="search_form" method="post">
            <input type="text" id="search_text" placeholder="请输入球员名" name="playerName" class="playerName">
            <input type="submit" value="搜索" id="search_form_sub">
        </form>
            <%--<script type="text/javascript">
                /*鼠标点击搜索按钮，启动Ajax*/
                $("#search_form_sub").click(function () {
                    /*获取到搜索框的值*/
                    var value =$("#search_text").val();
                    console.log(value);
                    /*使用Ajax*/
                    $.ajax({
                        //url，写要访问的地址，这里访问的是servlet映射地址
                        url: "AJAXServlet",
                        cache: false,  // 是否缓存
                        //参数  相当于地址栏后面的参数
                        data: "player_name="+value,
                        //请求类型
                        type: 'POST',
                        timeout:2000,
                        //成功的回调   问成功后，执行的方法，参数是后台的结果
                        success:function (result) {
                          /*  // 将获取到的数据写入span标签
                            $("#sp").text(result);*/
                            alert(result);
                        }
                    })
                })
            </script>--%>
        <form action="/pms/LogoutServlet" class="own_center" method="post">
            <span class="welcome_txt">欢迎您 &nbsp;</span><span class="welcome_txt"><a href="">${sessionScope.SESSION_USER.user_name}</a></span><span class="welcome_txt">&nbsp;先生&nbsp;&nbsp;	&nbsp;</span>
            <input type="submit" value="退出" class="own_center_sub">
        </form>
    </div>
    <div class="view_pager">
        <span class="hot_player"><h4>热点推荐球员</h4></span>
        <ul class="roll_move">
            <li><a href="/pms/playerMessage.html"><img src="img/轮播/尼克杨.jpg" alt="" /></a></li>
            <li><a href="javascript:;"><img src="img/轮播/库里.jpg" alt="" /></a></li>
            <li><a href="javascript:;"><img src="img/轮播/林书豪.jpg" alt="" /></a></li>
            <li><a href="javascript:;"><img src="img/轮播/罗斯.jpg" alt="" /></a></li>
            <li><a href="javascript:;"><img src="img/轮播/韦德.jpg" alt="" /></a></li>
            <!--<li><a href="javascript:;"><img src="img/轮播/尼克杨.jpg" alt="" /></a></li>-->
        </ul>
        <div class="btn">
            <div class="left_btn">&nbsp; < </div>
            <div class="right_btn"> &nbsp;> </div>
        </div>

        <div class="circle">
            <ul class="circleUl">
                <li></li>
                <li></li>
                <li></li>
                <li></li>
                <li></li>
            </ul>
        </div>
    </div>
        <table class="table table-striped" id="topic_tab" >
            <tr >
                <th >最新话题</th>
                <th >话题内容</th>
                <th >置顶</th>
            </tr>
            <c:forEach items="${sessionScope.topics}" var="topic">
                <c:choose>
                    <c:when test="${topic.IS_BRIGHT==1}">
                        <tr class="bright">
                            <td width="25%" >${topic.TOPIC_NAME}</td>
                            <td width="63%"  style="text-overflow: clip"><a href="">${topic.TOPIC_MESSAGE}</a> </td>
                            <td width="12%" ><c:if test="${topic.IS_TOP==1}"> <span class="glyphicon glyphicon-pushpin">已置顶</span> </c:if>  </td>
                        </tr>
                    </c:when>
                    <c:otherwise>
                        <tr>
                            <td width="25%" >${topic.TOPIC_NAME}</td>
                            <td width="63%"><a href="" style="text-overflow: clip">${topic.TOPIC_MESSAGE}</a> </td>
                            <td width="12%"><c:if test="${topic.IS_TOP==1}"> <span>已置顶</span> </c:if>  </td>
                        </tr>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </table>

</div>
<div class="player_bg">
    <%--<div class="btn-group player_table">
        <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            全部球员 <span class="caret"></span>
        </button>
        <ul class="dropdown-menu">
            <li><a href="#">Action</a></li>
            <li><a href="#">Another action</a></li>
            <li><a href="#">Something else here</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">Separated link</a></li>
        </ul>
    </div>--%>
    <table class="table table-striped player_table">
        <tr>
            <th>球员名</th>
                <th>
                    <div class="btn-group">
                        <button  type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            所有球队 <span class="caret"></span>
                        </button>
                        <ul class="dropdown-menu" role="menu">
                            <c:forEach items="${sessionScope.teams}" var="team">
                                <li>
                                   <a href="/pms/ChooseTeamServlet?team_name=${team.TEAM_NAME}">${team.TEAM_NAME}</a>
                                </li>
                            </c:forEach>
                        </ul>
                    </div>
            </th>
            <th>查看详情</th>
        </tr>
        <c:forEach items="${sessionScope.players}" var="pla_mes">
            <tr>
                <form action="/pms/SearchServlet" method="post">
                    <td class="player_name"><input  type="hidden" value="${pla_mes.PLAYER_NAME}" name="playerName">${pla_mes.PLAYER_NAME}</td>
                    <td class="team_name">${pla_mes.TEAM_NAME}</td>
                    <td><input type="submit" value="详情" class="details"></td>
                </form>
            </tr>
        </c:forEach>
    </table>

</div>

<div id="foot"></div>
</body>

</html>