<%@page import="javax.swing.JOptionPane"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <!-- JSTL 라이브러리 -->    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- css -->
<link href="http://localhost/ss/common/css/yl_main.css" rel="stylesheet" >
<link href="http://localhost/ss/common/css/main.css" rel="stylesheet" >
<title>LookBook</title>

<!-- bootstrap -->
<link href="http://localhost/ss/common/bootstrap-3.3.2/css/bootstrap.min.css" rel="stylesheet">
<!-- jQuery CDN(Contents Delivery Network) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<!-- bootstrap -->
<script src="http://localhost/ss/common/bootstrap-3.3.2/js/bootstrap.min.js"></script>
<!-- include summernote css/js -->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>



<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/Swiper/4.5.1/css/swiper.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/Swiper/4.5.1/js/swiper.min.js"></script>

<style type="text/css">
	
	#title{width: 1130px; height:30px; margin-left: 45px;border: 1px solid #dfdfdf;}
	td { padding-top: 10px}
	#commTable > td{padding-top: 0px}
	#commTd{padding-top: 0px}
</style>
<script type="text/javascript">




$(function() {
	  
	  $("#commBtn").click(function(){
		  if($("#comments").val()==""){
			  alert("댓글을 작성해주세요!!");
			  return;
		  }
		  if($("#member_id").val()==""){
			  alert("로그인 후 댓글을  작성해주세요!!");
			  return;
		  }
		  
		  $("#frm").submit();
	  })
	 
	  

$("#deleteBtn").click(function(){
			//window.open("id_dup.do?cmd=D001", "popup", "width=500, height=302, top="
			window.open("deleteLb.do?num="+${param.num}, "popup", "width=640, height=200, top="
				+ (window.screenTop + 300) + ",left=" + (window.screenLeft + 500))
		
});//click

$("#updateBtn").click(function(){ 
	location.href = "updateDetail.do?num=" + ${param.num};
})
});//ready




function logout(){
    if( confirm("정말 로그아웃 하시겠습니까?")){
    	location.href="http://localhost/ss/login/logout.do";
	}
}

</script>
</head>
<body>
<!-- header start -->
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
    <!-- header end -->
    <section>
     <!-- container start -->
        <div class="container">
   <!--      "process/lookbook_write_process.jsp" -->
        	<form action="lookbook_write_process.do?num=${param.num }" method="post" name="frm" id="frm">
        	<!-- LookBook write header -->
        	<h2>룩북 보기</h2>
        		<div style = "border: 1px solid #dfdfdf; border-radius: 10px">
        	<table>
        	<tr>
        	</tr>
        
        	<tr>
	        	<td rowspan = "3" style = "width :50%; height : 100%; algin :top"> 
	        		<div style = "  width : 80%; height : 500px; margin-left : 45px;">
	        		<div class="swiper-container" style = "  width : 400px; height : 450px; postion:relative; z-index:0">
        					<div class= "swiper-wrapper" style ="padding-left : 35px">
      					<c:forEach var="img" items="${detailImg}" >
        						<div class="swiper-slide" >
        							<img style =" width:330px; height : 500px;"src ="http://localhost/ss/resources/upload/${img}" />
        						</div>
        				</c:forEach> 
        				<!-- 		<div class="swiper-slide">
        							<img src ="http://localhost/ss/common/product_photo/bot_2.jpg"/>
        						</div>
        						<div class="swiper-slide">
        							<img src ="http://localhost/ss/common/product_photo/bot_3.jpg"/>
        						</div>
        						<div class="swiper-slide">
        							<img src ="http://localhost/ss/common/product_photo/bot_4.jpg" />
        						</div> -->
        					</div>
        					<div class="swiper-button-next"></div><!-- 다음 버튼 (오른쪽에 있는 버튼) -->
							<div class="swiper-button-prev"></div><!-- 이전 버튼 -->
        				</div>
							<div class="swiper-pagination" style="padding-left:200px"></div>
	        		</div>
	        	</td>
        		<td style = "border-bottom : 1px solid #dfdfdf; height: 200px"> 
	        		<%-- <strong><c:out value ="${detailLb.member_id }" /></strong>
        			<c:out value="${detailLb.lb_title }"/>
        			<c:out value="${detailLb.lb_contents }" escapeXml="false"/> --%>
        			
        			<table style="width: 100%; height: 100%;">
        				<thead>
        					<tr>
        						<th style = "height :5%; border-bottom: 1px solid #dfdfdf" ><h4><strong><c:out value ="${detailLb.member_id }" /></strong> 님의 룩북 </h4> </th>
        					</tr>
        				</thead>
					    <tbody>
					    	<tr>
					    		<td style= "height: 30%"><h5><strong><c:out value="${detailLb.lb_title }"/></strong></h5></td>
					    	<tr>
					    	<tr>
					    		<td><c:out value="${detailLb.lb_contents }" escapeXml="false"/> </td>
					    	<tr>
					    </tbody>		
        			</table>
        		</td>
        	</tr>
        	<tr>
        		<td style = "border : 1px solid #dfdfdf;height: 250px; vertical-align: top;" id="commTd">
        		<div style="height : 250px;overflow: auto;"> 
        				<table style = "width:100%;" id="commTable" >
        					<c:if test="${empty comments }" >
        						<tr>
        							<td> 첫 댓글을 작성해주세요 !!</td>
	        					<tr>
       						</c:if>
       						<c:forEach var="comments" items="${comments }" >
       							<c:choose>
       							<c:when test="${comments.member_id eq sessionScope.id}">
       							<tr>	
       				
       								<td style = "width : 100px; height: 10px; padding-top:0px"><input type="hidden" value= "${comments.lb_comments_num }"/><h5><strong><c:out value="${comments.member_id }"/></strong></h5></td>
        							<td style = "width : 260px"><c:out value="${comments.lb_comments }"/></td>
        							<td style = "width : 100px"><c:out value="${comments.lb_comments_date }"/> <input type ="button" value="X" class="btn" style="color:RED" onclick="window.open('deleteComm.do?num=${param.num}&commNum=${comments.lb_comments_num }', 'popup', 'width=640, height=200')"></td>				
       							</tr>
       							</c:when>
       							<c:otherwise>
       							<tr>	
       								<td style = "width : 100px"><strong><c:out value="${comments.member_id }"/></strong></td>
        							<td style = "width : 260px"><c:out value="${comments.lb_comments }"/></td>
        							<td style = "width : 100px"><c:out value="${comments.lb_comments_date }"/></td>				
       							</tr>
       							</c:otherwise>
       							</c:choose>
        					</c:forEach>
        				</table>
        		</div>
        		</td>
        	</tr>
        	<tr>
        		<td>
        	
        		<div style ="vertical-align: bottom">
        			<input type="hidden" value="${param.num }" name="lb_posts_num" />
        			<input type="hidden" value="${sessionScope.id }" name="member_id" id="member_id"/>
        			<input type="text" placeholder="댓글달기..." name="lb_comments" id="comments"style ="border: 1px solid #dfdfdf; width  : 500px; height: 30px"/> <input type="button" id="commBtn" value = "작성" class="btn btn-primary"/>
        		</div>
        		
        	</td>
        	</tr>
        	<tr>
        	</tr>
        	</table>
        	</div>
        	</form>
        	<br/>
        	<c:choose>
        		<c:when test= "${detailLb.member_id eq sessionScope.id  }"	>
        			
	        		<div style="padding-left: 920px">
        				<input type="button" value="수정하기" class="btn btn-success" id="updateBtn" />	<input type="button" value="삭제하기" class="btn btn-danger" id="deleteBtn" /> <input type="button" value="뒤로가기" class="btn btn-info" id="write" onclick = "location.href='lookbook_main.do'"/>
        			</div>
        		</c:when>
        		<c:otherwise>
        			<div style="padding-left: 1060px">
        				<input type="button" value="뒤로가기" class="btn btn-info" id="write" onclick =  "location.href='lookbook_main.do'"/>
        			</div>
        		</c:otherwise>
        	</c:choose>
        	
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