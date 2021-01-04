<%--
  Created by IntelliJ IDEA.
  User: ASUS111LAN
  Date: 2021/1/1
  Time: 13:55
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"   isELIgnored="false"%>
<html >

<head>
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    %>
    <base href="<%=basePath%>">
    <meta charset="utf-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>管理用户 - XXX博客管理系统</title>

    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <link rel="stylesheet" type="text/css" href="css/font-awesome.min.css">

    <link rel="apple-touch-icon-precomposed" href="images/icon/icon.png">
    <link rel="shortcut icon" href="images/icon/favicon.ico">
    <script src="js/jquery-2.1.4.min.js"></script>

</head>

<body class="user-select">
<section class="container-fluid">
    <header>
        <nav class="navbar navbar-default navbar-fixed-top">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false"> <span class="sr-only">切换导航</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
                    <a class="navbar-brand" href="#">NBAmamage</a> </div>
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
    <aside class="col-sm-3 col-md-2 col-lg-2 sidebar">
        <!--<ul class="nav nav-sidebar">
          <li><a href="index.html">报告</a></li>
        </ul>-->
        <ul class="nav nav-sidebar">
            <li ><a href="playermanage.jsp">球员管理</a></li>
            <li ><a href="teammanage.jsp">球队管理</a></li>
            <li><a href="topic.jsp">话题管理</a></li>
            <li ><a href="comment.jsp">评论管理</a></li>
        </ul>

        <ul class="nav nav-sidebar">
            <li class="active"><a class="dropdown-toggle" id="userMenu" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">用户管理</a>
                <ul class="dropdown-menu" aria-labelledby="userMenu">
                    <li><a href="#">管理员用户管理</a></li>
                    <li class="active"><a href="manage_user.jsp">用户管理</a></li>

                </ul>
            </li>
        </ul>
    </aside>
    <div class="col-sm-9 col-sm-offset-3 col-md-10 col-lg-10 col-md-offset-2 main" id="main">
        <h1 class="page-header">操作</h1>
        <ol class="breadcrumb">
            <li><a data-toggle="modal" data-target="#addUser">增加用户</a></li>
        </ol>
        <h1 class="page-header">管理 <span class="badge">${sessionScope.USERs.size()}</span></h1>
        <div class="table-responsive">
            <table class="table table-striped table-hover">
                <thead>
                <tr>
                    <th><span class="glyphicon glyphicon-user"></span> <span class="visible-lg">账户名</span></th>
                    <th><span class="glyphicon glyphicon-paperclip"></span> <span class="visible-lg">密码</span></th>
                    <th><span class="glyphicon glyphicon-bookmark"></span> <span class="visible-lg">邮箱</span></th>
                    <th><span class="glyphicon glyphicon-collapse-up"></span> <span class="visible-lg">名字</span></th>
                    <th><span class="glyphicon glyphicon-xbt"></span> <span class="visible-lg">电话号码</span></th>
                    <th><span class="glyphicon glyphicon-pencil"></span> <span class="visible-lg">性别</span></th>
                    <th><span class="glyphicon glyphicon-time"></span> <span class="visible-lg">生日</span></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${sessionScope.USERs}" var="user">
                    <tr>
                        <td>${user.user_name}</td>
                        <td>${user.password}</td>
                        <td>${user.email}</td>
                        <td>${user.name}</td>
                        <td>${user.phone_num}</td>
                        <td>${user.sex}</td>
                        <td>${user.birth_day}</td>
                        <td><form action="/pms/DelServlet" method="post"><input type="hidden" name="user_name" value="${user.user_name}"> <input type="submit" value="删除"></form> </td>
                    </tr>
                </c:forEach>

                </tbody>
            </table>
        </div>
    </div>
    </div>
</section>
<!--增加用户模态框-->
<div class="modal fade" id="addUser" tabindex="-1" role="dialog" aria-labelledby="addUserModalLabel">
    <div class="modal-dialog" role="document" style="max-width:450px;">
        <form action="/pms/RegisterServlet" method="post" autocomplete="off" draggable="false">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" >增加用户</h4>
                </div>
                <div class="modal-body">
                    <table class="table" style="margin-bottom:0px;">
                        <thead>
                        <tr> </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td wdith="30%">用户名:</td>
                            <td width="70%"><input type="text" value="" class="form-control" name="username" maxlength="10" autocomplete="off" placeholder="用户名"/></td>
                        </tr>
                        <tr>
                            <td wdith="30%">密码:</td>
                            <td width="70%"><input type="password" value="" class="form-control" name="password" maxlength="10" autocomplete="off" placeholder="密码"/></td>
                        </tr>
                        <tr>
                            <td wdith="30%">Email:</td>
                            <td width="70%"><input type="email" value="" class="form-control" name="email" maxlength="13" autocomplete="off" placeholder="请输入你的邮箱"/></td>
                        </tr>
                        <tr>
                            <td wdith="30%">姓名:</td>
                            <td width="70%"><input type="password" class="form-control" name="rename" maxlength="18" autocomplete="off" placeholder="请输入真实姓名" /></td>
                        </tr>
                        <tr>
                            <td wdith="30%">性别:</td>
                            <td width="70%"> <input type="radio" class="form-control"  name="gender" value="male" checked> 男
                            <input type="radio" name="gender" class="form-control" value="female"> 女
                        </td>
                        </tr>
                        <tr>
                            <td wdith="20%">手机号:</td>
                            <td width="80%"><input type="text" class="form-control" name="telphone" maxlength="18" autocomplete="off" placeholder="请输入手机号"/></td>
                        </tr>
                        <tr>
                            <td wdith="20%">生日:</td>
                            <td width="80%"><input type="date" class="form-control" name="birthday" maxlength="18" autocomplete="off" placeholder="请输入生日日期"/></td>
                        </tr>
                        </tbody>
                        <tfoot>
                        <tr></tr>
                        </tfoot>
                    </table>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    <button type="submit" class="btn btn-primary">提交</button>
                </div>
            </div>
        </form>
    </div>
</div>
<%--<!--用户信息模态框-->
<div class="modal fade" id="seeUser" tabindex="-1" role="dialog" aria-labelledby="seeUserModalLabel">
    <div class="modal-dialog" role="document" style="max-width:450px;">
        <form action="/User/update" method="post" autocomplete="off" draggable="false">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title">修改用户</h4>
                </div>
                <div class="modal-body">
                    <table class="table" style="margin-bottom:0px;">
                        <thead>
                        <tr> </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td wdith="20%">姓名:</td>
                            <td width="80%"><input type="text" value="" class="form-control" id="truename" name="truename" maxlength="10" autocomplete="off" /></td>
                        </tr>
                        <tr>
                            <td wdith="20%">用户名:</td>
                            <td width="80%"><input type="text" value="" class="form-control" id="username" name="username" maxlength="10" autocomplete="off" /></td>
                        </tr>
                        <tr>
                            <td wdith="20%">电话:</td>
                            <td width="80%"><input type="text" value="" class="form-control" id="usertel" name="usertel" maxlength="13" autocomplete="off" /></td>
                        </tr>
                        <tr>
                            <td wdith="20%">旧密码:</td>
                            <td width="80%"><input type="password" class="form-control" name="old_password" maxlength="18" autocomplete="off" /></td>
                        </tr>
                        <tr>
                            <td wdith="20%">新密码:</td>
                            <td width="80%"><input type="password" class="form-control" name="password" maxlength="18" autocomplete="off" /></td>
                        </tr>
                        <tr>
                            <td wdith="20%">确认密码:</td>
                            <td width="80%"><input type="password" class="form-control" name="new_password" maxlength="18" autocomplete="off" /></td>
                        </tr>
                        </tbody>
                        <tfoot>
                        <tr></tr>
                        </tfoot>
                    </table>
                </div>
                <div class="modal-footer">
                    <input type="hidden" name="userid" value="" />
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    <button type="submit" class="btn btn-primary">提交</button>
                </div>
            </div>
        </form>
    </div>
</div>--%>
<script src="js/bootstrap.min.js"></script>
<script src="js/admin-scripts.js"></script>
<script>
    $(function () {
        $("#main table tbody tr td a").click(function () {
            var name = $(this);
            var id = name.attr("rel"); //对应id
            if (name.attr("name") === "see") {
                $.ajax({
                    type: "POST",
                    url: "/User/see",
                    data: "id=" + id,
                    cache: false, //不缓存此页面
                    success: function (data) {
                        var data = JSON.parse(data);
                        $('#truename').val(data.truename);
                        $('#username').val(data.username);
                        $('#usertel').val(data.usertel);
                        $('#userid').val(data.userid);
                        $('#seeUser').modal('show');
                    }
                });
            } else if (name.attr("name") === "delete") {
                if (window.confirm("此操作不可逆，是否确认？")) {
                    $.ajax({
                        type: "POST",
                        url: "/User/delete",
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

