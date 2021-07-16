package kr.co.ss.lookbook.controller;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import kr.co.ss.lookbook.service.FileUploadService;
import kr.co.ss.lookbook.service.LbDetailService;
import kr.co.ss.lookbook.service.LbMainService;
import kr.co.ss.lookbook.vo.FileUploadVO;

@Controller
@SessionAttributes("id")
public class FileController {

	@Resource(name="uploadPath")
	String uploadPath;

	@RequestMapping(value="/lookbook/upload.do", method= RequestMethod.POST)
	public String fileUploads(MultiFiles multiFiles, String title, MultipartFile upfile1, Model model, HttpServletRequest reqeust,String hid) throws IllegalStateException, IOException{
		String fileName = upfile1.getOriginalFilename();
	
		
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String date = sdf.format(cal.getTime());

		int cnt =0;
		for(MultipartFile file : multiFiles.getUpfile1()) {
			
			
			File target = new File(uploadPath, hid+"_"+date+"_"+file.getOriginalFilename());
			FileUploadService fus = new FileUploadService();
			cnt = fus.addLbImg(new FileUploadVO(Integer.parseInt(hid), hid+"_"+date+"_"+file.getOriginalFilename()));
			
			file.transferTo(target);
		
		}//end for
		
		model.addAttribute("fileCnt", cnt);
		
		//return "redirect:../lookbook_main.do";
		return "prj3/lookbook/upload_process";
	}//fileUploads
	
	@RequestMapping(value="/lookbook/uploadCancel.do", method= RequestMethod.POST)
	public String fileUploadCancel(int hid, Model model) {
		
		LbMainService lms = new LbMainService();
		List<String> imgList = lms.searchLbMainImg(hid);
		for(int i =0; i< imgList.size(); i++) {
			File file = new File(uploadPath+imgList.get(i));
			file.delete();
		}

		LbDetailService lds = new LbDetailService();
		lds.removeImgLb(hid);
		int cnt = 2;
		model.addAttribute("fileCnt", cnt);
		
		//return "redirect:../lookbook_main.do";
		return "prj3/lookbook/upload_process";
	}//fileUploads
	

}
