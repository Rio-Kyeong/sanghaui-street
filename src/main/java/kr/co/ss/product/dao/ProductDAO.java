package kr.co.ss.product.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.ss.connection.MyBatisHandler;
import kr.co.ss.product.domain.ProductDetailUserDomain;
import kr.co.ss.product.domain.ProductListUserDomain;

@Repository
public class ProductDAO {

	public ProductDAO() {
		org.apache.ibatis.logging.LogFactory.useLog4JLogging();
	}//ProductDAO
	
	
	/**
	 * 상의 목록
	 * @return
	 */
	public List<ProductListUserDomain> selectProductListTopUser(){
		List<ProductListUserDomain> list=null;
		//1. MyBatis Handler 얻기
		SqlSession ss = MyBatisHandler.getInstance().getHandler();
		//2. id에 해당하는 쿼리를 찾아서 실행한 후 결과 얻기
		list = ss.selectList("kr.co.ss.product.productListUserMapper.productListTopUser");
		//3. 연결끊기
		if(ss!=null) {ss.close();}//end if
		
		return list;
	}//selectProductListTopUser
	
	/**
	 * 하의 목록
	 * @return
	 */
	public List<ProductListUserDomain> selectProductListBotUser(){
		List<ProductListUserDomain> list=null;
		//1. MyBatis Handler 얻기
		SqlSession ss = MyBatisHandler.getInstance().getHandler();
		//2. id에 해당하는 쿼리를 찾아서 실행한 후 결과 얻기
		list = ss.selectList("kr.co.ss.product.productListUserMapper.productListBotUser");
		//3. 연결끊기
		if(ss!=null) {ss.close();}//end if
		
		return list;
	}//selectProductListBotUser
	
	/**
	 * 상품 상세
	 * @return
	 */
	public ProductDetailUserDomain selectProductDetailUser(int prod_num){
		ProductDetailUserDomain pduDomain = null;
		//1. MyBatis Handler 얻기
		SqlSession ss = MyBatisHandler.getInstance().getHandler();
		//2. id에 해당하는 쿼리를 찾아서 실행한 후 결과 얻기
		pduDomain = ss.selectOne("kr.co.ss.product.productDetailUserMapper.productDetailUser", prod_num);
		//3. 연결끊기
		if(ss!=null) {ss.close();}//end if	
		
		return pduDomain;
	}//selectProductDetailUser
	
	
}//class
