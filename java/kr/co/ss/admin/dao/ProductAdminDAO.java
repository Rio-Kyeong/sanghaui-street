package kr.co.ss.admin.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.ss.admin.domain.ProductDetailAdminDomain;
import kr.co.ss.admin.domain.ProductListAdminDomain;
import kr.co.ss.admin.vo.ProductDeleteVO;
import kr.co.ss.admin.vo.ProductInsertVO;
import kr.co.ss.admin.vo.ProductModifyVO;
import kr.co.ss.connection.AdminMyBatisHandler;

/**
 * 상품에 대한 동작을 쿼리문으로 정의하는 클래스
 * @author sist
 */

public class ProductAdminDAO {
	
	/**
	 * 상품 전체보기
	 * @return
	 */
	public List<ProductListAdminDomain> selectProductAll(){
		List<ProductListAdminDomain> list=null;
		SqlSession ss=AdminMyBatisHandler.getInstance().getHandler();
		list=ss.selectList("kr.co.ss.admin.prodMapper.prodList");
		if(ss!=null) {ss.close();}
		
		return list;
	}//selectProductAll
	
	
	/**
	 * 상품 하나보기
	 * @return
	 */
	public ProductDetailAdminDomain selectProductInfo(int prod_num){
		ProductDetailAdminDomain plad=null;
		SqlSession ss=AdminMyBatisHandler.getInstance().getHandler();
		plad=ss.selectOne("kr.co.ss.admin.prodMapper.prodInfo",prod_num);
		if(ss!=null) {ss.close();}
		
		return plad;
	}//selectProductAll
	
	
	/**
	 * 상품추가
	 * @param piVO
	 * @return
	 */
	public int insertProduct(ProductInsertVO piVO) {
		int cnt=0;
		SqlSession ss=AdminMyBatisHandler.getInstance().getHandler();
		
		cnt=ss.insert("kr.co.ss.admin.prodMapper.insertProd",piVO);
		if(cnt==1) {
			ss.commit();
		}//if
		
		if(ss != null ) { ss.close(); }
		return cnt;
	}//insertProduct
	
	
	/**
	 * 상품수정
	 * @param pmVO
	 * @return
	 */
	public int updateProduct(ProductModifyVO pmVO) {
		int cnt=0;
		SqlSession ss=AdminMyBatisHandler.getInstance().getHandler();
		
		cnt=ss.update("kr.co.ss.admin.prodMapper.modifyProd",pmVO);
		if(cnt==1) {
			ss.commit();
		}//if
		
		if(ss != null ) { ss.close(); }
		return cnt;
	}//updateProduct
	
	
	/**
	 * 상품삭제
	 * @param pdVO
	 * @return
	 */
	public int deleteProduct(ProductDeleteVO pdVO) {
		int cnt=0;
		SqlSession ss=AdminMyBatisHandler.getInstance().getHandler();
		
		cnt=ss.update("kr.co.ss.admin.prodMapper.deleteProd",pdVO);
		if(cnt==1) {
			ss.commit();
		}//if
		
		if(ss != null ) { ss.close(); }
		return cnt;
	}//deleteProduct
	
	
}//class
