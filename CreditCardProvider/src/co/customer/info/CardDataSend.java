package co.customer.info;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.mysql.fabric.xmlrpc.base.Data;

import Com.carddata.cust.DBUtil;


@WebService(endpointInterface = "co.customer.info.CardProvider")
public class CardDataSend {
	
	public List<CardModel> getDisplay(String str) throws SQLException{
		
		List<CardModel> transactionlist = new ArrayList<CardModel>();
		
		Connection con = DBUtil.getConnection();
		PreparedStatement pstm = con.prepareStatement("SELECT * FROM loginuser.transaction where cardnum='" + str + "'");
		ResultSet rs = pstm.executeQuery();
		while (rs.next()) {
			
			String date = rs.getString("date");
			String fname = rs.getString("fname");
			String lname = rs.getString("lname");
			String email = rs.getString("emailid");
			String address = rs.getString("Address");
			String phone = rs.getString("phone");
			String activity = rs.getString("activity");
			String Withdrowal = rs.getString("withdrowal");
			String deposit = rs.getString("deposit");
			String total_amount = rs.getString("total_amount");
			String source = rs.getString("source");
			String comment = rs.getString("comment");
			String cardnum = rs.getString("cardnum");
			
			CardModel card = new CardModel();
			card.setDate(date);
			card.setFname(fname);
			card.setLname(lname);
			card.setEmailid(email);
			card.setPhone(phone);
			card.setActivity(activity);
			card.setWithdrowal(Withdrowal);
			card.setDeposit(deposit);
			card.setTotal_amount(total_amount);
			card.setSource(source);
			card.setCardnum(cardnum);
			
			transactionlist.add(card);

		}
		System.out.println(transactionlist);
		DBUtil.closeConnection(con, pstm);
		return transactionlist;
	}

}












//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/*package com.carddata.cust;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.jws.WebService;
import com.cardinfo.customer.DBUtil;
import com.mysql.fabric.Response;
import com.mysql.jdbc.PreparedStatement;

@WebService(endpointInterface = "com.carddata.cust.CardService")
public class CardDataSend {


public CardDataSend(Date date, String string, String string2, String string3, String string4, String string5,
		String string6, String string7, String string8, String string9, String string10) {
	// TODO Auto-generated constructor stub
}

		 String str = "121212";

	public static void main(String args[]) throws SQLException {
		CardDataSend sd = new CardDataSend();
		sd.getDisplay();
	}

	public ArrayList<CardDataSend> getDisplay(String str) throws SQLException {
		
		ArrayList<CardDataSend> transList = new ArrayList<>();
		Connection con = DBUtil.getConnection();
		java.sql.PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = con.prepareStatement("SELECT * FROM loginuser.transaction where cardnum='" + str + "'");
			rs = pstmt.executeQuery();
			while (rs.next()) {

				CardDataSend customer = new CardDataSend(rs.getDate("date"), rs.getString("fname"), rs.getString("lname"),rs.getString("emailid"),rs.getString("Address"),rs.getString("phone"),rs.getString("activity"),rs.getString("withdrowal"),rs.getString("deposit"),rs.getString("source"),rs.getString("comment"));
				transList.add(customer);
				
				
				Date dateCreated = rs.getDate("date");
				String fname = rs.getString(3);
				String lname = rs.getString(4);

				System.out.print("--> " + fname);
				System.out.println("--> " + lname);
				System.out.println("--> " + dateCreated);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			con.close();
		}
		 return transList;
	}
}
*/