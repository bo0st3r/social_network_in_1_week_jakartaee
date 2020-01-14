package be.helha.aemt.util;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import be.helha.aemt.entity.Address;
import be.helha.aemt.entity.Admin;
import be.helha.aemt.entity.FormerStudent;
import be.helha.aemt.entity.Member;
import be.helha.aemt.enumeration.Major;

public class Main {

	public static void main(String args[]) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("groupeB4");
        EntityManager em = emf.createEntityManager();
        
		Member m1 = new Admin("Robin","Roekens","admin","77e467eb0169e82e77f090df217a323357c6a157a98c0375e6f6dbafe029c83a",LocalDate.now());
		Member m2 = new FormerStudent("Elsa","Draux","ancien","77e467eb0169e82e77f090df217a323357c6a157a98c0375e6f6dbafe029c83a",LocalDate.of(1988, 7, 4), 2020, 
				Major.InformatiqueGestion, "0000000", true, 
				new Address("Beloeil", "Rue de la fosse", "114", 7972));
		Member m3 = new FormerStudent("Bastien","Decorte","user","77e467eb0169e82e77f090df217a323357c6a157a98c0375e6f6dbafe029c83a",LocalDate.of(2000, 12, 30), 2021, 
				Major.InformatiqueGestion, "1111111", true, 
				new Address("Mons", "Rue du coq", "53a", 7500));
		
		em.getTransaction().begin();
		em.persist(m1);
		em.persist(m2);
		em.persist(m3);
		em.getTransaction().commit();
		em.close();
	}
}
