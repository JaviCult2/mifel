package com.mifel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mifel.model.Item;
import com.mifel.repository.ItemRepository;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemRepository item_repository;
	@Override
	public Item saveItem(Item item) {
		return item_repository.save(item);
	}

	@Override
	public List<Item> getItems() {
		return item_repository.findAll();
	}

	@Override
	public Item getItem(Integer id) {
		return item_repository.findById(id).get();
	}

	@Override
	public void deleteItem(Integer id) {
		item_repository.deleteById(id);;
		
	}

	@Override
	public Item updateItem(Integer id, Item item) {
		
		Item i = item_repository.findById(id).get();
		
		return item_repository.save(i);
	}

	@Override
	public List<Item> findByNameIgnoraCaseContaining(String name) {
		// TODO Auto-generated method stub
		return item_repository.findByNameIgnoreCaseContaining(name);
	}

}
