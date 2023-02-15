package main;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import dao.CategoryDAO;
import dao.EmployeeDAO;
import entities.Category;
import entities.Employee;
import entities.Livre;
public class ManageEmployee {
	public static SessionFactory factory;
	private static ServiceRegistry serviceRegistry;
	
	public static void configHibernate() {
		try {

			// Initialize the hibernate configuration.
			Configuration configuration = new Configuration().configure();
			configuration.addAnnotatedClass(Employee.class);
			configuration.addAnnotatedClass(Category.class);
			configuration.addAnnotatedClass(Livre.class);
			// Build a service registry from the properties of the configuration
			// This is new in Hibernate 4 !
			serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();

			// Build the SessionFactory !
			factory = configuration.buildSessionFactory(serviceRegistry);
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static void main(String[] args) {
		
		System.out.println("Hello Hibernate");
		configHibernate();
		/*
		Category category1 = new Category("Programmation Python",8);
		Category category2 = new Category("Programmation Angular",6);
		
		CategoryDAO.addCategory(category1);
		CategoryDAO.addCategory(category2);
		System.out.println(CategoryDAO.getAllCategories());*/
		//System.out.println(CategoryDAO.getAllCategoriesByDescendingOrder());
		//System.out.println("Le nombre de catégorie : "+CategoryDAO.getQtyCategory());
		
		/*
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Donner votre firstname : ");
		String fsname = sc.nextLine();
		System.out.println("Donner votre lastname : ");
		String lsname = sc.nextLine();
		
		System.out.println("Donner votre salaire : ");
		int salaire = sc.nextInt();
		
		
		Integer empID1 = EmployeeDAO.addEmployee(fsname, lsname, salaire);
		 */
		
		/* List down all the employees */
		//EmployeeDAO.listEmployees();
		 
		 
		/*
		/* Update employee's records */
		// EmployeeDAO.updateEmployee(1, 15000);
		
		// EmployeeDAO.listEmployees();
		 
		/* Delete an employee from the database */
		//EmployeeDAO.deleteEmployee(1);
		
		/* List down new list of the employees */
		//EmployeeDAO.listEmployees();
	}

	

}
