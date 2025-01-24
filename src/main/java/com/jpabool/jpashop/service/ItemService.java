package com.jpabool.jpashop.service;


import com.jpabool.jpashop.domain.item.Item;
import com.jpabool.jpashop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ItemService {

    private final ItemRepository itemRepository;


    @Transactional
    public void saveItem(Item item) {
         itemRepository.save(item);

    }

//    @Transactional(readOnly = true)
    public List<Item> findItems(){
        return itemRepository.findAll();
    }

    public  Item findItem(Long id){
        return itemRepository.findOne(id);
    }




}
