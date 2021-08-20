package kr.co.ss.lookbook.service;

import kr.co.ss.lookbook.dao.FileUploadDAO;
import kr.co.ss.lookbook.vo.FileUploadVO;

public class FileUploadService {

	
	public int addLbImg(FileUploadVO fuVO) {
		
		FileUploadDAO fuDAO = new FileUploadDAO();
		
		return fuDAO.insertLbImg(fuVO);
	}
}
