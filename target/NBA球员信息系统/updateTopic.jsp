<%--
  Created by IntelliJ IDEA.
  User: ASUS111LAN
  Date: 2021/1/2
  Time: 19:26
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
    <head>
        <!-- 指定字符集 -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>修改话题</title>
        <script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.5.1/jquery.js"></script>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <script src="js/jquery-2.1.0.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </head>
 <body>
    <div class="container" style="width: 400px;">
     <h3 style="text-align: center;">修改话题信息</h3>
     <form action="/pms/UpdateTopicServlet" method="post">
         <div class="form-group">
             <label for="name">标题：</label>
             <input type="text" class="form-control" id="name" name="topic_name"  readonly="readonly" value="${sessionScope.topic.TOPIC_NAME}" />
         </div>

         <div class="form-group">
             <label>内容：</label>
             <textarea name="topic_message" id="com_text" style="width:400px;height: 400px;resize: none" rows="60" cols="100" >${sessionScope.topic.TOPIC_MESSAGE}</textarea>
         </div>

         <c:choose  >
             <c:when test="${sessionScope.topic.IS_TOP==1}">
                 <div class="form-group">
                     <label>是否置顶：</label>
                     <input type="radio" name="istop" value="0"  />否
                     <input type="radio" name="istop" value="1"  checked/>是
                 </div>

             </c:when>
             <c:otherwise>
                 <div class="form-group">
                     <label>是否置顶：</label>
                     <input type="radio" name="istop" value="0" checked/>否
                     <input type="radio" name="istop" value="1"  />是
                 </div>
             </c:otherwise>
         </c:choose>

         <c:choose  >

             <c:when test="${sessionScope.topic.IS_BRIGHT==1}">
                 <div class="form-group">
                     <label>是否高亮：</label>
                     <input type="radio" name="isbright" value="0"  />否
                     <input type="radio" name="isbright" value="1"  checked/>是
                 </div>
             </c:when>

             <c:otherwise>
                 <div class="form-group">
                     <label>是否高亮：</label>
                     <input type="radio" name="isbright" value="0" checked />否
                     <input type="radio" name="isbright" value="1"  />是
                 </div>

             </c:otherwise>
         </c:choose>
         <div class="form-group" style="text-align: center">
             <input class="btn btn-primary" type="submit" value="修改" />
             <input class="btn btn-default" type="button" value="返回"/>
         </div>
     </form>
 </div>
 </body>


</html>