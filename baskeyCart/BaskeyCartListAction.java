package baskeyCart;

import java.util.ArrayList;
import vo.ActionForward;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.action.Action;
import oracle.net.aso.b;
import oracle.net.aso.r;
import svc.BaskeyCartListService;
import vo.Basket_detail;

public class BaskeyCartListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO 자동 생성된 메소드 스텁
		
		BaskeyCartListService baskeyCartListService = new BaskeyCartListService(); 
		
		ArrayList<Basket_detail> baskeyCartList = baskeyCartListService.getCartList(request);
		
		int totalMoney = 0;
		int money = 0;
		
		/*
		 * for (int i = 0; i < baskeyCartList.size(); i++) { money =
		 * baskeyCartList.get(i).getBasket_price() *
		 * baskeyCartList.get(i).getBasket_detail_count(); totalMoney += money; }
		 */		
		
		request.setAttribute("totalMoney", totalMoney);
		request.setAttribute("baskeyCartList", baskeyCartList);
		
//		ActionForward forward =new ActionForward("baskeyCartList.bk", false);//"디스패치 방식"으로 포워딩
		ActionForward forward =new ActionForward("baskeyCartList.jsp", false);//"디스패치 방식"으로 포워딩
		
		return forward;
	}

}
