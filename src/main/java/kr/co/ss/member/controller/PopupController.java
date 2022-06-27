package kr.co.ss.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PopupController {
	
	/**
	 * ���� �˾�â
	 * @return
	 */
	@GetMapping(value = "/login/fail.do")
	public String loginFailPopup() {
		
		return "prj3/login/process/fail";
	}
	
	/**
	 * ��й�ȣ ������� �˾�â
	 * @return
	 */
	@GetMapping(value = "/login/password_fail.do")
	public String pwFailPopup() {
		
		return "prj3/login/process/member_fail";
	}
	
	/**
	 * ��й�ȣ ���漺�� �˾�â
	 * @return
	 */
	@GetMapping(value = "/login/password_success.do")
	public String pwSuccessPopup() {
		
		return "prj3/login/process/password_update";
	}
	
	/**
	 * ȸ������ ���漺�� �˾�â
	 * @return
	 */
	@GetMapping(value = "/login/member_success.do")
	public String memberSuccessPopup() {
		
		return "prj3/login/process/member_update";
	}
	
	/**
	 * ȸ��Ż�� �˾�â
	 * @return
	 */
	@GetMapping(value = "/login/withdrawal_success.do")
	public String withdrawalPopup() {
		
		return "prj3/login/process/member_secession";
	}
	
	/**
	 * ȭ������ �ߺ�Ȯ��
	 * @return
	 */
	@GetMapping(value = "/login/idCheck.do")
	public String idCheckPopup() {
		
		return "prj3/login/process/id_check";
	}
	
	/**
	 * ���̵� ã�� ����
	 * @return
	 */
	@GetMapping(value = "/login/idFindSuccess.do")
	public String idFindSuccessPopup() {

		return "prj3/login/process/id_find";
	}
	
	/**
	 * ��й�ȣ ã�� ����
	 * @return
	 */
	@GetMapping(value = "/login/pwFindSuccess.do")
	public String pwFindSuccessPopup() {

		return "prj3/login/process/pw_find";
	}
}