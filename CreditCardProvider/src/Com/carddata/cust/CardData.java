package Com.carddata.cust;

import java.sql.Date;

public class CardData {
	private int cust_id;
	private int card_num;
	private String card_name;
	private String card_date;

	public int getCust_id() {
		return cust_id;
	}

	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}

	public int getCard_num() {
		return card_num;
	}

	public void setCard_num(int card_num) {
		this.card_num = card_num;
	}

	public String getCard_name() {
		return card_name;
	}

	public void setCard_name(String card_name) {
		this.card_name = card_name;
	}

	public String getCard_date() {
		return card_date;
	}

	public void setCard_date(String card_date) {
		this.card_date = card_date;
	}

	public int getCard_ccv() {
		return card_ccv;
	}

	public void setCard_ccv(int card_ccv) {
		this.card_ccv = card_ccv;
	}

	private int card_ccv;
}
