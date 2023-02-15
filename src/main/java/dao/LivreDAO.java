package dao;

import static main.ManageEmployee.factory;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import entities.Livre;

public class LivreDAO {

	public static int addLivre(Livre livre) {
		Session session = factory.openSession();
		Transaction tx = null;
		Integer livreID = null;
		try {
			tx = session.beginTransaction();
			livreID = (Integer) session.save(livre);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return livreID;
	}
	
	public static List<Livre> getAllLivres()
	{
		List<Livre> ls=null;
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction(); // débuter la transaction
			
			String hql = "from Livre";
			Query query = session.createQuery(hql);
			ls = query.list();
			
			tx.commit();
		} 
		catch (Exception e) {
			//System.out.println("Un problème dans la base");
			if (tx != null) {
				tx.rollback();// on effectue un roll back en cas d’exception
                    // afin de garder la cohérence des données
				session.close();
			}
			
		}
		session.close();// fermeture de la session hibernate
		return ls;
	}
	
}
