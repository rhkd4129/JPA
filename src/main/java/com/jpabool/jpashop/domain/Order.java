package com.jpabool.jpashop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name="orders")
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
    private  Member member;



    @OneToMany(mappedBy = "order")
    List<OrderItem> orderItemList = new ArrayList<>();


    //order를 가지고 delivery를 찾을 일이 많아서 여기서 주인설정 /크게 상관은 x
    @OneToOne
    @JoinColumn(name="delivery_id")
    private Delivery delivery;

    private LocalDateTime orderDate;
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;



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
