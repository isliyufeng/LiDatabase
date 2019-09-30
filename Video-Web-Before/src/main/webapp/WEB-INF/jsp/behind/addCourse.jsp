<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">

    <!--表示使用IE最新的渲染模式进行解析-->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!--
    	兼容一些移动设备，会根据屏幕的大小缩放
    	width=device-width  表示宽度是设备的宽度（很多手机的宽度都是980px）
    	initial-scale=1  初始化缩放级别   1-5
    	minimum-scale=1  maximum-scale=5
    	user-scalable=no  禁止缩放
    -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>添加或修改视频</title>

    <!-- Bootstrap -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

    <script src="${pageContext.request.contextPath}/js/jquery-1.12.4.min.js"></script>

    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    <script src="${pageContext.request.contextPath}/js/ajaxfileupload.js"></script>

    <style type="text/css">
        th {
            text-align: center;
        }
    </style>
    <script type="text/javascript">
        function showName(obj, id) {
            var c = $(obj).text();
            // 将获取的值显示在输入框内
            $("#subjectName").val(c);
            // 将给隐藏的文本赋值
            $("#subjectId").val(id);
        }

        //页面加载完毕之后就执行以下代码片段
        $(function () {
            $("#id").val(${course.id});
        });


        function validateInput(obj) {
            var value = $(obj).val();
            if (!/^\d+$/.test(value)) {
                alert("必须输入数字！！");
            }
        }

        function validateInput2(obj) {
            var value = $(obj).val();
            if (!(/^http:\/\/[a-z]+\.[a-z0-9]+\.[a-z]{2,}$/.test(value))) {
                alert("该输入不是一个网址，例如：http://www.alibaba.com");
            }
        }


        // 添加或修改
        function commitForm() {
            $.post("${pageContext.request.contextPath}/course/saveOrUpdate",
                $("#formSaveAndUpdate").serialize(),
                function (data) {
                    if (data == 'success') {
                        location.href = "${pageContext.request.contextPath}/course/list";
                    } else {
                        alert(data + "1");
                    }
                }
            );
            return false;
        }
    </script>

</head>
<body>


<nav class="navbar-inverse">
    <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">

            <a class="navbar-brand" href="${pageContext.request.contextPath}/video/list">视频管理系统</a>
        </div>

        <div class="collapse navbar-collapse"
             id="bs-example-navbar-collapse-9">
            <ul class="nav navbar-nav">
                <li><a href="${pageContext.request.contextPath}/video/list">视频管理</a></li>
                <li><a href="${pageContext.request.contextPath}/speaker/list">主讲人管理</a></li>
                <li class="active"><a href="${pageContext.request.contextPath}/course/list">课程管理</a></li>


            </ul>
            <p class="navbar-text navbar-right">
                <span>${sessionScope.userName}</span>
                <i class="glyphicon glyphicon-log-in" aria-hidden="true"></i>&nbsp;&nbsp;
                <a href="${pageContext.request.contextPath}/admin/exit" class="navbar-link">退出</a>
            </p>
        </div>
        <!-- /.navbar-collapse -->


    </div>
    <!-- /.container-fluid -->
</nav>

<div class="jumbotron" style="padding-top: 15px;padding-bottom: 15px;">
    <div class="container">
        <c:if test="${empty course.id}">
            <h2>添加课程信息</h2>
        </c:if>

        <c:if test="${not empty course.id}">
            <h2>修改课程信息</h2>
        </c:if>

    </div>
</div>

<div class="container" style="margin-top: 20px;">
    <form class="form-horizontal" id="formSaveAndUpdate">
        <c:if test="${not empty course.id}">
            <input type="hidden" name="id" id="id" value="${course.id}">
        </c:if>

        <div class="form-group">
            <label class="col-sm-2 control-label">课程名称</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="courseTitle" value="${course.courseTitle}"
                       placeholder="课程名称">
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-2 control-label">课程简介</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="courseDesc" value="${course.courseDesc}"
                       placeholder="课程简介">
            </div>
        </div>

        <div class="form-group">
            <label for="inputEmail3" class="col-sm-2 control-label">专业方向</label>
            <div class="col-sm-10">
                <div class="input-group">
                    <div class="input-group-btn">
                        <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" id="but"
                                aria-haspopup="true" aria-expanded="false">下拉菜单<span class="caret"></span>
                        </button>
                        <ul id="selectCourse" class="dropdown-menu">
                            <c:forEach items="${subjects}" var="subject">
                                <li value="${subject.id}">
                                    <a href="#" onclick="showName(this,${subject.id})">${subject.subjectName}</a>
                                </li>
                            </c:forEach>
                        </ul>
                    </div><!-- /btn-group -->
                    <input type="hidden"  id="subjectId" name="subjectId">
                    <input type="text" class="form-control" disabled id="subjectName" name="subjectName" aria-label="...">
                </div><!-- /input-group -->
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default" onclick="return commitForm()">保存</button>
            </div>
        </div>
    </form>

</div>


</body>
</html>