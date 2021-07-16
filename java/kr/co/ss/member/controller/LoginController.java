package kr.co.ss.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import kr.co.ss.member.domain.AdminLoginInfoDomain;
import kr.co.ss.member.domain.IdFindDomain;
import kr.co.ss.member.domain.LoginInfoDomain;
import kr.co.ss.member.domain.MemberSearchDomain;
import kr.co.ss.member.service.MemberService;
import kr.co.ss.member.vo.AdminLoginVO;
import kr.co.ss.member.vo.LoginVO;
import kr.co.ss.member.vo.MemberUpdateVO;
import kr.co.ss.member.vo.MemberVO;
import kr.co.ss.member.vo.PasswordUpdateVO;
import kr.co.ss.member.vo.SearchIdVO;
import kr.co.ss.member.vo.SearchPwVO;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes({"id","adminId"})
public class LoginController {
	
	/**
	 * 메인 페이지에서 로그인 페이지 이동
	 * @return
	 */
	@RequestMapping(value = "/login/login.do")
	public String loginForm() {
		
		return "prj3/login/login";
	}
	
	/**
	 * 로그인 실패/완료(메인 페이지로 이동)
	 * @return
	 */
	@RequestMapping(value = "/login/loginTry.do")
	public String loginProcess(LoginVO lVO, Model model) {
		
		String url = "";

		LoginInfoDomain lid = null;
		MemberService ms = new MemberService();
		lid = ms.searchLogin(lVO);

		if(lid == null || lid.getMember_withdrawal().equals("Y")){
			model.addAttribute("loginFail","loginFail"); //로그인실패 식별 값
			url = "prj3/login/login";
		}else {			
			String id = lid.getMember_id();
			model.addAttribute("id", id);//session
			url = "forward:/main/main_all.do"; //메인 상품데이터을 같이 반환
		}	
		return url;
	}
	
	/**
	 * 로그아웃
	 * @param ss
	 * @return
	 */
	@RequestMapping(value = "/login/logout.do")
	public String logoutProcess(SessionStatus ss) {
		
		ss.setComplete();
		
		return "prj3/login/process/logout";
	}
	
	/**
	 * 로그인 페이지에서 관리자 로그인 페이지 이동
	 * @return
	 */
	@RequestMapping(value = "/login/admin_login.do", method = GET)
	public String adminLoginForm() {
		
		return "prj3/login/admin_login";
	}
	
	/**
	 * 관리자 로그인
	 * @param alVO
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/login/AdminloginTry.do", method = POST)
	public String adminLoginProcess(AdminLoginVO alVO, Model model) {
		
		String url = "";

		AdminLoginInfoDomain alid = null;
		MemberService ms = new MemberService();
		alid = ms.searchAdminLogin(alVO);

		if(alid == null){
			model.addAttribute("loginFail","loginFail"); //로그인실패 식별 값
			url = "prj3/login/admin_login";
		}else {			
			String adminId = alid.getAdmin_id();
			model.addAttribute("adminId", adminId);//session
			url = "prj3/admin/admin_main";
		}	
		return url;
	}
	
	/**
	 * 로그인 페이지에서 회원가입 페이지 이동
	 * @return
	 */
	@RequestMapping(value = "/login/join.do", method = GET)
	public String joinForm() {
		
		return "prj3/login/join";
	}
	
	@RequestMapping(value = "/login/join_success.do", method = POST)
	public String joinSuccessProcess(MemberVO mVO, Model model) {
		
		int cnt = 0;
		String url = "";
		
		model.addAttribute("name", mVO.getMember_name());
		model.addAttribute("id", mVO.getMember_id());
		
		MemberService ms = new MemberService();
		cnt = ms.addMember(mVO);
		
		if(cnt == 1) {
			url = "prj3/login/process/join_success";
		}else {
			url = "prj3/login/process/join_fail";
		}
		return url;
	}
		
	/**
	 * 로그인 페이지에서 아이디찾기 페이지 이동
	 * @return
	 */
	@RequestMapping(value = "/login/id_find.do", method = GET)
	public String idFindForm() {

		return "prj3/login/id_find_form";
	}
	
	/**
	 * 로그인 페이지에서 비밀번호찾기 페이지 이동
	 * @return
	 */
	@RequestMapping(value = "/login/pw_find.do", method = GET)
	public String pwFindForm() {

		return "prj3/login/pw_find_form";
	}
	
	/**
	 * 마이페이지 이동
	 * @return
	 */
	@RequestMapping(value = "/login/member.do", method = GET)
	public String memberForm(HttpSession ss, Model model) {
		
		String url ="";
		
		
		 if(ss.getAttribute("id") == null) { 
			 url = "prj3/login/login"; 
			 }else {
			 MemberSearchDomain msd = new MemberSearchDomain();
			 MemberService ms = new MemberService();
			 msd = ms.searchMemberInfo((String)ss.getAttribute("id"));
			 model.addAttribute("memberInfo",msd);
			 url = "prj3/login/member";
			} 
		return url;
	}
	
	/**
	 * 마이페이지에서 비밀번호변경 페이지로 이동
	 * @return
	 */
	@RequestMapping(value = "/login/password.do", method = GET)
	public String memberPwForm(HttpSession ss) {
		ss.getAttribute("id");
		return "prj3/login/password";
	}
	
	/**
	 * 비밀번호 변경(팝업창을 반환)
	 * @param id
	 * @param puVO
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/login/password_update.do", method = POST)
	public String memberPwProcess(String id, PasswordUpdateVO puVO, Model model) {
		int cnt = 0;
		String url ="";
		
		puVO.setMember_id(id);
		
		MemberService ms  = new MemberService();
		cnt = ms.modifyPassword(puVO);	
		
		if(cnt == 1) {
			model.addAttribute("success","success");
				
			url = "prj3/login/password";
		}else {
			model.addAttribute("fail","fail");
			url = "prj3/login/password";
		}
		return url;
	}
	
	
	/**
	 * 회원탈퇴
	 * @param member_withdrawal
	 * @return
	 */
	@RequestMapping(value = "login/withdrawal_process.do")
	public String removeMemberProcess(String member_id, Model model) {
		
		int cnt=0;
		String url ="";
		
		MemberService ms = new MemberService();
		cnt = ms.removeMember(member_id);
		if(cnt == 1) {
			model.addAttribute("withdrawal","withdrawal");
			url = "prj3/login/member";
		}
		
		return url;
	}
	
	/**
	 * 아이디 중복확인
	 * @param idCk
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/login/idDup.do")
	public String searchIdDup(String idCk, Model model) {
		
		boolean dupFlag = false;
		String msg ="";
		String url ="";
		
		MemberService ms = new MemberService();
		dupFlag = ms.searchIdDup(idCk);
		
		if(dupFlag == true) {
			msg="는 이미 존재하는 아이디 입니다.\n다른 아이디를 입력해주세요.";
			model.addAttribute("dupTrue",msg);
			url = "prj3/login/process/id_check";
		}else {
			msg="는 사용가능 합니다. 사용하시겠습니까?";
			model.addAttribute("dupFalse",msg);
			url = "prj3/login/process/id_check";
		}
		return url;
	}
	
	/**
	 * 아이디 찾기
	 * @param sVO
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/login/idSearch.do", method = POST)
	public String SearchId(SearchIdVO sIVO, Model model) {
		IdFindDomain ifd = new IdFindDomain();
		MemberService ms = new MemberService();
		
		ifd = ms.SearchId(sIVO);
		
		if(ifd != null) { 
			model.addAttribute("idFind",ifd);	
			model.addAttribute("success","success");	
		}else {
			model.addAttribute("fail","fail");			
		}
		
		return "prj3/login/id_find_form";
	}
	
	/**
	 * 비밀번호 찾기(재설정)
	 * @param sVO
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/login/pwSearch.do", method = POST)
	public String SearchPw(SearchPwVO sVO, Model model) {
		
		MemberService ms = new MemberService();
		boolean passFlag = ms.SearchPw(sVO);
		String RandomPass = ms.addRandomPw(passFlag);
		
		if(passFlag == true) {
			
			//ID찾고 ID로 비밀번호를 변경
			SearchIdVO sIVO = new SearchIdVO();
			sIVO.setMember_name(sVO.getMember_name());
			sIVO.setMember_email(sVO.getMember_email());
			
			IdFindDomain ifd = ms.SearchId(sIVO);
			
			PasswordUpdateVO puVO = new PasswordUpdateVO();
			puVO.setMember_id(ifd.getMember_id());
			puVO.setMember_pw(RandomPass);
			ms.modifyPassword(puVO);
			
			model.addAttribute("success","success");
			model.addAttribute("RandomPass",RandomPass);
			
		}else {
			model.addAttribute("fail","fail");	
		}
		
		return "prj3/login/pw_find_form";
	}
	
	/**
	 * 회원정보 수정
	 * @param muVO
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/login/memberUpdate.do", method = POST)
	public String modifyMember(MemberUpdateVO muVO, Model model) {
		
		int cnt = 0;
		
		MemberService ms = new MemberService();
		cnt = ms.modifyMember(muVO);
		
		if(cnt == 1) {
			model.addAttribute("success","success");
		}else {
			model.addAttribute("fail","fail");			
		}
		
		return "prj3/login/member";
	}
		
}
