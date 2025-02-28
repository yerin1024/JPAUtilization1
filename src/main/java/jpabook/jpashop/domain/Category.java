package jpabook.jpashop.domain;

import jakarta.persistence.*;
import jpabook.jpashop.domain.item.Item;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.FetchType.*;

@Entity
@Getter @Setter
public class Category {

    @Id @GeneratedValue
    @Column(name = "category_id")
    private Long id;

    private String name;

    @ManyToMany
    @JoinTable(name = "category_item" //관계형디비에서 다대다관계는 중간테이블이 존재
            , joinColumns = @JoinColumn(name = "category_id") //중간테이블에 들어갈 컬럼
            , inverseJoinColumns = @JoinColumn(name = "item_id")) //중간테이블에 item쪽으로 들어갈 컬럼
    private List<Item> items = new ArrayList<>();

    //계층형 구조
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "parent_id")
    private Category parent;

    @OneToMany(mappedBy = "parent")
    private List<Category> child = new ArrayList<>();
    
    //연관관계 편의메서드
    public void addChildCategory(Category child) {
        this.child.add(child);
        child.setParent(this);
    }
    
}
