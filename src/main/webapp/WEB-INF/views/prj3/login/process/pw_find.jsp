<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset=" UTF-8">
 <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title></title>

<!-- bootstrap -->
<link href="http://localhost/ss/common/bootstrap-3.3.2/css/bootstrap.min.css" rel="stylesheet">
<!-- jQuery CDN(Contents Delivery Network) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<!-- bootstrap -->
<script src="http://localhost/ss/common/bootstrap-3.3.2/js/bootstrap.min.js"></script>
<style type="text/css">

	.wrap{width:620px; height: 360px; margin: 10px; padding: 20px 20px; box-sizing: border-box; border: 1px solid #d7d7d7; text-align: center;
		display: flex; justify-content: center;}
	#header{width: 577px; height: 172; padding-bottom:20px; }
	#span{color: #337ab7; font-size: 22px; font-weight: bold;}
	#line{background-color: #d7d7d7; height: 1px;}
	#btDiv{display: flex; justify-content: center;}
	
		
	h2{font-size: 35px; color: #222;}
	p{margin: 20px 0; font-size: 16px; color: #666;}
	span{font-weight: 300;}
	
</style>
<script type="text/javascript">
/* $(function(){
	$("#login").click(function() {
		$(location).attr('href', "http://localhost/ss/prj3/login/login.jsp")
	})
	
}) */

function loginBtn(){
	opener.location.replace("http://localhost/ss/login/login.do");
	window.open('about:blank','_self').self.close();
};
	

</script>
</head>
<body>
<div class = "wrap">
	<div id="header">
		<form name = "check">
			<div >
				<img src="http://localhost/ss/common/popup_img/blue_v.PNG" alt="img_fail" >
			</div>
			<h4>임시 비밀번호 발급이 완료되었습니다.</h4>
			<p>임시비밀번호 : <span id ="span"><c:out value="${ param.pass }"/></span></p>
			<br/>
			<div id="line"></div><br/>
				<div id = "btDiv">
					<button type="button" class="btn btn-primary btn-lg" id="login" onclick="loginBtn()">로그인</button>
				</div>
		</form>
	</div>
</div>
</body>
</html>