package action;

import service.BookService;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import domain.Book;

public class BookAction extends ActionSupport{
	private Book book ;
	private String bname;
    private int lowprice;
    private int highprice;
    private int bamount;
    private String bid;
    
	public String getBid() {
		return bid;
	}
	public void setBid(String bid) {
		this.bid = bid;
	}
	
	public int getBamount() {
		return bamount;
	}
	public void setBamount(int bamount) {
		this.bamount = bamount;
	}
	public int getLowprice() {
		return lowprice;
	}
	public void setLowprice(int lowprice) {
		this.lowprice = lowprice;
	}
	public int getHighprice() {
		return highprice;
	}
	public void setHighprice(int highprice) {
		this.highprice = highprice;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	


	private BookService bookService;
	public BookService getBookService() {
		return bookService;
	}
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}
	
	//添加书本
	public String save() {
		bookService.save(book);
		return "success";
	}
	
	//显示书本信息
	public String list() {
		ActionContext ac=ActionContext.getContext();
		Map<String, Object> request=ac.getContextMap();
        request.put("book", bookService.getAll());
        return "success";
    }
	
	//按书名查询书本信息
	public String findByName() {
		ActionContext ac=ActionContext.getContext();
		Map<String, Object> request=ac.getContextMap();
        request.put("book", bookService.findByName(bname));
        return "success";
    }
	
	//按价格区间查询书本
	public String findByPrice() {
		ActionContext ac=ActionContext.getContext();
		Map<String, Object> request=ac.getContextMap();
        request.put("book", bookService.findByPrice(lowprice,highprice));
        return "success";
    }
	
	//修改书本数量
	public String bookUpdate(){
		bookService.update(bid,bamount);
		return "success";
	}
	
}
