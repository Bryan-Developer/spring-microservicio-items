package com.bryan.developer.curso.microservicio.items.services;

import java.util.List;

import com.bryan.developer.curso.microservicio.items.entities.Item;

public interface ItemService {
	
	List<Item> listarItems();
	Item encontrarItem(Long id, Integer cantidad);

}
