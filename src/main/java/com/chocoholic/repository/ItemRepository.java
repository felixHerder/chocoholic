package com.chocoholic.repository;

import com.chocoholic.model.ItemEntity;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<ItemEntity, String > {

}
