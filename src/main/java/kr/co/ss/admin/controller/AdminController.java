package kr.co.ss.admin.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.co.ss.admin.domain.AdminLBListDomain;
import kr.co.ss.admin.domain.AdminUsersDomain;
import kr.co.ss.admin.domain.ProductListAdminDomain;
import kr.co.ss.admin.service.AdminService;
import kr.co.ss.admin.vo.ProductDeleteVO;
import kr.co.ss.admin.vo.ProductInsertVO;
import kr.co.ss.admin.vo.ProductModifyVO;
import kr.co.ss.admin.vo.UserDeleteVO;

@Controller
@SessionAttributes("adminId")
public class AdminController {
	
	/**
	 * 상품목록 페이지
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/admin/admin_main.do",method={GET,POST})
	public String adminProdList(Model model) {
		
	AdminService as=new AdminService();
	List<ProductListAdminDomain> prodList=as.adminProdList();
	model.addAttribute("prodList",prodList);
		
		return "prj3/admin/admin_main";
	}//adminProdList
	
	
	/**
	 * 회원목록 페이지
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/admin/admin_users.do",method={GET,POST})
	public String adminUsersList(Model model) {
		
		AdminService as=new AdminService();
		List<AdminUsersDomain> usersList=as.adminUsersList();
		model.addAttribute("usersList",usersList);
		
		return "prj3/admin/admin_users";
	}//adminUsersList
	
	
	/**
	 * 게시글목록 페이지
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/admin/admin_lookbooks.do",method={GET,POST})
	public String adminLBList(Model model) {
		
		AdminService as=new AdminService();
		List<AdminLBListDomain> LBList=as.adminLBList();
		model.addAttribute("LBList",LBList);
		
		return "prj3/admin/admin_lookbooks";
	}//adminLBList
	
	
	/**
	 * 상품상세정보
	 * @param prod_num
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/admin/admin_prod_info.do",method={GET,POST})
	public String AdminProdInfo(int prod_num,Model model) {
		
		AdminService as=new AdminService();
		model.addAttribute("prodInfo",as.searchProductInfo(prod_num));
		
		return "prj3/admin/admin_prod_info";
	}//AdminProdInfo
	
	
	/**
	 * 회원상세정보
	 * @param member_id
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/admin/admin_user.do",method={GET,POST})
	public String AdminUserInfo(String member_id,Model model) {
		
		AdminService as=new AdminService();
		model.addAttribute("userInfo",as.searchUserInfo(member_id));
		
		return "prj3/admin/admin_user";
	}//AdminUserInfo
	
	
	/**
	 * 룩북보기
	 * @param lb_posts_num
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/admin/admin_lookbook.do",method={GET,POST})
	public String AdminLBInfo(int lb_posts_num,Model model) {
		
		AdminService as=new AdminService();
		model.addAttribute("LBInfo",as.searchLBInfo(lb_posts_num));
		model.addAttribute("LBImg",as.LBImgList(lb_posts_num));
		return "prj3/admin/admin_lookbook";
	}//AdminUserInfo
	
	
	/**
	 * 상품추가 폼
	 * @return
	 */
	@RequestMapping(value="/admin/admin_prod_addFrm.do",method={GET,POST})
	public String AdminProdAddFrm() {
		
	
		
		return "prj3/admin/prod_addFrm";
	}//AdminProdAddFrm
	
	
	/**
	 * 상품추가
	 * @return
	 */
	@RequestMapping(value="/admin/admin_prodAdd_proc.do",method={POST})
	public String AdminProdAddProc(HttpServletRequest hsr, ProductInsertVO piVO) {
		AdminService as=new AdminService();
		
		String savePath="C:/dev/workspace/team_prj3/src/main/webapp/product_photo_upload";
		int maxSize=500*500*7;
		String encType="UTF-8";
		MultipartRequest mr=null;
		try {
		mr=new MultipartRequest(hsr,savePath,maxSize,encType,new DefaultFileRenamePolicy());
		} catch (IOException e) {
			e.printStackTrace();
		}//catch
		
		String prod_img=mr.getFilesystemName("prod_img");
		String prod_name=mr.getParameter("prod_name");
		String prod_price=mr.getParameter("price");
		String prod_cat=mr.getParameter("category");
		String prod_detail=mr.getParameter("prod_detail");
		
		
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd-a hh:mm:ss EEEE");
		Date date=new Date();
		String add_date= String.valueOf(sdf.format(date));
		
		String withdrawl="N";
		
		piVO.setProd_explain(prod_detail);
		piVO.setProd_cat(prod_cat);
		piVO.setProd_name(prod_name);
		piVO.setProd_price(prod_price);
		piVO.setProd_add_date(add_date);
		piVO.setProd_delete(withdrawl);
		piVO.setProd_image(prod_img);
		as.insertProd(piVO);
		
		return "redirect:admin_main.do";
	}//AdminProdAddProc
	
	
	/**
	 * 상품수정
	 * @return
	 */
	@RequestMapping(value="/admin/admin_prodMod_proc.do",method={POST})
	public String AdminProdUpdateProc(HttpServletRequest hsr,ProductModifyVO pmVO) {
		AdminService as=new AdminService();
		
		String savePath="C:/dev/workspace/team_prj3/src/main/webapp/product_photo_upload";
		int maxSize=500*500*7;
		String encType="UTF-8";
		MultipartRequest mr=null;
		try {
			mr=new MultipartRequest(hsr,savePath,maxSize,encType,new DefaultFileRenamePolicy());
		} catch (IOException e) {
			e.printStackTrace();
		}//catch
		
		System.out.println("---------------------------------"+mr);
		String prod_img=mr.getFilesystemName("prod_img");
		
		String prod_name=mr.getParameter("prod_name");
		String prod_price=mr.getParameter("price");
		String prod_detail=mr.getParameter("prod_detail");
		int prod_num=Integer.parseInt(mr.getParameter("prod_num"));
		
		pmVO.setProd_num(prod_num);
		pmVO.setProd_explain(prod_detail);
		pmVO.setProd_name(prod_name);
		pmVO.setProd_price(prod_price);
		pmVO.setProd_image(prod_img);
		as.modifyProd(pmVO);
		
		return "redirect:admin_main.do";
	}//AdminProdUpdateProc
	
	
	/**
	 * 상품삭제
	 * @param hsr
	 * @param pdVO
	 * @return
	 */
	@RequestMapping(value="/admin/admin_prodDel_proc.do",method={GET,POST})
	public String AdminProdDeleteProc(HttpServletRequest hsr,ProductDeleteVO pdVO) {
		AdminService as=new AdminService();
		
		int prod_num=Integer.parseInt(hsr.getParameter("prod_num"));
		String withdrawl="Y";
		
		pdVO.setProd_num(prod_num);
		pdVO.setProd_delete(withdrawl);
		as.removeProd(pdVO);
		
		return "redirect:admin_main.do";
	}//AdminProdAddProc
	
	
	/**
	 * 회원탈퇴
	 * @param hsr
	 * @param pdVO
	 * @return
	 */
	@RequestMapping(value="/admin/admin_userDel_proc.do",method={GET,POST})
	public String AdminUserDeleteProc(HttpServletRequest hsr,UserDeleteVO udVO) {
		AdminService as=new AdminService();
		
		String member_id=hsr.getParameter("member_id");
		String withdrawl="Y";
		
		udVO.setMember_id(member_id);
		udVO.setMember_withdrawal(withdrawl);
		as.removeUser(udVO);
		
		return "redirect:admin_users.do";
	}//AdminUserDeleteProc
	
	
	@RequestMapping(value="/admin/admin_LBDel_proc.do",method={GET,POST})
	public String AdminLBDeleteProc(int lb_posts_num) {
		AdminService as=new AdminService();
		
		as.removeLB(lb_posts_num);
		
		return "redirect:admin_lookbooks.do";
	}//AdminLBDeleteProc

}
