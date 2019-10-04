package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Borrower;

public class BorrowerHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("ConsoleBookshelf");
	
	public void insertBorrower(Borrower b) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(b);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Borrower> showAllBorrowers(){
		EntityManager em = emfactory.createEntityManager();
		List<Borrower> allBorrowers = em.createQuery("SELECT b FROM Borrower b").getResultList();
		return allBorrowers;
	}
}