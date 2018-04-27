package dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import domain.Book;

public class BookDao extends HibernateDaoSupport{
	
	//����鱾
	public void save(Book book) {
		System.out.println("Dao�е�save����ִ���ˣ�"+book.getBid());
		this.getHibernateTemplate().save(book);
	}
	
	//��ʾ�鱾��Ϣ
	public List<Book> getAll() {
	    return this.getHibernateTemplate().find("from Book");
	}
	
	//��������ѯ�鱾��Ϣ
	public List<Book> findByName(String name) {
	    return this.getHibernateTemplate().find("from Book where BNAME like ?",name);  
	}
	
	//���۸������ѯ�鱾
	public List<Book> findByPrice(int lowprice,int highprice) {
	    return this.getHibernateTemplate().find("from Book where bprice > ? and bprice < ?",lowprice,highprice);
	}
	
	//�޸��鱾����
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
