package dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import domain.Book;

public class BookDao extends HibernateDaoSupport{
	
	//添加书本
	public void save(Book book) {
		System.out.println("Dao中的save方法执行了！"+book.getBid());
		this.getHibernateTemplate().save(book);
	}
	
	//显示书本信息
	public List<Book> getAll() {
	    return this.getHibernateTemplate().find("from Book");
	}
	
	//按书名查询书本信息
	public List<Book> findByName(String name) {
	    return this.getHibernateTemplate().find("from Book where BNAME like ?",name);  
	}
	
	//按价格区间查询书本
	public List<Book> findByPrice(int lowprice,int highprice) {
	    return this.getHibernateTemplate().find("from Book where bprice > ? and bprice < ?",lowprice,highprice);
	}
	
	//修改书本数量
	public void update(Book book){
		getHibernateTemplate().update(book);
	}
	public Book find(String bid){
		List list = getHibernateTemplate().find("from Book where BID =?",bid);
		if(list.size()>0){
			return (Book)list.get(0);
		}else{
			return null;
		}
	}
	
	
}
