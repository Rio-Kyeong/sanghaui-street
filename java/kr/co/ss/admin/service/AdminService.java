package kr.co.ss.admin.service;

import java.net.http.HttpRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import kr.co.ss.admin.dao.AdminDAO;
import kr.co.ss.admin.dao.ProductAdminDAO;
import kr.co.ss.admin.domain.AdminLBDetailDomain;
import kr.co.ss.admin.domain.AdminLBImgListDomain;
import kr.co.ss.admin.domain.AdminLBListDomain;
import kr.co.ss.admin.domain.AdminUserInfoDomain;
import kr.co.ss.admin.domain.AdminUsersDomain;
import kr.co.ss.admin.domain.ProductDetailAdminDomain;
import kr.co.ss.admin.domain.ProductListAdminDomain;
import kr.co.ss.admin.vo.ProductDeleteVO;
import kr.co.ss.admin.vo.ProductInsertVO;
import kr.co.ss.admin.vo.ProductModifyVO;
import kr.co.ss.admin.vo.UserDeleteVO;

/**
 * @author user
 *
 */
public class AdminService {
	
	/**
	 * 상품리스트
	 * @return
	 */
	public List<ProductListAdminDomain> adminProdList(){
		ProductAdminDAO paDAO=new ProductAdminDAO();
		
		return paDAO.selectProductAll();
	}//adminProdList
	
	
	/**
	 * 회원리스트
	 * @return
	 */
	public List<AdminUsersDomain> adminUsersList(){
		AdminDAO aDAO=new AdminDAO();
		
		return aDAO.selectUsersAll();
	}//adminUsersList
	
	
	/**
	 * 게시글리스트
	 * @return
	 */
	public List<AdminLBListDomain> adminLBList(){
		AdminDAO aDAO=new AdminDAO();
		
		return aDAO.selectLBAll();
	}//adminLBList
	
	
	/**
	 * 상품정보보기
	 * @param prod_num
	 * @return
	 */
	public ProductDetailAdminDomain searchProductInfo(int prod_num){
		ProductAdminDAO paDAO=new ProductAdminDAO();
		
		return paDAO.selectProductInfo(prod_num);
	}//searchProductInfo
	
	
	/**
	 * 회원정보보기
	 * @param member_id
	 * @return
	 */
	public AdminUserInfoDomain searchUserInfo(String member_id){
		AdminDAO aDAO=new AdminDAO();
		
		return aDAO.selectUserInfo(member_id);
	}//searchUserInfo
	
	
	/**
	 * 게시글보기
	 * @param member_id
	 * @return
	 */
	public AdminLBDetailDomain searchLBInfo(int lb_posts_num){
		AdminDAO aDAO=new AdminDAO();
		
		return aDAO.selectLBInfo(lb_posts_num);
	}//searchLBInfo
	
	
	/**
	 * 게시글이미지보기
	 * @param lb_posts_num
	 * @return
	 */
	public List<String> LBImgList(int lb_posts_num){
		AdminDAO aDAO=new AdminDAO();
		
		
		return aDAO.selectLBImg(lb_posts_num);
	}//LBImgList
	
	
	/**
	 * 상품추가
	 * @param piVO
	 * @return
	 */
	public int insertProd(ProductInsertVO piVO) {
	int cnt=0;
	
	ProductAdminDAO paDAO=new ProductAdminDAO();
	cnt=paDAO.insertProduct(piVO);
	
		return cnt;
	}//insertProd
	
	
	/**
	 *  상품수정
	 * @param piVO
	 * @return
	 */
	public int modifyProd(ProductModifyVO pmVO) {
		int cnt=0;
		
		ProductAdminDAO paDAO=new ProductAdminDAO();
		cnt=paDAO.updateProduct(pmVO);
		
		return cnt;
	}//modifyProd
	
	
	/**
	 * 상품삭제
	 * @param pdVO
	 * @return
	 */
	public int removeProd(ProductDeleteVO pdVO) {
		int cnt=0;
		
		ProductAdminDAO paDAO=new ProductAdminDAO();
		cnt=paDAO.deleteProduct(pdVO);
		
		return cnt;
	}//insertProd
	
	
	/**
	 * 회원탈퇴
	 * @param pdVO
	 * @return
	 */
	public int removeUser(UserDeleteVO udVO) {
		int cnt=0;
		
		AdminDAO aDAO=new AdminDAO();
		cnt=aDAO.deleteUser(udVO);
		
		return cnt;
	}//removeUser
	
	
	/**
	 * 게시글삭제
	 * @param lb_posts_num
	 * @return
	 */
	public int removeLB(int lb_posts_num) {
		int cnt=0;
		
		AdminDAO aDAO=new AdminDAO();
		cnt=aDAO.deleteLB(lb_posts_num);
		
		return cnt;
	}//removeUser
	
	

}
