package be.helha.aemt.util;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import be.helha.aemt.entity.Address;
import be.helha.aemt.entity.Admin;
import be.helha.aemt.entity.FormerStudent;
import be.helha.aemt.entity.InternshipOffer;
import be.helha.aemt.entity.JobOffer;
import be.helha.aemt.entity.Member;
import be.helha.aemt.entity.News;
import be.helha.aemt.entity.Offer;
import be.helha.aemt.entity.Portrait;
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
<<<<<<< HEAD
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
		Address a1 = new Address("Mons", "Rue de la paix", "98", 7000);
		Address a2 = new Address("Charleroi", "Rue du carreaux", "12", 6000);
		Address a3 = new Address("Namur", "Rue de Charleroi", "102", 5000);
		Address a4 = new Address("Bruxelles", "Rue de la finance", "666", 1000);
		Address a5 = new Address("Bruxelles", "Rue des contrebandiers", "1", 1000);
		Address a6 = new Address("Messancy", "Chaussée de Namur", "78", 6780);
		Address a7 = new Address("Ath", "Rue du débutant", "19", 7800);

		InternshipOffer oi3= new InternshipOffer("Stage d'assistant de direction", "Nestlé Belgique", "Nestlé Belgique recherche un/une assistant(e) de direction pour son siège de Namur. Vous serez amené a être autonome, Stage enrichissant", LocalDate.of(2020, 9, 01), LocalDate.now(), true, Major.AssistantDirection, a3, "90 jours", true);
		InternshipOffer oi4= new InternshipOffer("Stage en Informatique SPF finance", "SPF Finance", "Stage non rémunéré, bien encadré", LocalDate.of(2020, 4, 01), LocalDate.now(), true, Major.InformatiqueGestion, a4, "3 mois", true);
		JobOffer jo1 = new JobOffer("Consultant Informatique", "IT Company", "Mobile partout en Belgique, la route ne vous fait pas peur", LocalDate.of(2020, 2, 1), LocalDate.now(), true, Major.InformatiqueGestion, a2,"CDI");
		JobOffer jo2 = new JobOffer("CDD Comptable Mons", "Cabinet J et fils","Nous recherchons actuellement un/une comptable pour étoffer notre petite équipe.  Les horaires sont flexibles.  CDD de 6 mois pour commencer", LocalDate.of(2020, 7, 1), LocalDate.now(), true, Major.Comptabilite, a1,"CDD");
//		Portrait p1 = new Portrait("Un parcours de geek", "La définition du geek peut varier d'un individu à l'autre, mais la définition qui en ressort le plus souvent est celle-ci : un geek (de l'anglais : Écouter) est une personne passionnée par un ou plusieurs domaines précis, plus souvent utilisé pour les domaines liés aux « cultures de l'imaginaire » (certains genres du cinéma, la bande dessinée, les jeux vidéo, les jeux de rôles, etc.), ou encore aux sciences, à la technologie et l'informatique.  R.R.");
		
=======
//		News n1 = new News("Une délégation internationale de l’AWEX à la HELHa","Une délégation internationale de l’AWEX (Agence wallonne à l’exportation et aux investissements étrangers) a visité le campus de la HELHa Mons ce matin dans le but de découvrir la formation DataCenter Engineering.\n" + 
//				"Des dignitaires venus des quatre coins du monde (Chine, États-Unis, Canada et Singapour) ont pu suivre des modules de la formation continue et assister au maintien d’un vrai Data Center.\n" + 
//				"Cette rencontre, en plus de promouvoir le savoir-faire belge au-delà de notre continent, a eu pour objectif de faciliter les échanges entre les professionnels du secteur et les professeurs en vue co-développer la formation.\n" + 
//				"Une véritable plus-value pour la HELHa et ses étudiants en ingénierie !", LocalDate.now());		
>>>>>>> branch 'master' of https://github.com/bo0st3r/AEMT_2020_groupeB4.git
		em.getTransaction().begin();
		em.persist(m1);
		em.persist(m2);
		em.persist(m3);
<<<<<<< HEAD
		em.persist(m4);
		em.persist(m5);
		em.persist(m6);
		em.persist(m7);
		em.persist(a1);
		em.persist(a2);
		em.persist(a3);
		em.persist(a4);
		em.persist(a5);
		em.persist(a6);
		em.persist(a7);
		em.persist(oi4);
		em.persist(oi3);
		em.persist(jo1);
		em.persist(jo2);
//		em.persist(p1);


=======
//		em.persist(n1);
>>>>>>> branch 'master' of https://github.com/bo0st3r/AEMT_2020_groupeB4.git
		em.getTransaction().commit();
		em.close();
	}
}
