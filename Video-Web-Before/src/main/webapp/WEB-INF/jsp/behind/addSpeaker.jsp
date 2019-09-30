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

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->

    <!-- 如果IE版本小于9，加载以下js,解决低版本兼容问题 -->
    <!--[if lt IE 9]>
    <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->


    <!--
    	引入网络的jquery  ,如果想换成自己的，导入即可
    	网站优化：建议将你网站的css\js等代码，放置在互联网公共平台上维护，比如：七牛
    -->
    <script src="${pageContext.request.contextPath}/js/jquery-1.12.4.min.js"></script>

    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    <script src="${pageContext.request.contextPath}/js/ajaxfileupload.js"></script>

    <style type="text/css">
        th {
            text-align: center;
        }
    </style>
    <script type="text/javascript">
        function showName(obj, job, type) {
            var c = $(obj).text();
            if (type == 1) {
                // 将获取的值显示在输入框内
                $("#speakerJob").val(c);
                $("#speakerJob1").val(c);
            } else {
                // 将获取的值显示在输入框内
                $("#speakerJob").val(c);
                $("#speakerJob1").val(c);
            }
        }

        //页面加载完毕之后就执行以下代码片段


        $(function () {
            if (${not empty speaker.headImgUrl}) {
                var headImgUrl = '${speaker.headImgUrl}';
                $("#photo").html("<img  width='100px' height='100px' src='" + headImgUrl + "'/>");
                $("#headImgUrl").val(headImgUrl);
            }
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

        // 上传图片
        function fileUpload() {
            $.ajaxFileUpload({
                url: "${pageContext.request.contextPath}/video/upload", //需要链接到服务器地址
                secureuri: false, //是否启用安全提交，默认为false。
                fileElementId: "uploadImgInput", //上传文件选择框的id属性
                dataType: 'text', //json，与后台对应，text和json
                success: function (data) { //后台ajax返回的数据 此处Imgurl
                    $("#photo")
                        .html(
                            "<img  width='100px' height='100px' src='" + data + "'/>");
                    $("#headImgUrl").val(data);
                },
                error: function (XMLHttpRequest, textStatus,
                                 errorThrown) {
                    alert('上传失败！');
                }
            });
        }

        // 添加或修改
        function commitForm() {
            $.post("${pageContext.request.contextPath}/speaker/saveOrUpdate",
                $("#formSaveAndUpdate").serialize(),
                function (data) {
                    if (data == 'success') {
                        location.href = "${pageContext.request.contextPath}/speaker/list";
                    }
                }
            );
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
                <li class="active"><a href="${pageContext.request.contextPath}/speaker/list">主讲人管理</a></li>
                <li><a href="${pageContext.request.contextPath}/course/list">课程管理</a></li>


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

        <%-- <c:if test="empty ${video.id}"> --%>
        <c:if test="${empty speaker.id}">
            <h2>添加讲师信息</h2>
        </c:if>

        <c:if test="${not empty speaker.id}">
            <h2>修改讲师信息</h2>
        </c:if>

    </div>
</div>


<div class="container" style="margin-top: 20px;">

    <form class="form-horizontal" id="formSaveAndUpdate">
        <c:if test="${not empty speaker.id}">
            <input type="hidden" name="id" id="id" value="${speaker.id}">
        </c:if>

        <div class="form-group">
            <label class="col-sm-2 control-label">讲师名字</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="speakerName" value="${speaker.speakerName}"
                       placeholder="讲师名字">
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-2 control-label">讲师职位</label>
            <div class="col-sm-10">
                <div class="input-group">
                    <div class="input-group-btn">
                        <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown"
                                aria-haspopup="true" aria-expanded="false">下拉菜单<span class="caret"></span></button>
                        <ul id="selectSpeaker" class="dropdown-menu">
                            <li value="讲师">
                                <a href="#" onclick="showName(this,'讲师',1)">讲师</a>
                            </li>
                            <li value="高级讲师">
                                <a href="#" onclick="showName(this,'高级讲师',1)">高级讲师</a>
                            </li>
                            <li value="副教授">
                                <a href="#" onclick="showName(this,'副教授',1)">副教授</a>
                            </li>
                            <li value="教授">
                                <a href="#" onclick="showName(this,'教授',1)">教授</a>
                            </li>
                        </ul>
                    </div><!-- /btn-group -->
                    <input type="hidden" class="form-control" id="speakerJob"  name="speakerJob"  value="${speaker.speakerJob}" aria-label="...">
                    <input type="text" class="form-control" id="speakerJob1" disabled name="speakerJob1"  value="${speaker.speakerJob}" aria-label="...">
                </div><!-- /input-group -->
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-2 control-label">讲师简介</label>
            <div class="col-sm-10">
                <textarea class="form-control" name="speakerDesc" rows="3">${speaker.speakerDesc}</textarea>
            </div>
        </div>

        <div class="form-group">
            <label for="uploadForm" class="col-sm-2 control-label">照片</label>
            <div class="col-sm-10">
                <form id="uploadForm" enctype="multipart/form-data" method="post">
                    <input type="file" name="headImg" id="uploadImgInput" onchange="fileUpload()"/>
                </form>
                <div id="photo"></div>
                <input type="hidden" id="headImgUrl" name="headImgUrl" class="form-control"
                       value="${speaker.headImgUrl}">
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default" onclick="commitForm()">保存</button>
            </div>
        </div>
    </form>

</div>

</body>
</html>