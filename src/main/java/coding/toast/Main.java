package coding.toast;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Main {
	public static void main(String[] args) {
		
		// persistence.xml 에 작성된
		// <persistence-unit name="my-unit"> 의 name 을
		// Persistence.createEntityManagerFactory 메소드의 인자로 전달합니다.
		try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-unit");
		     EntityManager em = emf.createEntityManager()) {
			
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			
			try {
				// 여기에 자기가 테스트해 보고 싶은 코드를 작성합니다.
				Member helloA = Member.builder().id(1L).name("CodingToastBread").build();
				em.persist(helloA);
				
				tx.commit();
			} catch (Exception e) {
				tx.rollback();
				throw new RuntimeException(e);
			}
		}
	}
}
