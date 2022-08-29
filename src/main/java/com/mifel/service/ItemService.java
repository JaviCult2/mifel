package com.mifel.service;

import java.util.List;

import com.mifel.model.Item;

public interface ItemService {

	public Item saveItem(Item item);
	public List<Item> getItems();
	public Item getItem(Integer id);
	public void deleteItem(Integer id);
	public Item updateItem(Integer id, Item item);
	public List<Item> findByNameIgnoraCaseContaining(String name);
}
