package Com.carddata.cust;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.newgen.constant.QueryConstant;
//import com.newgen.util.DBUtil;

@WebServlet("/CardStore")
public class CardStore extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CardStore() {
    	
        super();
        System.out.println("CardStore");
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		String card_num= request.getParameter("cardnumber");
		String card_name= request.getParameter("cardname");
		String card_date= request.getParameter("carddate");
		String card_ccv= request.getParameter("cardccv");
		 
		System.out.println(card_num);
		System.out.println(card_date);
		
		Connection con = DBUtil.getConnection();
		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate("insert into loginuser.cardinfo (card_num, card_name,card_date,card_cvv) values('"+ card_num +"','"+ card_name +"','"+ card_date +"','"+ card_ccv +"')");
			System.out.println("successs");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
}
