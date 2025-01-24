package com.jpabool.jpashop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.aspectj.weaver.ast.Or;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "orders")
@Getter @Setter
public class Order {
    @Id
    @SequenceGenerator(
                name = "ORDER_SEQ",
            sequenceName = "ORDER_SEQ",
            initialValue = 1,
            allocationSize = 1
    )
    @GeneratedValue(
            strategy= GenerationType.SEQUENCE,
            generator = "ORDER_SEQ")
    @Column(name = "order_id")
    private Long id;



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member; //주문 회원



    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems = new ArrayList<>();



    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "delivery_id")
    private Delivery delivery; //배송정보

    private LocalDateTime orderDate; //주문시간

    @Enumerated(EnumType.STRING)
    private OrderStatus status; //주문상태 [ORDER, CANCEL]

    public void setMember(Member member){
        this.member = member;
        member.getOrderList().add(this);
    }

    public void setDelivery(Delivery delivery){
        this.delivery = delivery;
        delivery.setOrder(this);

    }

    public void addOrderItem(OrderItem orderItem){
        orderItem.setOrder(this);
        this.orderItems.add(orderItem);
    }


    public  static  Order createOrder(Member member ,Delivery delivery, OrderItem... orderItems ){
        Order order = new Order();
        order.setMember(member);
        order.setDelivery(delivery);
        for(OrderItem orderItem:orderItems){
            order.addOrderItem(orderItem);
        }
        order.setStatus(OrderStatus.ORDER);
        order.setOrderDate(LocalDateTime.now());
        return  order;
    }

    //주문취소

}
//-- 먼저 현재 어떤 PDB를 사용하고 있는지 확인
//SELECT SYS_CONTEXT('USERENV', 'CON_NAME') FROM DUAL;
//
//-- PDB로 전환 (보통 ORCLPDB 또는 XEPDB1 같은 이름을 사용)
//ALTER SESSION SET CONTAINER = XEPDB1;
//
//-- 이제 사용자 생성
//CREATE USER JPA IDENTIFIED BY tiger;
//GRANT CREATE SESSION TO JPA;
//GRANT DBA TO JPA;
//GRANT UNLIMITED TABLESPACE TO JPA;
