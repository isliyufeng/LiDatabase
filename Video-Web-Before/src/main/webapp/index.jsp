<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta name="viewport" content="initial-scale=1, maximum-scale=1, user-scalable=no">
    <meta charset="utf-8">
    <meta name="renderer" content="webkit">
    <meta name="keywords" content="Web前端视频教程,大数据视频教程,HTML5视频教程,UI视频教程,PHP视频教程,java视频教程,python基础教程">
    <meta name="description" content="Y先生教育在线课程视频,为您提供java,python,HTML5,UI,PHP,大数据等学科经典视频教程在线浏览学习,精细化知识点解析,深入浅出,想学不会都难,Y先生教育,学习成就梦想！">
    <meta name="author" content="">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/base.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/css.css">
    <link rel="icon" href="favicon.png" type="image/png" />
    <title>在线公开课-Y先生教育|java|大数据|HTML5|python|UI|PHP视频教程</title>
    <script src="${pageContext.request.contextPath}/js/jquery-1.12.4.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/gVerify.js"></script>
    <script type="text/javascript">
    
       $(function(){
          
          //div 两个哪个显示呢？
          if(null!="${sessionScope.userAccount}" && "${sessionScope.userAccount}" !=""){
               $("#regBlock").css("display","none");
	           $("#userBlock").css("display","block");
          }else{
               $("#regBlock").css("display","block");
	           $("#userBlock").css("display","none");
          }
          
       });
    </script>
</head>

<body class="w100">
    <header>
        <div class="container">
            <span>欢迎来到Y先生教育！</span>
            
            
	            <div id="regBlock" style="display:none;float:right">
	               <a href="javascript:;" id="reg_open"><img src="${pageContext.request.contextPath}/img/we.png">注册</a>
	               <a href="javascript:;" id="login_open"><img src="${pageContext.request.contextPath}/img/we.png">登录</a>
	            </div>
            
	            <div id="userBlock" style="display:none;float:right">

	               <a href="${pageContext.request.contextPath}/user/loginOut" id="loginout">退出</a>
	               <a href="${pageContext.request.contextPath}/user/showMyProfile" id="account">${sessionScope.userAccount}</a>
	            </div>
           
            <a onclick="JavaScript:addFavorite2()"><img src="${pageContext.request.contextPath}/img/sc.png" draggable="false">加入收藏</a>
            <a onclick="pyRegisterCvt()" target="_blank" href="http://wpa.qq.com/msgrd?v=3&uin=2580094677&site=qq&menu=yes"><img src="${pageContext.request.contextPath}/img/we.png" draggable="false">联系我们</a>
            <a class="color_e4"><img src="${pageContext.request.contextPath}/img/phone.png" draggable="false"> 0375-208-9092&#x3000;&#x3000;0375-208-9051</a>

        </div>
    </header>
    <nav class="w100">
        <div class="container">
            <img src="${pageContext.request.contextPath}/img/logo.png" alt="Y先生教育的logo" onclick="location.href='${pageContext.request.contextPath}/index.jsp'" draggable="false">
            <ul class="text_13 f_right">
                <li>
                    <a href="#" target="_blank">首页</a>
                </li>
                <li class="nav_down">
                    高端课程<img src="${pageContext.request.contextPath}/img/nav_down.png" alt="" draggable="false">
                    <ul id="nav_down" class="t_center">
                        <li>
                            <a target="_blank" href="${pageContext.request.contextPath}/course/beforeList?subjectId=2">Java</a>
                        </li>
                        <li>
                            <a target="_blank" href="${pageContext.request.contextPath}/course/beforeList?subjectId=7">VR</a>
                        </li>
                        <li>
                            <a target="_blank" href="${pageContext.request.contextPath}/course/beforeList?subjectId=1">HTML5</a>
                        </li>
                        <li>
                            <a target="_blank" href="${pageContext.request.contextPath}/course/beforeList?subjectId=5">大数据</a>
                        </li>
                        <li>
                            <a target="_blank" href="${pageContext.request.contextPath}/course/beforeList?subjectId=3">Android</a>
                        </li>
                        <li>
                            <a target="_blank" href="${pageContext.request.contextPath}/course/beforeList?subjectId=6">APP UI</a>
                        </li>
                        <li>
                            <a target="_blank" href="${pageContext.request.contextPath}/course/beforeList?subjectId=11">PHP</a>
                        </li>
                        <li>
                            <a target="_blank" href="${pageContext.request.contextPath}/course/beforeList?subjectId=10">Python</a>
                        </li>
                        <li>
                            <a target="_blank" href="${pageContext.request.contextPath}/course/beforeList?subjectId=4">iOS</a>
                        </li>
                    </ul>
                </li>
                <li id="gkk" class="nav_choose">
                    <a href="#">在线公开课</a>
                </li>
                <li>
                    <a href="#">专家师资</a>
                </li>
                
                <li><a href="#" >Y先生新闻</a></li>
                <li class="nav_last">
                    <a href="#" >关于Y先生</a>
                </li>
            </ul>
        </div>
    </nav>

    <!--banner图-->
    <div class="banner index-banner"></div>

    <!--模块化课程-->
    <div class="course">
        <div class="container">
            <p class="title">模块化课程，从入门到精通，大神并不遥远</p>
            <div class="course-info">
                <table cellspacing="10">
                    <tr>
                        <td colspan="2">
                            <a href="${pageContext.request.contextPath}/course/beforeList?subjectId=1">
                                <img src="${pageContext.request.contextPath}/img/html5.jpg" alt="" class="image scale" draggable="false">
                                <div class="headline">
                                    <span>Web前端教程</span>
                                    <img src="${pageContext.request.contextPath}/img/arrow.png" alt="">
                                </div>
                            </a>
                        </td>
                        <td>
                            <!--上线时修改id-->
                            <a href="${pageContext.request.contextPath}/course/beforeList?subjectId=6">
                                <img src="${pageContext.request.contextPath}/img/ui.jpg" alt="" class="image scale" draggable="false">
                                <div class="headline">
                                    <span>UI设计教程</span>
                                    <img src="${pageContext.request.contextPath}/img/arrow.png" alt="">
                                </div>
                            </a>
                        </td>
                        <td rowspan="2" class="one_three">
                            <a href="#" class="opacity5">
                                <img src="${pageContext.request.contextPath}/img/java.jpg" alt="" class="image" draggable="false">
                                <div class="headline">
                                    <span>Java教程</span>
                                    <img src="${pageContext.request.contextPath}/img/arrow.png" alt="">
                                </div>
                            </a>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <a href="#" class="opacity5">
                                <img src="${pageContext.request.contextPath}/img/bigdata.jpg" alt="" class="image" draggable="false">
                                <div class="headline">
                                    <span>大数据教程</span>
                                    <img src="${pageContext.request.contextPath}/img/arrow.png" alt="">
                                </div>
                            </a>
                        </td>
                        <td colspan="2">
                            <a href="${pageContext.request.contextPath}/course/beforeList?subjectId=10">
                                <img src="${pageContext.request.contextPath}/img/python.jpg" alt="" class="image scale" draggable="false">
                                <div class="headline">
                                    <span>Python教程</span>
                                    <img src="${pageContext.request.contextPath}/img/arrow.png" alt="">
                                </div>
                            </a>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <a href="${pageContext.request.contextPath}/course/beforeList?subjectId=11">
                                <img src="${pageContext.request.contextPath}/img/php.jpg" alt="" class="image scale" draggable="false">
                                <div class="headline">
                                    <span>PHP教程</span>
                                    <img src="${pageContext.request.contextPath}/img/arrow.png" alt="">
                                </div>
                            </a>
                        </td>
                        <td colspan="2" class="three_two">
                            <img src="${pageContext.request.contextPath}/img/qidai.jpg" alt="" class="image" draggable="false">
                            <div class="headline">
                                更多课程，敬请期待...
                            </div>
                        </td>
                    </tr>
                </table>
                <!--马上试听-->
                <a onclick="pyRegisterCvt()" target="_blank" href="http://wpa.qq.com/msgrd?v=3&uin=2580094677&site=qq&menu=yes">
                    <div class="audition">高级课程</div>
                </a>
            </div>
        </div>
    </div>


    <!--报名表单-->
    <div class="form_area">
        <div class="container">
            <p class="title"><b>这个世界上可以选择的很多，可以改变命运的选择很少<br />你现在准备好向梦想出发了吗？</b></p>
            <form id="iform" action="#" method="post">
                <div class="form_line1"></div>
                <div class="form_line2"></div>
                <div class="wrap">
                    <input type="hidden" name="action" value="post" />
                    <input type="hidden" name="diyid" value="3" />
                    <input type="hidden" name="do" value="2" />
                    <input type="hidden" name="ip" value="" />
                    <input type="hidden" name="time" value="" />
                    <div><label for="name">姓名：</label><input name="name" id="name" type="text" class="form-control" /></div>
                    <div><label for="tel">手机号：</label><input name="tel" id="tel" type="text" class="form-control" /></div>
                    <div><label for="qq">QQ：</label><input name="qq" id="qq" type="text" class="form-control" /></div>
                </div>
                <input class="button" type="submit" value="立即报名" />
            </form>
        </div>
    </div>
    <!--页脚-->
    <footer>
        <ul>
            <li>
                <img src="${pageContext.request.contextPath}/img/footer_logo.png" alt="" draggable="false">
            </li>
            <li class="mt25">
                <h3>校区地址</h3>
                <ul>
                    <li>地址<br>河南省平顶山市龙翔大道河南Y先生学院</li>
                    
                </ul>
            </li>
            <li class="mt25">
                <h3>联系我们</h3>
                <ul id="foo_icon">
                    <li>河南省平顶山市龙翔大道河南Y先生学院</li>
                    <li>e-mail:zy@chengjian100.com</li>
                    <li>电话:0395-208-9051 0375-208-9092</li>
                    <li class="erwei">
                        <br>
                        <div>
                            <img class="weixin" src="${pageContext.request.contextPath}/img/微信公众号.png" alt="" draggable="false">
                            <img class="weibo" src="${pageContext.request.contextPath}/img/微博公众号.png" alt="" draggable="false">
                        </div>
                    </li>
                </ul>
            </li>
        </ul>
        <div class="record">Y先生教育 &copy; 豫ICP备13013243号;河南Y先生学院</div>
    </footer>

    <!--登录注册弹出框-->
    <div class="mask hidden" id="login">
        <div class="mask_content">
            <div class="mask_content_header">
                <img src="${pageContext.request.contextPath}/img/logo.png" alt="" class="ma">
            </div>
            <div class="mask_content_body">
                <form id="loginForm" action="#">
                    <h3>快速登录</h3>
                    <input type="email" id="loginEmail" placeholder="请输入邮箱" name="email">
                    <input type="password" id="loginPassword" placeholder="请输入密码" name="password">
                    <div id="forget">
                        <a href="${pageContext.request.contextPath}/user/forgetPassword">忘记密码？</a>
                    </div>
                    <input type="submit" onclick="return commitLogin()" value="登&#x3000;录">
                </form>
            </div>
            <div class="mask_content_footer">
                <span id="login_close">关&#x3000;闭</span>
            </div>
        </div>
    </div>
    <div class="mask hidden" id="reg">
        <div class="mask_content">
            <div class="mask_content_header">
                <img src="${pageContext.request.contextPath}/img/logo.png" alt="" class="ma">
            </div>
            <div class="mask_content_body">
                <form id="regForm" action="user/insertUser">
                    <h3>新用户注册</h3>
                    <input type="email" id="regEmail" placeholder="请输入邮箱" name="email"><span id="emailMsg"></span>
                    <input type="password" id="regPsw" placeholder="请输入密码" name="password">
                    <input type="password" id="regPswAgain" placeholder="请再次输入密码" name="psw_again"><span id="passMsg"></span>
                    <div id="yzm" class="form-inline">
                        <input type="text" name="yzm" style="width: 45%; display: inline-block;">
                        <div id="v_container" style="width: 45%;height: 40px;float:right;"></div>
                    </div>
                    <input type="submit" onclick="return commitRegForm();" value="注&#x3000;册">
                </form>
            </div>
            <div class="mask_content_footer">
                <span id="reg_close">关&#x3000;闭</span>
            </div>
        </div>
    </div>

    
    
</body>

<script>

    // 导航栏
    $('nav').children('div').children('ul').children('li').mouseenter(function () {
        $('nav').children('div').children('ul').children('li').removeClass('nav_choose');
        $(this).addClass('nav_choose');
    });
    $('nav').mouseleave(function () {
        $('nav').children('div').children('ul').children('li').removeClass('nav_choose');
        $('#gkk').addClass('nav_choose');
    });

    // 导航栏下拉菜单
    $('nav .nav_down').mouseenter(function () {
        $('#nav_down').stop().slideDown();
        $(this).children('img').attr('src', 'http://localhost:8080/Videos/img/nav_down2.png');
    });
    $('nav .nav_down').mouseleave(function () {
        $('#nav_down').stop().slideUp();
        $(this).children('img').attr('src', 'http://localhost:8080/Videos/img/nav_down.png');
    });

    $(window).scroll(function () {
        if ($(this).scrollTop() > 300) {
            $('#top').fadeIn();
            $('body').css('paddingTop', '90px');
            $('nav').css({
                'position': 'fixed',
                'top': '0',
                'left': '0',
                'border-bottom': '1px solid #e6e6e6'
            });
        }
        else {
            $('body').css('paddingTop', '0');
            $('nav').css({
                'position': 'initial',
                'top': '0',
                'left': '0',
                'border-bottom': 'none'
            });
        }
    });
    // 登录注册显示和消失弹出框
    $('#reg_open').click(function () {
        $('#reg').removeClass('hidden');
    });
    $('#login_open').click(function () {
        $('#login').removeClass('hidden');
    });
    $('#reg_close').click(function(){
        $('#reg').addClass('hidden');
    });
    $('#login_close').click(function(){
        $('#login').addClass('hidden');
    });


    // 报名
    $("#iform .button").click(function (ev) {
        ev.preventDefault();

        var input1 = $('.form-control:eq(0)').val();
        var input2 = $('.form-control:eq(1)').val();
        var input3 = $('.form-control:eq(2)').val();
        var reg2 = /^1[3578]\d{9}$/;
        var reg3 = /^[1-9]\d{4,10}$/;

        if (input1 == "") {
            alert("姓名不能为空");
        } else if (!reg2.test(input2)) {
            alert("手机格式不符！！请重新填写！");
        } else if (!reg3.test(input3)) {
            alert("QQ格式不符！！请重新填写！");
        } else {
            $("#iform").submit();
        }

    });


    // 获取url路径中的参数
    function GetUrlParam(paraName) {
        var url = document.location.toString();
        var arrObj = url.split("?");

        if (arrObj.length > 1) {
            var arrPara = arrObj[1].split("&");
            var arr;
            for (var i = 0; i < arrPara.length; i++) {
                arr = arrPara[i].split("=");

                if (arr != null && arr[0] == paraName) {
                    return arr[1];
                }
            }
            return "";
        }
        else {
            return "";
        }
    }




    //==========================Java02班升级JS===============================

    $("#regEmail").blur(function(){
        //不为空再校验
        var emailVal=$("#regEmail").val();
        var reg = /^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\.[a-zA-Z0-9-]+)*\.[a-zA-Z0-9]{2,6}$/;
        if (reg.test(emailVal)) {
            //alert(emailVal);
            // js 判断不相等  不能使用   !""==xxxx
            if(null != emailVal && ""!=emailVal){
                var params={"email":emailVal};
                // alert(params);
                $.post("${pageContext.request.contextPath}/user/validateEmail",params,function(data){
                    if(data=="success"){
                        regIsCommitEmail=true;
                        $("#emailMsg").text("该邮箱可用").css("color","green");
                    }else{
                        regIsCommitEmail=false;
                        $("#emailMsg").text("该邮箱已注册，请直接登录").css("color","red");
                    }
                });
            }
            regIsCommitEmail = true;
            $("#emailMsg").text("该邮箱可用").css("color", "green");

        } else {
            regIsCommitEmail=false;
            $("#emailMsg").text("请输入正确的邮箱").css("color","red");
        }



    });

    $("#regPswAgain").blur(function(){
        var pass01= $("#regPsw").val();
        var pass02= $("#regPswAgain").val();
        if(null==pass01 || ""==pass01 || null==pass02 || ""==pass02){
            $("#passMsg").text("密码不能为空").css("color","red");
            regIsCommitPsw =false;
        }else{
            if(pass01!=pass02){
                regIsCommitPsw=false;
                $("#passMsg").text("两次密码输入不一致，请重新输入").css("color","red");
            }else{
                regIsCommitPsw=true;
                $("#passMsg").text("");
            }
        }
    });

    $("#loginout").click(function(){
        $.get("user/loginOut",null,function(){
            $("#regBlock").css("display","block");
            $("#userBlock").css("display","none");
        });

    });

    var regIsCommitEmail=false;
    var regIsCommitPsw=false;
    var verifyCode;
    function commitRegForm(){
        var code =$("input[name='yzm']").val();
        //alert(code);
        //alert(regIsCommitEmail+","+regIsCommitPsw);
        if(regIsCommitEmail && regIsCommitPsw && verifyCode.validate(code)){
            //用js提交表单
            // $("#regForm").commit();
            $.ajax({
                url:"${pageContext.request.contextPath}/user/insertUser",
                data:$("#regForm").serialize(),
                type:"POST",
                success:function(data){
                    if(data=='success'){
                        //注册框消失
                        $("#reg").addClass("hidden");
                        $("#account").text($("#regEmail").val());
                        //将注册的user信息展示
                        $("#regBlock").css("display","none");
                        $("#userBlock").css("display","block");
                    }
                },
                error:function(){
                    alert("联系管理员");
                }
            });

            return false;

        }else{
            return false;
        }

    }

    verifyCode = new GVerify("v_container");

    function commitLogin(){
        var email =$("#loginEmail").val();
        var password =$("#loginPassword").val();
        if(null!=email && email!="" && null!=password && password!=""){
            var params=$("#loginForm").serialize();
            // alert(params);
            // post要小写
            $.post("${pageContext.request.contextPath}/user/loginUser",params,function(data){
                // alert(data);
                if(data=='success'){
                    //登录框消失
                    $("#login").addClass("hidden");

                    $("#account").text($("#loginEmail").val());
                    //将注册的user信息展示
                    $("#regBlock").css("display","none");
                    $("#userBlock").css("display","block");

                    $("#isLogin").val(1);
                }
            });

            return false;
        }

        return false;
    }


</script>
</html>
