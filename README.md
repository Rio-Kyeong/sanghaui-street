# SANGHAUI STREET Web Shopping mall

**Spring Framework, MyBatis를 이용한 패션 쇼핑몰 웹 페이지 구현 팀 프로젝트**

사용자들이 직접 회원가입을 통해 로그인 후 상품구매, 게시판 작성을 할 수 있으며,<br/>
관리자 페이지를 통해 상품, 게시글, 회원을 관리할 수 있는 웹 쇼핑몰 구현

## 참여 인원
* 팀원 : 유경우 현병호 진재혁 김다은 이예림

## 담당업무
- 유경우
  * 로그인(Login), 회원가입(Join) 사용자 페이지 구현
  * 메인(Main) 페이지 구현
  
- 현병호
  * 관리자(Admin) 페이지 구현
  
- 진재혁
  * 게시판(Lookbook) 페이지 구현
  
- 김다은
  * 상품(Product) 페이지 구현
  
- 이예림
  * 주문(Order) 페이지 구현

## 개발 기간
* 2021년 6월 14일 ~ 6월 28일(15일)

## 개발 환경
![develoment](https://github.com/RyuKyeongWoo/spring_web_team-project/blob/main/image/DevelopmentEnvironment.PNG)

## Entity-Relationship Diagram
![ERD](https://github.com/RyuKyeongWoo/spring_web_team-project/blob/main/image/ERD.png)

## 사용자(Member) Class Diagram
![CLASS](https://github.com/RyuKyeongWoo/spring_web_team-project/blob/main/image/ClassDiagram.png)

## 사용자(Member) 구현 내용
<pre>
<b>Join</b>

- 아이디 중복 확인 자식 창을 제공하며 AJAX 비동기 방식을 통해 아이디 사용 가능/불가능 텍스트를 반환합니다.
  (아이디 사용 링크를 클릭하면 부모 창에 아이디가 입력됩니다)
- Daum 우편변호 API를 사용하여 우편번호와 기본주소를 반환합니다.
- 회원가입 완료 시 사용자 정보들은 DB에 입력되며, 비밀번호는 개인정보 보호를 위해서 MD5 암호화 후 입력합니다.

<img src="https://github.com/RyuKyeongWoo/spring_web_team-project/blob/main/image/join.png"/>
</pre>

<pre>
<b>ID/Password Fine</b>

- 회원의 이름과 이메일을 입력받아 자식 창으로 아이디와 가입 일을 반환받을 수 있습니다.
- 비밀번호는 새로운 랜덤 임시 비밀번호를 발급받아서 로그인을 할 수 있습니다.
  (새로운 랜덤 임시 비밀번호는 MD5로 암호화되어 DB에 갱신됩니다)
    
<img src="https://github.com/RyuKyeongWoo/spring_web_team-project/blob/main/image/fine.png"/>
</pre>

<pre>
<b>Login</b>

- 로그인된 해당 아이디는 session을 통해 유지가 되며, 게시판과 마이페이지 그리고 상품 구매를 할 수 있습니다.
- 로그아웃은 우측 상단에서 가능하며, 로그아웃 시 해당 session은 삭제되기 때문에 
  게시판과 마이페이지 그리고 상품 구매를 할 수 없습니다.
  
<img src="https://github.com/RyuKyeongWoo/spring_web_team-project/blob/main/image/login.png"/>
</pre>

<pre>
<b>MyPage</b>

- 회원 탈퇴 시 해당 회원의 데이터는 탈퇴 여부를 N에서 Y로 변경해 주어 관리해 준다.(로그인 불가능)
- 회원의 정보 변경 페이지와 비밀번호 변경 페이지를 분리해 주어 회원의 정보를 변경할 때마다 
  비밀번호도 같이 변경해 주어야 하는 단점을 보완하였습니다.

<img src="https://github.com/RyuKyeongWoo/spring_web_team-project/blob/main/image/MyPage.png"/>
</pre>
