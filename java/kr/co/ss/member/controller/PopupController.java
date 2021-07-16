package kr.co.ss.member.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class PopupController {
	
	
	/**
	 * 실패 팝업창
	 * @return
	 */
	@RequestMapping(value = "/login/fail.do", method = GET)
	public String loginFailPopup() {
		
		return "prj3/login/process/fail";
	}
	
	/**
	 * 비밀번호 변경실패 팝업창
	 * @return
	 */
	@RequestMapping(value = "/login/password_fail.do", method = GET)
	public String pwFailPopup() {
		
		return "prj3/login/process/member_fail";
	}
	
	/**
	 * 비밀번호 변경성공 팝업창
	 * @return
	 */
	@RequestMapping(value = "/login/password_success.do", method = GET)
	public String pwSuccessPopup() {
		
		return "prj3/login/process/member_update";
	}
	
	/**
	 * 회원탈퇴 팝업창
	 * @return
	 */
	@RequestMapping(value = "/login/withdrawal_success.do", method = GET)
	public String withdrawalPopup() {
		
		return "prj3/login/process/member_secession";
	}
	
	/**
	 * 화원가입 중복확인
	 * @return
	 */
	@RequestMapping(value = "/login/idCheck.do", method = GET)
	public String idCheckPopup() {
		
		return "prj3/login/process/id_check";
	}
	
	/**
	 * 아이디 찾기 성공
	 * @return
	 */
	@RequestMapping(value = "/login/idFindSuccess.do", method = GET)
	public String idFindSuccessPopup() {

		return "prj3/login/process/id_find";
	}
	
	/**
	 * 비밀번호 찾기 성공
	 * @return
	 */
	@RequestMapping(value = "/login/pwFindSuccess.do", method = GET)
	public String pwFindSuccessPopup() {

		return "prj3/login/process/pw_find";
	}
	
	

}
