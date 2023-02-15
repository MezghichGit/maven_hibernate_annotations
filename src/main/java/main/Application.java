package main;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import dao.CategoryDAO;
import dao.LivreDAO;
import entities.Category;
import entities.Livre;
import utils.ConfigurationHibernate;

public class Application {

	public static void main(String[] args) {
		//1)Chargment et configuration de Hibernate
		//Obtention du factory pour créer une session hibernate
		ConfigurationHibernate.configHibernate();
		
		//2)Faire des Ajout de 2 Catégorie
		/*
		Category category1 = new Category("Programmation Java",20);
		Category category2 = new Category("Programmation Python",15);
		Category category3 = new Category("Programmation Angular",10);
		
		CategoryDAO.addCategory(category1);
		CategoryDAO.addCategory(category2);
		CategoryDAO.addCategory(category3);
		System.out.println(CategoryDAO.getAllCategories());
		*/
		//3)Ajout de 2 Livres
		
		Category categoryJava = CategoryDAO.getCategoryById(13);
		Category categoryAngular = CategoryDAO.getCategoryById(15);
	
		Date dateEditionJava = 
				java.util.Date.from( LocalDate.of( 2014 , 2 , 11 ).atStartOfDay(ZoneId.of( "Africa/Tunis" )) .toInstant());
		
		Date dateEditionAngular = 
				java.util.Date.from( LocalDate.of( 2020 , 12 , 10 ).atStartOfDay(ZoneId.of( "Africa/Tunis" )) .toInstant());
		
		
		Livre livreJava = new Livre("OCP Official guide",200,dateEditionJava,categoryJava);
	    Livre livreAngular = new Livre("Angular Official guide",200,dateEditionAngular,categoryAngular);
		
		LivreDAO.addLivre(livreJava);
		LivreDAO.addLivre(livreAngular);
		
		System.out.println(LivreDAO.getAllLivres());
		//System.out.println(ZoneId.systemDefault());

	}

}
