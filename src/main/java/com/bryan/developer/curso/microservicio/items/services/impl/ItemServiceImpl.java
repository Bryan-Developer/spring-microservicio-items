package com.bryan.developer.curso.microservicio.items.services.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bryan.developer.curso.microservicio.items.entities.Item;
import com.bryan.developer.curso.microservicio.items.entities.Producto;
import com.bryan.developer.curso.microservicio.items.services.ItemService;
import com.bryan.developer.curso.microservicio.items.util.LogAbstract;

@Service
public class ItemServiceImpl extends LogAbstract implements ItemService {

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public List<Item> listarItems() {
		LOG.info("Ejecutando el siguiente Metodo de la Clase: " + getClass().getName() + " - "
				+ Thread.currentThread().getStackTrace()[1].getMethodName());
		List<Producto> productos = Arrays.asList(
				restTemplate.getForObject("http://localhost:8001/api/v1/ms/productos/listar", Producto[].class));
		return productos.stream().map(p -> new Item(p, 1)).collect(Collectors.toList());
	}

	@Override
	public Item encontrarItem(Long id, Integer cantidad) {
		LOG.info("Ejecutando el siguiente Metodo de la Clase: " + getClass().getName() + " - "
				+ Thread.currentThread().getStackTrace()[1].getMethodName());
		Map<String, String> pathVariables = new HashMap<>();
		pathVariables.put("id", id.toString());
		Producto producto = restTemplate.getForObject("http://localhost:8001/api/v1/ms/productos/listar/{id}",
				Producto.class, pathVariables);
		return new Item(producto, cantidad);
	}

}
