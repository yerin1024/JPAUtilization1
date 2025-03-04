package jpabook.jpashop.controller;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MemberForm {

    @NotEmpty(message = "회원 이름은 필수 입니다.")
    private String name;

    private String city;
    private String street;
    private String zipcode;

    //Member객체와 MemberForm객체를 따로 쓰는 이유는
    //JPA를 사용할 때 entity는 최대한 순수하게 비즈니스로직만 포함하도록 만들어야 함
    //현재 예제는 단순해서 둘이 합쳐서 사용해도 되지만 실무에서는 복잡해질 가능성 높기 때문에 분리하는게 좋음
}
