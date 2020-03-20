package com.bryan.developer.curso.microservicio.items.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.bryan.developer.curso.microservicio.items.clientes.ProductoClienteRest;
import com.bryan.developer.curso.microservicio.items.entities.Item;
import com.bryan.developer.curso.microservicio.items.services.ItemService;
import com.bryan.developer.curso.microservicio.items.util.LogAbstract;

@Service
@Primary
public class ItemServiceFeignImpl extends LogAbstract implements ItemService {

	@Autowired
	private ProductoClienteRest rest;

	@Override
	public List<Item> listarItems() {
		LOG.info("Ejecutando el siguiente Metodo de la Clase: " + getClass().getName() + " - "
				+ Thread.currentThread().getStackTrace()[1].getMethodName());
		return rest.listarProductos().stream().map(p -> new Item(p, 1)).collect(Collectors.toList());
	}

	@Override
	public Item encontrarItem(Long id, Integer cantidad) {
		LOG.info("Ejecutando el siguiente Metodo de la Clase: " + getClass().getName() + " - "
				+ Thread.currentThread().getStackTrace()[1].getMethodName());
		return new Item(rest.mostrarProducto(id), cantidad);
	}

}
