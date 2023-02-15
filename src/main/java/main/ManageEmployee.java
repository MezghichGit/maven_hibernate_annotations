package main;

import java.time.LocalDate;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


import dao.CategoryDAO;
import dao.EmployeeDAO;
import dao.LivreDAO;
import entities.Category;
import entities.Employee;
import entities.Livre;
public class ManageEmployee {

	
	

	public static void main(String[] args) {
		
		System.out.println("Hello Hibernate");
		
		
		///////////// Manipulation des Livres /////////
		
		Category category = CategoryDAO.getCategoryById(7);	
		//LocalDate date = LocalDate.of(2014, 10, 10);
		Date dateEdition =  new Date();
		Livre livre = new Livre("OCP Official guide",200,dateEdition,category);
		LivreDAO.addLivre(livre);
		System.out.println(LivreDAO.getAllLivres());
		
		
		//////////// Fin //////////////////////
		
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
