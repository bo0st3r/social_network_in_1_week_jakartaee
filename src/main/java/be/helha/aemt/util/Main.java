package be.helha.aemt.util;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import be.helha.aemt.entity.Address;
import be.helha.aemt.entity.Admin;
import be.helha.aemt.entity.FormerStudent;
import be.helha.aemt.entity.Member;
import be.helha.aemt.entity.News;
import be.helha.aemt.enumeration.Major;

public class Main {

	public static void main(String args[]) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("groupeB4");
        EntityManager em = emf.createEntityManager();
        
		Member m1 = new Admin("Robin","Roekens","admin","77e467eb0169e82e77f090df217a323357c6a157a98c0375e6f6dbafe029c83a","admin",LocalDate.now());
		Member m2 = new FormerStudent("Elsa","Draux","ancien","77e467eb0169e82e77f090df217a323357c6a157a98c0375e6f6dbafe029c83a","ancien", LocalDate.of(1988, 7, 4), 2020, 
				Major.InformatiqueGestion, "0000000", true, 
				new Address("Beloeil", "Rue de la fosse", "114", 7972));
		Member m3 = new FormerStudent("Bastien","Decorte","user","77e467eb0169e82e77f090df217a323357c6a157a98c0375e6f6dbafe029c83a","user",LocalDate.of(2000, 12, 30), 2021, 
				Major.InformatiqueGestion, "1111111", true, 
				new Address("Mons", "Rue du coq", "53a", 7500));
		
		Member m4 = new FormerStudent("Jean","Pierre","jj","77e467eb0169e82e77f090df217a323357c6a157a98c0375e6f6dbafe029c83a","jp@g.g",LocalDate.of(1980, 7, 14), 2012, 
				Major.AssistantDirection, "1111111", false, null);
		Member m5 = new FormerStudent("Marie","Jeanne","mar","77e467eb0169e82e77f090df217a323357c6a157a98c0375e6f6dbafe029c83a","mariejeanne@g.g",LocalDate.of(1960, 8, 23), 2015, 
				Major.AssistantDirection, "1111111", false, null);
		Member m6 = new FormerStudent("Eliot","Hennebo","elio","77e467eb0169e82e77f090df217a323357c6a157a98c0375e6f6dbafe029c83a","elio@g.g",LocalDate.of(1975, 5, 30), 2016, 
				Major.Comptabilite, "1111111", false, null);
		Member m7 = new FormerStudent("Steven","Durenne","stev","77e467eb0169e82e77f090df217a323357c6a157a98c0375e6f6dbafe029c83a","test@gmail.com",LocalDate.of(1999, 2, 22), 2013, 
				Major.Comptabilite, "1111111", false, null);
		
//		News n1 = new News("Une délégation internationale de l’AWEX à la HELHa","Une délégation internationale de l’AWEX (Agence wallonne à l’exportation et aux investissements étrangers) a visité le campus de la HELHa Mons ce matin dans le but de découvrir la formation DataCenter Engineering.\n" + 
//				"Des dignitaires venus des quatre coins du monde (Chine, États-Unis, Canada et Singapour) ont pu suivre des modules de la formation continue et assister au maintien d’un vrai Data Center.\n" + 
//				"Cette rencontre, en plus de promouvoir le savoir-faire belge au-delà de notre continent, a eu pour objectif de faciliter les échanges entre les professionnels du secteur et les professeurs en vue co-développer la formation.\n" + 
//				"Une véritable plus-value pour la HELHa et ses étudiants en ingénierie !", LocalDate.now());		
		em.getTransaction().begin();
		em.persist(m1);
		em.persist(m2);
		em.persist(m3);
		em.persist(m4);
		em.persist(m5);
		em.persist(m6);
		em.persist(m7);
//		em.persist(n1);
		em.getTransaction().commit();
		em.close();
	}
}
