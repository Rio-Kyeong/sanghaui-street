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
	.wrap{width:620px; height: 360px; margin: 10px; padding: 40px 20px; box-sizing: border-box; border: 1px solid #d7d7d7; text-align: center;}
	#header{width: 577px; height: 172}
	.text{width: 300px; height: 50px; margin-right: 10px; font-size: 20px}
	#inputDiv{height: 50px; display: flex; justify-content: center; }
	
	h2{font-size: 35px; color: #222;}
	p{margin: 20px 0; font-size: 16px; color: #666;}
	span{font-weight: 300;}
</style>
<script type="text/javascript">
	$(function(){
		$("#checkBt").click(function(){
			$.ajax({
				url:"http://localhost/ss/login/idDup.do",
				data: "MEMBER_ID="+$("#MEMBER_ID").val(),
				dayaType:"text",
				type:"get",
				error:function(xhr){
					console.log(xhr.status);
					console.log(xhr.statusText);
				},
				success:function( text ){
					$("#reqDiv").html( text );	
				}
			})	
		})
	})	

	function useId( MEMBER_ID ){
		opener.window.document.joinFrm.id.value = MEMBER_ID;
		self.close();	
	}
	
</script>
</head>
<body>
<div class = "wrap">
	<div id="header">
			<h2>ID CHECK<span> 아이디 중복확인</span></h2>
			<p>사용하고자 하는 아이디를 입력해주세요.<br/>
			아이디 중복확인 후 사용 가능한 아이디로 선택하시면 됩니다.</p>
			<div id="inputDiv">
				<input type="text" name ="MEMBER_ID" id ="MEMBER_ID" class="form-control text" maxlength="16"/>
				<input type="button" value="ID 중복확인" name ="checkBt" id ="checkBt"  class="btn btn-default btn-lg" />
			</div>
				<div id="reqDiv"></div>
	</div>
</div>
</body>
</html>