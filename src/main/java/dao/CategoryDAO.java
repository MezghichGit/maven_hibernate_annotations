package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import entities.Category;
import static utils.ConfigurationHibernate.factory;

public class CategoryDAO {

	public static int addCategory(Category temp) {
		Session session = factory.openSession();
		Transaction tx = null;
		Integer categoryID = null;
		try {
			tx = session.beginTransaction();
			categoryID = (Integer) session.save(temp);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return categoryID;
	}
	
	public static void updateCategory(Integer categoryID, String title) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Category category = (Category) session.get(Category.class, categoryID);
			category.setTitle(title);
			session.update(category);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public static void deleteCategory(Integer categoryID) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Category category = (Category) session.get(Category.class, categoryID);
			session.delete(category);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	public static List<Category> getAllCategories()
	{
		List<Category> ls=null;
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction(); // débuter la transaction
			
			String hql = "from Category";
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
	
	public static List<Category> getAllCategoriesByDescendingOrder()
	{
		List<Category> ls=null;
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction(); // débuter la transaction
			
			String hql = "from Category order by CATEGORY_NBBOOK desc";
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
	
	public static int getQtyCategory() {
		int qtyCategory = 0;
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction(); // débuter la transaction
			
			String hql = "from Category";
			Query query = session.createQuery(hql);
			qtyCategory = query.list().size();
			
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
		return qtyCategory;
	}
	
	
	///
	
	public static Category getCategoryById(Integer categoryID) {
		Category category=null;
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			 category = (Category) session.get(Category.class, categoryID);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return category;
	}
}