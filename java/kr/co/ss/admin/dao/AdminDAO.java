package kr.co.ss.admin.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.ss.admin.domain.AdminLBDetailDomain;
import kr.co.ss.admin.domain.AdminLBImgListDomain;
import kr.co.ss.admin.domain.AdminLBListDomain;
import kr.co.ss.admin.domain.AdminUserInfoDomain;
import kr.co.ss.admin.domain.AdminUsersDomain;
import kr.co.ss.admin.vo.ProductDeleteVO;
import kr.co.ss.admin.vo.UserDeleteVO;
import kr.co.ss.connection.AdminMyBatisHandler;

public class AdminDAO {

	/**
	 * 회원 전체보기
	 * @return
	 */
	public List<AdminUsersDomain> selectUsersAll(){
		List<AdminUsersDomain> list=null;
		SqlSession ss=AdminMyBatisHandler.getInstance().getHandler();
		list=ss.selectList("kr.co.ss.admin.usersMapper.usersList");
		if(ss!=null) {ss.close();}
		
		return list;
	}//selectUsersAll
		
		/**
		 * 게시글 전체보기
		 * @return
		 */
		public List<AdminLBListDomain> selectLBAll(){
			List<AdminLBListDomain> list=null;
			SqlSession ss=AdminMyBatisHandler.getInstance().getHandler();
			list=ss.selectList("kr.co.ss.admin.LBMapper.LBList");
			if(ss!=null) {ss.close();}
			
			return list;
	}//selectLBAll
		
		
		/**
		 * 회원정보보기
		 * @return
		 */
		public AdminUserInfoDomain selectUserInfo(String member_id){
			AdminUserInfoDomain auid=null;
			SqlSession ss=AdminMyBatisHandler.getInstance().getHandler();
			auid=ss.selectOne("kr.co.ss.admin.usersMapper.userInfo",member_id);
			if(ss!=null) {ss.close();}
			
			return auid;
		}//selectUserInfo
		
		
		/**
		 * 룩북상세보기
		 * @return
		 */
		public AdminLBDetailDomain selectLBInfo(int lb_posts_num){
			AdminLBDetailDomain aldd=null;
			SqlSession ss=AdminMyBatisHandler.getInstance().getHandler();
			aldd=ss.selectOne("kr.co.ss.admin.LBMapper.LBInfo",lb_posts_num);
			if(ss!=null) {ss.close();}
			
			return aldd;
		}//selectLBInfo
		
		
		/**
		 * 룩북이미지
		 * @return
		 */
		public List<String> selectLBImg(int lb_posts_num){
			List<String> imgList=null;
			SqlSession ss=AdminMyBatisHandler.getInstance().getHandler();
			imgList=ss.selectList("kr.co.ss.admin.LBMapper.LBImg",lb_posts_num);
			if(ss!=null) {ss.close();}
			return imgList;
		}//selectLBImg
		
		
		/**
		 * 회원탈퇴
		 * @param udVO
		 * @return
		 */
		public int deleteUser(UserDeleteVO udVO) {
			int cnt=0;
			SqlSession ss=AdminMyBatisHandler.getInstance().getHandler();
			
			cnt=ss.update("kr.co.ss.admin.usersMapper.deleteUser",udVO);
			if(cnt==1) {
				ss.commit();
			}//if
			
			if(ss != null ) { ss.close(); }
			return cnt;
		}//deleteUser
		
		
		/**
		 * 게시글삭제
		 * @param lb_posts_num
		 * @return
		 */
		public int deleteLB(int lb_posts_num) {
			int cnt=0;
			SqlSession ss=AdminMyBatisHandler.getInstance().getHandler();
			
			cnt=ss.update("kr.co.ss.admin.LBMapper.deleteLB",lb_posts_num);
			if(cnt==1) {
				ss.commit();
			}//if
			
			if(ss != null ) { ss.close(); }
			return cnt;
		}//deleteLB
	
}
