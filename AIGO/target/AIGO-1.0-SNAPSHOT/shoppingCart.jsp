<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<meta charset="UTF-8">
		<title>爱购购物车</title>
		<link rel="icon" type="image/x-icon" href="img/title-icon.jpg"/>
		<link rel="stylesheet" href="css/reset.css" />
		<link rel="stylesheet" href="css/top.css" />
		<link rel="stylesheet" href="css/shoppingCart.css" />
		<link rel="stylesheet" href="css/footer.css" />
		<link rel="stylesheet" href="css/font-awesome-4.7.0/Font-Awesome-master/css/font-awesome.min.css" />
		<script type="text/javascript" src="js/jquery.js" ></script>
		<script type="text/javascript" src="js/shoppingCart.js" ></script>
	</head>
	<body>
		<!--头部-->
		<div class="top" id="top">
			<!--头部bar-->
			<div class="top-bar">
				<div class="w1230 top-main">
					<a href="index.jsp" class="toIndex">
						<i class="fa fa-home"></i>
						<span>爱购网首页</span>
					</a>
					<div class="account">
						<span>${username}<i class="fa fa-caret-down"></i></span>
						<div class="manage">
							<ul>
								<li><a href="#">收货地址</a></li>
								<li><a href="#">购物车</a></li>
								<li><a href="#">我的订单</a></li>
								<li><a href="#">退出</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="w1230">
			<img src="img/logo.png" width="100" height="40" class="logo"/>
			<span class="cart">购物车</span>
		</div>
		<!--收货地址-->
		<div class="w1230 address">
			<div class="default">
				<div class="default-title">收货地址</div>
				<div class="default-list">
					<span class="add-person">收货人：<span id="addName"></span></span>
					<span class="add-tel" id="addTel"></span>
					<p class="add">收货地址：<span id="add"></span></p>
				</div>
				<div class="down"><i class="fa fa-chevron-up" id="down"></i></div>
			</div>

			<div class="address-list" id="address-list">

					<ul>
						<c:forEach items="${addresses}" var="add">
							<li class="clear-float">
								<input type="radio" name="address" class="single" />
								<div class="address-des">
									<span class="add-person">${add.receivingPerson}</span>
									<span class="add-tel">${add.mobilePhone}</span>
									<p>${add.receivingAddress}</p>
								</div>
							</li>
						</c:forEach>

					</ul>

			</div>
		</div>
		<!--购物车展示-->

		<div class="w1230 shopping">
			<!--标题栏-->
			<div class="shopping-title">
				<ul class="clear-float">
					<li class="chk"><input type="checkbox" class="all-chk"/></li>
					<li class="info">商品信息</li>
					<li class="price">单价（元）</li>
					<li class="num">数量</li>
					<li class="min-price-title">小计（元）</li>
					<li class="operate">操作</li>
				</ul>
			</div>
			<!--详细展示-->
			<div class="shopping-list">
				<c:forEach items="${shops}" var="sh">
					<ul class="clear-float">
						<li class="chk"><input type="checkbox" class="chkbox" product-id="1001"/></li>
						<li class="info"><a href="#" target="_blank">
							<img src="/eshop/${sh.productImage}"/>
							<p>${sh.productName}</p>
						</a></li>
						<li class="price">${sh.price}</li>
						<li class="num">
							<a href="javascript:void(0)" class="minus">-</a>
							<input type="text" value="1" class="num-val"/>
							<a href="javascript:void(0)" class="add">+</a>
						</li>
						<li class="min-price">55.80</li>
						<li class="operate"><a href="#">删除</a></li>
					</ul>
				</c:forEach>
			</div>
			<!--合计-->
			<div class="shopping-footer clear-float">
				<div class="shopping-footer-l">
					<input type="checkbox" class="all-chk2 all-chk"/>
					<span>全选（共<span class="all-num"></span>件）</span>
					<span class="line">|</span>
					<a href="#" class="all-del">批量删除</a>
				</div>
				<div class="shopping-footer-r">
					<span>已选商品<span class="choose-num">0</span>件</span>
					<span class="line">|</span>
					<span>合计：<span class="total">￥0.00</span></span>
					<a href="/cto.do" class="compute">结算</a>
				</div>
			</div>
		</div>
		<!--脚注-->
		<div class="footer">
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
	</form>
		<script>
			$(function(){
				$(".compute").click(function(){
					var jsonArr = [];
					//获得所有被选中的chkbox
					$(".chkbox:checked").each(function(){
						var id = $(this).attr("product-id");
						console.log($(this).attr("product-id"));
						//获得同一行的数量
						var num = $(this).parent().parent().find(".num-val").val();
						console.log(num);
						//将数据转换为json对象，添加到数据
						var json = {"productId":id,"num":num};
						jsonArr.push(json);
					});
					console.log(jsonArr);
					//将数组转换为字符串
					console.log(JSON.stringify(jsonArr));
				});
			});
		</script>
	</body>
</html>
