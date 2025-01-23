package com.jpabool.jpashop.domain.item;

import com.jpabool.jpashop.domain.Order;
import com.jpabool.jpashop.domain.OrderItem;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


// 상속관계 매핑이여서 전략을 부모클래스에잡아준다 싱글테이블전략을 해서
@Entity
@Getter
@Setter
@Inheritance(strategy =  InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype")
public abstract class Item {
    @Id
    @SequenceGenerator(
            name = "ITEM_SEQ",
            sequenceName = "ITEM_SEQ",
            initialValue = 1,
            allocationSize = 1
    )
    @GeneratedValue(
            strategy= GenerationType.SEQUENCE,
            generator = "ITEM_SEQ")
    @Column(name = "item_id")
    private Long id;


    private String name;
    private int price;
    private  int stockQuantity;

    @OneToMany(mappedBy = "item")
    private List<OrderItem> orderItemList = new ArrayList<>();


}
