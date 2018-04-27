package domain;

import java.sql.Date;
import javax.persistence.Entity;

@Entity
public class Book {

	private String bid;
	private String bname;
	private String bauther;
	private String btype;
	private int bprice;
	private int bamount;
	private Date bpubdate;
	
	public String getBid() {
		return bid;
	}
	public void setBid(String bid) {
		this.bid = bid;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		System.out.println("setBname");
		this.bname = bname;
	}
	public String getBauther() {
		return bauther;
	}
	public void setBauther(String bauther) {
		this.bauther = bauther;
	}
	public String getBtype() {
		return btype;
	}
	public void setBtype(String btype) {
		this.btype = btype;
	}
	public int getBprice() {
		return bprice;
	}
	public void setBprice(int bprice) {
		this.bprice = bprice;
	}
	public int getBamount() {
		return bamount;
	}
	public void setBamount(int bamount) {
		this.bamount = bamount;
	}
	public Date getBpubdate() {
		return bpubdate;
	}
	public void setBpubdate(Date bpubdate) {
		this.bpubdate = bpubdate;
	}
	
	
	
}
