<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset=" UTF-8">
 <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>PASSWORD FIND</title>

<!-- css -->
<link href="http://localhost/ss/common/css/yl_main.css" rel="stylesheet">

<!-- bootstrap -->
<link href="http://localhost/ss/common/bootstrap-3.3.2/css/bootstrap.min.css" rel="stylesheet">
<!-- jQuery CDN(Contents Delivery Network) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<!-- bootstrap -->
<script src="http://localhost/ss/common/bootstrap-3.3.2/js/bootstrap.min.js"></script>

<style type="text/css">

	.main_con{ width: 100%; justify-content: center; display: flex; flex-direction: column; align-items: center; padding-top: 200px}
	#container{ width:  100%; height: 1200px;  }
	
	#login_wrap{border: 1px solid #d7d5d5; width: 1300px; height:700px; display: flex; flex-direction: column; justify-content: center; align-items: center;  }
	#login_header{width:600px; font-size: 60px;   font-weight: bold; display: flex;  justify-content: center; align-items: center; font-size: 40px; font-weight: bold;}
	#login_container{width: 700px; display: flex; flex-direction: column; justify-content: center; align-items: center; }
	#login_font{width: 700px; height: 140px; font-size: 20px;   margin-right: 600px;}
	
	#spanId{padding-left: 20px; padding-right: 45px; }
	#spanPw{padding-left: 20px; padding-right: 70px;}
	#bt{background-color:black; width: 120px; height: 60px; font-size: 25px; font-weight: bold; }
	#hr{width: 600px; border: 1px solid #8F8F91}
	#guide{text-align: center; color: #999; width: 600px; margin-left: 50px}
	
	div > p{font-size: 60px}
	div > span {font-size: 18px;}
	div > span > a{color: black;}
	
	label{border: 1px solid; #ccc; border-radius: 2px; color: #8F8F91; font-size: 25px; margin-bottom: 20px }
	input{ border:none; width: 550px; height: 85px; font-size: 25px; } 
	input:focus {outline: none;}
</style>

<script type="text/javascript">
$(function(){
	$("#id").keydown(function(evt){ 
		if(evt.which == 13){
			chkNull();
		}//end if
	});	
	$("#name").keydown(function(evt){ 
		if(evt.which == 13){
			chkNull();
		}//end if
	});	
	$("#email").keydown(function(evt){ 
		if(evt.which == 13){
			chkNull();
		}//end if
	});	
	$("#bt").click(function(){ 
		chkNull();
	});	
});

function chkNull(){
	if( $("#id").val() ==""){
		alert("아이디는 필수 입력");
		$("#id").focus();
		return;
	}//end if
	if( $("#name").val() ==""){
		alert("이름은 필수 입력");
		$("#name").focus();
		return;
	}//end if
	if( $("#email").val() ==""){
		alert("이메일은 필수 입력");
		$("#email").focus();
		return;
	}//end if
	$("#pwFrm").submit();
}//chkNull

 	<c:if test="${ !empty success }">
		pwFindSuccess();
	</c:if>
	
	<c:if test="${ !empty fail }">
		pwFindFail();
	</c:if>	 

	function pwFindSuccess(){
		window.open("http://localhost/ss/login/pwFindSuccess.do?pass=${ RandomPass }","success","width = 640, height = 387, top ="+(window.sceenTop+350)+",left =" +(window.creenleft + 600));
	}; 	
	
	function pwFindFail(){
		window.open("http://localhost/ss/login/fail.do","fail","width = 640, height = 387, top ="+(window.sceenTop+350)+",left =" +(window.creenleft + 600));
	}; 
	 
</script>
</head>
<body>
    <header class="header">
          <div class="main_nav">
            <div>
                <h1 class="title"><a href="http://localhost/ss/main/main_all.do"><img src="http://localhost/ss/common/images/%EC%83%81%ED%95%98%EC%9D%98%EC%8A%A4%ED%8A%B8%EB%A6%BF.png"></a></h1>
                <ul class="navigation">
                    <li><a href="http://localhost/ss/product/prod_top.do" style="color: black">TOP</a></li> <!-- 링크수정함 -->
                    <li><a href="http://localhost/ss/product/prod_bot.do" style="color: black">BOTTOM</a></li> <!-- 링크수정함 -->
                    <li><a href="http://localhost/ss/lookbook/lookbook_main.do" style="color: black">LOOKBOOK</a></li> <!-- 링크수정함 -->
                    <li><a href="http://localhost/ss/login/member.do" style="color: black">MYPAGE</a></li> <!-- 링크수정함 -->
                </ul>
            </div>
            <ul class="icons">  
          	<c:choose>
          		<c:when test="${ id eq null}">
               	<li>
                   <p>login</p> 
                   <a href="http://localhost/ss/login/login.do"> <!-- 링크수정함 -->
                    <svg version="1.1" id="Capa_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
                       viewBox="0 0 512 512" style="enable-background:new 0 0 512 512;" xml:space="preserve" >
                           <path d="M437.02,330.98c-27.883-27.882-61.071-48.523-97.281-61.018C378.521,243.251,404,198.548,404,148
                               C404,66.393,337.607,0,256,0S108,66.393,108,148c0,50.548,25.479,95.251,64.262,121.962
                               c-36.21,12.495-69.398,33.136-97.281,61.018C26.629,379.333,0,443.62,0,512h40c0-119.103,96.897-216,216-216s216,96.897,216,216
                               h40C512,443.62,485.371,379.333,437.02,330.98z M256,256c-59.551,0-108-48.448-108-108S196.449,40,256,40
                               c59.551,0,108,48.448,108,108S315.551,256,256,256z" />
                    </svg>
                  </a>  
                </li>
                </c:when>
                <c:otherwise>
                <li>
                   <p>login</p> 
                   <a href="#" onclick="logout()"> <!-- 링크수정함 -->
                    <svg version="1.1" id="Capa_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
                       viewBox="0 0 512 512" style="enable-background:new 0 0 512 512;" xml:space="preserve" >
                           <path d="M437.02,330.98c-27.883-27.882-61.071-48.523-97.281-61.018C378.521,243.251,404,198.548,404,148
                               C404,66.393,337.607,0,256,0S108,66.393,108,148c0,50.548,25.479,95.251,64.262,121.962
                               c-36.21,12.495-69.398,33.136-97.281,61.018C26.629,379.333,0,443.62,0,512h40c0-119.103,96.897-216,216-216s216,96.897,216,216
                               h40C512,443.62,485.371,379.333,437.02,330.98z M256,256c-59.551,0-108-48.448-108-108S196.449,40,256,40
                               c59.551,0,108,48.448,108,108S315.551,256,256,256z" />
                    </svg>
                  </a>  
                </li>
                </c:otherwise>
              </c:choose>
                <li>
                    <p>cart</p>
                    <a href="http://localhost/ss/order/orderDetail.do"> 
                    <svg id="Capa_1" enable-background="new 0 0 512 512" viewBox="0 0 512 512" xmlns="http://www.w3.org/2000/svg">
                        <path d="m472 452c0 11.046-8.954 20-20 20h-20v20c0 11.046-8.954 20-20 20s-20-8.954-20-20v-20h-20c-11.046 
                        0-20-8.954-20-20s8.954-20 20-20h20v-20c0-11.046 8.954-20 20-20s20 8.954 20 20v20h20c11.046 0 20 8.954 20 20zm0-312v192c0 
                        11.046-8.954 20-20 20s-20-8.954-20-20v-172h-40v60c0 11.046-8.954 20-20 20s-20-8.954-20-20v-60h-192v60c0 11.046-8.954 20-20 
                        20s-20-8.954-20-20v-60h-40v312h212c11.046 0 20 8.954 20 20s-8.954 20-20 20h-232c-11.046 0-20-8.954-20-20v-352c0-11.046 8.954-20 
                        20-20h60.946c7.945-67.477 65.477-120 135.054-120s127.109 52.523 135.054 120h60.946c11.046 0 20 8.954 20 20zm-121.341-20c-7.64-45.345-47.176-80-94.659-80s-87.019 34.655-94.659 80z"/>
                        </svg>
                        </a>
                </li>
            </ul>
        </div>
    </header>		
		<div  id = container>
			<div class = main_con >
			<div id=login_font><p>PASSWORD FIND</p>홈 > 비밀번호 찾기</div>
			<div id = login_wrap>
				<div id="login_header">비밀번호 찾기</div><br/>
				<form action="http://localhost/ss/login/pwSearch.do" method="post" id = "pwFrm" name = "pwFrm">
				<div id= login_container>
					<label>
						<span id = "spanId">아이디</span>
						<input type="text" autofocus="autofocus" tabindex="1" maxlength="16" name ="member_id" id = "id">
					</label>
					<br/>
					<label>
						<span id = "spanPw">이름</span>
						<input type="text"  tabindex="2" maxlength="16" name ="member_name" id="name">
					</label>
					<br/>
					<label>
						<span id = "spanId">이메일</span>
						<input type="text"  tabindex="3" name ="member_email" id="email">
					</label>
					<br/>
						<button type="button" class="btn btn-primary"  id="bt" >확인</button>
				</div>
				</form>
			</div>
		</div>
		</div>	
		<footer>
			<div class="footer-wrap">
            <div class="footer-content">
                <h2>ABOUT SANGHAUI</h2>
                <p>
                    상하의스트릿 공식 온라인스토어는 ㈜쌍용교육센터의 콘텐츠를 위임받아 운영하고 있습니다. <br/>
                    상하의스트릿 공식 온라인 스토어에서 사용하는 인증 마크를 훼손 또는 무단복제하여 사용할 수 없으며, <br/>
                    해당 콘텐츠의 소유권은 SANGHAUI STREET ㈜쌍용교육센터에 있습니다.<br/>
					Copyright © sanghaui street. All rights reserved.
                </p>
            </div>
            <div class="footer-content">
                <h2>CS CENTER</h2>
                <ul>
                    <li>업무시간 10:00 - 17:00</li>
                    <li>점심시간 12:00 - 13:00</li>
                    <li>휴무 토요일,일요일,공휴일</li>
                    <li>현금 등으로 결제시 저희 쇼핑몰이 가입한</li>
                    <li>PG에스크로 구매안전 서비스를 이용하실 수 있습니다</li>
                </ul>
            </div>
            <div class="footer-content">
                <h2>OUR COMPANY</h2>
                <ul>
                    <li>회사명 : (주)쌍용교육센터</li>
                    <li>사업자등록번호 : 2148529296</li>
                    <li>통신판매업 신고 : 제 2021-서울쌍용-3333호</li>
                    <li>주소 : 서울특별시 강남구 테헤란로 132(역삼동) </li>
                    <li>한독약품빌딩 8층 쌍용교육센터</li>
                </ul>
            </div>
        </div>
		</footer>
	

</body>
</html>