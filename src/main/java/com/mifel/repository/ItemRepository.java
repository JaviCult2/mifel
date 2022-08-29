package com.mifel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mifel.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer>{

	List<Item> findByNameIgnoreCaseContaining(String name);
	
}
