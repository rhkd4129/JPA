package com.jpabool.jpashop.repository;


import com.jpabool.jpashop.domain.Order;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepository {
    private EntityManager em;


    public void save(Order order){
        em.persist(order);
    }

}
