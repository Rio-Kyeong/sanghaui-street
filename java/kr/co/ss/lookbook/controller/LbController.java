package kr.co.ss.lookbook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import kr.co.ss.lookbook.domain.LbCommentDomain;
import kr.co.ss.lookbook.domain.LbDetailDomain;
import kr.co.ss.lookbook.domain.LbMainAllDomain;
import kr.co.ss.lookbook.domain.LbMainDomain;
import kr.co.ss.lookbook.service.LbDetailService;
import kr.co.ss.lookbook.service.LbMainService;
import kr.co.ss.lookbook.service.LbService;
import kr.co.ss.lookbook.vo.InsertCommentVO;
import kr.co.ss.lookbook.vo.InsertUpdateLbVO;
import kr.co.ss.lookbook.vo.UpdateLbVO;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;



@Controller
@SessionAttributes("id")
public class LbController {
	
	@Resource(name="uploadPath")
	String uploadPath;
	
	/**
	 * 메인 페이지 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/lookbook/lookbook_main.do")
	public String lbMainForm(Model model) {
		
		List<LbMainAllDomain> lmadList = new ArrayList<LbMainAllDomain>();
		List<String> imgList = new ArrayList<String>();
		List<LbMainDomain> lmList = new ArrayList<LbMainDomain>();
	
		LbMainService lms = new LbMainService();
		lmadList = lms.searchLbMainAll();
		
		for(int i =0; i < lmadList.size(); i ++) {
			
			imgList = lms.searchLbMainImg(lmadList.get(i).getLb_posts_num());
			
			lmList.add(new LbMainDomain(lmadList.get(i).getLb_posts_num(),lmadList.get(i).getMember_id(),lmadList.get(i).getLb_title(), imgList));
			
	
		}
		model.addAttribute("testList", lmList);
		
		
		//model.addAttribute("lbList", lmadList);
		//model.addAttribute("imgList", imgList);
		
		return "prj3/lookbook/lookbook_main";
	}
	
	/**
	 * 메인페이지> 내룩북보기
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/lookbook/lookbook_myMain.do")
	public String lbMyMainForm(String id, Model model) {
		
		List<LbMainAllDomain> lmadList = null;
		List<String> imgList = null;
		List<LbMainDomain> lmList = new ArrayList<LbMainDomain>();

		LbMainService lms = new LbMainService();
		lmadList = lms.searchLbMyMainAll(id);
		
		for(int i =0; i < lmadList.size(); i ++) {
			
			imgList = lms.searchLbMainImg(lmadList.get(i).getLb_posts_num());
			
			lmList.add(new LbMainDomain(lmadList.get(i).getLb_posts_num(),lmadList.get(i).getMember_id(),lmadList.get(i).getLb_title(), imgList));
			
			
		}
		
		model.addAttribute("testList", lmList);
		model.addAttribute("lbList", lmadList);
		model.addAttribute("imgList", imgList);
		
		return "prj3/lookbook/lookbook_main";
	}
	
	/**
	 * 댓글 보기
	 * @param num
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/lookbook/write_comment.do", method= GET)
	public String writeCommentForm(@RequestParam(value="num") int num, Model model) {
		LbDetailDomain ldDomain = null;
		List<String> imgList = null;
		List<LbCommentDomain> lcList = null;
		
		LbDetailService lds = new LbDetailService();
		LbMainService lms = new LbMainService();
		
		ldDomain = lds.searchLbDetail(num);
		imgList = lms.searchLbMainImg(num);
		lcList = lds.searchLbComments(num);
				
		
		model.addAttribute("detailLb",ldDomain);
		model.addAttribute("detailImg",imgList);
		model.addAttribute("comments",lcList);
		
		return "prj3/lookbook/lookbook_comment";
	}//writeCommentForm
	
	
	
	
	@RequestMapping(value="/lookbook/write.do", method= {GET,POST})
	public String writeForm(Model model) {
		
		LbService ls = new LbService();
		ls.addPostNo();
		
		String num = ls.searchPostNo();
		model.addAttribute("num", num);
		
		
		

		return "prj3/lookbook/lookbook_write";
	}//writeCommentForm
	

	
	
	@RequestMapping(value="/lookbook/upload_form.do", method= POST)
	public String uploadForm() {
		return "prj3/lookbook/upload_process";
	}
	
	@RequestMapping(value="/lookbook/lookbook_write.do", method= {GET,POST})
	public String modifyWrite(InsertUpdateLbVO iulVO, Model model) {
		
		String path="";
		LbService ls = new LbService();
		int cnt = ls.addModifyLb(iulVO);
		
		if( cnt == 0) {
			path = "prj3/lookbook/errorPage/errorPage";
		}else {
			path ="redirect:lookbook_main.do";
			model.addAttribute("cnt", cnt);
		}
		
		return path;
	}//modifyWrite
	
	
	
	@RequestMapping(value="/lookbook/LbWriteCancel.do", method= {GET,POST})
	public String lbWriteCancel() {
		
		return "prj3/lookbook/popup/message_cancel";
	}
	
	@RequestMapping(value="/lookbook/lbCencleDelete.do", method= {GET,POST})
	public String lbCencleDelete(@RequestParam(value="num") int num) {
		
		LbService ls = new LbService();
		LbMainService lms = new LbMainService();
		int lbImgNoCnt = ls.searchLbImgNoCnt(num);
		
		
		if(lbImgNoCnt > 0) {
			List<String> imgList = lms.searchLbMainImg(num);
			for(int i =0; i< imgList.size(); i++) {
				File file = new File(uploadPath+imgList.get(i));
				file.delete();
			}
			
			ls.removeLbImgNo(num);
			ls.removeLbNo(num);
			 
			
		}else {
			ls.removeLbNo(num);
			
		}
		
		return "prj3/lookbook/popup/message_cancel";
	}
	
	@RequestMapping(value="/lookbook/lookbook_write_process.do", method = {GET,POST})
	public String lbAddComment(InsertCommentVO icVO,Model model ) {
		LbDetailService lds = new LbDetailService();
		int cnt = lds.addComment(icVO);
		
		return "redirect:write_comment.do?num="+icVO.getLb_posts_num();
	}
	
	@RequestMapping(value="/lookbook/deleteLb.do", method= {GET,POST})
	public String lbDelete() {
		
		return "prj3/lookbook/popup/message_delete";
	}
	
	@RequestMapping(value="/lookbook/deleteComplate.do", method= {GET,POST})
	public String lbDeleteProcess(@RequestParam(value="num") int lb_posts_num) {
		
		
		LbDetailService lds = new LbDetailService();
		LbMainService lms = new LbMainService();
		
		
		List<String> imgList = lms.searchLbMainImg(lb_posts_num);
		for(int i =0; i< imgList.size(); i++) {
			File file = new File(uploadPath+imgList.get(i));
			file.delete();
		}
		
		lds.removeImgLb(lb_posts_num);
		lds.removeComment(lb_posts_num);
		lds.removeLb(lb_posts_num);
			

				
	
		return "prj3/lookbook/popup/message_delete2";
	}
	
	
	@RequestMapping(value="/lookbook/deleteComm.do", method= {GET,POST})
	public String commDelete() {
		
		return "prj3/lookbook/popup/comment_delete";
	}
	
	@RequestMapping(value="/lookbook/deleteCommComplate.do", method= {GET,POST})
	public String commDeleteProcess(@RequestParam(value="commNum") int lb_comments_num) {
		
		
		LbDetailService lds = new LbDetailService();
		lds.removeDetailComment(lb_comments_num);
		
		
		return "prj3/lookbook/popup/comment_delete2";
	}
	
	
	
	/**
	 * 상세보기에서 수정
	 * @param num
	 * @return
	 */
	@RequestMapping(value="/lookbook/updateDetail.do", method= {GET,POST})
	public String detailUpdate(@RequestParam(value="num")int num, Model model) {
		
		LbDetailDomain ldDomain = null;
		List<String> imgList = null;
		
		LbDetailService lds = new LbDetailService();
		LbMainService lms = new LbMainService();
		
		ldDomain = lds.searchLbDetail(num);
		imgList = lms.searchLbMainImg(num);
				
		
		model.addAttribute("detailLb",ldDomain);
		model.addAttribute("detailImg",imgList);
		
		return "prj3/lookbook/lookbook_update";
	}
	
	@RequestMapping(value="/lookbook/updateProcess.do", method= {GET,POST})
	public String processUpdate(UpdateLbVO ulVO, Model model) {
		
		String path ="";
		LbDetailService lds= new LbDetailService();
		lds.modifyLb(ulVO);
		
		path ="redirect:write_comment.do?num="+ulVO.getLb_posts_num();
		
		return path;
	}
	
}//class

