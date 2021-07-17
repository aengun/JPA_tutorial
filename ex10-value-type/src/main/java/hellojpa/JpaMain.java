package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

//            Member member = new Member();
//            member.setUsername("hello");
//            member.setHomeAddress(new Address("city", "street", "10"));
//            member.setWorkPeriod(new Period());
//            em.persist(member);

//            //================================================================
//
//            Address address = new Address("city", "street", "10");
//
//            Member member1 = new Member();
//            member1.setUsername("member1");
//            member1.setHomeAddress(address);
//            em.persist(member1);
//
//            Member member2 = new Member();
//            member2.setUsername("member2");
//            member2.setHomeAddress(address);
//            em.persist(member2);
//
//            member1.getHomeAddress().setCity("newCity"); // member2의 주소도 바뀐다

//            //================================================================
//
//            Address address = new Address("city", "street", "10");
//
//            Member member1 = new Member();
//            member1.setUsername("member1");
//            member1.setHomeAddress(address);
//            em.persist(member1);
//
//            Address address2 = new Address(address.getCity(), address.getStreet(), address.getZipcode());
//
//            Member member2 = new Member();
//            member2.setUsername("member2");
//            member2.setHomeAddress(address2);
//            em.persist(member2);
//
//            member1.getHomeAddress().setCity("newCity"); // member2의 주소도 바뀐다

//            //================================================================
//
//            Address address = new Address("city", "street", "10");
//
//            Member member1 = new Member();
//            member1.setUsername("member1");
//            member1.setHomeAddress(address);
//            em.persist(member1);
//
//            // 값을 바꾸고 싶은 경우 (세터를 지워서 못 바꾸는 상황) : 통째로 바꾼다
//            Address newAddress = new Address("NewCity", address.getStreet(), address.getZipcode());
//            member1.setHomeAddress(newAddress);

            //================================================================

            Address address1 = new Address("city", "street", "10");
            Address address2 = new Address("city", "street", "10");

            System.out.println("address1 == address2 : " + (address1 == address2));
            System.out.println("address1 equals address2 : " + (address1.equals(address2)));




            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            System.out.println("e = " + e);
        } finally {
            em.close();
        }

        emf.close();

    }


}
