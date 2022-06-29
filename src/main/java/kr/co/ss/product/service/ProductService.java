package kr.co.ss.product.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.co.ss.product.dao.ProductDAO;
import kr.co.ss.product.domain.ProductDetailUserDomain;
import kr.co.ss.product.domain.ProductListUserDomain;

@Service
public class ProductService {

	/**
	 * 상의 목록
	 * @return
	 */
	public List<ProductListUserDomain> selectProductListTopUser(){
		ProductDAO pDAO = new ProductDAO();
		
		return pDAO.selectProductListTopUser();
	}//selectProductListTopUser
	
	/**
	 * 하의 목록
	 * @return
	 */
	public List<ProductListUserDomain> selectProductListBotUser(){
		ProductDAO pDAO = new ProductDAO();
		
		return pDAO.selectProductListBotUser();
	}//selectProductListBotUser
	
	/**
	 * 상품 상세
	 * @return
	 */
	public ProductDetailUserDomain selectProductDetailUser(int prod_num){
		ProductDAO pDAO = new ProductDAO();
		
		return pDAO.selectProductDetailUser(prod_num);
	}//selectProductDetailUser
	
}
