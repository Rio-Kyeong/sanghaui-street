<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>회원상세정보</title>

<!-- css -->
<link href="http://localhost/ss/common/css/yl_main.css" rel="stylesheet" >
<link href="http://localhost/ss/common/css/main.css" rel="stylesheet" >


<!-- bootstrap -->
<link href="http://localhost/ss/common/bootstrap-3.3.2/css/bootstrap.min.css" rel="stylesheet">
<!-- jQuery CDN(Contents Delivery Network) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<!-- bootstrap -->
<script src="http://localhost/ss/common/bootstrap-3.3.2/js/bootstrap.min.js"></script>

<style type="text/css">
.header{
	z-index: 1;
}


.navigation {
	margin-left : 10px;
	z-index: 1;
}
#headerTitle {
	margin-top : 20px;
	margin-left : 400px;
}

#wrap {
	width: 1250px;
	height: 900px;
	margin: 0px auto;
	background-color: #dfdfdf;
}

td {
	text-align: center;
}

th {
	text-align: center;
	background-color: #909090
}
/* container시작 */
#container{
	margin-top: 100px;
	width:1600px;
	height:800px;
	float:right;
	}
/* container끝 */
td,th{text-align:center;}

#title{
	margin-left: 400px;
}
td{text-align:center;width:600px;}
th{text-align:center;width:600px;background-color:#909090}
/* 상세정보 */
#details{width:1200px;height:600px;position:relative;top:20px;left:20px; margin-left: 380px;}

</style>




<!-- logout메소드 복붙하세용 -->
<script type="text/javascript">
function logout(){
    if( confirm("정말 로그아웃 하시겠습니까?")){
    	location.href="http://localhost/ss/login/logout.do";
	}
}
</script>



<body>
<!-- 헤더 복붙하세용 -->
<!-- header start -->
    <header class="header">
        <div class="main_nav">
            <div>
                <h1 class="title"><a href="#"><img src="http://localhost/ss/common/prj2_images/%EC%83%81%ED%95%98%EC%9D%98%EC%8A%A4%ED%8A%B8%EB%A6%BF.png"></a></h1>
                <ul class="navigation">
                   	<li><a href="http://localhost/ss/admin/admin_users.do" style="color: black">회원목록</a></li>
                    <li><a href="http://localhost/ss/admin/admin_lookbooks.do" style="color: black">게시판목록</a></li>
                    <li><a href="http://localhost/ss/admin/admin_main.do" style="color: black">상품관리</a></li>
                </ul>
            </div>
            <ul class="icons">  
          	<c:choose>
          		<c:when test="${ adminId eq null}">
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
               
            </ul>
        </div>
    </header>
<!-- header end --> 
<div id="wrap">
	<div id="container">
	<h1 id="headerTitle">SANGHAUI STREET ADMINISTRATOR</h1>
		<h1 id="title" ><c:out value="${userInfo.member_id}"/>님 회원정보</h1>
				<table class="table table-bordered" id="details">
				<tr>
					<th>아이디</th><td><c:out value="${userInfo.member_id}"/></td>
				</tr>
				<tr>
					<th>이름</th><td><c:out value="${userInfo.member_name}"/></td>
				</tr>
				<tr>
					<th>성별</th><td><c:out value="${userInfo.member_gender}"/></td>
				</tr>
				<tr>
					<th>생년월일</th><td><c:out value="${userInfo.member_birth}"/></td>
				</tr>
				<tr>
					<th>연락처</th><td><c:out value="${userInfo.member_phone}"/></td>
				</tr>
				<tr>
					<th>이메일</th><td><c:out value="${userInfo.member_email}"/></td>
				</tr>
				<tr>
					<th>우편번호</th><td><c:out value="${userInfo.member_zipcode}"/></td>
				</tr>
				<tr>
					<th>상세주소</th><td><c:out value="${userInfo.member_detailed_addr}"/></td>
				</tr>
				<tr>
					<th>가입날짜</th><td><c:out value="${userInfo.member_sign_date}"/></td>
				</tr>
				<tr>
					<th>탈퇴여부</th><td><c:out value="${userInfo.member_withdrawal}"/></td>
				</tr>
				
				</table>
			
			<a href="http://localhost/ss/admin/admin_userDel_proc.do?member_id=${userInfo.member_id}"><input type="button" value="탈퇴" class="btn btn-primary" style="position:relative;left:1500px;top:20px"/></a>
	</div>
</div>
 <!-- footer start -->
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
    <!-- footer end -->
</body>
</html>