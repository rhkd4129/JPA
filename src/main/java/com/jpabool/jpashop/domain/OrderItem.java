package com.jpabool.jpashop.domain;

import com.jpabool.jpashop.domain.item.Item;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "order_item")
public class OrderItem {
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
    @Column(name = "order_item_id")
    private Long id;






    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;


    private int orderPrice;  ///주문가격
    private int count;       // 주문 수량

}