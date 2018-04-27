package service;

import java.util.List;

import dao.BookDao;
import domain.Book;


public class BookService {

	private BookDao bookDao;

	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}
	
	
	//����鱾
	public void save(Book book) {
		bookDao.save(book);
	}
	
	//��ʾ�鱾��Ϣ
	public List<Book> getAll() { 
        return bookDao.getAll();
    }
	
	//��������ѯ�鱾��Ϣ
	public List<Book> findByName(String name) { 
        return bookDao.findByName(name);
    }
	
	//���۸������ѯ�鱾
	public List<Book> findByPrice(int lowprice,int highprice) { 
        return bookDao.findByPrice(lowprice,highprice);
    }
	
	//�޸��鱾����
	public void update(String bid,int bamount){
		Book book = this.find(bid);
		book.setBamount(bamount);
		bookDao.update(book);
	}
	
	
	public Book find(String bid){
		return bookDao.find(bid);
	}
	
}
