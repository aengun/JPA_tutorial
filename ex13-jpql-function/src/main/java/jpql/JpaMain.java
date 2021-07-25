package jpql;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

//            //===============================================
//            //경로 표현식 - 상태필드 : 단순히 값을 저장하기 위한 필드, 경로탐색의 끝, 탐색X
//            Member member1 = new Member();
//            member1.setUsername("관리자1");
//            em.persist(member1);
//
//            Member member2 = new Member();
//            member2.setUsername("관리자2");
//
//
//            em.persist(member2);
//
//            em.flush();
//            em.clear();
//
//            String query = "select m.username from Member m";
//
//            List<String> result = em.createQuery(query, String.class)
//                    .getResultList();
//
//            for (String s : result) {
//                System.out.println("s = " + s);
//            }

//            //===============================================
//            //경로 표현식 - 연관필드 - 단일값 연관경로(대상이 엔티티)
//            //묵시적 내부조인이 발생, 탐색 O
//            Member member1 = new Member();
//            member1.setUsername("관리자1");
//            em.persist(member1);
//
//            Member member2 = new Member();
//            member2.setUsername("관리자2");
//
//            em.persist(member2);
//
//            em.flush();
//            em.clear();
//
//            String query = "select m.team from Member m";
//
//            List<Team> result = em.createQuery(query, Team.class)
//                    .getResultList();
//
//            for (Team s : result) {
//                System.out.println("s = " + s);
//            }

//            //===============================================
//            //경로 표현식 - 연관필드 - 컬렉션 값 연관경로(대상이 컬렉션)
//            //묵시적 내부조인이 발생, 탐색 X
//            Team team = new Team();
//            em.persist(team);
//
//            Member member1 = new Member();
//            member1.setUsername("관리자1");
//            member1.setTeam(team);
//            em.persist(member1);
//
//            Member member2 = new Member();
//            member2.setUsername("관리자2");
//            member2.setTeam(team);
//            em.persist(member2);
//
//            em.flush();
//            em.clear();
//
//            String query = "select t.members from Team t";
//
//            Collection result = em.createQuery(query, Collection.class)
//                    .getResultList();
//
//            for (Object o : result) {
//                System.out.println("o = " + o);
//            }
//
//            String query2 = "select t.members.size from Team t";
//            Integer result2 = em.createQuery(query2, Integer.class).getSingleResult();
//            System.out.println("result2 = " + result2);

//            //===============================================
//            // 묵시적 조인 >> 명시적 조인으로 바꿔라
//            Team team = new Team();
//            em.persist(team);
//
//            Member member1 = new Member();
//            member1.setUsername("관리자1");
//            member1.setTeam(team);
//            em.persist(member1);
//
//            Member member2 = new Member();
//            member2.setUsername("관리자2");
//            member2.setTeam(team);
//            em.persist(member2);
//
//            em.flush();
//            em.clear();
//
//            //명시적 조인으로 별칭을 얻을 후 필요한 속성들을 가져온다.
//            String query = "select m.username from Team t join t.members m";
//
//            List<Collection> result = em.createQuery(query, Collection.class)
//                    .getResultList();
//            System.out.println("result = " + result);

            //===============================================
            // fetch Join
            Team team = new Team();
            em.persist(team);

            Member member1 = new Member();
            member1.setUsername("관리자1");
            member1.setTeam(team);
            em.persist(member1);

            Member member2 = new Member();
            member2.setUsername("관리자2");
            member2.setTeam(team);
            em.persist(member2);

            em.flush();
            em.clear();

            //명시적 조인으로 별칭을 얻을 후 필요한 속성들을 가져온다.
            String query = "select m.username from Team t join t.members m";

            List<Collection> result = em.createQuery(query, Collection.class)
                    .getResultList();
            System.out.println("result = " + result);


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
