
<%--
  Created by IntelliJ IDEA.
  User: ASUS111LAN
  Date: 2021/1/1
  Time: 13:53
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false"%>
<!doctype html>
<html >
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>球员信息管理系统</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <link rel="stylesheet" type="text/css" href="css/font-awesome.min.css">
    <link rel="apple-touch-icon-precomposed" href="images/icon/icon.png">
    <link rel="shortcut icon" href="images/icon/favicon.ico">
    <script src="js/jquery-2.1.4.min.js"></script>
    <!--[if gte IE 9]>
    <script src="js/jquery-1.11.1.min.js" type="text/javascript"></script>
    <script src="js/html5shiv.min.js" type="text/javascript"></script>
    <script src="js/respond.min.js" type="text/javascript"></script>
    <script src="js/selectivizr-min.js" type="text/javascript"></script>
    <![endif]-->
    <!--[if lt IE 9]>
    <script>window.location.href='upgrade-browser.html';</script>
    <script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.5.1/jquery.js"></script>
    <![endif]-->
</head>

<body class="user-select">
<section class="container-fluid">
    <header>
        <nav class="navbar navbar-default navbar-fixed-top">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false"> <span class="sr-only">切换导航</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
                    <a class="navbar-brand" href="/">NBAmamage</a> </div>
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav navbar-right">
                       <%-- <li><a href="">消息 <span class="badge">1</span></a></li>--%>
                        <%--<li class="dropdown"> <a class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">admin <span class="caret"></span></a>
                            &lt;%&ndash;<ul class="dropdown-menu dropdown-menu-left">
                               &lt;%&ndash; <li><a title="查看或修改个人信息" data-toggle="modal" data-target="#seeUserInfo">个人信息</a></li>&ndash;%&gt;
                                &lt;%&ndash;<li><a title="查看您的登录记录" data-toggle="modal" data-target="#seeUserLoginlog">登录记录</a></li>&ndash;%&gt;
                            </ul>&ndash;%&gt;
                        </li>--%>
                        <li><a href="/pms/LogoutServlet" onClick="if(!confirm('是否确认退出？'))return false;">退出登录</a></li>
                       <%-- <li><a data-toggle="modal" data-target="#WeChat">帮助</a></li>--%>
                    </ul>
                   <%-- <form action="" method="post" class="navbar-form navbar-right" role="search">
                        <div class="input-group">
                            <input type="text" class="form-control" autocomplete="off" placeholder="键入关键字搜索" maxlength="15">
                            <span class="input-group-btn">
                     <button class="btn btn-default" type="submit">搜索</button>
              </span> </div>
                    </form>--%>
                </div>
            </div>
        </nav>
    </header>
    <div class="row">
        <aside class="col-sm-3 col-md-2 col-lg-2 sidebar">
            <!--<ul class="nav nav-sidebar">
              <li><a href="index.html">报告</a></li>
            </ul>-->
            <ul class="nav nav-sidebar">
                <li class="active"><a href="playermanage.jsp">球员管理</a></li>
                <li ><a href="teammanage.jsp">球队管理</a></li>
                <li ><a href="topic.jsp">话题管理</a></li>
                <li><a href="comment.jsp">评论管理</a></li>
            </ul>

            <ul class="nav nav-sidebar">
                <li><a class="dropdown-toggle" id="userMenu" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">用户管理</a>
                    <ul class="dropdown-menu" aria-labelledby="userMenu">
                        <li><a href="#">管理员用户管理</a></li>
                        <li><a href="manage_user.jsp">用户管理</a></li>

                    </ul>
                </li>

            </ul>
        </aside>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-lg-10 col-md-offset-2 main" id="main">
            <form action="/Article/checkAll" method="post" >
                <h1 class="page-header">Q球员信息管理Q</h1>
                <ol class="breadcrumb">
                    <li><a href="addPlayer.html">增加球员</a></li>
                </ol>
                <h1 class="page-header">球员管理 <span class="badge">${sessionScope.players.size()}</span></h1>
                <div class="table-responsive">
                    <table class="table table-striped table-hover">
                        <thead>
                        <tr>
                            <th><span class="glyphicon glyphicon-th-large"></span> <span class="visible-lg">球员姓名</span></th>
                            <th><span class="glyphicon glyphicon-file"></span> <span class="visible-lg">所在球队</span></th>
                            <th><span class="glyphicon glyphicon-time"></span> <span class="visible-lg">生日</span></th>
                            <th><span class="glyphicon glyphicon-pencil"></span> <span class="visible-lg">位置</span></th>
                            <th><span class="glyphicon glyphicon-screenshot"></span> <span class="visible-lg">详情</span></th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${sessionScope.players}" var="player">
                            <tr>
                                <td>${player.PLAYER_NAME}<%--<%=session.getAttribute("players").toString()%>--%></td>
                                <td class="article-title">${player.TEAM_NAME}</td>
                                <td>${player.BIRTH_DAY}</td>
                                <td>${player.POSITION}</td>
                                <td><a href="">详情</a></td>
                                <td><a href="\pms\update.html">修改</a> <a rel="6">删除</a></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                <%--<footer class="message_footer">
                    <nav>
                        <div class="btn-toolbar operation" role="toolbar">
                            <div class="btn-group" role="group"> <a class="btn btn-default" onClick="select()">全选</a> <a class="btn btn-default" onClick="reverse()">反选</a> <a class="btn btn-default" onClick="noselect()">不选</a> </div>
                            <div class="btn-group" role="group">
                                <button type="submit" class="btn btn-default" data-toggle="tooltip" data-placement="bottom" title="删除全部选中" name="checkbox_delete">删除</button>
                            </div>
                        </div>
                        <ul class="pagination pagenav">
                            <li class="disabled"><a aria-label="Previous"> <span aria-hidden="true">&laquo;</span> </a> </li>
                            <li class="active"><a>1</a></li>
                            <li class="disabled"><a aria-label="Next"> <span aria-hidden="true">&raquo;</span> </a> </li>
                        </ul>
                    </nav>
                </footer>--%>
            </form>
        </div>
    </div>
</section>

<script src="js/bootstrap.min.js"></script>
<script src="js/admin-scripts.js"></script>
<script>
    //是否确认删除
    $(function(){
        $("#main table tbody tr td a").click(function(){
            var name = $(this);
            var id = name.attr("rel"); //对应id
            if (event.srcElement.outerText == "删除")
            {
                if(window.confirm("此操作不可逆，是否确认？"))
                {
                    $.ajax({
                        type: "POST",
                        url: "/Article/delete",
                        data: "id=" + id,
                        cache: false, //不缓存此页面
                        success: function (data) {
                            window.location.reload();
                        }
                    });
                };
            };
        });
    });
</script>
</body>
</html>

