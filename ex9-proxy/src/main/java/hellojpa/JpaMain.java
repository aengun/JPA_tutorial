package hellojpa;

import org.hibernate.Hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

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

//            System.out.println("start=======================");
//
//            Member member = new Member();
//            member.setUsername("hello");
//            em.persist(member);
//
//            Member member2 = new Member();
//            member2.setUsername("hello2");
//            em.persist(member2);
//            System.out.println("flush========================");
//            em.flush();
//            em.clear();
//
//
//            Member m1 = em.find(Member.class, member.getId());
//            Member m2 = em.find(Member.class, member.getId());
//
//            System.out.println("=================="+(m1.getClass() == m2.getClass()));

            //==================================================================

//            Member member1 = new Member();
//            member1.setUsername("member1");
//            em.persist(member1);
//
//            em.flush();
//            em.clear();
//
//            Member refMember = em.getReference(Member.class, member1.getId());
//            System.out.println("refMember = " + refMember.getClass());
//
//            Member findMember = em.find(Member.class, member1.getId());
//            System.out.println("findMember = " + findMember.getClass());
//
//            System.out.println("ref == find" + (refMember == findMember));
//
//
//            tx.commit();

            //==================================================================
//            Member member1 = new Member();
//            member1.setUsername("member1");
//            em.persist(member1);
//
//            em.flush();
//            em.clear();
//
//            Member refMember = em.getReference(Member.class, member1.getId());
//            System.out.println("refMember = " + refMember.getClass());
//
////            em.detach(refMember);
////            em.clear();
////            refMember.getUsername();
//
////            refMember.getUsername();
////            System.out.println("isLoaded = " + emf.getPersistenceUnitUtil().isLoaded(refMember));
//
//            Hibernate.initialize(refMember); // 강제 초기화


            // ===================================================================
            // 프록시 2강 즉시로딩 지연로딩

//            Team team = new Team();
//            team.setName("teamA");
//            em.persist(team);
//
//            Member member1 = new Member();
//            member1.setUsername("member1");
//            member1.setTeam(team);
//            em.persist(member1);
//
//            em.flush();
//            em.clear();
//
//            Member m = em.find(Member.class, member1.getId());
//
//            System.out.println("===============1");
//            System.out.println("m = "+ m.getTeam().getClass());
//            System.out.println("===============2");
//            m.getTeam().getName();
//            System.out.println("===============3");

            //===================================================================
            Team team1 = new Team();
            team1.setName("teamA");
            em.persist(team1);

            Team team2 = new Team();
            team2.setName("teamB");
            em.persist(team2);

            Member member1 = new Member();
            member1.setUsername("member1");
            member1.setTeam(team1);
            em.persist(member1);

            Member member2 = new Member();
            member2.setUsername("member2");
            member2.setTeam(team2);
            em.persist(member2);

            em.flush();
            em.clear();

            em.createQuery("select m from Member m join fetch m.team", Member.class)
                    .getResultList();

            Member m = em.find(Member.class, member1.getId());
            System.out.println(m.getTeam().getClass());


            //===================================================================

//            Child child1 = new Child();
//            Child child2 = new Child();
//
//            Parent parent = new Parent();
//            parent.addChild(child1);
//            parent.addChild(child2);
//
//            em.persist(parent);
////            em.persist(child1);
////            em.persist(child2);
//            em.flush();
//            em.clear();
//
//            Parent findParent = em.find(Parent.class, parent.getId());
//
//            findParent.getChildList().remove(0);


            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            System.out.println("e = " + e);
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
