package jpabook.jpashop.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jpabook.jpashop.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    //@PersistenceContext 스프링이 jpa의 EntityManager만들어서 주입해줌
    //spring-data-jpa를 통해 @PersistenceContext를 @Autowired로 변경할 수 있고 (원래는 안됨)
    //이것을 생성자주입 -> @RequiredArgsConstruct로 바꾸면 깔끔
//    @PersistenceContext
    private final EntityManager em;

    public void save(Member member) {
        em.persist(member);
    }

    public Member findOne(Long id) {
        return em.find(Member.class, id);
    }

    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class) //jpql은 from의 대상이 (테이블이 아닌)엔티티 대상으로 쿼리를 날림
                .getResultList();
    }

    public List<Member> findByName(String name) {
        return em.createQuery("select m from Member m where m.name=:name", Member.class)
                .setParameter("name", name)
                .getResultList();
    }

}
