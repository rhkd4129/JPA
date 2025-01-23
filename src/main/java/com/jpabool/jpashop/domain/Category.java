package com.jpabool.jpashop.domain;

import jakarta.persistence.*;

public class Category {
    @Id
    @SequenceGenerator(
            name = "CATEGORY_SEQ",
            sequenceName = "CATEGORY_SEQ",
            initialValue = 1,
            allocationSize = 1
    )
    @GeneratedValue(
            strategy= GenerationType.SEQUENCE,
            generator = "CATEGORY_SEQ")
    @Column(name = "category_id")
    private Long id;

//    private String


}
