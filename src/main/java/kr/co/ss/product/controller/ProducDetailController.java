package kr.co.ss.product.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import kr.co.ss.product.service.ProductService;

@Controller
@SessionAttributes("id")
public class ProducDetailController {
	
	@RequestMapping(value = "/product/prod_detail.do", method = {GET, POST})
	public String selectProductDetailUser(@RequestParam(value = "prod_num")int prod_num, Model model, HttpSession ss) {
		//System.out.println(prod_num);
		String url = "";
		String id = (String) ss.getAttribute("id");
		
		ProductService ps = new ProductService();
		
		model.addAttribute("prodList", ps.selectProductDetailUser(prod_num));
		
		if(id != null) {
			model.addAttribute("id", id);
		}
		
		url = "prj3/product/prod_detail"; 

		return url;
	}//selectProductDetailUser
}//class
