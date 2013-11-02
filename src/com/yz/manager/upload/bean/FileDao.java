package com.yz.manager.upload.bean;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.yz.manager.hibernate.HibernateSessionFactory;

public class FileDao {

	Session session=null;
	public void save(SomeFile file) {
		session=HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();
		session.save(file);
		tx.commit();
	}
	/**
	 * 获得文件列表
	 * @param userName
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<SomeFile> list() {
		session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "from SomeFile";
		Query query = session.createQuery(hql);
		//query.setString("name",userName);
		List<SomeFile> list = query.list();
		for(SomeFile file:list){
			System.out.println(file.getFileName());
		}
		tx.commit();
		return list;
	}
	
	public boolean delete(int id) {
		session=HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();
		SomeFile file = (SomeFile)session.load(SomeFile.class, id);
		session.delete(file);
		tx.commit();
		return false;
	}

	@SuppressWarnings("unused")
	public SomeFile find(String fileName) {
		session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();
		String hql = "from SomeFile as somefile where somefile.fileName = :name";
		Query query = session.createQuery(hql);
		query.setString("name",fileName);
		SomeFile file= (SomeFile) query.list().get(0);
		return file;
	}
}
