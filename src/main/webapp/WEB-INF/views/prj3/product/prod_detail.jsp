<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- YL CSS -->
<link href="http://localhost/ss/common/css/yl_main.css" rel="stylesheet" >
<!-- bootstrap -->
<link href="http://localhost/ss/common/bootstrap-3.3.2/css/bootstrap.min.css" rel="stylesheet">
<!-- jQuery CDN(Contents Delivery Network) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<!-- bootstrap -->
<script src="http://localhost/ss/common/bootstrap-3.3.2/js/bootstrap.min.js"></script>
    <title>상하의STREET</title>
    
<style type="text/css">
#wrap{width:  1583px; height: 1580px; margin: 0px auto;} 
#header{width:  1583px; height: 105px; border-bottom: 1px solid #dddddd;}
#container{width:  1583px; height: 1000px; }
#footer{width:  1583px; height: 475px; border-top: 1px solid #dddddd;} 

#content{position: relative; top: 100px;overflow: hidden;}
#prodImg{float:left;width:550px;height: 500px; align-content: center;}
#prodDetail{float:right;width: 550px;height: 600px;}

.inside_border{border-top: 2px solid #dfdfdf;}
#tabPhoto{width: 550px;height: 500px; margin-left:100px;}
#tabDetail{width: 550px;height: 500px; margin-left: auto; margin-right: auto;}
#prodName{font-size:20px;}
#price{font-size: 30px;}
</style>
</head>
<body onload="init()">
<script type="text/javascript">

$(document).on('keyup','input[inputmode=numeric]',function(event){
	this.value = this.value.replace(/[^0-9]/g,'');   // 입력값이 숫자가 아니면 공백
	this.value = this.value.replace(/,/g,'');          // ,값 공백처리
	this.value = this.value.replace(/\B(?=(\d{3})+(?!\d))/g, ","); // 정규식을 이용해서 3자리 마다 , 추가 	
}); 


var sell_price;
var order_quantity;

function init () {
	sell_price = document.frm.sell_price.value;
	order_quantity = document.frm.order_quantity.value;
	document.frm.order_price.value = sell_price;
	change();
}

function add () {
	hm = document.frm.order_quantity;
	sum = document.frm.order_price;
	if(hm.value<10){
	hm.value ++ ;
	sum.value = parseInt(hm.value) * sell_price;
	}else{
		alert("최대 10개까지 구입하실 수 있습니다.");
	}
}

function del () {
	hm = document.frm.order_quantity;
	sum = document.frm.order_price;
		if (hm.value > 1) {
			hm.value -- ;
			sum.value = parseInt(hm.value) * sell_price;
		}
}

function change () {
	hm = document.frm.order_quantity;
	sum = document.frm.order_price;

		if (hm.value < 0) {
			hm.value = 0;
		}
	sum.value = parseInt(hm.value) * sell_price;
}  

function logout(){
    if( confirm("정말 로그아웃 하시겠습니까?")){
    	location.href="http://localhost/ss/login/logout.do";
	}
}


	

<%-- <%=userId == null?"style='display: none;'":""%> --%> 
</script>

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
		<div id="content">
			<div id="prodImg">
			<table id="tabPhoto">
			<tr>
				<td>
				<input type="hidden" value = "${ prodList.prod_num }"/>
				<img src="http://localhost/ss/common/product_photo/${prodList.prod_image}"/>
				</td>
			</tr>
			</table>
			</div>
			<div id="prodDetail">
		<form name="frm" id="frm" action="../order/orderInfo.do"  method="post"> <!-- order 페이지 링크 넣어주면돼용 -->
			<table id="tabDetail" style="top: 200px;">
			<tr class="inside_border" id=prodName>
				<th colspan="2">
				<!-- 상품명 -->
				<c:out value="${prodList.prod_name }"/>
				</th>
			</tr>
			<tr>
				<th colspan="2" id="price">
				<input type="hidden" id="img" value="http://localhost/ss/common/product_photo/${prodList.prod_image}">
				<input type="hidden" id="sell_price"
					value="${Integer.parseInt(prodList.prod_price.replace(",",""))}">
				<input type="hidden" name="prod_num" value="${prodList.prod_num }">
				<input type="text"  value="${prodList.prod_price }"
				style="text-align:right; width: 150px;" name="prod_price"  >원</th>
			</tr>		
			<tr>
				<td colspan="2">
				<!-- 상품 설명 -->
				<c:out value="${prodList.prod_explain}"/>
				</td>
			</tr>
			<tr class="inside_border">
				<th>사이즈</th>
				<td>
				<select name="order_size" id="order_size">
					<option value="S">S</option>
					<option value="M">M</option>
					<option value="L">L</option>
				</select>  
				</td>
			</tr>
			<tr class="inside_border">
				<th>수량</th>
				<td>
				<input type="button" value="-" class="btn btn-secondary" onclick="del();">
				<input type="text" readonly="readonly" style="width: 30px;text-align: center;" 
				value="1"  maxlength="1" onchange="change();"id="quantity" name="order_quantity">
				<input type="button" value="+" class="btn btn-secondary" onclick="add();" >
				</td>
			</tr>
			<tr class="inside_border" >
				<th>총결제금액</th>
				<th>
				<input  type="text" readonly="readonly" name="order_price" style="text-align:right; width: 80px;"
						inputmode="numeric"  >원 
						
				</th>
			</tr>
			<tr>	
				<td colspan="2" >
				<c:if test="${ not empty id }">
					<button type="submit" id="frmBtn" name="frmBtn" class="btn btn-default btn-lg btn-block">구매하기</button> 
				</c:if>
				</td>
			</tr>
			</table>
			</form>
			</div>
		</div>		
		</div>	
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