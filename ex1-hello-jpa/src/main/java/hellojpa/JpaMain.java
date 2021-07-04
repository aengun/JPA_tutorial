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
//            멤버 추가
//            Member member = new Member();
//            member.setId(2L);
//            member.setName("helloB");
//            em.persist(member);

//            조회
//            Member findMember = em.find(Member.class, 1L);
//            System.out.println("findMember = "+findMember.getId()+" "+findMember.getName());

//            삭제
//            em.remove(findMember);

//            수정
//            Member findMember = em.find(Member.class, 1L);
//            findMember.setName("helloJPA"); // 이후 em.persist로 저장 안 해도 됨

//            쿼리를 직접 쓰는 경우 : JPQL
//            List<Member> result =  em.createQuery("select m from Member as m", Member.class)
//                    .getResultList();
//            for(Member member : result){
//                System.out.println("member = "+member.getId()+" "+member.getName());
//            }


//            ============================3장======================

//            //비영속
//            Member member = new Member();
//            member.setId(100L);
//            member.setName("helloJPA");
//            //영속 - 이때는 아직 db에 저장되지 않는다.
//            System.out.println("==== BEFORE ====");
//            em.persist(member);
//            System.out.println("==== AFTER ====");
//            //준영속 : 영속 상테를 분리
//            em.detach(member);
//            //삭제 : 객체 삭제
//            em.remove(member);


            //1차캐시 테스트
//            Member member = new Member();
//            member.setId(102L);
//            member.setName("helloJPA");
//            System.out.println("==== BEFORE ====");
//            em.persist(member);
//            System.out.println("==== AFTER ====");
//
//            Member findMember = em.find(Member.class, 102L);
//            System.out.println("findMember.id : "+findMember.getId());
//            System.out.println("findMember.name : "+findMember.getName());

//            // 1차캐시 테스트 쿼리가 한 번만 실행됨
//            Member findMember1 = em.find(Member.class, 101L);
//            Member findMember2 = em.find(Member.class, 101L);
//
//            // 영속 엔티티의 동일성 보장
//            System.out.println("result : " + (findMember1 == findMember2));

            // 엔티티 저장되는 시점 확인 : 커밋 할 때(persist할때 아님)
//            Member member1 = new Member(150L, "A");
//            Member member2 = new Member(160L, "B");
//
//            em.persist(member1);
//            em.persist(member2);
//
//            System.out.println("==========================");

            // 엔티티 수정
//            Member member = em.find(Member.class, 150L);
//            member.setName("zzzz"); // => persist필요 없이 바로 변경됨
//            System.out.println("===========================");

            // 플러시
//            Member member = new Member(200L, "member200");
//            em.persist(member);
//            em.flush();
//            System.out.println("======================");

            // 준영속 상태
//            Member member = em.find(Member.class, 150L);
//            member.setName("AAAA");
//            em.detach(member);
//            System.out.println("=====================");

            // 준영속 clear
//            Member member = em.find(Member.class, 150L);
//            member.setName("AAAA");
//            em.clear();
//            System.out.println("=====================");
//
//            Member member2 = em.find(Member.class, 150L);


//            ============================4장======================

            Member member = new Member();
            member.setUsername("C");

            em.persist(member);



//            ============================5장======================

            tx.commit();

        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();

    }

}
