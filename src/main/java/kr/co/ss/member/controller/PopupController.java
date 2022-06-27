package kr.co.ss.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PopupController {
	
	/**
	 * 실패 팝업창
	 * @return
	 */
	@GetMapping(value = "/login/fail.do")
	public String loginFailPopup() {
		
		return "prj3/login/process/fail";
	}
	
	/**
	 * 비밀번호 변경실패 팝업창
	 * @return
	 */
	@GetMapping(value = "/login/password_fail.do")
	public String pwFailPopup() {
		
		return "prj3/login/process/member_fail";
	}
	
	/**
	 * 비밀번호 변경성공 팝업창
	 * @return
	 */
	@GetMapping(value = "/login/password_success.do")
	public String pwSuccessPopup() {
		
		return "prj3/login/process/password_update";
	}
	
	/**
	 * 회원정보 변경성공 팝업창
	 * @return
	 */
	@GetMapping(value = "/login/member_success.do")
	public String memberSuccessPopup() {
		
		return "prj3/login/process/member_update";
	}
	
	/**
	 * 회원탈퇴 팝업창
	 * @return
	 */
	@GetMapping(value = "/login/withdrawal_success.do")
	public String withdrawalPopup() {
		
		return "prj3/login/process/member_secession";
	}
	
	/**
	 * 화원가입 중복확인
	 * @return
	 */
	@GetMapping(value = "/login/idCheck.do")
	public String idCheckPopup() {
		
		return "prj3/login/process/id_check";
	}
	
	/**
	 * 아이디 찾기 성공
	 * @return
	 */
	@GetMapping(value = "/login/idFindSuccess.do")
	public String idFindSuccessPopup() {

		return "prj3/login/process/id_find";
	}
	
	/**
	 * 비밀번호 찾기 성공
	 * @return
	 */
	@GetMapping(value = "/login/pwFindSuccess.do")
	public String pwFindSuccessPopup() {

		return "prj3/login/process/pw_find";
	}
}