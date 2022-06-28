package kr.co.ss.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.ss.product.domain.ProductListUserDomain;
import kr.co.ss.product.service.ProductService;

@Controller
public class MainController {
	
	private final ProductService ps;
	
	@Autowired
	public MainController(ProductService ps) {
		this.ps = ps;
	}
	
	@GetMapping(value = "/main/main_all.do")
	public String mainForm(Model model) {
		List<ProductListUserDomain> topList = ps.selectProductListTopUser();
		model.addAttribute("topList", topList);
		
		List<ProductListUserDomain> botList = ps.selectProductListBotUser();
		model.addAttribute("botList", botList);
		
		return "prj3/main/main_all";
	}
}
