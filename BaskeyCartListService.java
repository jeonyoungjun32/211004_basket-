package svc;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import vo.Basket_detail;

public class BaskeyCartListService {

	public ArrayList<Basket_detail> getCartList(HttpServletRequest request){
		HttpSession session = request.getSession();
		ArrayList<Basket_detail> baskeyCartList = (ArrayList<Basket_detail>) session.getAttribute("baskeyCartList");
		
		return baskeyCartList;
		
	}
	}
