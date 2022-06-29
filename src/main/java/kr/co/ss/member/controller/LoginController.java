package kr.co.ss.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import kr.co.ss.member.domain.AdminLoginInfoDomain;
import kr.co.ss.member.domain.IdFindDomain;
import kr.co.ss.member.domain.LoginInfoDomain;
import kr.co.ss.member.domain.MemberSearchDomain;
import kr.co.ss.member.service.MemberServiceImp;
import kr.co.ss.member.vo.AdminLoginVO;
import kr.co.ss.member.vo.LoginVO;
import kr.co.ss.member.vo.MemberUpdateVO;
import kr.co.ss.member.vo.MemberVO;
import kr.co.ss.member.vo.PasswordUpdateVO;
import kr.co.ss.member.vo.SearchIdVO;
import kr.co.ss.member.vo.SearchPwVO;

import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes({"id","adminId"})
public class LoginController {
	
	private final MemberServiceImp ms;
	
	@Autowired
	public LoginController(MemberServiceImp ms) {
		this.ms = ms;
	}

	/**
	 * 로그인 페이지 이동
	 * @return
	 */
	@GetMapping(value = "/login/login.do")
	public String loginForm() {
		
		return "prj3/login/login";
	}
	
	/**
	 * 로그인
	 * @return
	 */
	@GetMapping(value = "/login/loginTry.do")
	public String loginProcess(@ModelAttribute LoginVO lVO, Model model) {
		
		String url = "";

		LoginInfoDomain lid = ms.searchLogin(lVO);

		if(lid == null || lid.getMember_withdrawal().equals("Y")){
			model.addAttribute("loginFail","loginFail"); //만약 login 정보가 없거나 탈퇴 정보가 Y이면
			url = "prj3/login/login";
		}else {
			String id = lid.getMember_id();
			model.addAttribute("id", id); //session
			url = "forward:/main/main_all.do"; //forward를 이용해서 main페이지로 이동
		}
		return url;
	}
	
	/**
	 * 로그아웃
	 * @param ss
	 * @return
	 */
	@GetMapping(value = "/login/logout.do")
	public String logoutProcess(SessionStatus ss) {
		
		ss.setComplete();
		
		return "prj3/login/process/logout";
	}
	
	/**
	 * 관리자 로그인 페이지 이동
	 * @return
	 */
	@GetMapping(value = "/login/admin_login.do")
	public String adminLoginForm() {
		
		return "prj3/login/admin_login";
	}
	
	/**
	 * 관리자 로그인
	 * @param alVO
	 * @param model
	 * @return
	 */
	@GetMapping(value = "/login/AdminloginTry.do")
	public String adminLoginProcess(@ModelAttribute AdminLoginVO alVO, Model model) {
		
		String url = "";

		AdminLoginInfoDomain alid = ms.searchAdminLogin(alVO);
		
		if(alid == null){
			model.addAttribute("loginFail","loginFail"); //관리자 로그인 실패
			url = "prj3/login/admin_login";
		}else {			
			String adminId = alid.getAdmin_id();
			model.addAttribute("adminId", adminId);//session
			url = "forward:/admin/admin_main.do";
		}	
		return url;
	}
	
	/**
	 * 회원가입 이동
	 * @return
	 */
	@GetMapping(value = "/login/join.do")
	public String joinForm() {
		
		return "prj3/login/join";
	}
	
	
	/**
	 * 회원가입
	 * @param mVO
	 * @param model
	 * @return
	 */
	@PostMapping(value = "/login/join_success.do")
	public String joinSuccessProcess(@ModelAttribute MemberVO mVO, Model model) {
		
		int cnt = 0;
		String url = "";
		
		model.addAttribute("name", mVO.getMember_name());
		model.addAttribute("id", mVO.getMember_id());

		cnt = ms.addMember(mVO);
		
		if(cnt == 1) {
			url = "prj3/login/process/join_success";
		}else {
			url = "prj3/login/process/join_fail";
		}
		return url;
	}
		
	/**
	 * 아이디 찾기 페이지 이동
	 * @return
	 */
	@GetMapping(value = "/login/id_find.do")
	public String idFindForm() {

		return "prj3/login/id_find_form";
	}
	
	/**
	 * 비밀번호 찾기 페이지 이동 
	 * @return
	 */
	@GetMapping(value = "/login/pw_find.do")
	public String pwFindForm() {

		return "prj3/login/pw_find_form";
	}
	
	/**
	 * 마이페이지(회원 정보 출력)
	 * @return
	 */
	@GetMapping(value = "/login/member.do")
	public String memberForm(HttpSession ss, Model model) {
		
		String url ="";
		
		 if(ss.getAttribute("id") == null) {
			 url = "prj3/login/login";
		 }else {
			 //Object형으로 업캐스팅을 했으므로, 가져올 땐 원래대로 다운캐스팅
			 MemberSearchDomain msd = ms.searchMemberInfo((String)ss.getAttribute("id"));
			 model.addAttribute("memberInfo", msd);
			 url = "prj3/login/member";
		 } 
		 return url;
	}
	
	/**
	 * 비밀번호 변경 페이지 이동
	 * @return
	 */
	@GetMapping(value = "/login/password.do")
	public String memberPwForm(HttpSession ss) {
		
		ss.getAttribute("id");
		return "prj3/login/password";
	}
	
	/**
	 * 비밀번호 변경
	 * @param id
	 * @param puVO
	 * @param model
	 * @return
	 */
	@PostMapping(value = "/login/password_update.do")
	public String memberPwProcess(@ModelAttribute PasswordUpdateVO puVO, Model model) {
		
		int cnt = 0;
		String url ="";
		
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
	@GetMapping(value = "login/withdrawal_process.do")
	public String removeMemberProcess(@RequestParam(value = "id") String id, Model model) {
		
		int cnt=0;
		String url ="";

		cnt = ms.removeMember(id);
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
	@GetMapping(value = "/login/idDup.do")
	public String searchIdDup(@RequestParam(value = "id") String id, Model model) {
		
		boolean dupFlag = false;
		String msg = null;

		dupFlag = ms.searchIdDup(id);
		
		if(dupFlag == true) {
			msg = id + "는 이미 존재하는 아이디 입니다. 다른 아이디를 입력해주세요.";
			model.addAttribute("dup", msg);

		}else {
			msg = id + "는 사용가능 합니다. 사용하시겠습니까?<a href=\"#void\"onclick=\"useId('"+ id +"')\">사용";
			model.addAttribute("dup", msg);
		}
		return "prj3/login/process/id_check_text";
	}
	
	/**
	 * 아이디 찾기
	 * @param sVO
	 * @param model
	 * @return
	 */
	@PostMapping(value = "/login/idSearch.do")
	public String SearchId(@ModelAttribute SearchIdVO sIVO, Model model) {
		
		IdFindDomain ifd = ms.SearchId(sIVO);
		
		if(ifd != null) { 
			model.addAttribute("idFind",ifd);	
			model.addAttribute("success","success");
		}else {
			model.addAttribute("fail","fail");
		}
		
		return "prj3/login/id_find_form";
	}
	
	/**
	 * 비밀번호 찾기(랜덤 비밀번호 생성)
	 * @param sVO
	 * @param model
	 * @return
	 */
	@PostMapping(value = "/login/pwSearch.do")
	public String SearchPw(@ModelAttribute SearchPwVO sVO, Model model) {
		
		String RandomPass = ms.SearchPw(sVO);
		
		if(RandomPass.isEmpty()) {
			model.addAttribute("fail", "fail");
		}else {
			model.addAttribute("success", "success");
			model.addAttribute("RandomPass", RandomPass);
		}
		return "prj3/login/pw_find_form";
	}
	
	/**
	 * 마이페이지(정보수정)
	 * @param muVO
	 * @param model
	 * @return
	 */
	@PostMapping(value = "/login/memberUpdate.do")
	public String modifyMember(@ModelAttribute MemberUpdateVO muVO, Model model) {
		
		int cnt = 0;
		
		cnt = ms.modifyMember(muVO);
		
		if(cnt == 1) {
			model.addAttribute("success","success");
		}else {
			model.addAttribute("fail","fail");			
		}		
		return "prj3/login/member";
	}
}
