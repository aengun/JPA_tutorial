package hellojpa;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

//            Member member = new Member();
//            member.setUsername("member1");
//            em.persist(member );
//
//            //반환 타입이 명확한 경우
//            TypedQuery<Member> query1 = em.createQuery("select m from Member m", Member.class);
//            //반환 타입이 명확하지 않은경우
//           Query query2 = em.createQuery("select m.username, m.age from Member m");

//            //==============================================================
//            //결과 조회 api >> 리스트 반환, 결과가 없으면 빈리스트
//            Member member = new Member();
//            member.setUsername("member1");
//            em.persist(member);
//
//            TypedQuery<Member> query = em.createQuery("select m from Member m", Member.class);
//            List<Member> resultList = query.getResultList(); // 결과가 하나 이상일 때
//
//            for (Member m : resultList) {
//                System.out.println("member : " + member);
//            }

//            //==============================================================
//            //결과 조회 api >> 단일 객체 반환
//            // 결과가 없으면 NoResultEsception
//            // 결과가 둘 이상이면 NonUniqueResultException
//            Member member = new Member();
//            member.setUsername("member1");
//            em.persist(member);
//
//            TypedQuery<Member> query = em.createQuery("select m from Member m where m.id=1L", Member.class);
//            Member result = query.getSingleResult();// 결과가 정확히 하나
//
//            System.out.println("result = " + result);

//            //==============================================================
//            //파라미터 바인딩
//            Member member = new Member();
//            member.setUsername("member1");
//            member.setAge(10);
//            em.persist(member);
//
//            TypedQuery<Member> query = em.createQuery("select m from Member m where m.username=:username", Member.class);
//            query.setParameter("username", "member1");
//            Member result = query.getSingleResult();// 결과가 정확히 하나
//
//            System.out.println("result = " + result.getUsername());

//            //==============================================================
//            //파라미터 바인딩2
//            Member member = new Member();
//            member.setUsername("member1");
//            member.setAge(10);
//            em.persist(member);
//
//            Member result = em.createQuery("select m from Member m where m.username=:username", Member.class)
//                    .setParameter("username", "member1")
//                    .getSingleResult();// 결과가 정확히 하나
//
//            System.out.println("result = " + result.getUsername());

//            //==============================================================
//            //프로젝션1 : 엔티티 프로젝션(프로젝션: select절에 조회할 대상을 지정하는 것)
//            // 영속성컨텍스트에서 관리가 된다.
//            Member member = new Member();
//            member.setUsername("member1");
//            member.setAge(10);
//            em.persist(member);
//
//            em.flush();
//            em.clear();
//
//            List<Member> resultList = em.createQuery("select m from Member m", Member.class)
//                    .getResultList();
//
//            Member findMember = resultList.get(0);
//            findMember.setAge(20); // 영속성 컨텍스트에서 관리됨

//            //==============================================================
//            //프로젝션2 다른 엔티티 가져올 때
//            Member member = new Member();
//            member.setUsername("member1");
//            member.setAge(10);
//            em.persist(member);
//
//            em.flush();
//            em.clear();
//
//            List<Team> resultList = em.createQuery("select m.team from Member m", Team.class)
//                    .getResultList();

//            //==============================================================
//            //프로젝션2-2 다른 엔티티 가져올 때 >> join문법 그대로 써라
//            Member member = new Member();
//            member.setUsername("member1");
//            member.setAge(10);
//            em.persist(member);
//
//            em.flush();
//            em.clear();
//
//            List<Team> resultList = em.createQuery("select t from Member m join m.team t", Team.class)
//                    .getResultList();

//            //==============================================================
//            //프로젝션3 임베디드 타입 프로젝션
//            Member member = new Member();
//            member.setUsername("member1");
//            member.setAge(10);
//            em.persist(member);
//
//            em.flush();
//            em.clear();
//
//            List<Address> resultList = em.createQuery("select o.address from Order o", Address.class)
//                    .getResultList();

//            //==============================================================
//            //프로젝션4 스칼라
//            Member member = new Member();
//            member.setUsername("member1");
//            member.setAge(10);
//            em.persist(member);
//
//            em.flush();
//            em.clear();
//
//            List resultList = em.createQuery("select m.username, m.age from Member m")
//                    .getResultList();
//
//            Object o =  resultList.get(0);
//            Object[] result = (Object[]) o;
//
//            for(Object object : result){
//                System.out.println(object);
//            }

//            //==============================================================
//            //프로젝션4-2 스칼라 - TypeQuery 만들기
//            Member member = new Member();
//            member.setUsername("member1");
//            member.setAge(10);
//            em.persist(member);
//
//            em.flush();
//            em.clear();
//
//            List<Object[]> resultList = em.createQuery("select m.username, m.age from Member m")
//                    .getResultList();
//
//            Object[] o =  resultList.get(0);
//            for(Object object : o){
//                System.out.println(object);
//            }

//            //==============================================================
//            //프로젝션4-3 스칼라 - new 명령어로 DTO 로 조회
//            Member member = new Member();
//            member.setUsername("member1");
//            member.setAge(10);
//            em.persist(member);
//
//            em.flush();
//            em.clear();
//
//            List<MemberDTO> resultList = em.createQuery("select new hellojpa.MemberDTO(m.username, m.age) from Member m", MemberDTO.class)
//                    .getResultList();
//
//            for(MemberDTO m : resultList){
//                System.out.println(m.getUsername()+" "+m.getAge());
//            }

//            //==============================================================
//            // 페이징 API
//            for (int i = 0; i < 100; i++) {
//                Member member = new Member();
//                member.setUsername("member" + i);
//                member.setAge(i);
//                em.persist(member);
//            }
//
//            em.flush();
//            em.clear();
//
//            List<Member> resultList = em.createQuery("select m from Member m order by m.age desc", Member.class)
//                    .setFirstResult(1  )
//                    .setMaxResults(10)
//                    .getResultList();
//            System.out.println("resultList.size = " + resultList.size());
//            for (Member m : resultList) {
//                System.out.println("m = " + m.toString());
//            }

//            //==============================================================
//            // 조인
//            Team team =  new Team();
//            team.setName("teamA");
//            em.persist(team);
//
//            Member member = new Member();
//            member.setUsername("member1");
//            member.setAge(10);
//
//            member.setTeam(team);
//
//            em.persist(member);
//
//            em.flush();
//            em.clear();
//
//            String query = "select m from Member m inner join m.team t";
//            List<Member> resultList = em.createQuery(query, Member.class)
//                    .getResultList();

            //==============================================================
            // 서브쿼리 >> 말로만 설명

//            //==============================================================
//            // 타입 표현
//            Team team =  new Team();
//            team.setName("teamA");
//            em.persist(team);
//
//            Member member = new Member();
//            member.setUsername("member1");
//            member.setAge(10);
//            member.setType(MemberType.ADMIN);
//
//            member.setTeam(team);
//
//            em.persist(member);
//
//            em.flush();
//            em.clear();
//
//            String query = "select m.username, 'HELLO', TRUE from Member m "
//                    +"where m.type = hellojpa.MemberType.ADMIN"; // enum은 패키지명까지 다 써야함
//            List<Object[]> resultList = em.createQuery(query)
//                    .getResultList();
//
//            for(Object[] objects : resultList){
//                System.out.println(objects[0]);
//                System.out.println(objects[1]);
//                System.out.println(objects[2]);
//            }

//            //==============================================================
//            // 케이스문
//            Team team = new Team();
//            team.setName("teamA");
//            em.persist(team);
//
//            Member member = new Member();
//            member.setUsername("member1");
//            member.setAge(10);
//            member.setType(MemberType.ADMIN);
//
//            member.setTeam(team);
//
//            em.persist(member);
//
//            em.flush();
//            em.clear();
//
//            String query =
//                    "select " +
//                            "case when m.age <= 10 then '학생요금' " +
//                            " when m.age >= 60 then '경로요금' " +
//                            " else '일반요금' end " +
//                            "from Member m";
//            List<String> resultList = em.createQuery(query, String.class)
//                    .getResultList();
//            for (String s : resultList) {
//                System.out.println("s = " + s);
//            }

//            //==============================================================
//            // 케이스문
//            Team team = new Team();
//            team.setName("teamA");
//            em.persist(team);
//
//            Member member = new Member();
//            member.setAge(10);
//            member.setType(MemberType.ADMIN);
//
//            member.setTeam(team);
//
//            em.persist(member);
//
//            em.flush();
//            em.clear();
//
//            String query = "select coalesce(m.username, '이름 없는 회원') from Member m";
//            List<String> resultList = em.createQuery(query, String.class)
//                    .getResultList();
//            for (String s : resultList) {
//                System.out.println("s = " + s);
//            }

            //==============================================================
            // 케이스문
            Team team = new Team();
            team.setName("teamA");
            em.persist(team);

            Member member = new Member();
            member.setAge(10);
            member.setType(MemberType.ADMIN);

            member.setTeam(team);

            em.persist(member);

            em.flush();
            em.clear();

            String query = "select nullif(m.username, '관리자') from Member m";
            List<String> resultList = em.createQuery(query, String.class)
                    .getResultList();
            for (String s : resultList) {
                System.out.println("s = " + s);
            }

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
