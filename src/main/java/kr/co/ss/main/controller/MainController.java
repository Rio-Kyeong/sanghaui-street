package kr.co.ss.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.ss.product.service.ProductService;

@Controller
public class MainController {
	
	@RequestMapping(value = "/main/main_all.do")
	public String mainForm(Model model) {
		ProductService ps = new ProductService();
		model.addAttribute("topList", ps.selectProductListTopUser());
		
		ProductService ps1 = new ProductService();
		model.addAttribute("botList", ps1.selectProductListBotUser());
		
		return "prj3/main/main_all";
	}
	
	
}
