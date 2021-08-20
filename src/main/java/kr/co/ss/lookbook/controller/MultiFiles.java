package kr.co.ss.lookbook.controller;

import org.springframework.web.multipart.MultipartFile;

public class MultiFiles {
	private String title;
	private MultipartFile[] upfile1;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public MultipartFile[] getUpfile1() {
		return upfile1;
	}
	public void setUpfile1(MultipartFile[] upfile1) {
		this.upfile1 = upfile1;
	}
	
	
}
