<%--
  Created by IntelliJ IDEA.
  User: ASUS111LAN
  Date: 2020/12/29
  Time: 11:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>注册</title>
    <script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.5.1/jquery.js"></script>
    <link rel="stylesheet" type="text/css" href="css/register.css"/>
</head>
<body>
<!--头部-->
<div id="reg_header">
    <div class="reg_h_center">
        <div class="reg_h_left">
            <!-- <img src="images/logo.png" alt="">-->
            <h1 >欢迎注册</h1>
        </div>
    </div>
</div>


<!--表单内容-->
<div class="reg_back">
    <div class="reg_left">
        <p>新用户注册</p>
        <p>USER REGISTER</p>
    </div>
    <div class="reg_center">
        <div class="reg_form">
            <form action="/pms/RegisterServlet" method="post">
                <table>
                    <tr>
                        <td class="td_left"><label for="username">用户名</label></td>
                        <td class="td_right"><input type="text" name="username" placeholder="请输入用户名"
                                                    id="username"> <span id="user_ajax"></span></td>
                        <script >
                            $(function () {
                                $("#username").blur(function(){
                                    var username = $("#username").val();
                                    $.get("/pms/AjaxRegisterServlet",{user_name:name},function (result) {
                                        alert(result);
                                        $("user_ajax").html(result);
                                    },"json");
                                })
                            })
                        </script>
                    </tr>
                    <tr>
                        <td class="td_left"><label for="password">密码</label></td>
                        <td class="td_right"><input type="password" name="password" placeholder="请输入密码"
                                                    id="password"></td>
                    </tr>
                    <tr>
                        <td class="td_left"><label for="Email">Email</label></td>
                        <td class="td_right"><input type="email" name="email" placeholder="请输入Email" id="Email">
                        </td>
                    </tr>
                    <tr>
                        <td class="td_left"><label for="rename">姓名</label></td>
                        <td class="td_right"><input type="text" name="rename" placeholder="请输入真实姓名" id="rename">
                        </td>
                    </tr>
                    <tr>
                        <td class="td_left"><label for="Telphone">手机号</label></td>
                        <td class="td_right"><input type="text" name="telphone" placeholder="请输入您的手机号"
                                                    id="Telphone"></td>
                    </tr>
                    <tr>
                        <td class="td_left"><label>性别</label></td>
                        <td class="td_right"><input type="radio" name="gender" value="male" checked> 男
                            <input type="radio" name="gender" value="female"> 女
                        </td>
                    </tr>
                    <tr>
                        <td class="td_left"><label for="Birthday">出生日期</label></td>
                        <td class="td_right"><input type="date" name="birthday" id="Birthday"></td>
                    </tr>
                    <!-- <tr>
                            <td class="td_left"><label for="checkcode">验证码</label></td>
                            <td class="td_right"><input type="text" name="checkcode" id="checkcode">
                                <img src="images/商城素材/check_code.png" id="img_check"></td>

                        </tr>-->
                    <tr>
                        <td colspan="2" align="center"><input type="submit" value="注册" class="reg_btn" id="btn_sub"></td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
    <div class="reg_right">
        <p>已有账号?<a href="Login.html">立即登录</a></p>
    </div>
</div>
</body>
</html>
