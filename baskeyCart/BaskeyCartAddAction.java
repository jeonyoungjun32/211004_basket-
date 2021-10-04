package baskeyCart;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.action.Action;
import svc.BaskeyCartAddService;
import vo.ActionForward;
import vo.Product;

public class BaskeyCartAddAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		BaskeyCartAddService baskeyCartAddService = new BaskeyCartAddService(); 
		
		int serial_code = Integer.parseInt(request.getParameter("serial_code")); //여서 null값인데 왜?!왜!!시발!!
		
		System.out.println("아니 시발?"+serial_code);
		
		ArrayList<Product> baskeyCart = baskeyCartAddService.geteCartBaskey(serial_code);
		
		
		System.out.println("asdasd");
		baskeyCartAddService.addCart(request, baskeyCart);
		
		
		if(baskeyCart == null) {
			PrintWriter out = response.getWriter();
			out.print("<script>");
			out.print("alert('장바구니 목록리스트에 없습니다');");
			out.print("history.back();");
			out.print("</script>");
		}
		
		
		return new ActionForward("baskeyCartList.bk", true);
	}

}
