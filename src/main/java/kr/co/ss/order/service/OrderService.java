package kr.co.ss.order.service;
import java.util.ArrayList;
import java.util.List;
import kr.co.ss.order.dao.OrderDAO;
import kr.co.ss.order.domain.OrderDetailDomain;
import kr.co.ss.order.domain.OrderInfoDomain;
import kr.co.ss.order.vo.OrderInsertVO;


public class OrderService {
	
	/**
	 * 메인화면에서 회원의 구매정보를 볼 수 있는 주문내역창
	 * @param member_id
	 * @return
	 */
	public List<OrderDetailDomain> searchOrder(String member_id){
			List<OrderDetailDomain> list = new ArrayList<OrderDetailDomain>();
			OrderDAO oDAO = new OrderDAO();
			list = oDAO.selectOrder(member_id);
		return list;
	}
	
	public List<OrderInfoDomain> searchOrderInfo(String member_id){
		
		List<OrderInfoDomain> list = new ArrayList<OrderInfoDomain>();
		OrderDAO oDAO = new OrderDAO();
		list = oDAO.selectOrderInfo(member_id);
		
		return list;
	}
	
	/**
	 * 주문내역 Insert
	 * @param oiVO
	 * @return
	 */
	public int addOrder(OrderInsertVO oiVO) { 
		int rowCnt = 0;
		OrderDAO od = new OrderDAO(); 
		rowCnt = od.insertOrder(oiVO);
		return rowCnt; 
	}//selectOrder
	
	
	
}//class
