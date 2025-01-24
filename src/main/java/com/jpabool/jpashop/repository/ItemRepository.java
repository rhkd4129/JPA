package com.jpabool.jpashop.repository;

import com.jpabool.jpashop.domain.item.Item;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItemRepository {

    @PersistenceContext
    private EntityManager em;

    public void save(Item item){
        if(item.getId() == null){
            em.persist(item);
        }else{
            em.merge(item);
        }
//        return item.getId();

    }

    public List<Item> findAll(){
        return  em.createQuery("select item from Item item ",Item.class)
                .getResultList();
    }

    public Item findOne(Long id){
        return em.find(Item.class,id);
    }



}
