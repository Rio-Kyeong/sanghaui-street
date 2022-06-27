package kr.co.ss.product.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.ss.product.service.ProductService;

@Controller
public class ProductListController {
	
	@RequestMapping(value = "/product/prod_top.do", method = {GET,POST})
	public String selectProductListTopUser(Model model) {
		
		ProductService ps = new ProductService();
		model.addAttribute("topList", ps.selectProductListTopUser());
		
		return "prj3/product/prod_top";
	}//selectProductListTopUser
	
	@RequestMapping(value = "/product/prod_bot.do", method = {GET, POST})
	public String selectProductListBotUser(Model model) {
		
		ProductService ps = new ProductService();
		model.addAttribute("botList", ps.selectProductListBotUser());
		
		return "prj3/product/prod_bot";
	}//selectProductListBotUser
	
}//class
