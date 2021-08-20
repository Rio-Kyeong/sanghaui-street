<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- <%
<%-- 	//사용자 로그인 한 이후의 아이디 데이터를 필요한 페이지에서 사용하기 위한 공통 JSP
	String userId = (String)session.getAttribute("id");
	if(userId == null){  
		response.sendRedirect("http://localhost/ss/prj2/login/login.jsp");
		return;
	} 
%> --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- css -->
<link href="http://localhost/ss/common/css/yl_main.css" rel="stylesheet">

<title>LookBook</title>

<!-- bootstrap -->
<link href="http://localhost/ss/common/bootstrap-3.3.2/css/bootstrap.min.css" rel="stylesheet">
<!-- jQuery CDN(Contents Delivery Network) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<!-- bootstrap -->
<script src="http://localhost/ss/common/bootstrap-3.3.2/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/Swiper/4.5.1/css/swiper.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/Swiper/4.5.1/js/swiper.min.js"></script>



<style type="text/css">	

	h2,h3{text-align: center; font-weight:bold;}

	
	.swiper-container {
	width : 100%;
	height:540px;
}
	
	.swiper-slide{
		text-align : center;
		display:flex; /* 내용을 중앙정렬 하기위해 flex 사용 */
		align-items:center; /* 위아래 기준 중앙정렬 */
		justify-content:center; /* 좌우 기준 중앙정렬 */
	}
	.swiper-slide img {
	box-shadow:0 0 5px #555;
}
</style>



<script type="text/javascript">

function logout(){
    if( confirm("정말 로그아웃 하시겠습니까?")){
    	location.href="http://localhost/ss/login/logout.do";
	}
}

$(function(){
	if(${param.cnt} == 1){
		alert("게시글이 등록되었습니다.");
		location.href="http://localhost/ss/lookbook/lookbook_main.do";
	}
	

})

$(function(){
	
	
});//ready
</script>
</head>
<body>
<input type="hidden" value="${sessionScope.id }"/>
<!-- header start -->
    <header class="header" >
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
    <!-- header end -->
    <section>
     <!-- container start -->
        <div class="container" style="height: 100%; text-align: center;  ">
    

        		 	<h2>Look Book</h2>
        		<div align="left" style = "padding-left:100px;">
        		<c:choose>
        		
        		<c:when test="${empty sessionScope.id }">
        			<h4> <a href="lookbook_main.do" id = "AllLb"style="color:#3379FE; border-bottom:3px solid #3379FE">전체 룩북 보기 </a></h4>
        		</c:when>
        		<c:otherwise>
					<c:choose>
				
	    	    		<c:when test="${empty param.id }" >
	    	    			<h4> <a href="lookbook_main.do" id = "AllLb"style="color:#3379FE; border-bottom:3px solid #3379FE">전체 룩북 보기 </a> | <a href="lookbook_myMain.do?id=${sessionScope.id }" id="MyLb" style="color:black">내 룩북 보기 </a></h4>
	    	    		</c:when>
	    	    		<c:otherwise>
   		    	 			<h4> <a href="lookbook_main.do" id = "AllLb"style="color:black">전체 룩북 보기 </a>| <a href="lookbook_myMain.do?id=${sessionScope.id }" id="MyLb" style="color:#3379FE; border-bottom:3px solid #3379FE">내 룩북 보기 </a></h4>
	    	    		</c:otherwise>
					</c:choose>
        		</c:otherwise>
        		</c:choose>
        			<div align = "right">
        			<c:if test="${not empty sessionScope.id }" >
	        		<input type="button" value="글쓰기" class="btn btn-primary" onclick="location.href ='write.do'" id="btnWrite"/>
        			</c:if>
        			</div>
        		</div>
        	
        	<!-- 전체 div-->
        		<div style = "border : 1px solid #dfdfdf; overflow:auto; margin : auto; width : 80%; height : 1200px; border-radius: 10px"> 
        		<!-- 개별 div -->
        		<c:if test="${empty testList }">
        			현재 피드가 존재하지 않습니다.<br/>
        			글을 작성해주세요!!
        		</c:if> 
 				<c:forEach var="testList" items="${testList }">
 				<br/>
        			<div style = "border : 1px solid #dfdfdf; margin : auto; width : 60%; height: 600px; position:relative; z-index : auto; border-radius: 10px ">
        			<input type="hidden" value="${testList.lb_posts_num }" />
        				<div style = "border-bottom : 1px solid #dfdfdf;text-align:left;  padding-left: 10px;width : 100%; height : 40px">
        					
        					<h4><strong><c:out value = "${testList.member_id }"/></strong> </h4>
        					
        				</div>
        				<div>
        				
        				<div class="swiper-container" style = "border-bottom : 1px solid #dfdfdf;  width : 100%; height : 100%; postion:relative; z-index:0">
        					<div class= "swiper-wrapper">
      					<c:forEach var="img" items="${testList.img}" >
        						<div class="swiper-slide" >
        							<img style =" width:400px; height : 500px;"src ="http://localhost/ss/resources/upload/${img}" />
        						</div>
        				</c:forEach> 
        		
        					</div>
        					<div class="swiper-button-next"></div><!-- 다음 버튼 (오른쪽에 있는 버튼) -->
							<div class="swiper-button-prev"></div><!-- 이전 버튼 -->
							<div class="swiper-pagination"></div>
        				</div>
        				</div>
        					<h3><strong><a href = "write_comment.do?num=${testList.lb_posts_num }" style= "color:black;  "><c:out value="${testList.lb_title}"/></a></strong></h3>
<!--         			
 -->   	     			
        			</div>
        		</c:forEach>
        		<!--  개별 div 끝 -->
        			
        			
        			
        		</div>
        	</div>
        	<script>
        				new Swiper('.swiper-container', {
        				pagination : { // 페이징 설정
        					el : '.swiper-pagination',
        					clickable : true, // 페이징을 클릭하면 해당 영역으로 이동, 필요시 지정해 줘야 기능 작동
        				},
        				navigation : { // 네비게이션 설정
        					nextEl : '.swiper-button-next', // 다음 버튼 클래스명
        					prevEl : '.swiper-button-prev', // 이번 버튼 클래스명
        				},
        			});
					</script>
    	</section>
    <!-- container end -->
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