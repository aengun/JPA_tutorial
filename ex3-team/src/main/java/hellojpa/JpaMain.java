package hellojpa;

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

//            Team team = new Team();
//            team.setName("teamA");
//            em.persist(team);
//
//            Member member = new Member();
//            member.setUsername("member1");
//            member.setTeamId(team.getId());
//            em.persist(member);
//
//            // 멤버로 팀 조회
//            Member findMember = em.find(Member.class, member.getId());
//            Long findTeamId = findMember.getTeamId();
//            Team findTeam = em.find(Team.class, indTeamId); // 객체지향 스럽지 않다

//            //===================================================
//
//            Team team = new Team();
//            team.setName("teamA");
//            em.persist(team);
//
//            Member member = new Member();
//            member.setUsername("member1");
//            member.setTeam(team );
//            em.persist(member);
//
//            em.flush();
//            em.clear();
//
//            Member findMember = em.find(Member.class, member.getId());
//            Team findTeam = findMember.getTeam();
//
//            //멤버의 팀 바꾸기
//            Team newTeam = em.find(Team.class, 100L);
//            findMember.setTeam(newTeam);

//            //===================================================
//
//            Team team = new Team();
//            team.setName("teamA");
//            em.persist(team);
//
//            Member member = new Member();
//            member.setUsername("member1");
//            member.setTeam(team );
//            em.persist(member);
//
//            em.flush();
//            em.clear();
//
//            Member findMember = em.find(Member.class, member.getId());
//            List<Member> members = findMember.getTeam().getMembers();
//
//            for(Member m : members){
//                System.out.println("m : "+m.getUsername());
//            }

            //===================================================

            Team team = new Team();
            team.setName("teamA");
            em.persist(team);

            Member member = new Member();
            member.setUsername("member1");
//            member.setTeam(team); //**
            member.changeTeam(team); //**
            em.persist(member);

//            team.addMember(member); // member.changeTeam과 이것 둘 중 하나만 쓴다

//            team.getMembers().add(member); // 그냥 메소드로 해결 >> Member.changeMember

            Team findTeam = em.find(Team.class, team.getId());
            List<Member> members = findTeam.getMembers();

            for(Member m : members){
                System.out.println("m : "+ m.getUsername());
            }

            em.flush();
            em.clear();

            tx.commit();

        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();

    }

}
