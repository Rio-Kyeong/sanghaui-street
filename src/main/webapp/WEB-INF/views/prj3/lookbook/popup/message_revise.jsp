<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

	.wrap{width:620px; height: 172px; margin: 10px; padding: 40px 20px; box-sizing: border-box; border: 1px solid #d7d7d7; text-align: center;}
	#header{width: 577px; height: 100px; padding-top: 20px}
	#span{color: red; font-size: 22px; font-weight: bold;}
	#line{background-color: #d7d7d7; height: 1px;}
		
	h2{font-size: 35px; color: #222;}
	p{margin: 20px 0; font-size: 16px; color: #666;}
	span{font-weight: 300;}
	
</style>
<script type="text/javascript">
function closeWin(){
	opener.location.replace("http://localhost/team_prj2/prj2/lookbook/lookbook_main.jsp");
	window.open('about:blank','_self').self.close();
}//closeWin
</script>
</head>
<body>
<div class = "wrap">
	<div id="header">
		<form name = "check">
			<h4><strong style="font-size: 25px">게시글이 정상적으로 수정되었습니다.</strong></h4>
			<input type="button" value="확인" class="btn btn-primary" onclick="closeWin()"/>
		</form>
	</div>
</div>
</body>
</html>