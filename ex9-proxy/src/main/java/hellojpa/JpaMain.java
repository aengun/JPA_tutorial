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

////            Member member = em.find(Member.class, 1L);
////            printMemberAndTeam(member);
////            printMember(member);
//
//            Member member = new Member();
//            member.setUsername("hello");
//            em.persist(member);
//
//            em.flush();
//            em.clear();
//
////            Member findMember = em.find(Member.class, member.getId());
////            System.out.println("findMember.id = "+findMember.getId());
////            System.out.println("findMember.username = "+findMember.getUsername());
//            Member findMember = em.getReference(Member.class, member.getId());
//
//            System.out.println("findMember.class = " + findMember.getClass());
//            System.out.println("findMember.id = " + findMember.getId());
//            System.out.println("findMember.username = "+findMember.getUsername());

            //===================================================================

            Member member = new Member();
            member.setUsername("hello");
            em.persist(member);

            Member member2 = new Member();
            member2.setUsername("hello2");
            em.persist(member2);

            Member m1 = em.find(Member.class, member.getId());
            Member m2 = em.find(Member.class, member.getId());

            System.out.println(m1.getClass() == m2.getClass());

            tx.commit();

        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();

    }

//    private static void printMember(Member member) {
//        System.out.println("username = " + member.getUsername());
//    }
//
//    private static void printMemberAndTeam(Member member) {
//
//        String username = member.getUsername();
//        System.out.println("username = " + username);
//
//        Team team = member.getTeam();
//        System.out.println("team = " + team.getName());
//
//    }

}
