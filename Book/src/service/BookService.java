package service;

import java.util.List;

import dao.BookDao;
import domain.Book;


public class BookService {

	private BookDao bookDao;

	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}
	
	
	//添加书本
	public void save(Book book) {
		bookDao.save(book);
	}
	
	//显示书本信息
	public List<Book> getAll() { 
        return bookDao.getAll();
    }
	
	//按书名查询书本信息
	public List<Book> findByName(String name) { 
        return bookDao.findByName(name);
    }
	
	//按价格区间查询书本
	public List<Book> findByPrice(int lowprice,int highprice) { 
        return bookDao.findByPrice(lowprice,highprice);
    }
	
	//修改书本数量
	public void update(String bid,int bamount){
		Book book = this.find(bid);
		book.setBamount(bamount);
		bookDao.update(book);
	}
	
	
	public Book find(String bid){
		return bookDao.find(bid);
	}
	
}
