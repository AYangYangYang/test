<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<meta charset="UTF-8">
		<title>爱购登录页面</title>
		<link rel="icon" type="image/x-icon" href="img/title-icon.jpg"/>
		<link rel="stylesheet" href="css/reset.css" />
		<link rel="stylesheet" href="css/footer.css" />
		<link rel="stylesheet" href="css/login.css" />
	</head>
	<body>
		<!--登录/注册的头部-->
		<div class="lr-top w1230">
			<a href="index.jsp"><img src="img/logo.png" width="150px" height="60px"/></a>
			<div class="top-link">
				<a href="#"class="top-link1"></a>
				<a href="#" class="top-link2"></a>
				<a href="#" class="top-link3"></a>
			</div>
		</div>
		<!--登录/注册的中部-->
		<div class="lr-main">
			<div class="w1230">
				<div class="reg-div">
					<h3 class="login-title">登录爱购</h3>
					<p class="go-reg">还没有爱购账号？<a href="register.html">在此注册</a></p>
					<form action="/check.do" method="post" onsubmit="return check()">
						<p id="check"></p>
						<p><span class="icon-account"></span><input type="text" id="username" name="username" placeholder="请输入已注册的账号"/></p>
						<p><span class="icon-pwd"></span><input type="password" id="password" name="password" placeholder="请输入密码"/></p>
						<p class="clear-float"><input type="text" placeholder="验证码" class="code"/><img src="img/code.jpg" width="110px" height="42px" class="code-img"/></p>
						<p><input type="checkbox" class="chk-login"/><span>7天免登录</span></p>
						<input type="submit" value="登录" class="sum-btn" onsubmit="check()"/>
					</form>
				</div>
			</div>	
		</div>
		<!--登录/注册的底部-->
		<div class="lr-footer footer">
			<p class="w1230">
				<a href="#">关于爱购</a>
				<a href="#">合作伙伴</a>
				<a href="#">营销中心</a>
				<a href="#">廉正举报</a>
				<a href="#">联系客服</a>
				<a href="#">开发平台</a>
				<a href="#">诚征英才</a>
				<a href="#">联系我们</a>
				<a href="#">网站地图</a>
				<a href="#">知识产权</a><span>|</span>
				<span>&copy;2018-2020 igo.com 版权所有</span>
			</p>
		</div>
		<script src="js/jquery.js"></script>
<%--		<script>--%>
<%--				// $.post("/check.do"),--%>
<%--				// 		{"username":$("#username").test(),"password":$("#password").test()},--%>
<%--				// 		function (data) {--%>
<%--				// 			//data是后台返回的值--%>
<%--				// 			if (data=="true"){--%>
<%--				// 				$("#check").css("color","red").text("账号密码错误")--%>
<%--				// 				alert("账号密码错误，请重新输入")--%>
<%--				// 			}else {--%>
<%--				// 				$("#check").text("账号密码正确")--%>
<%--				// 				alert("账号密码正确")--%>
<%--				// 			}--%>
<%--				//--%>
<%--				// 		}--%>
<%--			//选择器 给username文本框添加失去焦点的事件--%>
<%--		</script>--%>
		<script>
			function check() {
				var name=document.getElementById("username").value;
				var password=document.getElementById("password").value;
				if(name==""){
					alert("账号不能为空")
					return false;

				}else if (/^\w$/.test(name))
				{
					alert("账号格式不正确")
					return false;
				}
				if(password==""){
					alert("密码不能为空")
					return false;

				}else if(/^{0-9a-zA-Z}+$/.test(password)){
					alert("密码格式不正确")
					return false;

				}

			}
		</script>
	</body>
</html>

<script>

	//取出传回来的参数error并与yes比较
	var errori ='<%=request.getParameter("error")%>';
	if(errori=='yes'){
		alert("登录失败!请重新登录");
	}
</script>
