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
<link href="http://localhost/team_prj2/common/css/yl_main.css" rel="stylesheet" >
<link href="http://localhost/team_prj2/common/css/main.css" rel="stylesheet" >
<title>LookBook</title>

<!-- bootstrap -->
<link href="http://localhost/team_prj2/common/bootstrap-3.3.2/css/bootstrap.min.css" rel="stylesheet">
<!-- jQuery CDN(Contents Delivery Network) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<!-- bootstrap -->
<script src="http://localhost/team_prj2/common/bootstrap-3.3.2/js/bootstrap.min.js"></script>
<!-- include summernote css/js -->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>

<!-- <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/Swiper/4.5.1/css/swiper.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/Swiper/4.5.1/js/swiper.min.js"></script> -->
<style type="text/css">
	h2,h3{text-align: center; font-weight:bold;}
		.text{width: 1185px;height:700px;border:1px solid #dfdfdf;}
	#title{width: 600px; height:30px; border: 1px solid #dfdfdf;}
		

.btn{border : 1px solid #333}

#preview {
    display: grid;
    grid-template-columns: 1fr 1fr 1fr;
}
.image {
    display: block;
    width: 100%;
}
.image-label {
    position: relative;
    bottom: 22px;
    left: 5px;
    color: white;
    text-shadow: 2px 2px 2px black;
}
</style>
<script type="text/javascript">


function sendView(){
	
	if($("#upfile1").val()==""){
		alert("이미지를 하나이상 등록해주세요");
		return;
	}
	
	if($("#title").val()==""){
		alert("제목을 입력해주세요");
		$("#title").focus();
		return;
	}
	
	if($("#summernote").val()==""){
		alert("내용을 입력해주세요");
		$("#summernote").focus();
		return;
	}
	
	if($("#imgUploadCancel1").length == 0){
		alert("파일업로드 버튼을 눌러주세요!");
		return;
	}
	
	alert("게시글 등록이 완료되었습니다");
	$("#postFrm").submit();
	//$("#imgFrm").submit();
}//sendView

$(function() {
	

	
	  $('#summernote').summernote({
		  width: 600,
		  height: 400,                 // set editor height
		  minHeight: 400,             // set minimum height of editor
		  maxHeight: 400,             // set maximum height of editor
		  focus: true,
		  placeholder: '내용을 입력해주세요',
		  toolbar: [
	          ['style', ['style']],
	          ['font', ['bold', 'underline', 'clear']],
	          ['color', ['color']],
	        ]
	  });
	  
	 
	  

	  
	
		
	imgCnt = 2;
	$("#plusBtn").click(function(){
		
		if($(".lb_upfile").length > 4 ){
			alert("사진은 최대 5장까지 등록가능합니다.");
			imgCnt = 2;
		}else{
			$("#addInput").append("<input type='file' id ='upfile"+imgCnt+"' onchange='PreviewImage"+imgCnt+"()' name ='upfile1' class='lb_upfile' />");
			$("#preview").append("<img style='width: 100px; height: 200px' class='preview-img'  id='preview-image"+imgCnt+"' src='https://dummyimage.com/500x500/ffffff/000000.png&text=preview+image'>");
			imgCnt = imgCnt + 1;
		}
	});//click
	
	
	$("#minusBtn").click(function(){
		if($(".lb_upfile").length < 2){
			alert("이미지는 최소한개이상 등록해야합니다.")
		}else{
		$(".lb_upfile:last-child").remove();
		$(".preview-img:last-child").remove();
		}
	});//click
	
	
	$("#imgUpload").click(function(){
	    //서버에서 실행가능한 파일은 업로드하지 못하게 막는다.
	      //선택한 파일의 확장자가 이미지 (jpg,gif,png,bmp)인 경우에만 submit되도록
	      //확장자 검증.   
	     for(var i = 1; i <= $(".lb_upfile").length; i ++){
	     	
	    	eval("var upfile"+i+" = $('#upfile"+i+"').val()");
	     
	     
		   if(eval("upfile"+i) == ""){
				alert(i + "번째 업로드가 비어있습니다.");
				return;
			}
	        var blockExt=["jpg","gif","png","bmp"];
	       
	      var ext=eval("upfile"+i+".substring(upfile"+i+".lastIndexOf('.')+1)");
	    
	      var blockFlag=false;
	      for(var j=0; j<blockExt.length; j++){
	         if(ext.toLowerCase() ==blockExt[j]){
	            blockFlag=true;
	         }//end if
	      }//end for
	      
	      if(!blockFlag){
	    	  alert(i+"번째 파일이 업로드가능한 확장자가 아닙니다.");
		      return;
	      }//end if 
	     }
	    $("#imgFrm").submit();
	    $("#imgUpload").val("업로드취소하기"); //value변경
	    $("#imgUpload").attr("class","btn btn-danger"); // 클래스변경
	    $("#imgUpload").attr("onclick","imgUploadCancel()"); //onclick 추가
	    $("#imgUpload").attr("id","imgUploadCancel1"); // 아이디변경
	    $("#plusBtn").attr("disabled", "disabled"); //버튼 안눌리게 변경
	    $("#minusBtn").attr("disabled", "disabled"); //"
	    $("#imgFrm").attr("action","uploadCancel.do"); // 폼태그action 변경
	    $("#imgFrm").attr("id","imgFrmCancel"); //폼태그아이디변경
	    
	    for(var i = 1; i <= $(".lb_upfile").length; i ++){
	    	$("#upfile"+i).attr("disabled","true");
	    	
	    }//end for
	    
	});//click


	var upfile1 = $("#upfile1").val();
	function readImage1(upfile1) {
	    // 인풋 태그에 파일이 있는 경우
	    if(upfile1.files && upfile1.files[0]) {
	        // 이미지 파일인지 검사 (생략)
	        // FileReader 인스턴스 생성
	        const reader1 = new FileReader()
	        // 이미지가 로드가 된 경우
	        reader1.onload = e1 => {
	            const previewImage1 = document.getElementById("preview-image1")
	            previewImage1.src = e1.target.result
	        }
	        // reader가 이미지 읽도록 하기
	        reader1.readAsDataURL(upfile1.files[0])
	    }
	}
	// input file에 change 이벤트 부여
	const inputImage1 = document.getElementById("upfile1")
	inputImage1.addEventListener("change", e1 => {
	    readImage1(e1.target)
	})
	

	

});//ready

 function imgUploadCancel(){
		$("#imgFrmCancel").submit();
		$("#imgUploadCancel1").val("사진업로드"); //value변경
	    $("#imgUploadCancel1").attr("class","btn btn-primary"); // 클래스변경
	    $("#imgUploadCancel1").removeAttr("onclick"); //onclick 추가
	    $("#imgUploadCancel1").attr("id","imgUpload"); // 아이디변경
	    $("#plusBtn").removeAttr("disabled"); //버튼 눌리게 변경
	    $("#minusBtn").removeAttr("disabled"); //"
	    $("#imgFrmCancel").attr("action","upload.do"); // 폼태그action 변경
	    $("#imgFrmCancel").attr("id","imgFrm"); //폼태그아이디변경
	    
	    for(var i = 1; i <= $(".lb_upfile").length; i ++){
	    	$("#upfile"+i).removeAttr("disabled");
	    	
	    }//end for
	    
} 

function popupCancel(){
	window.open("LbWriteCancel.do?num=${num}", "cancel", "width=650, height=200, top="+(window.screenTop+350)+", left="+(window.screenLeft+600));
}//popupCancel

function logout(){
    if( confirm("정말 로그아웃 하시겠습니까?")){
    	location.href="http://localhost/ss/login/logout.do";
	}
}



function PreviewImage2() {
    // 파일리더 생성 
    var preview2 = new FileReader();
    preview2.onload = function (e) {
    // img id 값 
    document.getElementById("preview-image2").src = e.target.result;
};
// input id 값 
preview2.readAsDataURL(document.getElementById("upfile2").files[0]);
};

function PreviewImage3() {
    // 파일리더 생성 
    var preview = new FileReader();
    preview.onload = function (e) {
    // img id 값 
    document.getElementById("preview-image3").src = e.target.result;
};
// input id 값 
preview.readAsDataURL(document.getElementById("upfile3").files[0]);
};


function PreviewImage4() {
    // 파일리더 생성 
    var preview = new FileReader();
    preview.onload = function (e) {
    // img id 값 
    document.getElementById("preview-image4").src = e.target.result;
};
// input id 값 
preview.readAsDataURL(document.getElementById("upfile4").files[0]);
};

function PreviewImage5() {
    // 파일리더 생성 
    var preview = new FileReader();
    preview.onload = function (e) {
    // img id 값 
    document.getElementById("preview-image5").src = e.target.result;
};
// input id 값 
preview.readAsDataURL(document.getElementById("upfile5").files[0]);
};


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
        	<!-- LookBook write header -->
        	<div>
        	<h2>게시글 작성</h2>
        	</div>
        	
	        	<div style = "float:left; width : 50%; ">
	        	  <form action = "upload.do" method = "post" enctype="multipart/form-data" id="imgFrm" target="param">
     				<input type ="hidden" value="${num }" name = "hid"/>		
      				  <div class="preview" id="preview" style = "border : 1px solid #dfdfdf;  border-radius: 10px;width : 370px; height : 500px; margin-left:45px;  postion:relative; z-index:0">
	        				<img style="width: 100px; height: 200px" id="preview-image1" src="https://dummyimage.com/500x500/ffffff/000000.png&text=preview+image">
	    			 </div>
				
					<div id = "addInput" style="width : 50%; float : left; padding-left: 50px">
						<input type="file" id="upfile1" name ="upfile1" class="lb_upfile"/> 
					</div>
					<div style = "float:left; width : 50%; ">
						<input type ="button" value ="+" id= "plusBtn" class="btn"/>  <input type ="button" value ="-" id= "minusBtn"class="btn" />  <input type="button" id="imgUpload" value="사진업로드" class="btn btn-primary"/>
					</div>
  				   </form>
  				   
	        	</div> 
  				   
	        	
	        <div style = "float: left; align:right; width : 50%">
        	<form action="lookbook_write.do" method="post" name="postFrm" id="postFrm">
     				<input type ="hidden" value="${num }" name = "lb_posts_num"/>		
        	<div>
        		작성자 : <input type="text" name="member_id" value="${sessionScope.id }" readonly="readonly" class="inputBox"/>
        	</div>	
        	<br/>
			<div>
        		<input type="text" class="text" placeholder="제목을 입력해주세요." name="lb_title" id="title"/>
			</div>
			<br/>
	        	<div>
        		<textarea id="summernote" name="lb_contents"></textarea>
	        	</div>
        	</form>
	        </div>	
        	
        	<div style = "padding-left : 760px;">
        			
        		<label style ="color : RED">* 글을 올리기전 사진업로드 버튼을 먼저 눌러주세요!!</label> <input type="button" value="올리기" class="btn btn-info" id="write" onclick="sendView()"/> <input type="button" value="취소" class="btn btn-danger" id="cancel" onclick="popupCancel()"/>
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
                    <li>주소 : 서울특별시 강남구 테헤란로 132(역삼동)<iframe id="id" name="param" style="width:1px; height:1px"></iframe> </li>
                    <li>한독약품빌딩 8층 쌍용교육센터</li>
                 
                </ul>
            </div>
        </div>
    </footer>
    <!-- footer end -->
</body>
</html>