package com.jpabool.jpashop.pr;

import com.jpabool.jpashop.domain.Address;
import com.jpabool.jpashop.domain.Order;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@Entity
public class Member2{

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



    @OneToMany(mappedBy = "member")
    private List<Order> orderList = new ArrayList<>();


    //    public void addOrder(Order order){
//        order.setMember(this);
//        orderList.add(order);
//    }
    {
}
