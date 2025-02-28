package jpabook.jpashop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;

    @Embedded //JPA 임베디드
    private Address address;

    //mappedBy="member" : ORDER테이블의 membmer컬럼과 매핑
    //주인의 member를 바꾸면 mapping된 곳도 바뀜 (반대로는 안됨)
    @OneToMany(mappedBy = "member") //member가 일 : order가 다
    private List<Order> orders = new ArrayList<>();

}
