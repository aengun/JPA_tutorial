package jpql;

import org.hibernate.annotations.BatchSize;

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

//            //===============================================
//            // fetch Join
//            Team teamA = new Team();
//            teamA.setName("팀A");
//            em.persist(teamA);
//
//            Team teamB = new Team();
//            teamB.setName("팀B");
//            em.persist(teamB);
//
//            Member member1 = new Member();
//            member1.setUsername("회원1");
//            member1.setTeam(teamA);
//            em.persist(member1);
//
//            Member member2 = new Member();
//            member2.setUsername("회원2");
//            member2.setTeam(teamA);
//            em.persist(member2);
//
//            Member member3 = new Member();
//            member3.setUsername("회원3");
//            member3.setTeam(teamB);
//            em.persist(member3);
//
//            em.flush();
//            em.clear();
//
////            String query = "select m From Member m";
//            String query = "select m From Member m join fetch m.team";
//
//            List<Member> result = em.createQuery(query, Member.class)
//                    .getResultList();
//
//            for (Member member : result) {
//                System.out.println("member : " + member.getUsername() + ", team : " + member.getTeam().getName());
//                //쿼리 순서
//                //회원1, 팀A(SQL)
//                //회원2, 팀A(1차 캐시 )
//                //회원3, 팀B(SQL)
//                //100명이라면???? ==> n+1 ==> fetch join으로 해결
//            }

//            //===============================================
//            // fetch Join
//            Team teamA = new Team();
//            teamA.setName("팀A");
//            em.persist(teamA);
//
//            Team teamB = new Team();
//            teamB.setName("팀B");
//            em.persist(teamB);
//
//            Member member1 = new Member();
//            member1.setUsername("회원1");
//            member1.setTeam(teamA);
//            em.persist(member1);
//
//            Member member2 = new Member();
//            member2.setUsername("회원2");
//            member2.setTeam(teamA);
//            em.persist(member2);
//
//            Member member3 = new Member();
//            member3.setUsername("회원3");
//            member3.setTeam(teamB);
//            em.persist(member3);
//
//            em.flush();
//            em.clear();
//
//            String query = "select t From Team t join fetch t.members";
//
//            List<Team> result = em.createQuery(query, Team.class)
//                    .getResultList();
//
//            for (Team team : result) {
//                System.out.println("team : " + team.getName() + ", " + team.getMembers().size());
//                for (Member m : team.getMembers()) {
//                    System.out.println("==> member : " + m);
//                }
//            }

//            //===============================================
//            // fetch Join - 중복 제거
//            Team teamA = new Team();
//            teamA.setName("팀A");
//            em.persist(teamA);
//
//            Team teamB = new Team();
//            teamB.setName("팀B");
//            em.persist(teamB);
//
//            Member member1 = new Member();
//            member1.setUsername("회원1");
//            member1.setTeam(teamA);
//            em.persist(member1);
//
//            Member member2 = new Member();
//            member2.setUsername("회원2");
//            member2.setTeam(teamA);
//            em.persist(member2);
//
//            Member member3 = new Member();
//            member3.setUsername("회원3");
//            member3.setTeam(teamB);
//            em.persist(member3);
//
//            em.flush();
//            em.clear();
//
//            String query = "select distinct t From Team t join fetch t.members";
//
//            List<Team> result = em.createQuery(query, Team.class)
//                    .getResultList();
//
//            for (Team team : result) {
//                System.out.println("team : " + team.getName() + ", " + team.getMembers().size());
//                for (Member m : team.getMembers()) {
//                    System.out.println("==> member : " + m);
//                }
//            }

//            //===============================================
//            // 페이징
//            // Team 클래스에 batchsize
//            // or Global option으로 default_batch_fetch_size(persistence.xml)
//            Team teamA = new Team();
//            teamA.setName("팀A");
//            em.persist(teamA);
//
//            Team teamB = new Team();
//            teamB.setName("팀B");
//            em.persist(teamB);
//
//            Member member1 = new Member();
//            member1.setUsername("회원1");
//            member1.setTeam(teamA);
//            em.persist(member1);
//
//            Member member2 = new Member();
//            member2.setUsername("회원2");
//            member2.setTeam(teamA);
//            em.persist(member2);
//
//            Member member3 = new Member();
//            member3.setUsername("회원3");
//            member3.setTeam(teamB);
//            em.persist(member3);
//
//            em.flush();
//            em.clear();
//
//            String query = "select distinct t From Team t join fetch t.members";
//
//            List<Team> result = em.createQuery(query, Team.class)
//                    .setFirstResult(0)
//                    .setMaxResults(2)
//                    .getResultList();
//
//            System.out.println("result = " + result.size());
//
//            for (Team team : result) {
//                System.out.println("team : " + team.getName() + ", " + team.getMembers().size());
//                for (Member m : team.getMembers()) {
//                    System.out.println("==> member : " + m);
//                }
//            }

//            //===============================================
//            // 엔티티 직접 사용
//            Team teamA = new Team();
//            teamA.setName("팀A");
//            em.persist(teamA);
//
//            Team teamB = new Team();
//            teamB.setName("팀B");
//            em.persist(teamB);
//
//            Member member1 = new Member();
//            member1.setUsername("회원1");
//            member1.setTeam(teamA);
//            em.persist(member1);
//
//            Member member2 = new Member();
//            member2.setUsername("회원2");
//            member2.setTeam(teamA);
//            em.persist(member2);
//
//            Member member3 = new Member();
//            member3.setUsername("회원3");
//            member3.setTeam(teamB);
//            em.persist(member3);
//
//            em.flush();
//            em.clear();
//
////            String query = "select m from Member m where m = :member";
////
////            Member findMember = em.createQuery(query, Member.class)
////                    .setParameter("member", member1)
////                    .getSingleResult();
//
//            // 엔티티 직접 사용한 것과 기본키를 사용한것과 쿼리가 같음
//            String query = "select m from Member m where m.id = :memberId";
//
//            Member findMember = em.createQuery(query, Member.class)
//                    .setParameter("memberId", member1.getId())
//                    .getSingleResult();
//
//            System.out.println("findMember : " + findMember);

//            //===============================================
//            // 엔티티 직접 사용 - 외래키
//            Team teamA = new Team();
//            teamA.setName("팀A");
//            em.persist(teamA);
//
//            Team teamB = new Team();
//            teamB.setName("팀B");
//            em.persist(teamB);
//
//            Member member1 = new Member();
//            member1.setUsername("회원1");
//            member1.setTeam(teamA);
//            em.persist(member1);
//
//            Member member2 = new Member();
//            member2.setUsername("회원2");
//            member2.setTeam(teamA);
//            em.persist(member2);
//
//            Member member3 = new Member();
//            member3.setUsername("회원3");
//            member3.setTeam(teamB);
//            em.persist(member3);
//
//            em.flush();
//            em.clear();
//
//            String query = "select m from Member m where m.team = :team";
//
//            List<Member> result = em.createQuery(query, Member.class)
//                    .setParameter("team", teamA)
//                    .getResultList();
//
//            System.out.println("result : " + result);

//            //===============================================
//            // named 쿼리
//            Team teamA = new Team();
//            teamA.setName("팀A");
//            em.persist(teamA);
//
//            Team teamB = new Team();
//            teamB.setName("팀B");
//            em.persist(teamB);
//
//            Member member1 = new Member();
//            member1.setUsername("회원1");
//            member1.setTeam(teamA);
//            em.persist(member1);
//
//            Member member2 = new Member();
//            member2.setUsername("회원2");
//            member2.setTeam(teamA);
//            em.persist(member2);
//
//            Member member3 = new Member();
//            member3.setUsername("회원3");
//            member3.setTeam(teamB);
//            em.persist(member3);
//
//            em.flush();
//            em.clear();
//
//            List<Member> resultList = em.createNamedQuery("Member.findByUsername", Member.class)
//                    .setParameter("username", "회원1")
//                    .getResultList();
//
//            for (Member m : resultList) {
//                System.out.println("member = " + m);
//            }

            //===============================================
            // 벌크 연산
            Team teamA = new Team();
            teamA.setName("팀A");
            em.persist(teamA);

            Team teamB = new Team();
            teamB.setName("팀B");
            em.persist(teamB);

            Member member1 = new Member();
            member1.setUsername("회원1");
            member1.setTeam(teamA);
            em.persist(member1);

            Member member2 = new Member();
            member2.setUsername("회원2");
            member2.setTeam(teamA);
            em.persist(member2);

            Member member3 = new Member();
            member3.setUsername("회원3");
            member3.setTeam(teamB);
            em.persist(member3);

            //flush
            int resultCount = em.createQuery("update Member m set m.age = 20")
                    .executeUpdate();
            em.clear();
//            System.out.println("result count : " + resultCount);
//
//            System.out.println("member1.getAge() = " + member1.getAge());
//            System.out.println("member2.getAge() = " + member2.getAge());
//            System.out.println("member3.getAge() = " + member3.getAge());

            Member findMember = em.find(Member.class, member1.getId());

            System.out.println("findMember = " + findMember.getAge());


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
