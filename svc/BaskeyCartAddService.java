package svc;

import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.ProductDAO;

import static db.Jdbcutil.*;

import vo.Basket_detail;
import vo.Product;

public class BaskeyCartAddService {
	
	public ArrayList<Product> geteCartBaskey(int serial_code) {
		Connection con = getConnection();
		ProductDAO productDAO = ProductDAO.getInstance();
		productDAO.setConnection(con);
		
		ArrayList<Product> product = productDAO.selectBaskeyCart(serial_code);
		
		System.out.println("serial_code 값 : "+serial_code);
		close(con);
		
		
		return product;
		
	}
	
	public void addCart(HttpServletRequest request, ArrayList<Product> baskeyCart) {
		
		HttpSession session = request.getSession();
		
		ArrayList<Basket_detail> cartList = (ArrayList<Basket_detail>) session.getAttribute("cartList");
		
		  if(cartList == null) {
		    	cartList = new ArrayList<Basket_detail>();
		    	session.setAttribute("cartList", cartList);
		    }
		  
		  System.out.println("cartList : "+ cartList);
		  
		  boolean isNewCart = true;
		  
		  for(int i=0;i<cartList.size();i++) {
			  if(baskeyCart.get(i).equals(cartList.get(i).getBasket_detail_name())) {
				  isNewCart = false;
				  cartList.get(i).setBasket_detail_count(cartList.get(i).getBasket_detail_count()+1);
				  break;
			  }
		  }
		  if(isNewCart == true) {
			  Basket_detail cart = new Basket_detail();
			  cart.setBasket_detail_name(baskeyCart.get(1).getName());
			  cart.setBasket_detail_choice(baskeyCart.get(2).getChoice());
			  cart.setBasket_detail_count(baskeyCart.get(3).getCount());
			  cart.setBasket_detail_date(baskeyCart.get(4).getPI_date());
			  cart.setBasket_basket_num(baskeyCart.get(5).getSerial_code());
			  cart.setBasket_price(baskeyCart.get(6).getPrice());
			  cart.setMember_id(baskeyCart.get(7).getId());
			  
			  cartList.add(cart);
		  }
		  
	}

}
