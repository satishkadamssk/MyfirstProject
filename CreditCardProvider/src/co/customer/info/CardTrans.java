package co.customer.info;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Com.carddata.cust.DBUtil;


@WebServlet("/CardTrans")
public class CardTrans extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CardTrans() {
		super();
		System.out.println("Transaction");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String card_id = request.getParameter("cardnumber");
		String fname = request.getParameter("firstname");
		String lname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String activity = request.getParameter("activity");
		String amount = request.getParameter("amount");
		String total_amount = request.getParameter("amount");
		String source = request.getParameter("sd");
		String comment = request.getParameter("comment");
		String cardnum = request.getParameter("cardnumber");

//		java.util.Date utilDate = new Date();
//		java.sql.Date date = new java.sql.Date(utilDate.getTime());

		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println(dateFormat.format(date)); //2016/11/16 12:08:43
		String date1 = dateFormat.format(date);
		
		
		System.out.println(fname);
		System.out.println(amount);
		//////////////////////////////////////////////////////
		Connection con = DBUtil.getConnection();

		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate(
					"insert into loginuser.transaction (date,fname, lname,emailid,address,phone,activity,deposit,source,comment,cardnum) values('"
							+ date1 + "','" + fname + "','" + lname + "','" + email + "','" + address + "','" + phone
							+ "','" + activity + "','" + amount + "','" + source + "','" + comment + "','" + cardnum
							+ "')");
			System.out.println("successs");
		} catch (SQLException e) {

			e.printStackTrace();
		}
		/////////////////////////////////////////////////////

		// doGet(request, response);

	}

}
