package com.jpabool.jpashop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Delivery {
    @Id
    @SequenceGenerator(
            name = "DELIVERY_SEQ",
            sequenceName = "DELIVERY_SEQ",
            initialValue = 1,
            allocationSize = 1
    )
    @GeneratedValue(
            strategy= GenerationType.SEQUENCE,
            generator = "DELIVERY_SEQ")
    @Column(name = "delivery_id")
    private Long id;


    @OneToOne(mappedBy = "delivery")
    private Order order;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    private  DeliveryStatus status;





}
