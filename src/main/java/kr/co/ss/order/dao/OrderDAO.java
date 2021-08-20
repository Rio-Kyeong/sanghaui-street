package kr.co.ss.order.dao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.session.SqlSession;

import kr.co.ss.order.domain.OrderDetailDomain;
import kr.co.ss.order.domain.OrderInfoDomain;
import kr.co.ss.order.vo.OrderInsertVO;


/**
 * 주문에 대한 동작을 쿼리문으로 정의하는 클래스
 * @author sist
 */
public class OrderDAO {
	
		/**
		 * 메인화면에서 회원의 구매정보를 볼 수 있는 주문내역창
		 * @param member_id
		 * @return
		 */
		public List<OrderDetailDomain> selectOrder(String member_id) {
			
			List<OrderDetailDomain> list = new ArrayList<OrderDetailDomain>();
			
			SqlSession ss = kr.co.ss.connection.MyBatisHandler.getInstance().getHandler();	
			
			list =ss.selectList("kr.co.ss.order.mapper.selectOrder", member_id);
			
			if( ss != null ) { ss.close(); } //end if
			
			return list;
		}
		
		/**
		 * 구매버튼을 누르면 볼 수 잇는 구매내역
		 * @param member_id
		 * @return
		 */
		public List<OrderInfoDomain> selectOrderInfo(String member_id) {
			
			List<OrderInfoDomain> list = new ArrayList<OrderInfoDomain>();
			
			SqlSession ss = kr.co.ss.connection.MyBatisHandler.getInstance().getHandler();	
			
			list =ss.selectList("kr.co.ss.order.mapper.selectinfoOrder", member_id);
			
			if( ss != null ) { ss.close(); } //end if
			
			return list;
		}
	
	/**
	 * 주문내역 삽입(INSERT)
	 * @param osVO
	 * @throws SQLException
	 */
		public int insertOrder(OrderInsertVO oiVO) {
			
			int rowCnt=0;
			//MyBatis Handler얻기
			SqlSession ss = kr.co.ss.connection.MyBatisHandler.getInstance().getHandler();
			rowCnt = ss.insert("kr.co.ss.order.mapper.insertOrder",oiVO);
			
			if(rowCnt ==1 ) {
				ss.commit();
			}//end if
			
			if(ss != null ){ss.close();} //end if
			
			return rowCnt;
		}//insertOrder
		
		
}//class
