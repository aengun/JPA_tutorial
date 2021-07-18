package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Set;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            //조회
//            Member member1 = new Member();
//            member1.setUsername("member1");
//            member1.setHomeAddress(new Address("homeCity", "street1", "1"));
//            member1.getFavoriteFoods().add("치킨");
//            member1.getFavoriteFoods().add("피자");
//            member1.getFavoriteFoods().add("족발");
//
//            member1.getAddressHistory().add(new Address("old1", "streetOld1", "old1"));
//            member1.getAddressHistory().add(new Address("old2", "streetOld2", "old2"));
//
//            em.persist(member1);
//
//            em.flush();
//            em.clear();
//
//            System.out.println("===============Start=================");
//            Member findMember = em.find(Member.class, member1.getId());
//            List<Address> addressHistory = findMember.getAddressHistory();
//            for (Address address : addressHistory) {
//                System.out.println("address : " + address.getCity());
//            }
//
//            Set<String> favoriteFoods = findMember.getFavoriteFoods();
//            for (String favoriteFood : favoriteFoods) {
//                System.out.println("favoriteFood : " + favoriteFood);
//            }

//            //============================================================
//            //수정
//
//            Member member1 = new Member();
//            member1.setUsername("member1");
//            member1.setHomeAddress(new Address("homeCity", "street1", "1"));
//            member1.getFavoriteFoods().add("치킨");
//            member1.getFavoriteFoods().add("피자");
//            member1.getFavoriteFoods().add("족발");
//
//            member1.getAddressHistory().add(new Address("old1", "streetOld1", "old1"));
//            member1.getAddressHistory().add(new Address("old2", "streetOld2", "old2"));
//
//            em.persist(member1);
//
//            em.flush();
//            em.clear();
//
//            Member findMember = em.find(Member.class, member1.getId());
//            //homeCity => newCity
////            findMember.getHomeAddress().setCity("newCity"); //immutable을 위해 세터를 프라이빗으로 설정해서 안됨
//            //값타입은 아예 새로 만들어서 바꿔넣어야 한다. 수정 불가
//            findMember.setHomeAddress(new Address("newCity", findMember.getHomeAddress().getStreet(), findMember.getHomeAddress().getZipcode()));
//
//            //치킨 >> 한식
//            findMember.getFavoriteFoods().remove("치킨");
//            findMember.getFavoriteFoods().add("한식");
//
//            //old1 >> new1
//            findMember.getAddressHistory().remove(new Address("old1", "streetOld1", "old1"));
//            findMember.getAddressHistory().add(new Address("newCity1", "streetOld1", "old1"));

            //============================================================
            //값타입 컬렉션 대안 : 컬렉션 대신에 일대다 관계를 고려한다. 일대다 관계를 위한 엔티티를 만들고 여기에 값 타입 사용

            Member member1 = new Member();
            member1.setUsername("member1");
            member1.setHomeAddress(new Address("homeCity", "street1", "1"));
            member1.getFavoriteFoods().add("치킨");
            member1.getFavoriteFoods().add("피자");
            member1.getFavoriteFoods().add("족발");

            member1.getAddressHistory().add(new AddressEntity("old1", "streetOld1", "old1"));
            member1.getAddressHistory().add(new AddressEntity("old2", "streetOld2", "old2"));

            em.persist(member1);

            em.flush();
            em.clear();

            Member findMember = em.find(Member.class, member1.getId());


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
