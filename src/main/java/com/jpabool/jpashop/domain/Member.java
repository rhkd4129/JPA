package com.jpabool.jpashop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Member {
    @Id
    @SequenceGenerator(
            name = "MEMBER_SEQ",
            sequenceName = "MEMBER_SEQ",
            initialValue = 1,
            allocationSize = 1
    )

    @GeneratedValue(
            strategy= GenerationType.SEQUENCE,
            generator = "MEMBER_SEQ")
    @Column(name = "member_id")

    private Long id;
    private String name;


    @Embedded
    private Address address;



    @OneToMany(mappedBy = "member")
    private List<Order> orderList = new ArrayList<>();


    public void addOrder(Order order){
        order.setMember(this);
        orderList.add(order);
    }


}
